<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>企业详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/detailsPage.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="content" class='notepad notepad-del'>
    <div class="content-inner clearfix">
        <div id="show">
            <div class="show-inner">
                <div class="edit-title">企业详情</div>
                <div class="details-list-box">
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">企业名称：</span>
                        <span class="details-list-content">${company.company_name}</span>
                    </div>
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">板块：</span>
                        <span class="details-list-content">${company.plate}</span>
                    </div>
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">注册地址：</span>
                        <span class="details-list-content">${company.register_address}</span>
                    </div>
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">办公地址：</span>
                        <span class="details-list-content">${company.office_address}</span>
                    </div>
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">成立时间：</span>
                        <span class="details-list-content">${company.register_time}</span>
                        <span class="details-list-title">注册资金：</span>
                        <span class="details-list-content3">${company.register_capital}</span>
                    </div>
                    <div class="details-list details-list1 clearfix">
                        <span class="details-list-title">法人：</span>
                        <span class="details-list-content">${company.legal_person}</span>
                        <span class="details-list-title">登记机构：</span>
                        <span class="details-list-content2">${company.registration_authority}</span>
                    </div>
                    <div class="details-list details-list2 clearfix">
                        <span class="details-list-title">营业期限：</span>
                        <span class="details-list-content4">${company.operation_term}</span>
                    </div>
                    <%--<div class="details-list details-list1 clearfix">
                        <span class="details-list-title">联系人：</span>
                        <span class="details-list-content"></span>
                        <span class="details-list-title">联系方式：</span>
                        <span class="details-list-content2"></span>
                    </div>--%>
                    <div class="details-list clearfix">
                        <span class="details-list-title">主营业务：</span>
                        <p>${company.main_business}</p>
                    </div>
                </div>
                <%--记事本记录/评分记录--%>
                <div class="details-center clearfix">
                    <ul class="details-center-nav">
                        <li><a class="selected">记事本记录</a></li>
                        <li><a>评分记录</a></li>
                        <li class="clearfix"></li>
                    </ul>
                    <div class="details-center-score">
                        <span>综合得分：</span>
                        <span class='score-value'>${all_score}星</span>
                        <span>商业：</span>
                        <span class='score-value'>${shangye_score}星</span>
                        <span>团队：</span>
                        <span class='score-value'>${team_score}星</span>
                        <span>业务：</span>
                        <span class='score-value'>${yewu_score}星</span>
                    </div>
                </div>
                <%--记事本记录--%>
                <div class="result details-notepad-result">
                    <table>
                        <thead>
                        <tr>
                            <td>序号</td>
                            <td>主题</td>
                            <td>内容</td>
                            <td>需求</td>
                            <td>创建者</td>
                            <td>星级</td>
                            <td>创建时间</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${notepads}" var="notepad" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td>${notepad.subject}</td>
                                <td class="handle-str">${notepad.content}</td>
                                <td>${notepad.demand}</td>
                                <td>${notepad.user_name}</td>
                                <td>${notepad.all_score}</td>
                                <td>${notepad.createtime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%--评分记录--%>
                <div class="result details-score-result">
                    <table>
                        <thead>
                        <tr>
                            <td>序号</td>
                            <td>星级</td>
                            <td>商业</td>
                            <td>团队</td>
                            <td>业务</td>
                            <td>内容</td>
                            <td>创建者</td>
                            <td>创建时间</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${notepads}" var="notepad" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td>${notepad.all_score}</td>
                                <td>${notepad.shangye_score}</td>
                                <td>${notepad.team_score}</td>
                                <td>${notepad.yewu_score}</td>
                                <td class="handle-str">${notepad.content}</td>
                                <td>${notepad.user_name}</td>
                                <td>${notepad.createtime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
