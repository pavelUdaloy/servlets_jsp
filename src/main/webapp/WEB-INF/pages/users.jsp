<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<p style="color: darkcyan; font-size: 15px; margin: 1px 1px 2px 1px"> Создать какого-нибудь юзера </p>
<br>
<form class="form" action="${pageContext.request.contextPath}/users?type=add" method="post">
    <input type="email" name="email" placeholder="email">
    <input type="text" name="firstName" placeholder="first name">
    <input type="text" name="lastName" placeholder="last name">
    <input type="number" name="age" placeholder="age">
    <input type="password" name="pass" placeholder="password">
    <select name="role">
        <option value="user">user</option>
        <option value="admin">admin</option>
    </select>
    <button type="submit">Добавить</button>
</form>
<br>
<br>
<br>
<br>
<p style="color: darkcyan; font-size: 15px; margin: 1px 1px 2px 1px"> Редактировать или удалить уже существующего </p>
<br>
<c:forEach var="user" items="${requestScope.get('userList')}">
    <a href="${pageContext.request.contextPath}/user?id=${user.id}">${user.firstName} ${user.lastName}</a>
    <br>
</c:forEach>
<br>
<br>
<a href="${pageContext.request.contextPath}/admin"> Назад </a>
<br>
<a href="${pageContext.request.contextPath}/main"> На главную </a>
<br>
</body>
</html>
