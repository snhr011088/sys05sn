<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
List<String> messageList = (List<String>) request.getAttribute("messageList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
</head>
<body>
<%
if (messageList != null) {
%>
<% for (String message : messageList) { %>
<p><%=message %></p>
<% } %>
<% } %>
<button type="button" onclick="history.back()">戻る</button>
</body>
</html>