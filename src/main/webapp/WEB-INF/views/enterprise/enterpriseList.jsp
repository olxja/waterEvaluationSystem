<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>企业管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/enterprise.js"></script>
    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="content" class='businessManagement'>
    <div class="content-inner clearfix">
        <div id="show">
            <div class="show-inner">
                <div class="show-top">
                    <div class="edit-title">企业管理</div>
                    <div class="operation clearfix">
                        <form id="searchEnterpriseForm" method="post">
                            <div class="condition condition-box">
                                <ul class="condition-list clearfix">
                                    <li>
                                        <span>公司名称：</span>
                                        <input type="text" name="company_name" value="${company_name}" placeholder="公司名称">
                                    </li>
                                    <li>
                                        <span>公司法人：</span>
                                        <input type="text" name="legal_person" value="${legal_person}" placeholder="公司法人">
                                    </li>
                                    <li class="range-li">
                                        <span>注册时间：</span>
                                        <input onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="start_time"
                                               value="${start_time}" type="text">
                                        <span>至</span>
                                        <input onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="end_time"
                                               value="${end_time}" type="text">
                                    </li>
                                    <%--<li class="range-li">
                                        <span>注册资金：</span>
                                        <input type="text">
                                        <span>至</span>
                                        <input type="text">
                                    </li>--%>


                                    <li>
                                        <a class="button reset-btn" onclick="resetting()">重置</a>
                                    </li>
                                </ul>
                            </div>
                        </form>
                        <div class="action-button">
                            <a class="button search-btn" onclick="searchEnterprise()">查询</a>
                            <a class="button add-btn">添加</a>
                        </div>
                    </div>
                </div>
                <div class="show-bottom">
                    <div class="result businessManagement-result">
                        <table>
                            <thead>
                            <tr>
                                <td>序号</td>
                                <td>企业名称</td>
                                <td>注册地址</td>
                                <td>办公地点</td>
                                <td>创建时间</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${companyList}" var="company" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td><a onclick="companyDetail('${company.id}')">${company.company_name}</a></td>
                                    <td>${company.register_address}</td>
                                    <td>${company.office_address}</td>
                                        <%--<td>${company.createtime}</td>--%>
                                    <td>${company.registerDate}</td>
                                    <td>
                                        <div class="td-btn clearfix">
                                            <a class="list-del" onclick="delEnterprise('${company.id}','${company.company_name}')"><img src="${pageContext.request.contextPath}/static/images/td-del.png" alt=""></a>
                                            <a class="list-edit" onclick="editEnterprise('${company.id}')"><img src="${pageContext.request.contextPath}/static/images/td-edit.png" alt=""></a>
                                        </div>
                                    </td>
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
<%--添加企业--%>
<form id="addEnterpriseForm">
    <div class='eject add-eject'>
        <div class="eject-box enterprise-eject-box">
            <div class="eject-box-title">
                <h3>新增企业</h3>
                <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
            </div>
            <div class="eject-box-content-box">
                <div class="eject-box-content">
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>企业名称：</span>
                        <div class='cName-li' id="aaa">
                            <input class='input1' id="CName" name="company_name" type="text" placeholder="请输入企业名称">
                            <em>*</em>
                        </div>
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>板块：</span>
                        <select name="plate">
                            <option value="暂无">请选择</option>
                            <option value="标准版">标准板</option>
                            <option value="孵化板">孵化板</option>
                            <option value="大创板">大创板</option>
                            <option value="科创板">科创板</option>
                            <option value="创新板">创新板</option>
                             <option value="其它">其它</option>
                        </select>
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>注册地址：</span>
                        <input class='input1' type="text" name="register_address" placeholder="请输入注册地址">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>办公地址：</span>
                        <input class='input1' type="text" name="office_address" placeholder="请输入办公地址">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>成立时间：</span>
                        <input class='input3' type="text" placeholder="" name="registerDate" placeholder="请输入成立时间">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>注册资金：</span>
                        <input class='input3' type="text" name="register_capital" placeholder="请输入注册资金">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>法人：</span>
                        <input class='input6' type="text" name="legal_person" placeholder="请输入法人">
                        <span class='item-list-name'>登记机构：</span>
                        <input class='input7' type="text" name="registration_authority" placeholder="请输入登记机构">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>营业期限：</span>
                        <input class='input3' type="text" placeholder="" name="operation_term" placeholder="请输入营业期限">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>发照日期：</span>
                        <input class='input3' type="text" placeholder="" name="license_time" placeholder="请输入发照日期">
                    </div>
                    <%--<div class='item-list clearfix'>
                        <span class='item-list-name'>联系人：</span>
                        <input class='input6' type="text" name="contact">
                        <span class='item-list-name'>联系方式：</span>
                        <input class='input7' type="text" name="contact_tel">
                    </div>--%>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>主营业务：</span>
                        <textarea cols="30" rows="10" name="main_business" placeholder="请输入主营业务"></textarea>
                    </div>
                </div>
                <div class="eject-btn">
                    <a class="eject-confirm" onclick="addEnterprise()">确定</a>
                    <a class="eject-cancel-a">取消</a>
                </div>
            </div>
        </div>
    </div>
</form>
<%--修改企业信息--%>
<form id="editEnterpriseForm">
    <div class='eject edit-eject'>
        <div class="eject-box enterprise-eject-box">
            <div class="eject-box-title">
                <h3>修改企业信息</h3>
                <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
            </div>
            <div class="eject-box-content-box">
                <div class="eject-box-content">
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>企业名称：</span>
                        <div class='cName-li'>
                            <input type="hidden" name="id">
                            <input class='input1' id="editName" name="company_name" type="text" placeholder="请输入企业名称">
                            <em>*</em>
                        </div>
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>板块：</span>
                        <select name="plate" >
                            <option value="暂无">请选择</option>
                            <option value="标准版">标准板</option>
                            <option value="孵化板">孵化板</option>
                            <option value="大创板">大创板</option>
                            <option value="科创板">科创板</option>
                            <option value="创新板">创新板</option>
                            <option value="其它">其它</option>
                        </select>
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>注册地址：</span>
                        <input class='input1' type="text" name="register_address">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>办公地址：</span>
                        <input class='input1' type="text" name="office_address">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>成立时间：</span>
                        <input class='input3' type="text" placeholder="" name="registerDate">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>注册资金：</span>
                        <input class='input3' type="text" name="register_capital">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>法人：</span>
                        <input class='input6' type="text" name="legal_person">
                        <span class='item-list-name'>登记机构：</span>
                        <input class='input7' type="text" name="registration_authority">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>营业期限：</span>
                        <input class='input3' type="text" placeholder="" name="operation_term">
                    </div>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>发照日期：</span>
                        <input class='input4' type="text" placeholder="" name="license_time">
                    </div>
                    <%--<div class='item-list clearfix'>
                        <span class='item-list-name'>联系人：</span>
                        <input class='input6' type="text" name="contact">
                        <span class='item-list-name'>联系方式：</span>
                        <input class='input7' type="text" name="contact_tel">
                    </div>--%>
                    <div class='item-list clearfix'>
                        <span class='item-list-name'>主营业务：</span>
                        <textarea cols="30" rows="10" name="main_business"></textarea>
                    </div>
                </div>
                <div class="eject-btn">
                    <a class="eject-confirm" onclick="updateEnterprise()">确定</a>
                    <a class="eject-cancel-a">取消</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>