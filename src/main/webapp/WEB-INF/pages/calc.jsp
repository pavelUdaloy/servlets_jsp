<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>

<%--<c:if test="${!requestScope.rezHas}">--%>
<%if (!((boolean) request.getAttribute("rezHas"))){%>
<form action="${pageContext.request.contextPath}/calc" method="post">
    <input type="number" name="firstValue" placeholder="First Value" minlength="1" maxlength="6" required>
    <br>
    <input type="number" name="secondValue" placeholder="Second Value">
    <br>
    <select name="sign">
        <option value="+">plus</option>
        <option value="-">minus</option>
        <option value="*">multiply</option>
        <option value="/">divide</option>
    </select>
<%--    <input type="text" name="sign" placeholder="Sign">--%>
<%--    <%if (((boolean) request.getAttribute("invalidateSign"))){%>--%>
<%--&lt;%&ndash;    <c:if test="${requestScope.invalidateSign}">&ndash;%&gt;--%>
<%--        <p style="color: red; font-size: 8px; margin: 1px 1px 2px 1px">Invalidate Sign(+ or - or * or /)</p>--%>
<%--&lt;%&ndash;    </c:if>&ndash;%&gt;--%>
<%--        <%}%>--%>
    <br>
    <button type="submit">Submit</button>
</form>
<%--</c:if>--%>
<%}else{%>
<c:if test="${requestScope.rezHas}">
    Ответ:
    <br>
    ${requestScope.rez}
    <br>
    Вычисление записано в вашу историю вычислений
    <br>
    <a href="${pageContext.request.contextPath}/calc"> Ещё один пример </a>
</c:if>
<%}%>
<br>
<a href="${pageContext.request.contextPath}/main"> На главную </a>
<br>
</body>
</html>
