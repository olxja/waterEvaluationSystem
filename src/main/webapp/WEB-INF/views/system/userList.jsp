<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>组织机构用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/organizationUser.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="content" class='organizationUser'>
    <div class="content-inner clearfix">
        <div id="sub-nav">
            <div class="model-box">
                <span>组织机构</span>
                <div class="sub-btn">
                    <a class="sub-add"><img src="${pageContext.request.contextPath}/static/images/sub-add.png" alt=""></a>
                    <a class="sub-edit" onclick="editDepartment()"><img src="${pageContext.request.contextPath}/static/images/sub-edit.png" alt=""></a>
                    <a class="sub-del" onclick="delDepartment()"><img src="${pageContext.request.contextPath}/static/images/sub-del.png" alt=""></a>
                </div>
            </div>
            <form>
                <div class="first-nav" id="departmentList">
                    <div class="first-show clearfix">
                        <a onclick="userList('')">组织机构</a>
                        <span></span>
                    </div>
                    <div class="second-nav">
                        <c:forEach items="${departmentList}" var="department">
                            <div class="second-show clearfix">
                                <a onclick="userList('${department.departmentId}')" value="${department.departmentId}"
                                   <c:if test="${departmentId==department.departmentId}">class="secondAselec"</c:if>>
                                        ${department.departmentName}
                                </a>
                                <span></span>
                            </div>
                            <div class="third-nav">
                                <c:forEach items="${department.childDepartmentList}" var="department">
                                    <a onclick="userList('${department.departmentId}')"
                                       value="${department.departmentId}"
                                       <c:if test="${departmentId==department.departmentId}">class="selected3"</c:if>>
                                            ${department.departmentName}
                                    </a>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </form>
        </div>
        <div id="show">
            <div class="show-inner">
                <div class="show-top">
                    <div class="edit-title">组织机构用户</div>
                    <div class="operation clearfix">
                        <div class="condition">
                            <div class="condition-input clearfix">
                                <input type="text" id="search" name="search" value="${search}" placeholder="姓名、职位...">
                                <a class="button search-btn" onclick="searchUser()">搜索</a>
                            </div>
                        </div>
                        <div class="action-button">
                            <a class="button add-btn">添加</a>
                            <a class="button batch-delete-btn" onclick="deleteSelectUser()">批量删除</a>
                            <a class="button user-import-btn">用户导入</a>
                        </div>
                    </div>
                </div>
                <div class="show-bottom">
                    <div class="result">
                        <table>
                            <thead>
                            <tr>
                                <td><input type="checkbox" name="box" onclick="checkAll(this,'box')"></td>
                                <td>序号</td>
                                <td>姓名</td>
                                <td>邮箱</td>
                                <td>电话</td>
                                <td>所属部门</td>
                                <td>角色</td>
                                <td>职位</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%--<form id="listForm">--%>
                                <c:forEach items="${pagination.list}" var="user" varStatus="i">
                                    <tr>
                                        <td><input type="checkbox" name="box" class="check" value="${user.userId}"/></td>
                                        <td>${i.count}</td>
                                        <td>${user.username}</td>
                                        <td>${user.email}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.departmentName}</td>
                                        <td>
                                            <c:forEach items="${user.roleList}" var="role">
                                                ${role.role_name}</br>
                                            </c:forEach>
                                        </td>
                                        <td>${user.position}</td>
                                        <td>
                                            <div class="td-btn clearfix">
                                                <a class="list-del" onclick="deleteUser('${user.userId}')"><img src="${pageContext.request.contextPath}/static/images/td-del.png" alt=""></a>
                                                <a class="list-edit" onclick="editUser('${user.userId}')"><img src="${pageContext.request.contextPath}/static/images/td-edit.png" alt=""></a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            <%--</form>--%>
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
<%--                               弹框                                       --%>
<%--添加机构--%>
<form id="addDepartmentFrom">
    <div class='eject add-nav'>
        <div class="min-box">
            <div class="min-input clearfix">
                <span>机构名：</span>
                <input type="text" name="departmentName">
            </div>
            <%--<div class="min-input clearfix">
                <span>机构类别：</span>
                <input type="text">
            </div>--%>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="addDepartment()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>
<%--修改机构--%>
<form id="editDepartmentFrom">
    <div class='eject edit-nav'>
        <div class="min-box">
            <div class="min-input clearfix">
                <span>机构名：</span>
                <input type="hidden" name="departmentId">
                <input type="text" name="departmentName">
            </div>
            <%--<div class="min-input clearfix">
                <span>机构类别：</span>
                <input type="text">
            </div>--%>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="updateDepartment()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>
<%--新增用户--%>
<form id="addUser">
    <div class='eject add-eject'>
        <div class="eject-box add-user-box">
            <div class="eject-box-title">
                <h3>新增用户</h3>
            </div>
            <div class="eject-box-content">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>姓名：</span>
                    <input class='input1' type="text" name="username" placeholder="请输入姓名">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>电话：</span>
                    <input class='input1' type="text" name="phone" placeholder="请输入电话">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>邮箱：</span>
                    <input class='input1' type="text" name="email" placeholder="请输入邮箱">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>职位：</span>
                    <input class='input1' type="text" name="position" placeholder="请输入职位">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>部门：</span>
                    <input type="hidden" name="departmentId"/>
                    <input type="text" class='input2' readonly="true" name="departmentName" placeholder="请选择部门"/>
                    <input class='input-btn select-department' type="button" value="选择部门" onclick="addUserDepartment()">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>角色：</span>
                    <input type="hidden" name="roleIdsString"/>
                    <input type="text" class='input2' readonly="true" name="roleNamesString" placeholder="请选择角色"/>
                    <input class='input-btn select-role' type="button" value="选择角色" onclick="addUserRole()">
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="addUser()">确定</a>
                <a class="eject-cancel">取消</a>
            </div>
        </div>
    </div>
</form>

<%--修改用户--%>
<form id="editUser">
    <div class='eject edit-eject'>
        <div class="eject-box edit-user-box">
            <div class="eject-box-title">
                <h3>修改用户</h3>
            </div>
            <div class="eject-box-content">
                <input name="userId" type="hidden">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>姓名：</span>
                    <input class='input1' type="text" name="username" placeholder="请输入姓名">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>电话：</span>
                    <input class='input1' type="text" name="phone" placeholder="请输入电话">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>邮箱：</span>
                    <input class='input1' type="text" name="email" placeholder="请输入邮箱">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>职位：</span>
                    <input class='input1' type="text" name="position" placeholder="请输入职位">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>部门：</span>
                    <input type="hidden" name="departmentId"/>
                    <input type="text" class='input2' readonly="true" name="departmentName" placeholder="请选择部门"/>
                    <input class='input-btn select-department' type="button" value="选择部门" on
                           onclick="editUserDepartment()">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>角色：</span>
                    <input type="hidden" name="roleIdsString"/>
                    <input type="text" class='input2' readonly="true" name="roleNamesString" placeholder="请选择角色"/>
                    <input class='input-btn select-role' onclick="editUserRole()" type="button" value="选择角色">
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="updateUser()">确定</a>
                <a class="eject-cancel">取消</a>
            </div>
        </div>
    </div>
</form>


<%--新增用户  选择部门--%>
<div class="select-box select-department-box add-select-department">
    <div class="select-department-box-inner">
        <h3 class="title">新增用户 请选择部门</h3>
        <div class="select-department-content">
            <div class="select-department-first">
                <div class="first-show clearfix">
                    <a>组织机构</a>
                    <span></span>
                </div>
                <div id="select-department-second" class="select-department-second">
                    <c:forEach items="${departmentList}" var="department">
                        <div class="second-show clearfix">
                            <a>${department.departmentName}</a>
                            <span></span>
                        </div>
                        <div id="addUser-select-department-third" class="select-department-third">
                            <c:forEach items="${department.childDepartmentList}" var="department">
                                <a value="${department.departmentId}">${department.departmentName}</a>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="select-role-box-btn">
            <a class="select-role-confirm" onclick="addUserSelectDepartment()">确定</a>
        </div>
    </div>
</div>
<%--修改用户  选择部门--%>
<div class="select-box select-department-box  edit-select-department">
    <div class="select-department-box-inner">
        <h3 class="title">修改用户 请选择部门</h3>
        <div class="select-department-content">
            <div class="select-department-first">
                <div class="first-show clearfix">
                    <a>组织机构</a>
                    <span></span>
                </div>
                <div class="select-department-second">
                    <c:forEach items="${departmentList}" var="department">
                        <div class="second-show clearfix">
                            <a>${department.departmentName}</a>
                            <span></span>
                        </div>
                        <div id="editUser-select-department-third" class="select-department-third">
                            <c:forEach items="${department.childDepartmentList}" var="department">
                                <a value="${department.departmentId}">${department.departmentName}</a>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="select-role-box-btn">
            <a class="select-role-confirm" onclick="editUserSelectDepartment()">确定</a>
        </div>
    </div>
</div>
<%--新增用户  选择角色--%>
<div class="select-box select-role-box add-select-role">
    <div class="select-role-box-inner">
        <h3 class="title">请选择角色</h3>
        <ul id="addUserRoleList">
            <c:forEach items="${roles}" var="role">
                <li>
                    <input name="role" type="checkbox" value="${role.role_id}"/>
                    <span>${role.role_name}</span>
                </li>
            </c:forEach>
        </ul>
        <div class="select-role-box-btn">
            <a class="select-role-confirm" onclick="addUserSelectRole()">确定</a>
        </div>
    </div>
</div>

<%--修改用户  选择角色--%>
<div class="select-box select-role-box edit-select-role">
    <div class="select-role-box-inner">
        <h3 class="title">请选择角色</h3>
        <ul id="editUserRoleList">
            <c:forEach items="${roles}" var="role">
                <li>
                    <input name="role" type="checkbox" value="${role.role_id}"/>
                    <span>${role.role_name}</span>
                </li>
            </c:forEach>
        </ul>
        <div class="select-role-box-btn">
            <a class="select-role-confirm" onclick="editUserSelectRole()">确定</a>
        </div>
    </div>
</div>
<%--用户导入--%>
<form id="mouldForm" method="post" enctype="multipart/form-data">
    <div class='eject import-user-eject'>
        <div class="eject-box import-user-box">
            <div class="eject-box-title">
                <h3>用户导入</h3>
            </div>
            <div class="eject-box-content">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>第一步：按照导入模版的格式准备导入数据</span>
                    <input class='input-btn' type="button" value="用户模版下载" onclick="downloadMould()">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>第二步：选择需要导入的Excel文件</span>
                    <div class="file-operation">
                        <a href="javascript:;" class="file" type="file">
						<span>选择文件
						    <input name="excel" onchange="" type="file">
						</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-import" onclick="importUser()">导入</a>
                <a class="eject-cancel">取消</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>