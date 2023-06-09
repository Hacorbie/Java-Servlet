<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/user"></c:url>
	<form action="${url}/index" method="post">
		<input type="text" name="id" placeholder="id" value="${user.id}" /> <br> 
		<input type="password" name="password" placeholder="password?" value="${user.password}"/><br> 
		<input type="text" name="fullname" placeholder="fullname" value="${user.fullname}" /> <br> 
		<input type="text" name="email" placeholder="email" value="${user.email}" /><br>
		<input type="radio" name="role" value="true" id="admin" checked/>
		<label for="admin">admin</label>
		<input type="radio" name="role" value="false" id="user" /> 
		<label for="user">user</label>
			 <br> <br>

		<button formaction="${url}/create">create</button>
		<button formaction="${url}/update">update</button>
		<button formaction="${url}/delete">delete</button>
		<a>reset</a>

	</form>
	<h3>${result}</h3>
	<table>
		<thead>
			<th>id</th>
			<th>fullname</th>
			<th>email</th>
			<th>admin</th>
			<th>Edit</th>
		</thead>

		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin}</td>
					<td><a href="${url}/edit/${item.id}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>