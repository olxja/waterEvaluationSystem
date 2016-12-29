<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>       	
<%@page import="com.bean.*,java.util.*" %>
<%  List<Map>  list = (List<Map>)request.getAttribute("list");
   
    String start_time="";
    String end_time="";
    String demand="";
    if(request.getAttribute("notepad")!=null){
 	   Notepad notepad = (Notepad)request.getAttribute("notepad");
 	   if(notepad.getDemand()!=null&&!"".equals(notepad.getDemand())){
 		  demand=notepad.getDemand();
 	   }
}
     String start_time1 = (String)request.getAttribute("start_time");
     String end_time1 = (String)request.getAttribute("end_time");
    if(start_time1!=null&&!"".equals(start_time1)){
    	start_time=start_time1;
    }
    if(end_time1!=null&&!"".equals(end_time1)){
    	end_time=end_time1;
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
	findDDemand();
	function findDDemand(){
		$.ajax({

	        type: "post",

	        url: "/app/needList",

	        dataType: "json",

	        success: function(data){
	        	var datan=data.needs;
	        	for(var i =0;i<datan.length;i++){
	        		 if('全部'!=datan[i].name){
	        		if('<%=demand%>'==datan[i].name){
	        			$("#demand").append('<option selected="selected" value="'+datan[i].name+'">'+datan[i].name+'</option>');
	        		}else{
	        		$("#demand").append('<option value="'+datan[i].name+'">'+datan[i].name+'</option>');
	        	}}}
	        	
	        }});
	}

	function commitForm(){
		$("#form1").submit();
	}
	function  findTongji(pageNo){
		var demand=$("#demand").val();
		var start_time=$("#start_time").val();
		var end_time=$("#end_time").val();
		$.ajax({

	        type: "post",

	        url: "/notepad/tongjiNotepad",

	        data: {flag:1,demand:demand,start_time:start_time,end_time:end_time,type:'demand'},
	        dataType: "json",

	        success: function(data){
	        	var all='';
	        	for(var  i=0;i<data.length;i++){
	        	var  content='<tr><td>'+data[i].id+'</td><td>'+data[i].demand+'</td><td>'+data[i].count+'</td></tr>';
	        	
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
							<li><a href="/notepad/tongjiNotepad?type=user_name">创建人</a></li>
							<li><a href="/notepad/tongjiNotepad?type=bumen_name">部门</a></li>
							<li><a href="/notepad/tongjiNotepad?type=demand" class='selected'>需求</a></li>
						</ul>
					</div>
					<!-- 需求 -->
					<div class="demand">
						<!-- <div class="operation clearfix">
							<div class="condition condition-box">
								<ul class="condition-list clearfix">
								<form action="tongjiNotepad?type=demand"  method="post"   id="form1" > 
									<li>
										<span>需求：</span>
										<select name="demand" id="demand">
											<option value="">请选择</option>
										</select>
									</li>
									<li class="range-li">
										<span>更新时间：</span>
										<input value="<%=start_time %>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="start_time" name="start_time"  type="text">
										<span>至</span>
										<input value="<%=end_time %>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="end_time" name="end_time" type="text">
									</li>
									<li>
										<a class="button search-btn" onclick="commitForm();">查询</a>
										<a class="button reset-btn">重置</a>
									</li>
									</form>
								</ul>
							</div>
						</div>-->
						<div class="result demand-result">
							<table>
								<thead>
									<tr>
										<td>序号</td>
										<td>需求</td>
										<td>汇总</td>
									</tr>
								</thead>
								<tbody id="bumen_list">
								<%
								int i =0;
								for(Map m:list){ 
								
								%>
									<tr>
										<td><%=++i %></td>
										<td><%=m.get("demand").toString()%></td>
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
				</div>
			</div>
		</div>
	</div>
</body>
</html>