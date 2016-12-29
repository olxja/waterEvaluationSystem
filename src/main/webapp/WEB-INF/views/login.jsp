<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>OA管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
	<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
	<script type="text/javascript">
		function loadUser(){
			$("#login").attr('action', "/loadUser");
			$("#login").attr('method', "post");
			$("#login").submit();
		}
	</script>
</head>
<body>
<div id="warp">
	<form id="login"  class="login-page">
		<div class="title">管理员登录</div>
		<input class="form-control" placeholder="用户名" id="j_username" name="username" size="20" maxlength="50" type="text">
		<input class="form-control" placeholder="密码" id="j_password" name="password" size="20" maxlength="50" type="password">
		<p style="color: red;">${message}</p>
		<div class="box clearfix">
			<div class='auto-login'>
				<input checked="checked" id="autoLogin" name="rememberMe" type="checkbox" value="true">
				<span>自动登录</span>
			</div>
		</div>
		<button class="btn btn-lg btn-block" value="Login" onclick="loadUser()">登录</button>
	</form>
</div>
</body>
</html>