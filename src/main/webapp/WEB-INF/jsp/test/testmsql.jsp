<%--
  Created by IntelliJ IDEA.
  User: 王波
  Date: 2017/7/12 0012
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>test1.jsp</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>

</head>
<body>



<ul>

</ul>
    <c:forEach items="${users}" var="user">
        <li>${user.id} | ${user.name} | ${user.password}</li>
    </c:forEach>


</body>
</html>
