<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Acc</title>
</head>
<body>


<%--<c:out value="${<%"Это аккаунт"%>  + pageContext.request.getSession().getAttribute('currentUser') + <%"<br>"%>}"></c:out>>--%>
<%out.println("Это аккаунт " + request.getSession().getAttribute("currentUser") + "<br>");%>
<a href="${pageContext.request.contextPath}/main"> Главная </a>
<br>
<a href="${pageContext.request.contextPath}/calc"> Калькулятор </a>
<br>
<c:if test="${pageContext.request.getSession().getAttribute('currentUser').getRole().getName() == 'admin'}">
    <a href="${pageContext.request.contextPath}/history"> Открыть историю вычислений всех юзеров </a>
    <br>
</c:if>
<c:if test="${pageContext.request.getSession().getAttribute('currentUser').getRole().getName() == 'user'}">
    <a href="${pageContext.request.contextPath}/history"> Открыть историю своих вычислений </a>
    <br>
</c:if>
<a href="${pageContext.request.contextPath}/redacc"> Редактирование данных аккаунта </a>
<br>
<a href="${pageContext.request.contextPath}/logout"> Выйти из аккаунта </a>
<br>
<c:if test="${pageContext.request.getSession().getAttribute('currentUser').getRole().getName() == 'admin'}">
    <a href="${pageContext.request.contextPath}/admin"> Открыть спец. возможности админа </a>
    <br>
</c:if>

</body>
</html>
