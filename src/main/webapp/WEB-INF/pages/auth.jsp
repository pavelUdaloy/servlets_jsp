<%@ page import="by.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/auth" method="post">
    <input type="email" name="email" placeholder="email">
    <c:if test="${requestScope.invalidateEmail}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Email</p>
    </c:if>
    <br>
    <input type="password" name="pass" placeholder="pass">
    <c:if test="${requestScope.invalidatePass}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Password</p>
    </c:if>
    <br>
    <button type="submit">Submit</button>
</form>
<a href="${pageContext.request.contextPath}/main"> На главную </a>
<br>
</body>
</html>
