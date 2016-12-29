//js限制显示字数
function cutstr(str,len)
{
   var str_length = 0;
   var str_len = 0;
      str_cut = new String();
      str_len = str.length;
      for(var i = 0;i<str_len;i++)
     {
        a = str.charAt(i);
        str_length++;
        if(escape(a).length > 4)
        {
         //中文字符的长度经编码之后大于4
         str_length++;
         }
         str_cut = str_cut.concat(a);
         if(str_length>=len)
         {
         str_cut = str_cut.concat("...");
         return str_cut;
         }
    }
    //如果给定字符串小于指定长度，则返回源字符串；
    if(str_length<len){
     return  str;
    }
}
//结束
$(function(){
	/*处理表格中显示内容的字数*/
	var tdArr=$(".result table tbody tr .handle-str");
	for(var i=0;i<tdArr.length;i++){
		var tdContent=$(tdArr[i]).html();
		tdContent=cutstr(tdContent,120);
		$(tdArr[i]).html(tdContent);
	}
	/*结束*/
  $(".nav .nav-list>li>a").click(function(){
    $(this).addClass("selected");
    $(this).parent().siblings().find("a").removeClass("selected");
    $(this).parent().siblings().find(".header-second-nav>ul>li>a").css({"color":"#999"});
  });
  $(".nav .nav-list>li:first-child").hover(function(){
    $(this).find(".header-second-nav").css({"display":"block"});
  },function(){
    $(this).find(".header-second-nav").css({"display":"none"});
  });
  $(".header-second-nav>ul>li>a").click(function(){
    $(this).css({"color":"#29aae3"});
    $(this).parent().siblings().find("a").css({"color":"#999"});
    $(this).parent().parent().parent().siblings("a").addClass("selected");
    $(this).parent().parent().parent().siblings("a").parent().siblings().find("a").removeClass("selected");
  });
  /*隐藏弹出框*/
  $(".eject").hide();
  /*结束*/
  var winheight=$(window).height();
  /*点击添加弹出*/
  $(".add-btn").click(function(){
    $(".add-eject").show(500);
    var thisHeight=$(".add-eject").find(".eject-box").height();
    var toTop=(winheight-thisHeight)/2;
    $(".add-eject").find(".eject-box").css({"margin-top":toTop});
  });
  /*结束*/
  /*点击修改弹出*/
  $(".list-edit").click(function(){
    $(".edit-eject").show(500);
    var thisHeight=$(".edit-eject").find(".eject-box").height();
    var toTop=(winheight-thisHeight)/2;
    $(".edit-eject").find(".eject-box").css({"margin-top":toTop});
  });
  /*结束*/
  /*点击详情弹出*/
  $(".list-detail").click(function(){
    $(".show-eject").show(500);
    var thisHeight=$(".show-eject").find(".eject-box").height();
    var toTop=(winheight-thisHeight)/2;
    $(".show-eject").find(".eject-box").css({"margin-top":toTop});
  });
  /*结束*/
  /*点击用户导入弹出*/
  $(".user-import-btn").click(function(){
    $(".import-user-eject").show(500);
    var thisHeight=$(".import-user-eject").find(".eject-box").height();
    var toTop=(winheight-thisHeight)/2;
    $(".import-user-eject").find(".eject-box").css({"margin-top":toTop});
  });
  /*结束*/
  /*点击弹出框取消*/
  $(".eject-cancel").click(function(){
    $(this).parent().parent().parent().hide(500);
  });
  /*结束*/
    /*点击弹出框取消(企业管理、记事本)*/
    $(".eject-cancel-a").click(function(){
        $(this).parent().parent().parent().parent().hide(500);
    });
    /*结束*/
    /*鼠标滚动*/
    $(window).scroll(function(){
        var scrollTop=$(window).scrollTop();
        $(".eject").css({"top":scrollTop});
        $(".select-box").css({"top":scrollTop});
    });
    /*结束*/
    /*鼠标滑过tr*/
    $(".result").on("mouseover mouseout","table tbody tr",function(event){
        var thisClass=$(this).attr("class");
        if(event.type == "mouseover"){
            //鼠标移入
            if(thisClass!="checkbox-box"){
                $(this).css({"background":"rgba(13,164,239,0.2)"});
            }
        }else if(event.type == "mouseout"){
            //鼠标移出
            var trIndex=$(this).index();
            if(thisClass!="checkbox-box"){
                $(this).css({"background":"none"});
            };
            if(trIndex%2 != 0){
                $(this).css({"background":"#fafafc"});
            }
        };
    });
    /*结束*/
    /*点击弹出框关闭按钮*/
    $(".eject-box .eject-box-title .eject-close").click(function(){
        $(this).parent().parent().parent().hide(500);
    });
    /*结束*/

})