package com.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pno = req.getParameter("pno");
		
		//상세조회(코드번호)
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(pno);
		req.setAttribute("vo", vo);
		
		//관련상품(현재상세조회상품 제외-별점높은순 4개만)
		List<ProductVO> relist = svc.productRelated(pno);
		req.setAttribute("relatedList", relist);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("product/productInfo.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
