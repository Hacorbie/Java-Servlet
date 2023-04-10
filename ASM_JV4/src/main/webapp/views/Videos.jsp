<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Video Management</title>
<!-- Thêm các file CSS Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<c:url var = "url" value ="/VideoManager"></c:url>
	<div class="container">
		<h1>Video Management</h1>
		<!-- Form thêm mới video -->
		<form method="post" action="${url}/AddVid">
		<div class="form-group">
    <label for="ID">ID :</label>
    <input type="text" class="form-control" name ="ID">
  </div>
			<div class="form-group">
    <label for="title">Title :</label>
    <input type="text" class="form-control" name ="title">
  </div>
  <div class="form-group">
    <label for="poster">Poster:</label>
    <input type="text" class="form-control" name="poster">
  </div>
  <div class="form-group">
    <label for="des">Description:</label>
    <input type="text" class="form-control" name="des">
  </div>
  <div class="radio">
    <label><input type="radio" name = "active" value ="yes"> Active</label>
    <label><input type="radio"name = "active" value ="no"> UnActive</label>
  </div>
  <button type="submit" class="btn btn-default">Thêm Video</button>
		</form>
		<br>
		<!-- Bảng hiển thị danh sách video -->
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Poster</th>
					<th>Views</th>
					<th>Description</th>
					<th>Active</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="video" items="${videos}">
					<tr>
						<td>${video.id}</td>
						<td>${video.title}</td>
						<td>${video.poster}</td>
						<td>${video.views}</td>
						<td>${video.description}</td>
						<td>${video.active}</td>
						<td>
							<!-- Form chỉnh sửa video -->
							<form method="post" action="${url}/DeleteVid" class="form-inline">
								<input type="hidden" name="action" value="edit"> <input
									type="hidden" name="idDelete" value="${video.id}">
								<button type="submit" class="btn btn-primary">Delete</button>
							</form> <!-- Form xóa video -->
							<form method="post" action="${url}/UpdateVid" class="form-inline">
								<input type="hidden" name="action" value="delete"> <input
									type="hidden"  name="idUpdate" value="${video.id}">
								<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#updateModal">Update</button>
								 <!-- Modal Update -->
    <div id="updateModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Update Video</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Title :</label>
                        <input type="text" class="form-control" name ="title" value="${video.title}">
                    </div>
                    <div class="form-group">
                        <label for="poster">Poster:</label>
                        <input type="text" class="form-control" name="poster" value="${video.poster}">
                    </div>
                    <div class="form-group">
                        <label for="des">Description:</label>
                        <input type="text" class="form-control" name="des" value="${video.description}">
                    </div>
                    <div class="radio">
                        <label><input type="radio" name = "active" value ="yes"> Active</label>
                        <label><input type="radio" name = "active" value ="no"> UnActive</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
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