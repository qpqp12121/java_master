<%@page import="common.Student"%>
<%@page import="java.util.List"%>
<%@ page import="common.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
</head>
<body>
	<table border='1'>
	<thead>
	<tr><th>학번</th><th>이름</th><th>영어</th><th>수학</th></tr>
	</thead>
	<tbody>
	<%
	StudentDAO dao = new StudentDAO();
	List<Student> list = dao.getStudentList();

	for (Student std : list) {   
		
	%>
	 <tr>
	 	<td><a href="studentInfo.jsp?sno="<%=std.getStuNo()%>></a></td>
	 	<td><%=std.getStuName()%></td>
	 	<td><%=std.getEngScore()%></td>
	 	<td><%=std.getMathScore()%></td>
	 </tr>

	<%
	}
	%>
	</tbody>
	</table>
	
</body>
</html>