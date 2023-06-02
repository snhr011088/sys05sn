<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%
String mode = (String) request.getAttribute("mode");
String modeName = (String) request.getAttribute("modeName");

List<Student> studentList = (List<Student>) request.getAttribute("studentList");
System.out.println(studentList.size());
System.out.println(studentList.get(0).getStudentId());

String[] studentIdList = (String[])request.getAttribute("studentIdList[]");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<p>●<%=modeName %>する生徒は下記で良いですか？</p>
<form action="/sys05sn/OperationResult" method="post">
<table border="1">
<tr>
<th>生徒番号</th>
<th>名前</th>
<th>学年</th>
</tr>
<% for(Student student: studentList){
%>
<tr>
<td><%=student.getStudentId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getGrade() %></td>
</tr>
<input type="hidden" name="studentIdList[]" value="<%=student.getStudentId() %>">
<%
}
%>
</table>
<% if(mode.contains("mail")){
%>
<P>●生徒が正しければ下記に連絡事項を入力してOKを押してください。</P>
<P>●連絡事項</P>
<% if(!mode.contains("in")){
%>
<P>○テスト結果の連絡がある場合は記入してください。</P>
　国語<input type="text" name="kokugo" size="5">
　数学<input type="text" name="sugaku" size="5">
　英語<input type="text" name="eigo" size="5">
　社会<input type="text" name="shakai" size="5">
　理科<input type="text" name="rika" size="5">

<P>○その他の連絡事項がある場合は記入してください。（全角180文字：下枠6行以内）</P>
<%
}else{
%>
<P>○連絡事項がある場合は記入してください。（全角180文字：下枠6行以内）</P>
<%
}
%>
<textarea rows="6" cols="60" name="emailText"></textarea>

<p>◆例文（下記文書をコピー・ペーストして使用できます）</p>
<p>・メール発信は遅れましたが通常の時刻に入室しています。</p>
<% if(!mode.contains("in")){
%>
<p>・メール発信は遅れましたが通常の時刻に退室しています。</p>
<%
}
%>
<p>・メール発信は遅れましたが　　：　　に入室しています。</p>
<% if(!mode.contains("in")){
%>
<p>・メール発信は遅れましたが　　：　　に退室しています。</p>
<%
}
}
%>

<input type="hidden" name="mode" value="<%=mode %>">
<input type="hidden" name="modeName" value="<%=modeName %>">
<input type="submit" value="ＯＫ（実行します）">
<button type="button" onclick="history.back()">戻る</button>
</form>
</body>
</html>