<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
	<form action="Bai2" method="post">
		<p>username</p>
		<input type="text" name="username">
		<p>password</p>
		<input type="text" name="password"> <br> <input
			type="radio" name="gt" id="nam" value="nam"> <label for="nam">Nam</label>
		<input type="radio" name="gt" id="nu" value="nu"> 
		<label for="nu">Nu</label>
			<br>
		<label for="id">da co gd</label>
		<input type="checkbox" name="gd" id ="gd"/>
		<br>	
	 	<select name="qt">
			<option>VN</option>
			<option>USA</option>
			<option>UK</option>
		</select> <input type="checkbox" name="hobby" id="seggs" value="seegs">
		<label for="seggs">seggs</label> <input type="checkbox" name="hobby"
			id="music" value="music"> <label for="music">am nhac</label>
		<input type="checkbox" name="hobby" id="asfdasfa" value="asdasdas">

		<label for="asfdasfa">asdasdas</label> <input type="checkbox"
			name="hobby" id="cccc" value="cccc"> <label for="cccc">cccc</label>
		<hr>
		<input type="submit" name="action">
	</form>
</div>

</body>
</html>