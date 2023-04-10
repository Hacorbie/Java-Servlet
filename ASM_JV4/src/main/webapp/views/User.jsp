<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Management</title>
<!-- Thêm các file CSS Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
	<c:url var="url" value="/UserManager"></c:url>
	<div class="container">
		<h1>User Management</h1>
		<!-- Form thêm mới video -->
		<form method="post" action="${url}/AddUser">
			<div class="form-group">
				<label for="ID">ID :</label> <input type="text" class="form-control"
					name="ID">
			</div>
			<div class="form-group">
				<label for="pass">Password :</label> <input type="text"
					class="form-control" name="pass">
			</div>
			<div class="form-group">
				<label for="fname">Fullname:</label> <input type="text"
					class="form-control" name="fname">
			</div>
			<div class="form-group">
				<label for="emai">Email:</label> <input type="text"
					class="form-control" name="emai">
			</div>
			<button type="submit" class="btn btn-default">Thêm User</button>
		</form>
		<br>
		<!-- Bảng hiển thị danh sách video -->
		<table class="table">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>FullName</th>
					<th>Email</th>
					<th>Role</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.password}</td>
						<td>${user.fullname}</td>
						<td>${user.email}</td>
						<td>${user.admin}</td>
						<td>
							<!-- Form chỉnh sửa video -->
							<form method="post" action="VideoController" class="form-inline">
								<input type="hidden" name="action" value="edit"> <input
									type="hidden" name="id" value="${user.id}">
								<button type="submit" class="btn btn-primary">Update</button>
							</form> <!-- Form xóa video -->
							<form method="post" action="VideoController" class="form-inline">
								<input type="hidden" name="action" value="delete"> <input
									type="hidden" name="id" value="${user.id}">
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Thêm các file JavaScript Bootstrap -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>