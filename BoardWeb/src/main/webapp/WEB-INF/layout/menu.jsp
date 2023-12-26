<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
    <%
    	String logId = (String) session.getAttribute("logId"); //LoginControl session작업하고
    	String logName = (String) session.getAttribute("logName");
    %>
    
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
             <%if(logName == null){ %>
                <div class="sidebar-heading border-bottom bg-light">Bootstrap(Guest)</div>
                <%} else{ %>
                <div class="sidebar-heading border-bottom bg-light">Bootstrap(<%=logName %>)</div> <!-- Start Boot` 복사해서 --로그인X Guest출력/아니면 이름출력 -->
                <%} %>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글목록</a>
                    <%if(logId == null){ %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
                    <%}else{ %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>     
                    <%} %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardForm.do">글등록</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
                </div>
            </div>