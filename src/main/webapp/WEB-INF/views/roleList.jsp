<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>角色权限</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">

    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/rolePermission.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        function addRole() {
            $("#addRoleForm").attr('action', "/addRole");
            $("#addRoleForm").attr('method', "post");
            $("#addRoleForm").submit();
        }

        function editRole() {
            var editId = $("#roleList .roleSelected").attr("value");
            var editName = $("#roleList .roleSelected").html();
            /*alert(editId+":"+editName);*/
            $("#editRoleForm [name='role_id']").attr("value",editId);
            $("#editRoleForm [name='role_name']").attr("value",editName);
        }
        
        function updateRole() {
            $("#editRoleForm").attr('action', "/updateRole");
            $("#editRoleForm").attr('method', "post");
            $("#editRoleForm").submit();
        }
        
        function delRole() {
            var editId = $("#roleList .roleSelected").attr("value");
            var editName = $("#roleList .roleSelected").html();
            if (confirm("确定要删除 "+editName+" 角色吗?")){
                window.location.href="/delRole?role_id="+editId;
            }
        }

        function getPermissionByRole(role_id, role_name) {
            $("#role_id").attr("value", role_id);
            $("#role_name").html("角色:" + role_name);
            $('#tt').tree({
                url: '/getPermissionByRoleId?role_id=' + role_id
            });
        }
        /*修改角色对应的权限*/
        function updateRolePermission() {
            var role_id = $("#role_id").val();
            if (role_id == "") {
                alert("请选择角色.");
            } else {
                var nodes = $('#tt').tree('getChecked');
                var permission_id = "";
                for (var i = 0; i < nodes.length; i++) {
                    var node = nodes[i];
                    permission_id += node.permission_id + ",";
                }
                $("#permissionForm").attr('action', "/updateRolePermission?permission_id=" + permission_id);
                $("#permissionForm").attr('method', "post");
                $("#permissionForm").submit();
            }
        }

    </script>
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<%--角色管理--%>
<div id="content" class='rolePermission'>
    <div class="content-inner clearfix">
        <div id="sub-nav">
            <div class="model-box">
                <span>角色管理</span>
                <div class="sub-btn">
                    <a class="sub-add"><img src="${pageContext.request.contextPath}/static/images/sub-add.png" alt=""></a>
                    <a class="sub-edit" onclick="editRole()"><img src="${pageContext.request.contextPath}/static/images/sub-edit.png" alt=""></a>
                    <a class="sub-del" onclick="delRole()"><img src="${pageContext.request.contextPath}/static/images/sub-del.png" alt=""></a>
                </div>
                <div class="second-nav" id="roleList">
                    <c:forEach items="${roles}" var="role">
                        <a onclick="getPermissionByRole('${role.role_id}','${role.role_name}')" value="${role.role_id}">${role.role_name}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <form id="permissionForm">
            <input type="hidden" name="roleId">
            <div id="show">
                <div class="show-inner">
                    <div class="show-top">
                        <div class="edit-title">角色权限</div>
                        <div class="result">
                            <p id="role_name">角色:未选择</p>
                            <input type="hidden" id="role_id" name="role_id">
                            <ul id="tt" class="easyui-tree" name="easyui"
                                url="/getPermissionByRoleId"
                                checkbox="true">
                            </ul>
                        </div>
                        <div class="role-updata">
                            <input type="button" onclick="updateRolePermission()" value="更新">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<%--添加角色--%>
<form id="addRoleForm">
    <div class='eject add-role'>
        <div class="min-box">
            <div class="min-input clearfix">
                <span>角色名：</span>
                <input type="text" name="role_name">
            </div>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="addRole()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>
<form id="editRoleForm">
    <div class='eject edit-role'>
        <div class="min-box">
            <div class="min-input clearfix">
                <span>角色名：</span>
                <input type="hidden" name="role_id">
                <input type="text" name="role_name">
            </div>
            <div class="min-btn clearfix">
                <a class="min-confirm" onclick="updateRole()">确定</a>
                <a class="min-cancle">取消</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>
