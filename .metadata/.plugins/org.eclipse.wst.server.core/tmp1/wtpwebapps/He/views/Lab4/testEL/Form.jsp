<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>User Edition</h3>
		<form action="Bai2_TestEL" method="post">
			Username:
			<input name="username" value ="${form.username}"><br>
			Password:
			<input name="password"><br>
			<input name="remember" type="checkbox">
			Remember me?
			<br>
			<button>Create</button>
		</form>
</body>
</html>