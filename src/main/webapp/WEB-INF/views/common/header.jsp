<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>header</title>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="header">
    <div class="header-inner clearfix">
        <div class="logo">
            <h3>新四板移动OA</h3>
        </div>
        <div class="nav">
            <ul class="nav-list clearfix">
                <shiro:hasRole name="超级管理员">
                    <li>
                        <a
                        <c:if test="${sessionScope.module==1}">class='selected'</c:if> >
                        系统管理
                        </a>
                        <div class="header-second-nav">
                            <ul>
                                <li><a href="/userList">机构管理</a></li>
                                <li><a href="/roleList">角色权限</a></li>
                                <li><a href="/logList">登录日志</a></li>
                                <li><a href="/needList">需求维护</a></li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasRole>
                <li><a
                        <c:if test="${sessionScope.module==2}">class='selected'</c:if> id="enterprise"
                        href="/company/findCompany">企业管理</a></li>
                <li><a
                        <c:if test="${sessionScope.module==3}">class='selected'</c:if> id="notebook"
                        href="/notepad/findNotepad">记事本</a></li>
                <li><a
                        <c:if test="${sessionScope.module==4}">class='selected'</c:if> id="statistics"
                        href="/notepad/tongjiNotepad?type=user_name">统计</a></li>
            </ul>
        </div>
        <div class="user-name"><span>${sessionScope.username}，您好！</span></div>
        <div class="edit-btn">
            <a href="/logout">注销</a>
            <a href="/editPassword">修改密码</a>
        </div>
    </div>
</div>
</body>
</html>
