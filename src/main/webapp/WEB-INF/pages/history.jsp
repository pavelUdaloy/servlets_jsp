<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>

<c:if test="${pageContext.request.getSession().getAttribute('currentUser').getRole().getName() == 'admin'}">
    <c:forEach var="calc" items="${requestScope.calcMap.entrySet().toArray()}">
        ${calc}
        <br>
    </c:forEach>
</c:if>
<c:if test="${pageContext.request.getSession().getAttribute('currentUser').getRole().getName() == 'user'}">
    ${requestScope.calcMap.get(pageContext.request.getSession().getAttribute('currentUser'))}
</c:if>
<br>
<a href="${pageContext.request.contextPath}/main"> На главную </a>
<br>
</body>
</html>
