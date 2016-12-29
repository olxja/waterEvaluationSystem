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
		$(function(){
			var formHeight=$(".add-investment-event").height();
			var windowHeight=$(window).height();
			var formTop=(windowHeight-formHeight)/2;
			$(".add-investment-event").css({"top":formTop});
			$(".add-btn").click(function(){
				$(".add-investment-event").css({"display":"block"});
			});
			$(".add-investment-event .cancel-btn").click(function(){
				$(".add-investment-event").css({"display":"none"});
				$(".add-investment-event ul li input").val("");
			});
			$(".offline-btn").click(function(){
				popup("确定下线吗？");
			});
		})