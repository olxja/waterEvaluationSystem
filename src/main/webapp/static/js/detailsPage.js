$(function(){
	/*结束*/
  /*隐藏评分记录*/
  $(".details-score-result").hide();
  /*结束*/
  $(".details-center .details-center-nav>li>a").click(function(){
    $(this).addClass("selected");
    $(this).parent().siblings().find("a").removeClass("selected");
    var thisIndex=$(this).parent().index();
    if(thisIndex==0){
      $(".details-notepad-result").show();
      $(".details-score-result").hide();
    }else if(thisIndex==1){
      $(".details-notepad-result").hide();
      $(".details-score-result").show();
    }
  });
})