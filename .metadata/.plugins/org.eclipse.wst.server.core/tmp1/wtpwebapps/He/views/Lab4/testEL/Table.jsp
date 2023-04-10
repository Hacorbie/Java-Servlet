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
	<h3>User List</h3>
		<table border="1" style="width:100%;">
		<thead>
			<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Remember?</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>username</td>
				<td>password</td>
				<td>remember</td>
			</tr>
			<c:forEach var="i" begin="1" end="5">
         		<tr>
					  <td><c:out value="${items[i].username}"/></td>
						<td><c:out value="${items[i].password}"/></td>
						<td><c:out value="${items[i].remember?'Yes':'No'}"/></td> 
					</tr>
			</c:forEach>
<%-- 			<%
				  for (int i = 0; i < 5; i++) {%>
				    <tr>
					  <td>${items[i].username}</td>
						<td>${items[i].password}</td>
						<td>${items[i].remember?'Yes':'No'}</td> 
					</tr>
					
			<%}%> --%>
			
			
		</tbody>
		</table>
</body>
</html>