<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Bai1" method="post">
		<p>Canh 1</p>
		<input name="a">
		<p>Canh 2</p>
		<input name="b">
		<p>Canh 3</p>
		<input name="c">
		<button formaction = "ChuVi">Chu Vi</button>
		<button formaction ="DienTich">Dien Tich</button>
		
		<h1>${message}</h1>
	</form>

</body>
</html>