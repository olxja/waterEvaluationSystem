<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.bean.*,java.util.*" %>
<%  List<Map>  list = (List<Map>)request.getAttribute("list");
    String start_time="";
    String end_time="";
    String bumen_name="";
    if(request.getAttribute("notepad")!=null){
  	   Notepad notepad = (Notepad)request.getAttribute("notepad");
  	   if(notepad.getBumen_name()!=null&&!"".equals(notepad.getBumen_name())){
  		 bumen_name=notepad.getBumen_name();
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
	<script type="text/javascript">
	document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
           $("#testquery").click();
	     }
	}
	findDeparts();
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
	function commitForm(){
		$("#form1").submit();
	}
	 function reset_data(){
	 		$("#bumen_name").val('');
	 		$("#start_time").val('');
	 		$("#end_time").val('');
	 	}	
	function  findTongji(pageNo){
		var bumen_name=$("#bumen_name").val();
		var demand=$("#demand").val();
		var start_time=$("#start_time").val();
		var end_time=$("#end_time").val();
		$.ajax({

	        type: "post",

	        url: "/notepad/tongjiNotepad",

	        data: {flag:1,bumen_name:bumen_name,demand:demand,start_time:start_time,end_time:end_time,type:'bumen_name'},
	        dataType: "json",

	        success: function(data){
	        	var all='';
	        	for(var  i=0;i<data.length;i++){
	        	var  content='<tr><td>'+data[i].id+'</td><td>'+data[i].bumen_name+'</td><td>'+data[i].count+'</td></tr>';
	        	
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
							<li><a href="/notepad/tongjiNotepad?type=bumen_name" class='selected'>部门</a></li>
							<li><a href="/notepad/tongjiNotepad?type=demand" >需求</a></li>
						</ul>
					</div>
					<!-- 部门 -->
					<div class="department">
						<div class="operation clearfix">
							<form action="tongjiNotepad?type=bumen_name"   method="post"  id="form1" >
								<div class="condition condition-box">
									<ul class="condition-list clearfix">
										 <li>
											<span>部门：</span>
											<select name="bumen_name" id="bumen_name">
												<option value="">请选择</option>
											</select>
										</li>
									<!-- 	<li>
											<span>需求类型：</span>
											<select name="demand" id="demand">
												<option value="">项目部</option>
												<option value="one">111</option>
												<option value="two">222</option>
												<option value="three">333</option>
											</select>
										</li>  -->
										<li class="range-li">
											<span>更新时间：</span>
											<input onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="start_time" value="<%=start_time %>" id="start_time" type="text">
											<span>至</span>
											<input onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="end_time" value="<%=end_time %>" id="end_time" type="text">
										</li>
										<li>
											<a class="button reset-btn" onclick="reset_data();">重置</a>
										</li>

									</ul>
								</div>
								<div class="action-button">
									<a class="button search-btn"  id="testquery" onclick="commitForm();">查询</a>
								</div>
							</form>
						</div>
						<div class="result department-result">
							<table>
								<thead>
									<tr>
										<td>序号</td>
										<td>部门</td>
										<td>汇总</td>
									</tr>
								</thead>
								<tbody  id="bumen_list">
								<%
								int i=0;
								for(Map m:list){
								%>
									<tr>
										<td><%=++i%></td>
										<td><%=m.get("bumen_name") %></td>
										<td><%=m.get("count") %></td>
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