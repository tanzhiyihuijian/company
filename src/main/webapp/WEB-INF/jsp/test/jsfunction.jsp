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

</head>
<body>

<script type="text/javascript">

    /*
    1. 如果没有 return语句, 函数执行完毕也会有返回结果, 只是结果为 undefined
    2. 可以将函数赋值给一个变量 var abs = function() {...}
    3.






     */

    var abs = function (x) {
        if (typeof x !== 'number') {
            throw 'Not a number !'
        }
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
    };


    function abs_1(x) {
        if (typeof x !== 'number') {
            throw 'Not a number !'
        }
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
    }

    var x = abs_1(1);
    var y = abs(-10);




</script>


</body>
</html>
