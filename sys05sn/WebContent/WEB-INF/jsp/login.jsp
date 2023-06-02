<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入退室メール連絡システム</title>
</head>
<body>
<h1>入退室メール連絡システム	◇◆◇研修用◇◆◇</h1>
<p>パスワードを入力して　ログイン　ボタンを押してください。</p>
<form action="/sys05sn/LoginServlet" method="post">
<p>パスワード：
<input type="password" name="user_password"></p>
<p><input type="submit" value="ログイン">
<input type="reset" value="取り消し">
<button type="button" onclick="history.back()">戻る</button>
</p>
<p>※研修用のパスワード　通常画面「1111」　管理画面「8888」</p>
<p>※研修用では電子メールは送信されません</p>
</form>
</body>
</html>