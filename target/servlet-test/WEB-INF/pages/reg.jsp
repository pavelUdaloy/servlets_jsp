<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reg</title>
</head>
<body>
<form class="form" action="${pageContext.request.contextPath}/reg" method="post">
    <input type="email" name="email" placeholder="email">
    <c:if test="${requestScope.invalidateEmail}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Email</p>
    </c:if>
    <br>
    <input type="text" name="firstName" placeholder="first name">
    <c:if test="${requestScope.invalidateFirstName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate First Name</p>
    </c:if>
    <br>
    <input type="text" name="lastName" placeholder="last name">
    <c:if test="${requestScope.invalidateLastName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Last Name</p>
    </c:if>
    <br>
    <input type="number" name="age" placeholder="age">
    <c:if test="${requestScope.invalidateAge}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Age</p>
    </c:if>
    <br>
    <input type="password" name="pass" placeholder="password">
    <c:if test="${requestScope.invalidatePassword}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Password</p>
    </c:if>
    <br>
    <button type="submit">Submit</button>
</form>
<a href="${pageContext.request.contextPath}/main">На главную</a>
</body>
</html>
