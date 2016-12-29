<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.bean.*,java.util.*" %>
<%  List<Map>  list = (List<Map>)request.getAttribute("list");
    String  user_name="";
    String  bumen_name="";
    String  demand="";
    String start_time="";
    String end_time="";
    if(request.getAttribute("notepad")!=null){
    	 Notepad notepad = (Notepad)request.getAttribute("notepad");
    	 if(notepad.getUser_name()!=null&&!"".equals(notepad.getUser_name())){
    	    	user_name=notepad.getUser_name();
    	    }
    	 if(notepad.getDemand()!=null&&!"".equals(notepad.getDemand())){
    		 demand=notepad.getDemand();
 	    }
    	 if(notepad.getBumen_name()!=null&&!"".equals(notepad.getBumen_name())){
    		 bumen_name=notepad.getBumen_name();
 	    }
    }
   if(request.getAttribute("start_time")!=null){
	   String start_time1 = (String)request.getAttribute("start_time");
	   if(start_time1!=null&&!"".equals(start_time1)){
	    	start_time=start_time1;
	    }
   }
    if(request.getAttribute("end_time")!=null){
    	   String end_time1 = (String)request.getAttribute("end_time");
    	   
    	    if(end_time1!=null&&!"".equals(end_time1)){
    	    	end_time=end_time1;
    	    }
    }
  

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- 不缓存 -->
	<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="0">
	<!-- 结束 -->
	<meta charset="UTF-8">
	<title>统计</title>
	<link rel="stylesheet" href="/static/css/reset.css">
	<link rel="stylesheet" href="/static/css/public.css">
	<script src="/static/js/jquery-1.11.1.js"></script>
	<script src="/static/js/public.js"></script>
	<script src="/static/js/statistics.js"></script>
	<script src="/static/laydate/laydate.js"></script>
	<script>
	document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
           $("#testquery").click();
	     }
	}
	findDeparts();
	findDDemand();
	function findDDemand(){
		var aa='<%=demand.replace("%","").trim()%>';
		$.ajax({

	        type: "post",
	        url: "/app/needList",

	        dataType: "json",

	        success: function(data){
	        	var datan=data.needs;
	        	for(var i =0;i<datan.length;i++){
	        		 if('全部'!=datan[i].name){
	        		if(aa==datan[i].name){
	        			$("#demand").append('<option selected="selected" value="'+datan[i].name+'">'+datan[i].name+'</option>');
	        		}else{
	        		$("#demand").append('<option value="'+datan[i].name+'">'+datan[i].name+'</option>');
	        	}}}
	        	
	        }});
	}
	 function reset_data(){
	 		$("#user_name").val('');
	 		$("#start_time").val('');
	 		$("#end_time").val('');
	 		
	 		$("#bumen_name").find('option').each(function(){
	 			if($(this).text()=='请选择'){
	 				$(this).attr("selected","selected");
	 			}
	 			else{
	 				$(this).removeAttr("selected");
	 			}
	 			
	 		});
	 		$("#demand").find('option').each(function(){
	 			if($(this).text()=='请选择'){
	 				$(this).attr("selected","selected");
	 			}
	 			else{
	 				$(this).removeAttr("selected");
	 			}
	 			
	 		})
	 		
	 	}	
	function findDeparts(){
		$.ajax({

	        type: "post",

	        url: "/notepad/findDeparts",

	        dataType: "json",

	        success: function(data){
	        	for(var i =0;i<data.length;i++){
	        		if('<%=bumen_name%>'==data[i].bumen_name){
	        			$("#bumen_name").append('<option selected="selected" value="'+data[i].bumen_name+'">'+data[i].bumen_name+'</option>');
	    	        	
	        		}
	        		else{
	        			$("#bumen_name").append('<option value="'+data[i].bumen_name+'">'+data[i].bumen_name+'</option>');
	    	        	
	        		}
	        		}
	        	
	        }});
	}
	//表单提交
	function commitForm(){
		$("#form1").submit();
	}
	function  findTongji(pageNo){
		var demand=$("#demand").val();
		var user_name=$("#user_name").val();
		var bumen_name=$("#bumen_name").val();
		var start_time=$("#start_time").val();
		var end_time=$("#end_time").val();
		$.ajax({

	        type: "post",

	        url: "/notepad/tongjiNotepad",

	        data: {flag:1,user_name:user_name,bumen_name:bumen_name,demand:demand,start_time:start_time,end_time:end_time,type:'user_name'},
	        dataType: "json",

	        success: function(data){
	        	var all='';
	        	for(var  i=0;i<data.length;i++){
	        	var  content='<tr><td>'+data[i].id+'</td><td>'+data[i].user_name+'</td><td>'+data[i].bumen_name+'</td><td>'+data[i].count+'</td></tr>';
	        	
	        	all+=content;
	        	
	        	}
	        	$("#bumen_list").html(all);
	        }
	        
		});
	}

	</script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content" class='statistics'>
		<div class="content-inner clearfix">
			<div id="show">
				<div class="show-inner">
					<div class="edit-title">统计</div>
					<div class="select-model">
						<ul class="clearfix">
							<li><a href="/notepad/tongjiNotepad?type=user_name"  class='selected'>创建人</a></li>
							<li><a href="/notepad/tongjiNotepad?type=bumen_name" >部门</a></li>
							<li><a href="/notepad/tongjiNotepad?type=demand" >需求</a></li>
							</ul>
					</div>
					<!-- 创建人 -->
					<div class="create-person">
						<div class="operation clearfix">
							<form action="tongjiNotepad?type=user_name"  method="post"  id="form1"  >
								<div class="condition condition-box">
									<ul class="condition-list clearfix">

										<li>
											<span>创建人：</span>
											<input type="text" value="<%=user_name %>" name="user_name" id="user_name" placeholder="创建人">
										</li>
										<li class="range-li">
											<span>更新时间：</span>
											<input id="start_time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<%=start_time %>" name="start_time" type="text">
											<span>至</span>
											<input id="end_time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<%=end_time %>" name="end_time" type="text">
										</li>
										<li>
											<span>部门：</span>
											<select id="bumen_name" name="bumen_name" >
												<option value="">请选择</option>
											</select>
										</li>
										<li>
											<span>需求类型：</span>
											<select id="demand" name="demand" >
												<option value="">请选择</option>
											</select>
										</li>
										<li>
											<a class="button reset-btn" onclick="reset_data();">重置</a>
										</li>
									</ul>
								</div>
								<div class="action-button">
									<a class="button search-btn" id="testquery" onclick="commitForm();" >查询</a>
								</div>
							</form>
						</div>
						<div class="result create-person-result">
							<table>
								<thead>
									<tr>
										<td>序号</td>
										<td>创建人</td>
										<td>部门</td>
										<td>汇总</td>
									</tr>
								</thead>
								<tbody id="bumen_list">
								<% 
								int i=0;
								for(Map m: list){ %>
									<tr>
										<td><%=++i %></td>
										<td><%=m.get("user_name").toString()%></td>
										<td><%=m.get("bumen_name").toString() %></td>
										<td><%=m.get("count").toString() %></td>
									</tr>
									<%} %>
										</tbody>
							</table>
						</div>
					</div>
					
					
			<!--分页-->
			<div class="page pb15 clearfix">
				<div class="r inb_a page_b" style="float: right;">
					<c:forEach items="${pagination.pageView }" var="page">
						${page}
					</c:forEach>
				</div>
			</div>
			<%--分页结束--%>
					<!-- 结束 -->
					<!-- 部门 -->
					<!-- 结束 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>