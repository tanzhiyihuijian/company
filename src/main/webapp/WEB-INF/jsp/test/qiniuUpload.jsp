<%--
  Created by IntelliJ IDEA.
  User: 王波
  Date: 2017/9/8 0008
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    const basePath = '${pageContext.request.contextPath}';
</script>



<html>
<head>
    <title>上传图片</title>


    <script src="${pageContext.request.contextPath}/static/js/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js" type="text/javascript"></script>


</head>
<body>


<form action="${pageContext.request.contextPath}/test/upload-x.action"
      method="post" enctype="multipart/form-data">
    名称: <input type="text" name="name"> <br>
    选择文件: <input type="file" name="file"> <br>
    <input type="submit" value="提交">
</form>


<hr>

<p><input type="file" id="file1" name="file" /></p>
<input type="button" value="上传" />
<p><img id="img1" alt="上传成功啦" src="" /></p>


<script type="text/javascript">
    $(function () {
        $(":button").click(function () {
            ajaxFileUpload();
        })
    });
    function ajaxFileUpload() {
        $.ajaxFileUpload
        (
            {
                url: '/ssm/test/upload-y.action', //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: 'file1', //文件上传域的ID
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                    $("#img1").attr("src", data.imgurl);
                    if (typeof (data.error) != 'undefined') {
                        if (data.error != '') {
                            alert(data.error);
                        } else {
                            alert(data.msg);
                        }
                    }
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            }
        );
        return false;
    }
</script>


</body>
</html>