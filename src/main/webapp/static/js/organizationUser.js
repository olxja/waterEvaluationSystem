//全选
function checkAll(obj, box) {
    var checkboxs = document.getElementsByName(box);
    for (var i = 0; i < checkboxs.length; i++) {
        checkboxs[i].checked = obj.checked;
    }
}

$(function () {
    /*$(".second-nav").hide();
     $(".third-nav").hide();*/

    $("table tbody input[type='checkbox']").click(function() {
        var isCkecked=$(this).prop("checked");
        if(isCkecked){
            $(this).parent().parent().addClass("checkbox-box");
        }else{
            $(this).parent().parent().removeClass("checkbox-box");
        }
    })

        $(".first-nav .first-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected1") {
            $(this).removeClass("selected1");
            $(this).parent().siblings(".second-nav").hide(500);
        } else {
            $(this).addClass("selected1");
            $(this).parent().siblings(".second-nav").show(500);
            $(this).parent().parent().siblings(".first-nav").find("span").removeClass("selected1");
            $(this).parent().parent().siblings(".first-nav").find(".second-nav").hide(500);
        }
    });
    $(".second-nav .second-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected2") {
            $(this).removeClass("selected2");
            $(this).parent().siblings(".third-nav").hide(500);
        } else {
            $(this).addClass("selected2");
            $(this).parent().siblings(".third-nav").show(500);
        }
        ;
    });
    $(".third-nav>a").click(function () {
        $(this).addClass("selected3");
        $(this).siblings().removeClass("selected3");
        $(this).parent().parent().parent().siblings(".first-nav").find(".second-nav").find(".third-nav").find("a").removeClass("selected3");
    });
    var winheight = $(window).height();
    /*$(".eject").hide();*/
    $(".organizationUser .sub-add").click(function () {
        $(".add-nav").show(500);
        var thisHeight = $(".add-nav").find(".min-box").height() + 120;
        var toTop = (winheight - thisHeight) / 2;
        $(".add-nav").find(".min-box").css({"margin-top": toTop});
    });
    /*$(".organizationUser .sub-edit").click(function () {
     $(".edit-nav").show(500);
     var thisHeight = $(".edit-nav").find(".min-box").height() + 120;
     var toTop = (winheight - thisHeight) / 2;
     $(".edit-nav").find(".min-box").css({"margin-top": toTop});
     });*/
    $(".min-box .min-btn .min-cancle").click(function () {
        $(this).parent().parent().parent().hide(500);
    });
    /*选择角色弹出框*/
    $(".select-role-box").hide();
    function selectRole(obj1, obj2) {
        $(obj1).click(function () {
            $(obj2).show(500);
            var thisHeight = $(obj2).find(".select-role-box-inner").height();
            var toTop = (winheight - thisHeight) / 2;
            $(obj2).find(".select-role-box-inner").css({"margin-top": toTop});
        });
    }

    /*结束*/
    /*新增选择角色*/
    selectRole(".add-eject .select-role", ".add-select-role");
    /*修改选择角色*/
    selectRole(".edit-eject .select-role", ".edit-select-role");

    /*选择部门弹出框*/
    $(".select-department-box").hide();
    /*结束*/
    /*新增选择部门*/
    $(".add-eject .select-department").click(function () {
        $(".add-select-department").show(500);
        var thisHeight = $(".add-select-department").find(".select-department-box-inner").height();
        var toTop = (winheight - thisHeight) / 2;
        $(".add-select-department").find(".select-department-box-inner").css({"margin-top": toTop});
    });
    /*结束*/
    /*修改选择部门*/
    $(".edit-eject .select-department").click(function () {
        $(".edit-select-department").show(500);
        var thisHeight = $(".edit-select-department").find(".select-department-box-inner").height();
        var toTop = (winheight - thisHeight) / 2;
        $(".edit-select-department").find(".select-department-box-inner").css({"margin-top": toTop});
    });
    /*结束*/
    $(".select-role-confirm").click(function () {
        $(this).parent().parent().parent().hide(500);
    });

    /*$(".select-department-second").hide();
     $(".select-department-third").hide();*/
    /*新增*/
    $(".add-select-department .select-department-first>.first-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected1") {
            $(this).removeClass("selected1");
            $(this).parent().siblings(".select-department-second").hide(500);
        } else {
            $(this).addClass("selected1");
            $(this).parent().siblings(".select-department-second").show(500);
            $(this).parent().parent().siblings(".select-department-first").find("span").removeClass("selected1");
            $(this).parent().parent().siblings(".select-department-first").find(".select-department-second").hide(500);
        }
        ;

    });
    $(".add-select-department .select-department-second>.second-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected2") {
            $(this).removeClass("selected2");
            $(this).parent().siblings(".select-department-third").hide(500);
        } else {
            $(this).addClass("selected2");
            $(this).parent().siblings(".select-department-third").show(500);
        }
        ;
    });
    $(".add-select-department .select-department-third>a").click(function () {
        $(this).addClass("selected3");
        $(this).siblings().removeClass("selected3");
        $(this).parent().parent().parent().siblings(".select-department-first").find(".select-department-second").find(".select-department-third").find("a").removeClass("selected3");
    });
    /*结束*/
    /*修改*/
    $(".edit-select-department .select-department-first>.first-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected1") {
            $(this).removeClass("selected1");
            $(this).parent().siblings(".select-department-second").hide(500);
        } else {
            $(this).addClass("selected1");
            $(this).parent().siblings(".select-department-second").show(500);
            $(this).parent().parent().siblings(".select-department-first").find("span").removeClass("selected1");
            $(this).parent().parent().siblings(".select-department-first").find(".select-department-second").hide(500);
        }
        ;

    });
    $(".edit-select-department .select-department-second>.second-show>span").click(function () {
        var isSelect = $(this).attr("class");
        if (isSelect == "selected2") {
            $(this).removeClass("selected2");
            $(this).parent().siblings(".select-department-third").hide(500);
        } else {
            $(this).addClass("selected2");
            $(this).parent().siblings(".select-department-third").show(500);
        }
        ;
    });
    $(".edit-select-department .select-department-third>a").click(function () {
        $(this).addClass("selected3");
        $(this).siblings().removeClass("selected3");
        $(this).parent().parent().parent().siblings(".select-department-first").find(".select-department-second").find(".select-department-third").find("a").removeClass("selected3");
    });
    /*结束*/
})

// 回车键事件
// 绑定键盘按下事件
$(document).keypress(function (e) {
    // 回车键事件
    if (e.which == 13) {
        searchUser();
    }
});

//搜索
function searchUser() {
    window.location.href = "/userList?search=" + $("#search").val();
}
//全选
function checkAll(obj, box) {
    var checkboxs = document.getElementsByName(box);
    for (var i = 0; i < checkboxs.length; i++) {
        checkboxs[i].checked = obj.checked;
    }
}
/*用户列表*/
function userList(departmentId) {
    window.location.href = "/userList?departmentId=" + departmentId;
}
function addUser() {
    var username = $("#addUser [name='username']").val();
    var email = $("#addUser [name='email']").val();
    var departmentName = $("#addUser [name='departmentName']").val();
    if (username == undefined || username == ""){
        alert("请输入用户名.");
    }else if (email == undefined || email == ""){
        alert("请输入邮箱.");
    }else if (departmentName == undefined || departmentName == ""){
        alert("请选择部门.");
    }else {
        $("#addUser").attr("action", "/addUser");
        $("#addUser").attr("method", "post");
        $("#addUser").submit();
    }
}
function deleteUser(userId) {
    if (confirm("确定删除该用户?")) {
        window.location.href = "/deleteUser?userId=" + userId;
    }
}
/*前往修改信息页面*/
function editUser(userId) {
    $.ajax({
        url: "/findUserById?userId=" + userId,
        type: "get",
        dataType: "json",
        success: function (data) {
            if (data.status == "1") {
                $("#editUser [name='userId']").val(data.user.userId);
                $("#editUser [name='username']").val(data.user.username);
                $("#editUser [name='phone']").val(data.user.phone);
                $("#editUser [name='email']").val(data.user.email);
                $("#editUser [name='position']").val(data.user.position);
                $("#editUser [name='departmentId']").val(data.user.departmentId);
                $("#editUser [name='departmentName']").val(data.user.departmentName);
                var roleList = data.user.roleList;
                var role_id = "";
                var role_name = "";
                for (var i = 0; i < roleList.length; i++) {
                    role_id += "," + roleList[i].role_id;
                    role_name += "," + roleList[i].role_name;
                }
                if (role_id.length > 0) {
                    role_id = role_id.substr(1);
                }
                if (role_name.length > 0) {
                    role_name = role_name.substr(1);
                }
                $("#editUser [name='roleIdsString']").val(role_id);
                $("#editUser [name='roleNamesString']").val(role_name);
            }
        }
    });
}
function updateUser() {
    var username = $("#editUser [name='username']").val();
    var email = $("#editUser [name='email']").val();
    var departmentName = $("#editUser [name='departmentName']").val();
    if (username == undefined || username == ""){
        alert("请输入用户名.");
    }else if (email == undefined || email == ""){
        alert("请输入邮箱.");
    }else if (departmentName == undefined || departmentName == ""){
        alert("请选择部门.");
    }else {
        $("#editUser").attr('action', "/updateUser");
        $("#editUser").attr('method', "post");
        $("#editUser").submit();
    }

}
/*批量删除*/
function deleteSelectUser() {
    if (confirm("确定要删除这些用户吗?")) {
        $("#listForm").attr('action', "/deleteSelectUser");
        $("#listForm").attr('method', "post");
        $("#listForm").submit();
    }
}

/*添加组织*/
function addDepartment() {
    var option = {
        url: "/checkDepartment",
        method: "post",
        dataType: "json",
        success: function (data) {
            if (data.status == "1") {
                $("#addDepartmentFrom").attr('action', "/addDepartment");
                $("#addDepartmentFrom").attr('method', "post");
                $("#addDepartmentFrom").submit();
            } else {
                alert(data.message);
            }
        }
    }
    $("#addDepartmentFrom").ajaxSubmit(option);
}
/*前往修改组织页面*/
function editDepartment() {
    var departmentId2 = $("#departmentList .secondAselec").attr("value");
    var departmentName2 = $("#departmentList .secondAselec").html();
    var departmentId3 = $("#departmentList .selected3").attr("value");
    var departmentName3 = $("#departmentList .selected3").html();
    var winheight = $(window).height();
    if (departmentId2 != undefined) {
        $(".edit-nav").show(500);
        var thisHeight = $(".edit-nav").find(".min-box").height() + 120;
        var toTop = (winheight - thisHeight) / 2;
        $(".edit-nav").find(".min-box").css({"margin-top": toTop});
        $("#editDepartmentFrom [name='departmentId']").attr("value", $.trim(departmentId2));
        $("#editDepartmentFrom [name='departmentName']").attr("value", $.trim(departmentName2));
    } else if (departmentId3 != undefined) {
        $(".edit-nav").show(500);
        var thisHeight = $(".edit-nav").find(".min-box").height() + 120;
        var toTop = (winheight - thisHeight) / 2;
        $(".edit-nav").find(".min-box").css({"margin-top": toTop});
        $("#editDepartmentFrom [name='departmentId']").attr("value", $.trim(departmentId3));
        $("#editDepartmentFrom [name='departmentName']").attr("value", $.trim(departmentName3));
    } else {
        alert("请选择可修改的部门.");
    }
}
/*修改组织*/
function updateDepartment() {
    $("#editDepartmentFrom").attr('action', "/updateDepartment");
    $("#editDepartmentFrom").attr('method', "post");
    $("#editDepartmentFrom").submit();
}
/*删除组织*/
function delDepartment() {
    var departmentId3 = $("#departmentList .selected3").attr("value");
    var departmentName3 = $("#departmentList .selected3").html();
    if (departmentId3 == undefined) {
        alert("请选择可修改的部门.");
    } else if (confirm("确定要删除  " + $.trim(departmentName3) + "  部门?该部门下的用户也会删除!")) {
        window.location.href = "/delDepartment?departmentId=" + departmentId3;
    }
}
/*添加用户中的选择部门,回显*/
function addUserDepartment() {
    var departmentId = $("#addUser [name='departmentId']").attr("value");
    $("#addUser-select-department-third [value=departmentId]").attr("class", "selected3");
}
/*添加用户中的选择部门,显示到添加用户窗口*/
function addUserSelectDepartment() {
    var departmentId = $("#addUser-select-department-third .selected3").attr("value");
    var departmentName = $("#addUser-select-department-third .selected3").html();
    $("#addUser [name='departmentId']").val(departmentId);
    $("#addUser [name='departmentName']").val(departmentName);
}
/*添加用户中的选择角色,回显*/
function addUserRole() {
    var aaArr = $("#addUserRoleList li input");
    for (var j = 0; j < aaArr.length; j++) {
        aaArr[j].checked = false;
        var roleIds = $("#addUser [name='roleIdsString']").attr("value");
        if (roleIds != "" && roleIds != undefined) {
            var roleIdArr = roleIds.split(",");
            for (var i = 0; i < roleIdArr.length; i++) {
                var role_id = roleIdArr[i];
                var _role_id = aaArr[j].value;
                if (role_id == _role_id) {
                    aaArr[j].checked = true;
                }
            }
        }
    }
}

/*添加用户中的选择角色,显示到添加用户窗口*/
function addUserSelectRole() {
    var aaArr = $("#addUserRoleList li input");
    var roleIdsString = "";
    var roleNamesString = "";
    for (var i = 0; i < aaArr.length; i++) {
        if ($(aaArr[i]).prop('checked')) {
            roleIdsString += "," + $(aaArr[i]).attr('value');
            roleNamesString += "," + $(aaArr[i]).siblings("span").html();
        }
    }
    var length1 = roleIdsString.length;
    if (length1 > 0) {
        roleIdsString = roleIdsString.substring(1);
    }
    var length = roleNamesString.length;
    if (length > 0) {
        roleNamesString = roleNamesString.substring(1);
    }
    $("#addUser [name='roleIdsString']").attr("value", roleIdsString);
    $("#addUser [name='roleNamesString']").attr("value", roleNamesString);
}
/*添加用户中的选择部门,回显*/
function editUserDepartment() {
    var departmentId = $("#editUser [name='departmentId']").attr("value");
    $("#editUser-select-department-third a").removeClass("selected3");
    var thirdArr = $("#editUser-select-department-third a");
    for (var i = 0; i < thirdArr.length; i++) {
        var thisVal = $(thirdArr[i]).attr("value");
        if (thisVal == departmentId) {
            $(thirdArr[i]).attr("class", "selected3");
        }
    }
}
/*修改用户中的选择部门,显示到修改用户窗口*/
function editUserSelectDepartment() {
    var departmentId = $("#editUser-select-department-third .selected3").attr("value");
    var departmentName = $("#editUser-select-department-third .selected3").html();
    $("#editUser [name='departmentId']").val(departmentId);
    $("#editUser [name='departmentName']").val(departmentName);
}

/*修改用户中的选择角色,回显*/
function editUserRole() {
    var aaArr = $("#editUserRoleList li input");
    for (var j = 0; j < aaArr.length; j++) {
        aaArr[j].checked = false;
        var roleIds = $("#editUser [name='roleIdsString']").attr("value");
        if (roleIds != "" && roleIds != undefined) {
            var roleIdArr = roleIds.split(",");
            for (var i = 0; i < roleIdArr.length; i++) {
                var role_id = roleIdArr[i];
                var _role_id = aaArr[j].value;
                if (role_id == _role_id) {
                    aaArr[j].checked = true;
                }
            }
        }
    }
}
/*修改用户中的选择角色,显示到修改用户窗口*/
function editUserSelectRole() {
    var aaArr = $("#editUserRoleList li input");
    var roleIdsString = "";
    var roleNamesString = "";
    for (var i = 0; i < aaArr.length; i++) {
        if ($(aaArr[i]).prop('checked')) {
            roleIdsString += "," + $(aaArr[i]).attr('value');
            roleNamesString += "," + $(aaArr[i]).siblings("span").html();
        }
    }
    var length1 = roleIdsString.length;
    if (length1 > 0) {
        roleIdsString = roleIdsString.substring(1);
    }
    var length = roleNamesString.length;
    if (length > 0) {
        roleNamesString = roleNamesString.substring(1);
    }
    $("#editUser [name='roleIdsString']").attr("value", roleIdsString);
    $("#editUser [name='roleNamesString']").val(roleNamesString);
}
function downloadMould() {
    window.location.href = "/downloadMould";
}

function importUser() {
    var option = {
        url: "/importUser",
        method: "post",
        dataType: "json",
        success: function (data) {
            if (data.status == "1") {
                alert(data.message);
                window.location.href = "/userList";
            } else {
                alert(data.message);
            }
        }
    }
    $("#mouldForm").ajaxSubmit(option);
}
