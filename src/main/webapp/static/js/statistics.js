/*$(function(){
	结束
  隐藏部门
  $(".department").hide();
  结束
  隐藏需求
  $(".demand").hide();
  结束
  $(".select-model>ul>li>a").click(function(){
    $(this).addClass("selected");
    $(this).parent().siblings().find("a").removeClass("selected");
    var thisIndex=$(this).parent().index();
    if(thisIndex==0){
      $(".create-person").show();
      $(".department").hide();
      $(".demand").hide();
    }else if(thisIndex==1){
      $(".create-person").hide();
      $(".department").show();
      $(".demand").hide();
    }else if(thisIndex==2){
      $(".create-person").hide();
      $(".department").hide();
      $(".demand").show();
    }
  });
})*/