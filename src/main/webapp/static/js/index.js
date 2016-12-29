$(function(){
	function popup(srting){
		var popupBox="<div class='popup-box'>";
		var popupBoxTille="<h4>系统提示</h4>";
		var popupBoxContent="<span class='popup-box-content'>"+srting+"</span>";
		var popupBoxButton="<div class='popup-box-button'><a class='popup-box-confirm'>确定</a><a class='popup-box-cancel'>取消</a></div>";
		popupBox += popupBoxTille;
		popupBox += popupBoxContent;
		popupBox += popupBoxButton;
		popupBox += "</div>";
		$("body").append(popupBox);
		var scrollTop=$(document).scrollTop();
		var top=scrollTop+200;
		$(".popup-box").css({"top":top});
		$(".popup-box-confirm").click(function(){
			$(".popup-box").remove();
		});
		$(".popup-box-cancel").click(function(){
			$(".popup-box").remove();
		});
	};

	$(".second-level").slideUp(500);
	$(".one-level-title").click(function(){
		var state=$(this).siblings(".second-level").attr("value");
		if(state=="hide"){
			$(this).siblings("span").html("-");
			$(this).css({"background-color":"#314256"});
			$(this).siblings(".second-level").slideDown(1000);
			$(this).siblings(".second-level").attr("value","show");
		}else{
			$(this).siblings("span").html("+");
			$(this).css({"background-color":"#3b4f67"});
			$(this).siblings(".second-level").slideUp(1000);
			$(this).siblings(".second-level").attr("value","hide");
		};
	});

	/*左侧菜单高度*/
	var windowHeight=$(window).height();
	var documentHeight=$(document).height();
	if(windowHeight>documentHeight){
		$("#page-left").css({"height":windowHeight});
	}else{
		$("#page-left").css({"height":documentHeight});
	};
	/*结束*/
	/*弹出框高度*/
	function formCenter(obj){
		var formHeight=$(obj).find("form").height()+80;
		var scrollTop=$(window).scrollTop();
		documentHeight=$(document).height();
		if(windowHeight>documentHeight){
			var formTop=(windowHeight-formHeight)/2+scrollTop;
			$(obj).css({"height":windowHeight});
		}else{
			var formTop=scrollTop+30;
			$(obj).css({"height":documentHeight});
		};
		$(obj).find("form").css({"top":formTop});
	}
	/*结束*/

	/*select选择*/
	$(".select").hover(function(){
		$(this).find(".option").css({"display":"block"});
		$(this).css({"background":"url('../images/select-up.png') no-repeat 80px center #fcfcfc"});
	},function(){
		$(this).find(".option").css({"display":"none"});
		$(this).css({"background":"url('../images/select-down.png') no-repeat 80px center #fcfcfc"});
	});
	
	$(".select").on("mouseover mouseout",".option",function(event){
		 if(event.type == "mouseover"){
		  //鼠标移入
			 $(this).css({"background-color":"#3db7e0"});
		 }else if(event.type == "mouseout"){
		  //鼠标离开
			 $(this).css({"background-color":"#fff"});
		 };
	});
	
	$(".select").on("click",".option",function(){
		var selectType=$(this).html();
		var selectId=$(this).attr("id");
		$(this).siblings(".select .select-show").html(selectType);
		$(this).siblings(".select .select-show").attr("id",selectId);
	});
	
	/*结束*/

	/*点击新增按钮*/
	$(".add-btn").click(function(){
		$(".eject-box").css({"display":"block"});
		formCenter(".eject-box");
	});
	/*点击修改按钮*/
	/*$(".list-edit").click(function(){
		$(".edit-box").css({"display":"block"});
		formCenter(".edit-box");
	});*/
	/*点击删除按钮*/
	/*$(".list-del").click(function(){
		popup("确认删除");
	});*/
	/*点击详情按钮*/
	/*$(".list-details").click(function(){
		$(".show-box").css({"display":"block"});
		formCenter(".show-box");
	});*/
	
	/*点击选择用户按钮*/
	$(".select-user").click(function(){
		$(this).parent().parent().parent().parent().css({"display":"none"});
		$(".select-user-box").css({"display":"block"});
		formCenter(".select-user-box");
	});

	/*结束*/
	
	/*点击取消按钮函数*/
	function cancelBtn(obj){
		$(obj).find("input").val("");
		$(obj).find(".select .select-show").html("请选择");
		$(obj).css({"display":"none"});
		var checkObj=$(".operating-authority>li a");
		if(checkObj!=undefined){
			$(".operating-authority>li a").attr({"class":"checkbox"});
		};
	};
	/*结束*/
	/*点击弹出框新增中取消按钮*/
	$(".eject-box .button-cancel").click(function(){
		cancelBtn(".eject-box");
	});
	/*结束*/
	/*点击弹出框修改中取消按钮*/
	$(".edit-box .button-cancel").click(function(){
		cancelBtn(".edit-box");
	});
	/*结束*/
	/*点击弹出框详情中取消按钮*/
	$(".show-box .button-cancel").click(function(){
		cancelBtn(".show-box");
	});
	/*结束*/
	/*投资事件中公司标签删除*/
	$(".company-tag>ul>li>a").click(function(){
		$(this).parent().remove();
	});
	/*结束*/



	/*审核管理*/
	$(".to-examine .to-examine-nav a").click(function(){
		var aIndex=$(this).index();
		switch(aIndex){
			case 0:
				$(".pending-audit").css({"display":"block"});
				$(".already-examine").css({"display":"none"});
				break;
			case 1:
				$(".pending-audit").css({"display":"none"});
				$(".already-examine").css({"display":"block"});
				break;
		}
		$(this).addClass("concern-selected");
		$(this).siblings().removeClass("concern-selected");
	});
	/*结束*/

	/*用户权限管理*/
	$(".user-management>ul>li>.operating-authority>li>a").click(function(){
		var AClass=$(this).attr("class");
		if(AClass=="checkbox"){
			$(this).attr("class","checked");
		}else{
			$(this).attr("class","checkbox");
		};
	});
	/*结束*/
	/*头条管理*/
	$(".image-text").hide();
	$(".link-btn").click(function(){
		$(this).addClass("selected-btn").siblings().removeClass("selected-btn");
		$(".link").show();
		$(".image-text").hide();
	});
	$(".image-text-btn").click(function(){
		$(this).addClass("selected-btn").siblings().removeClass("selected-btn");
		$(".link").hide();
		$(".image-text").show();
	});
	/*结束*/
	/*图文编辑*/
	//$('#edit').editable({inlineMode: false, alwaysBlank: true});
	/*结束*/
})