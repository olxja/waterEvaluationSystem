$(function(){
	//自动补全
    function autoCompletion() {
        $(".auto-completion").remove();
        var companyName = $("#company_name").val();
        if (companyName != "" && companyName != null && companyName != undefined) {
            $.ajax({
                type: "POST",
                url: '/app/enterAutoComplete',
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
                    $(".company_name_box").append(autoCompletion);
                }
            });
        } else {
            $(".auto-completion").remove();
        }
    }

    $('#company_name').bind('input propertychange', function () {
        $(".auto-completion").remove();
        var companyName = $("#company_name").val();
        if (companyName != "" && companyName != null && companyName != undefined) {
            $.ajax({
                type: "POST",
                url: '/app/enterAutoComplete',
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
                    $(".company_name_box").append(autoCompletion);
                }
            });
        } else {
            $(".auto-completion").remove();
        }
        ;
    });
    //结束
    $(".company_name_box").on("click", ".auto-completion>li>a", function () {
        var companyId = $(this).attr("value");
        var companyname= $(this).text();
        $("#company_name").val(companyname);
        $("#company_id").val(companyId);
    });
    
  //点击输入框以外
    document.onclick = function (e) {
        var e = e ? e : window.event;
        var tar = e.srcElement || e.target;
        if (tar.id != "bbb") {
            $(".auto-completion").hide();
        }
    }
    //结束
	
  /*点击选择星级*/
  $(".add-eject .star-list>ul>li").click(function(){
    var num=$(this).index()+1;
    var starArr=$(this).parent().find("li");
    for(var i=0; i<starArr.length; i++){
      if(i<num){
        $(starArr[i]).find("img").attr("src","/static/images/star1.png");
      }else{
        $(starArr[i]).find("img").attr("src","/static/images/star2.png");
      }
    };
    $(this).parent().parent().find("span").eq(1).html(num+"星");
  });
  /*结束*/
  /*点击选择星级*/
  $(".edit-eject").on("click",".star-list>ul>li",function(){
    var num=$(this).index()+1;
    var starArr=$(this).parent().find("li");
    for(var i=0; i<starArr.length; i++){
      if(i<num){
        $(starArr[i]).find("img").attr("src","/static/images/star1.png");
      }else{
        $(starArr[i]).find("img").attr("src","/static/images/star2.png");
      }
    };
    $(this).parent().parent().find("span").eq(1).html(num+"星");
  });
  /*结束*/

})

