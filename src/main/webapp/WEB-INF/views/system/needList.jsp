<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>需求维护</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/requirementMaintenance.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="content" class='requirementMaintenance'>
    <div class="content-inner clearfix">
        <div id="sub-nav">
            <div class="model-box">
                <span>需求维护</span>
                <div class="sub-btn">
                    <a class="sub-add"><img src="${pageContext.request.contextPath}/static/images/sub-add.png" alt=""></a>
                    <a class="sub-edit" onclick="editNeed()"><img src="${pageContext.request.contextPath}/static/images/sub-edit.png" alt=""></a>
                    <a class="sub-del" onclick="delNeed()"><img src="${pageContext.request.contextPath}/static/images/sub-del.png" alt=""></a>
                </div>
            </div>
            <div class="second-nav">
                <c:forEach items="${needs}" var="need">
                    <a value="${need.id}">${need.name}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<form id="addNeed">

    <div class='eject add-requirement'>
        <div class="min-box">
            <div class="min-input clearfix">
                <span>需求名称：</span>
                <input type="text" name="name">
            </div>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="addNeed()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>

<form id="editNeed">
    <div class='eject edit-requirement'>
        <div class="min-box">
            <input type="hidden" name="id">
            <div class="min-input clearfix">
                <span>需求名称：</span>
                <input type="text" name="name">
            </div>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="updateNeed()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>

</body>
</html>