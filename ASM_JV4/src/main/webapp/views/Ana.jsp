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
	<div class="container">
		<h1>Video Yêu Thích</h1>
		<!-- Form thêm mới video -->
		<form method="post" action="/Lab6_Java4/Analyst">
			<button type="submit" class="btn btn-default">Summit</button>
		</form>
		<br>
		<!-- Bảng hiển thị danh sách video -->
		<table class="table">
			<thead>
				<tr>
					<th>Video Title</th>
					<th>Favorite Count</th>
					<th>Lastest Date</th>
					<th>Oldest Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vid" items="${vids}">
					<tr>
						<td>${vid.videott}</td>
						<td>${vid.fc}</td>
						<td>${vid.lc}</td>
						<td>${vid.oc}</td>

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