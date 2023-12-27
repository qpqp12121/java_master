package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 3개 파라미터 (jsp파일에 정의한) name: title/content/writer 받고 -> DB에 insert하고 -> 목록페이지
		// 보여주기

		// get요청일때 / post요청일 때(파일요청때문에)

		BoardVO vo = new BoardVO();

		if (req.getMethod().equals("GET")) { // 원래 이거 없으면 기본 Get방식임
			// 3개 파라미터 받기
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			// 3개 변수활용해서 BoardVO타입에 저장
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

		} else if (req.getMethod().equals("POST")) {
			// 파일업로드 포함
			String saveLoc = req.getServletContext().getRealPath("images"); // request.프로젝트경로.에서 images찾아오기
			int maxSize = 1024 * 1024 * 5;
			MultipartRequest mr = null;

			// 매개값5개다부를거(1.request 2.saveLoc 3.maxSize 4.인코딩방식 5.리네임정책(같은파일있으면 서버에서
			// 이름새로바꿔서저장
			try {
				mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				String image = mr.getFilesystemName("image");

				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setImage(image);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of if.

		// 이동할 페이지(공통부분)
		BoardService svc = new BoardServiceMybatis();
		try {
			if (svc.addBoard(vo)) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of execute.

}// end of class.
