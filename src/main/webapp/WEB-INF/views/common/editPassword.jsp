<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">

    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/login.js"></script>
    <script>
        $(document).ready(function () {
            $("#password1").blur(function () {
                var num = $("#password1").val().length;
                if (num < 6) {
                    $("#tip2").html("<font color=\"red\" size=\"2\">  密码长度小于6位</font>");
                }
                else if (num > 18) {
                    $("#tip2").html("<font color=\"red\" size=\"2\">  密码长度大于18位</font>");
                }
                else {
                    $("#tip2").html("<font color=\"green\" size=\"2\">  OK</font>");
                }
            });
            $("#password2").blur(function () {
                var tmp = $("#password1").val();
                var num = $("#password2").val().length;
                if ($("#password2").val() != tmp) {
                    $("#tip3").html("<font color=\"red\" size=\"2\">  两次密码不一致</font>");
                }
                else {
                    if (num >= 6 && num <= 18) {
                        $("#tip3").html("<font color=\"green\" size=\"2\">  OK</font>");
                    }
                    else {
                        $("#tip3").html("<font color=\"red\" size=\"2\">  密码长度不符合</font>");
                    }
                }
            });
            $("#btn").click(function () {
                var flag = true;
                var old = $("#oldpassword").val();
                var pass = $("#password1").val();
                var pass2 = $("#password2").val();
                var num1 = $("#password1").val().length;
                var num2 = $("#password2").val().length;
                if (num1 != num2 || num1 < 6 || num2 < 6 || num1 > 18 || num2 > 18 || pass != pass2) {
                    flag = false;
                }
                else {
                    flag = true;
                }
                if (flag) {
                    /*var option={
                     url:"/manage/updatePassword",
                     method:"post",
                     dataType:"text",
                     success:function(data){
                     if(data.code==1){
                     $("#tip4").show().html("<font color=\"green\" size=\"3\">  Edit Success!</font>");
                     $("#oldpassword").val("");
                     $("#password1").val("");
                     $("#password2").val("");
                     $("#tip1").empty();
                     $("#tip2").empty();
                     $("#tip3").empty();
                     $("#tip4").delay(2000).hide(0);
                     }
                     else{
                     $("#tip4").show().html("<font color=\"red\" size=\"3\">  旧密码不正确</font>");
                     }
                     }
                     }
                     $("#jvForm").ajaxSubmit(option);*/
                    /*同步提交*/
                    $("#jvForm").attr('action', "/updatePassword");
                    $("#jvForm").attr('method', "post");
                    $("#jvForm").submit();
                    /*跳转到登陆页面*/
                    alert('修改密码成功,请重新登陆')
                    parent.location = "/login";
                }
                else {
                    $("#tip4").show().html("<font color=\"red\" size=\"3\">  请检查输入内容</font>");
                }
            });
        });
    </script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="warp">
    <form id="jvForm" method="post" action="/updatePassword">
        <div class="title">修改密码</div>
        <ul class='xform-ul'>
            <li class='clearfix'>
                <div class='form-label'>旧密码 :</div>
                <div class='form-input'>
                    <input type='password' id="oldpassword" name="oldpassword" placeholder="请输入旧密码"/>
                    <div style="display: inline" id="tip1"></div>
                </div>
            </li>
            <li class='clearfix'>
                <div class='form-label'>新密码 :</div>
                <div class='form-input'>
                    <input type='password' id="password1" name="password1" placeholder="密码长度在6到18位之间"/>
                    <div style="display: inline" id="tip2">
                    </div>
                </div>
            <li class='clearfix'>
                <div class='form-label'>确认新密码 :</div>
                <div class='form-input'>
                    <input type='password' id="password2" name="password2" placeholder="请再次输入密码"/>
                    <div style="display: inline" id="tip3">
                    </div>
            </li>
            <li class="text-center">
                <div>
                    <button class="btn btn-lg btn-block" id="btn">修改密码</button>
                </div>
            </li>

        </ul>
    </form>
</div>

</body>
</html>