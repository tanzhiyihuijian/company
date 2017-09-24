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

    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>--%>


    <%--

    requirejs以一个相对于 baseUrl的地址来加载所有的代码
    1. 不配置 baseUrl, 也不使用 data-main属性, baseUrl的路径就是相对于 html页面的路径 (请求 url)
    2. 使用 data-main属性: baseUrl是相对于 data-main对应的js的路径  (推荐使用)
    3. 配置 baseUrl  (需要拿到应用程序的路径)


    --%>

    <script>
        const jsBasePath = '${pageContext.request.contextPath}' + '/static/js/';
    </script>


    <%--<script src="${pageContext.request.contextPath}/static/js/require.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/static/js/module/app.js"></script>--%>

    <%--  第二种方式 --%>
    <script data-main="${pageContext.request.contextPath}/static/js/module/app"
            src="${pageContext.request.contextPath}/static/js/require.js"></script>


</head>
<body>







<input type="button" value="json" onclick="requestByJson()"/>
<br>
<input type="button" value="keyvalue" onclick="requestByKV()">
<br>


<%-- 设计两个 form, 将 form1的数据提交后, 做一定的处理返回到 form2, 处理结果依据 Controller--%>
<form>
    用户名: <input type="text" id="u1" name="username"> <br>
    密码: <input type="text" id="p1" name="password"> <br>
    <input type="button" value="提交" onclick="sendForm_KV()">
</form>

<form>
    用户名: <input type="text" id="u2" name="username"> <br>
    密码: <input type="text" id="p2" name="password"> <br>
</form>


<script type="text/javascript">

    //    请求和返回都是 json
    function requestByJson() {
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/test/jsonSource.action',
            // 设置 contentType为 json
            contentType: 'application/json;charset=utf-8', //接收 json数据
            // json数据
            data: '{"username":"小明", "password":"123456"}',
            //请求成功后的回调函数
            success: function (data) {
                alert(data.username);
            }
        });
    }

    // 请求是 key/value, 返回是 json
    function requestByKV() {
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/test/kvSource.action',
            data: 'username=kvname&password=kwpassword',
            success: function (data) {
                alert(data.username);
            }
        });
    }

    // 提交表单数据, 返回json结果
    function sendForm() {
        var u1 = $("#u1").val();
        var p1 = $("#p1").val();

        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/test/sendForm.action',
            contentType: 'application/json;charset=utf-8',
            data: '{"username":' + '"' + u1 + '", "password": "' + p1 + '"}',
            success: function (data) {
                $("#u2").val(data.username);
                $("#p2").val(data.password);
            }
        })
    }

    // 将数据作为 key-value形式发出
    function sendForm_KV() {
        var u1 = $("#u1").val();
        var p1 = $("#p1").val();
        var user = {
            username: $("#u1").val(),
            password: $("#p1").val()
        };
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/test/sendForm_KV.action',
            // key-value发出 (默认: "application/x-www-form-urlencoded")
            // contentType: 告知服务器将要发送的数据格式
            contentType: "application/x-www-form-urlencoded",

            // JSON.stringify()是将JavaScript对象转换为json字符串
            // JSON.parse(jsonstr)是将json字符串转换为javascript对象
            // data: JSON.stringify(user),
            data: user,
            success: function (data) {
                $("#u2").val(data.username);
                $("#p2").val(data.password);
            }
        })

    }


</script>


</body>
</html>
