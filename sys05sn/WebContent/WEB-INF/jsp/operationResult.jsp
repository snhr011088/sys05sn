<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%
String mode = (String) request.getAttribute("mode");
String modeName = (String) request.getAttribute("modeName");
String testText = (String) request.getAttribute("testText");
String emailText = (String) request.getAttribute("emailText");

List<Student> studentList = (List<Student>) request.getAttribute("studentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作完了画面</title>
</head>
<body>

<% for(Student student: studentList){
%>
<% if(mode.equals("mail")){
%>
<p><%=student.getName() %>さんへ連絡しました。<br>
<%
}else{
%>
<p><%=student.getName() %>さんの<%=modeName %>を受け付けました。<br>
<%
}
%>
※電子メールを送信しました。</p>
<% if(mode.contains("mail") ) {
	if(StringUtils.isNotBlank(testText)){
%>
	<p><%=testText %></p>
<%
	}
	if(StringUtils.isNotBlank(emailText)){
%>
	<p><%=emailText %></p>
<%
}
}
}
%>
<button type="button" onclick="history.back()">戻る</button>
<button type="button" onclick="history.go(-2)">最初に戻る</button>
</body>
</html>