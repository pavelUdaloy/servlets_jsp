<%@ page import="by.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PersAcc</title>
</head>
<body>

<%--<c:out value="Page for redacting account data"></c:out>--%>
<%--out.println("Page for redacting account data");--%>
<%--<c:set var="${user}" value="${request.getSession().getAttribute('currentUser')}" scope="application">--%>
Page for redacting account data
<br>
<%
    User user = ((User) request.getSession().getAttribute("currentUser"));
%>
<form class="form" action="${pageContext.request.contextPath}/redacc" method="post">
    <input type="text" name="newFirstName" value="<%=user.getFirstName()%>">
    <c:if test="${requestScope.invalidateFirstName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate First Name</p>
    </c:if>
    <br>
    <input type="text" name="newLastName" value="<%=user.getLastName()%>">
    <c:if test="${requestScope.invalidateLastName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Last Name</p>
    </c:if>
    <br>
    <input type="number" name="newAge" value="<%=user.getAge()%>">
    <c:if test="${requestScope.invalidateAge}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Age</p>
    </c:if>
    <br>
    <input type="password" name="newPass" value="<%=user.getPass()%>">
    <c:if test="${requestScope.invalidatePass}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Password </p>
    </c:if>
    <br>
    <button type="submit">Submit</button>
</form>
<a href="${pageContext.request.contextPath}/main">На главную</a>
</body>
</html>
