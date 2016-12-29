$(function () {
    var winheight = $(window).height();
    $(".requirementMaintenance .second-nav>a").click(function () {
        $(this).addClass("selected");
        $(this).siblings("a").removeClass("selected");
    });
    $(".eject").hide();
    $(".requirementMaintenance .sub-add").click(function () {
        $(".add-requirement").show(500);
        var thisHeight = $(".add-requirement").find(".min-box").height() + 120;
        var toTop = (winheight - thisHeight) / 2;
        $(".add-requirement").find(".min-box").css({"margin-top": toTop});
    });
    /*$(".requirementMaintenance .sub-edit").click(function(){
     $(".edit-requirement").show(500);
     var thisHeight=$(".edit-requirement").find(".min-box").height()+120;
     var toTop=(winheight-thisHeight)/2;
     $(".edit-requirement").find(".min-box").css({"margin-top":toTop});
     });*/
    $(".min-box .min-btn .min-cancle").click(function () {
        $(this).parent().parent().parent().hide(500);
    });

})

function addNeed() {
    $("#addNeed").attr('action', "/addNeed");
    $("#addNeed").attr('method', "post");
    $("#addNeed").submit();
}

function editNeed() {
    var editId = $("#sub-nav .second-nav .selected").attr("value");
    var editName = $("#sub-nav .second-nav .selected").html();
    var winheight = $(window).height();
    if (editId != undefined) {
        $(".edit-requirement").show(500);
        var thisHeight = $(".edit-requirement").find(".min-box").height() + 120;
        var toTop = (winheight - thisHeight) / 2;
        $(".edit-requirement").find(".min-box").css({"margin-top": toTop});
        $("#editNeed  [name='id']").attr("value", editId);
        $("#editNeed  [name='name']").attr("value", editName);
    } else {
        alert("请选择要修改的需求.");
    }
}

function updateNeed() {
    $("#editNeed").attr("method", "post");
    $("#editNeed").attr("action", "/updateNeed");
    $("#editNeed").submit();
}

function delNeed() {
    var editId = $("#sub-nav .second-nav .selected").attr("value");
    var editName = $("#sub-nav .second-nav .selected").html();
    if (editId != undefined) {
        if (confirm("确定要删除需求 " + editName + " 吗?")) {
            window.location.href = "/delNeed?id=" + editId;
        }
    } else {
        alert("请选择要删除的需求.");
    }
}