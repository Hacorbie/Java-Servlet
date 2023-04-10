<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Videos</title>
</head>
<body>
    
    <form action="/Lab6_Java4/Lab6" method="POST">
        <label>Title:</label>
        <input type="text" name="searchvid">
        <button type="submit" formaction = "SearchUser">Search</button>
    </form>
    <table  style = "border: 1px solid black">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Views</th>
                <th>Active</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${videos}" var="video">
                <tr>
                    <td>${video.id}</td>
                    <td>${video.title}</td>
                    <td>${video.views}</td>
                    <td>${video.active}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table><br><br>
    <form action="/Lab6_Java4/Lab6" method="POST">
        <label>Title:</label>
        <input type="text" name="searchUserByVid">
        <button type="submit" formaction = "SearchUser">Search</button>
    </form>
</body>
</html>
