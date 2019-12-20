<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<c:if test="${pageContext.request.getSession().getAttribute('currentUser') == null}">
    <a href="${pageContext.request.contextPath}/auth">Авторизация</a>
    <br>
    <a href="${pageContext.request.contextPath}/reg">Регистрация</a>
    <br>
</c:if>
<c:if test="${pageContext.request.getSession().getAttribute('currentUser') != null}">
    <a href="${pageContext.request.contextPath}/acc">Личный Кабинет</a>
    <br>
</c:if>

</body>
</html>