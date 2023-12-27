<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/jstl.jsp</title> <!-- 액션태그(기능제공) -->
</head>
<body>
	<!-- [ 자바코드 대체하기 ] -->
	
	<!-- 값 set하고 out출력해보기 -->
	<c:set var="name" value="홍길동"></c:set>
	<c:out value="${name }"></c:out> <!-- name이라는 변수의 값을 출력해라 -->
	<c:set var="age" value="20"></c:set>
	
	<!-- if구문 -->
	<c:if test="${age >= 20 }">
		<p>성인입니다</p>
	</c:if>
	
	<!-- if/else -->
	<c:choose>
		<c:when test="${age >= 20}">
			<p>성인입니다</p>
		</c:when>	
		<c:otherwise>
			<p>미성년입니다</p>
		</c:otherwise>	
	</c:choose>
	
	<!-- 반복문 for(int i=1; i<=10; i++) -->
	<c:forEach begin="1" end="10" step="1" var="i"> <!-- step 1이면 생략 가능 -->
		<p>i의 값은 ${i }</p>
	</c:forEach>
	
	<c:forEach begin="1" end="9" var="i"> <!-- step 1이면 생략 가능 -->
		<p>3 * ${i } = ${3*i }</p>
	</c:forEach>
	
	<!-- 확장for문 for(String name : names){} -->
	<c:set var="names" value="Hong,Hwang,Kim"></c:set>
	<c:forEach items="${names }" var="n">
	 <p>${n }</p>
	</c:forEach>
	
</body>
</html>	