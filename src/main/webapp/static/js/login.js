$(function(){
	var windowHeight=$(window).height();
	$("#warp").css({"height":windowHeight});
	var formHeight=$("form").height();
	var formTop=(windowHeight-formHeight)/2;
	$("#warp").css({"padding-top":formTop});


	//验证密码（含有数字或者字母）
       var rePassword=/^[0-9A-Za-z]{6,32}$/;
       $('.new-psd').bind('input propertychange', function() {
    	    var oldPsd=$(".new-psd").val();
        	if(rePassword.test(oldPsd)){
        		$(".new-text").html("");
        	}else{
        		$(".new-text").html("密码长度6-32位，支持数字、字母");
        	}
      });

       $('.confirm-psd').bind('input propertychange', function() {
       		oldPsd=$("new-psd").val();
    	    var confirmPsd=$("confirm-psd").val();
        	if(oldPsd!=confirmPsd){
        		$(".confirm-text").html("");
        	}else{
        		$(".confirm-text").html("两次输入密码不一致");
        	}
      });
})