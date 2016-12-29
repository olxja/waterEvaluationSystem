<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/11/29
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js" type="text/javascript"></script>

    <script type="text/javascript">
        function ajax() {
            var option = {
                url: "/enterAutoComplete",
                method: "post",
                dataType: "json",
                success: function (data) {
                    alert(data.message);
                }
            }
            $("#ajaxForm").ajaxSubmit(option);
        }
    </script>
</head>
<body>
<form id="ajaxForm">
    <input name="companyName">
    <input type="button" onclick="ajax()" value="ajax">
</form>
</body>
</html>
