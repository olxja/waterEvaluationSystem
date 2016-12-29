$(function () {
    //自动补全
    function autoCompletion() {
        $(".auto-completion").remove();
        var companyName = $("#CName").val();
        if (companyName != "" && companyName != null && companyName != undefined) {
            $.ajax({
                type: "POST",
                url: '/app/addEnterpriseBySolr',
                dataType: "json",
                data: {companyName: companyName},
                success: function (data) {
                    $(".auto-completion").remove();
                    var autoCompletion = "<ul class='auto-completion'>";
                    $.each(data.enterpriseList, function (i, itemParent) {
                        var company_id = itemParent["company_id"];
                        var company_name = itemParent["company_name"]
                        var autoCompletionLi = "<li><a value=" + company_id + ">" + company_name + "</a></li>";
                        autoCompletion += autoCompletionLi;
                    });
                    autoCompletion += "</ul>";
                    $(".cName-li").append(autoCompletion);
                }
            });
        } else {
            $(".auto-completion").remove();
        }
    }

    $('#CName').bind('input propertychange', function () {
        $(".auto-completion").remove();
        var companyName = $("#CName").val();
        if (companyName != "" && companyName != null && companyName != undefined) {
            $.ajax({
                type: "POST",
                url: '/app/addEnterpriseBySolr',
                dataType: "json",
                data: {companyName: companyName},
                success: function (data) {
                    $(".auto-completion").remove();
                    var autoCompletion = "<ul class='auto-completion'>";
                    $.each(data.enterpriseList, function (i, itemParent) {
                        var company_id = itemParent["company_id"];
                        var company_name = itemParent["company_name"]
                        var autoCompletionLi = "<li><a value=" + company_id + ">" + company_name + "</a></li>";
                        autoCompletion += autoCompletionLi;
                    });
                    autoCompletion += "</ul>";
                    $(".cName-li").append(autoCompletion);
                }
            });
        } else {
            $(".auto-completion").remove();
        }
        ;
    });
    //结束
    //结束

    $(".cName-li").on("click", ".auto-completion>li>a", function () {
        var companyId = $(this).attr("value");
        $.ajax({
            type: "GET",
            url: '/app/getEnterpriseById?companyId=' + companyId,
            dataType: "json",
            success: function (data) {
                if (data.status == "1") {
                    var enterprise = data.enterpriseList[0];
                    console.log(enterprise.business_scope);
                    $("#addEnterpriseForm [name='company_name']").val(enterprise.company_name);
                    $("#addEnterpriseForm [name='plate']").val("");
                    $("#addEnterpriseForm [name='register_address']").val(enterprise.registration_address);
                    $("#addEnterpriseForm [name='office_address']").val("");
                    $("#addEnterpriseForm [name='registerDate']").val(enterprise.registerDate);
                    $("#addEnterpriseForm [name='register_capital']").val(enterprise.register_capital);
                    $("#addEnterpriseForm [name='legal_person']").val(enterprise.legal_representative);
                    $("#addEnterpriseForm [name='registration_authority']").val(enterprise.registration_authority);
                    $("#addEnterpriseForm [name='operation_term']").val(enterprise.operation_term);
                    $("#addEnterpriseForm [name='license_time']").val(enterprise.license_time);
                    $("#addEnterpriseForm [name='main_business']").val(enterprise.business_scope);
                } else {
                    alert("查询失败！");
                }
            }
        });
    });
    //点击输入框以外
    document.onclick = function (e) {
        var e = e ? e : window.event;
        var tar = e.srcElement || e.target;
        if (tar.id != "aaa") {
            $(".auto-completion").hide();
        }
    }


    //结束


})

/*添加企业*/
function addEnterprise() {
    var company_name = $.trim($("#CName").val());
    if (company_name == "") {
        alert("请输入企业名称")
    } else {
        $("#addEnterpriseForm").attr("action", "/company/addCompany");
        $("#addEnterpriseForm").attr("method", "post");
        $("#addEnterpriseForm").submit();
    }
}
/*删除企业*/
function delEnterprise(id, company_name) {
    $.ajax({
        type: "GET",
        url: '/company/findNoteByCompanyName?company_name=' + company_name,
        dataType: "json",
        success: function (data) {
            if (data.status == 0) {
                alert(data.message);
            } else {
                if (confirm("确定要删除该企业吗？")) {
                    window.location.href = "/company/delCompany?id=" + id;
                }
            }
        }
    });
}
/*修改企业*/
function editEnterprise(id) {
    $.ajax({
            type: "GET",
            url: '/company/findOneCompany?id=' + id,
            dataType: "json",
            success: function (data) {
                if (data.status == "1") {
                    var enterprise = data.company;
                    $("#editEnterpriseForm [name='id']").val(enterprise.id);
                    $("#editEnterpriseForm [name='company_name']").val(enterprise.company_name);
                    $("#editEnterpriseForm [name='plate']").val(enterprise.plate);
                    $("#editEnterpriseForm [name='register_address']").val(enterprise.register_address);
                    $("#editEnterpriseForm [name='office_address']").val(enterprise.office_address);
                    $("#editEnterpriseForm [name='registerDate']").val(enterprise.register_time);
                    $("#editEnterpriseForm [name='register_capital']").val(enterprise.register_capital);
                    $("#editEnterpriseForm [name='legal_person']").val(enterprise.legal_person);
                    $("#editEnterpriseForm [name='registration_authority']").val(enterprise.registration_authority);
                    $("#editEnterpriseForm [name='operation_term']").val(enterprise.operation_term);
                    $("#editEnterpriseForm [name='license_time']").val(enterprise.license_time);
                    $("#editEnterpriseForm [name='main_business']").val(enterprise.main_business);
                } else {
                    alert("查询失败！");
                }
            }
        }
    );
}

function updateEnterprise() {
    var company_name = $.trim($("#editName").val());
    if (company_name == "") {
        alert("请输入企业名称")
    } else {
        $("#editEnterpriseForm").attr("action", "/company/updateCompany");
        $("#editEnterpriseForm").attr("method", "post");
        $("#editEnterpriseForm").submit();
    }
}

function companyDetail(id) {
    window.location.href = "/company/companyDetail?id=" + id;
}
// 回车键事件
// 绑定键盘按下事件
$(document).keypress(function (e) {
    // 回车键事件
    if (e.which == 13) {
        searchEnterprise();
    }
});
//搜索
function searchEnterprise() {
    $("#searchEnterpriseForm").attr("action", "/company/findCompany");
    $("#searchEnterpriseForm").attr("method", "post");
    $("#searchEnterpriseForm").submit();
}
//重置
function resetting() {
    $("#searchEnterpriseForm [name='company_name']").val("");
    $("#searchEnterpriseForm [name='start_time']").val("");
    $("#searchEnterpriseForm [name='end_time']").val("");
    $("#searchEnterpriseForm [name='legal_person']").val("");
}
