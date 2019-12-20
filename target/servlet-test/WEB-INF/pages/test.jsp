<%@ page import="by.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<c:forEach var="user" items="${applicationScope.get('userList')}">
    <p>${user}</p>
</c:forEach>
<c:forEach var="user" items="${applicationScope.userList}">
    <p>${user}</p>
</c:forEach>
<c:forEach var="user" items="${userList}">
    <p>${user}</p>
</c:forEach>
<%--<%--%>
<%--        for (User user : ((ArrayList<User>) pageContext.request.attribute("userList"))) {--%>

<%--    }--%>
<%--%>--%>
<%--<c:forEach var="user" items="${pageContext.getContext().getAttribute('userList')}">--%>
<%--    <p>${user}</p>--%>
<%--</c:forEach>--%>
<%--<c:forEach var="user" items="${pageContext.getContext().getContext().getAttribute('userList')}">--%>
<%--    <p>${user}</p>--%>
<%--</c:forEach>--%>
<form action="${pageContext.request.contextPath}/test" method="post">
    <input type="text" name="name">
    <c:if test="${requestScope.invalidateName}">
    <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px;">Invalidate Name</p>
</c:if>
    <button type="submit">Submit</button>
</form>
</body>
</html>
