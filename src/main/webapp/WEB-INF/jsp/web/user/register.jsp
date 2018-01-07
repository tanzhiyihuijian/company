<%--
  Created by IntelliJ IDEA.
  User: 王波
  Date: 2017/11/7 0007
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<div class="container">

<form action="">

    <label for="province-select"> 省: </label>
    <select id="province-select">
        <option value="-1">请选择</option>
    </select>

    <label for="city-select"> 市: </label>
    <select id="city-select">
        <option value="-1">请选择</option>
    </select>

    <label for="area-select"> 区: </label>
    <select id="area-select">
        <option value="-1">请选择</option>
    </select>


</form>

</div>

<script>

    let init = {
        serverPath: '${pageContext.request.contextPath}'
    };

    var contextPath = '${pageContext.request.contextPath}';
    var name = '${pageContext.request.serverName}';
    var port = '${pageContext.request.serverPort}';

    <%--name = '${pageContext.request}';--%>
    <%--name = '${pageContext.session}';--%>
    <%--name = '${pageContext.request.queryString}';--%>
    name = '${pageContext.request.requestURL}';
    <%--name = '${pageContext.request.contextPath}';--%>
    <%--name = '${pageContext.request.method}';--%>
    <%--name = '${pageContext.request.protocol}';--%>
    <%--name = '${pageContext.request.remoteUser}';--%>
    <%--name = '${pageContext.session.new}';--%>
    <%--name = '${pageContext.session.id}';--%>
    <%--name = '${header["User-Agent"]}';--%>
    <%--name = '${header["Host"]}';--%>
    <%--name = '${pageContext.request.remoteAddr }';--%>
    <%--name = '${pageContext.servletContext.serverInfo}';--%>
    <%--name = '${pageContext.request.serverPort}';--%>
    <%--name = '${pageContext.request.serverName}';--%>
    <%--name = '${pageContext.request.remoteHost}';--%>






</script>


<script src="${pageContext.request.contextPath}/static/js/vue.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user/register.js"></script>

</body>
</html>
