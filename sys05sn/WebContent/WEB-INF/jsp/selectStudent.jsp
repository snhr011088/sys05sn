<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%
String mode = (String) request.getAttribute("mode");
String modeName = "";
if("in".equals(mode) || "in_mail".equals(mode)){
	modeName = "入室";
}else if("out".equals(mode) || "out_mail".equals(mode)){
	modeName = "退室";
}else if("mail".equals(mode)){
	modeName = "連絡";
}

List<Student> studentList = (List<Student>) request.getAttribute("studentList");
String[] studentIdList = new String[studentList.size()];
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒選択画面</title>
</head>
<body>
<p>●<%=modeName %>する生徒を選択してください</p>
<form action="/sys05sn/Operation" method="post">
<table border="1">
<tr>
<th>ボタン</th>
<th>生徒番号</th>
<th>名前</th>
<th>学年</th>
</tr>
<% for(int index = 0; index < studentList.size(); index++){
	Student student = studentList.get(index);
	studentIdList[index] = student.getStudentId();
%>
<tr>
<td><input type="radio" name="studentIdList[]" value="<%=student.getStudentId() %>" required></td>
<td><%=studentIdList[index] %></td>
<td><%=student.getName() %></td>
<td><%=student.getGrade() %></td>
</tr>
<%
}
%>
</table>
<input type="hidden" name="mode" value="<%=mode %>">
<input type="hidden" name="modeName" value="<%=modeName %>">
<input type="submit" value="実行">
<button type="button" onclick="history.back()">戻る</button>
</form>
</body>
</html>