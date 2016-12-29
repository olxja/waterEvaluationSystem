<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>excel</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js" type="text/javascript"></script>

    <script type="text/javascript">
        function uploadDoc() {
            var option = {
                url: "/test/uploadDoc",
                method: "post",
                dataType: "json",
                success: function (data) {
                    if (data.status == 1){
                        alert("上传文件成功!");
                    }else {
                        alert("上传文件失败!");
                    }
                }
            }
            $("#editForm").ajaxSubmit(option);
        }
    </script>
</head>
<body>
        <form id="editForm">
            <input type="file" name="doc" onchange="uploadDoc()">
        </form>
</body>
</html>
