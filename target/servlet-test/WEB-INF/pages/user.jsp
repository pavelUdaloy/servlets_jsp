<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user?type=redact" method="post">
    <input type="hidden" name="id" value="${requestScope.get("userFR").id}">
    <input type="text" name="firstName" value=${requestScope.get("userFR").firstName}>
    <c:if test="${requestScope.invalidateFirstName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate First Name</p>
    </c:if>
    <br>
    <input type="text" name="lastName" value=${requestScope.get("userFR").lastName}>
    <c:if test="${requestScope.invalidateLastName}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Last Name</p>
    </c:if>
    <br>
    <input type="number" name="age" value=${requestScope.get("userFR").age}>
    <c:if test="${requestScope.invalidateAge}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Age</p>
    </c:if>
    <br>
    <input type="text" name="pass" value=${requestScope.get("userFR").pass}>
    <c:if test="${requestScope.invalidatePass}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Password</p>
    </c:if>
    <br>
    <select name="role">
<%--        <option value="${requestScope.userFR.role.name}" selected disabled>${requestScope.userFR.role.name}</option>--%>
        <option value="user">USER</option>
        <option value="admin">ADMIN</option>
    </select>
    <c:if test="${requestScope.invalidateRole}">
        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Role</p>
    </c:if>
    <br>
    <button type="submit"> Redact </button>
</form>
<br>
<form action="${pageContext.request.contextPath}/user?type=delete" method="post">
    <input type="hidden" name="id" value="${requestScope.get("userFR").id}">
    <button type="submit"> Delete </button>
</form>
</body>
</html>
