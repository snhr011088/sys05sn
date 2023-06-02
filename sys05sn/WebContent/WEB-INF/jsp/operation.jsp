<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通常画面</title>
</head>
<body>
<p>※研修用では電子メールは送信されません</p>
<p>▼選択してください　（ボタンチェック）</p>
<a href="/sys05sn/Operation?mode=in">入室 </a><br>
<a href="/sys05sn/Operation?mode=in_mail">入室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=out">退室 </a><br>
<a href="/sys05sn/Operation?mode=out_mail">退室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=mail">連絡のみ </a><br>
<p>▼複数生徒を同時に送信したい場合　（ボタンチェック）</p>
<a href="/sys05sn/Operation?mode=multi_in">複数入室 </a><br>
<a href="/sys05sn/Operation?mode=multi_in_mail">複数入室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=multi_out">複数退室 </a><br>
<a href="/sys05sn/Operation?mode=multi_out_mail">複数退室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=multi_mail">複数連絡のみ </a><br>
<p>▼選択してください　（バーコード入力）</p>
<a href="/sys05sn/Operation?mode=barcode_auto">自動 </a><br>
<a href="/sys05sn/Operation?mode=barcode_in">入室 </a><br>
<a href="/sys05sn/Operation?mode=barcode_in_mail">入室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=barcode_out">退室 </a><br>
<a href="/sys05sn/Operation?mode=barcode_out_mail">退室（連絡つき） </a><br>
<a href="/sys05sn/Operation?mode=barcode_mail">連絡のみ </a><br>

<button type="button" onclick="history.back()">戻る</button>
</body>
</html>
