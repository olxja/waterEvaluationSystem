<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>组织机构用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<%--表格--%>
<div id="content" class='journal'>
    <div class="content-inner clearfix">
        <div id="show">
            <div class="show-inner">
                <div class="show-top">
                    <div class="edit-title">登录日志</div>
                    <div class="result journal-result">
                        <table>
                            <thead>
                            <tr>
                                <td>序号</td>
                                <td>级别</td>
                                <td>详情</td>
                                <td>所属部门</td>
                                <td>类型</td>
                                <td>时间</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pagination.list}" var="log" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>
                                        <c:if test="${log.level==0}">信息</c:if>
                                        <c:if test="${log.level!=0}">严重</c:if>
                                    </td>
                                    <td>${log.detail}</td>
                                    <td>${log.department_name}</td>
                                    <td>
                                        <c:if test="${log.type==0}">用户操作</c:if>
                                        <c:if test="${log.type!=0}">系统错误</c:if>
                                    </td>
                                    <td>${log.login_time}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!--分页-->
                    <div class="page pb15 clearfix">
                        <div class="r inb_a page_b" style="float: right;">
                            <c:forEach items="${pagination.pageView }" var="page">
                                ${page}
                            </c:forEach>
                        </div>
                    </div>
                    <%--分页结束--%>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
</body>
</html>
