$(function(){
	var winheight=$(window).height();
	$(".rolePermission .second-nav>a").click(function(){
		$(this).addClass("roleSelected");
		$(this).siblings("a").removeClass("roleSelected");
	});
	$(".eject").hide();
	$(".rolePermission .sub-add").click(function(){
		$(".add-role").show(500);
		var thisHeight=$(".add-role").find(".role-box").height()+120;
    	var toTop=(winheight-thisHeight)/2;
    	$(".add-role").find(".min-box").css({"margin-top":toTop});
	});
	$(".rolePermission .sub-edit").click(function(){
		$(".edit-role").show(500);
		var thisHeight=$(".edit-role").find(".role-box").height()+120;
    	var toTop=(winheight-thisHeight)/2;
    	$(".edit-role").find(".min-box").css({"margin-top":toTop});
	});
	$(".min-box .min-btn .min-cancle").click(function(){
		$(this).parent().parent().parent().hide(500);
	});
})