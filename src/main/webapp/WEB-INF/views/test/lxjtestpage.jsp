<%--
  Created by IntelliJ IDEA.
  User: olxja_000
  Date: 2017/2/15
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>李雪剑测试用page</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js" type="text/javascript"></script>
    <script type="text/javascript">
        function showCompanyId() {
            var val=parseInt(document.getElementById("data").value);
            $.ajax({
                url: "<%=request.getContextPath()%>/getUserCompanyId",
                type:"post",
                data:{
                    user_id:val
                },
                success: function (data) {
                    alert(data);
                },
                fail:function () {
                    alert(val);
                }
            })
        }
        function showCompanyInfo() {
            var val=document.getElementById("data").value;
            $.ajax({
                url:"<%=request.getContextPath()%>/getMyData",
                type:"post",
                data:{
                    company_id:val
                },
                success:function (data) {
                    alert(data)
                }
            })
        }

        function deleteData() {
            var val=document.getElementById("data").value;
            $.ajax({
                url: "<%=request.getContextPath()%>/deleteCompanyInfo",
                type:"post",
                data:{
                    company_id:val
                },
                success: function (data) {
                    alert(data);
                },
                fail:function () {
                    alert("fail");
                }
            })
        }
        function insertCompany() {
            var company_name=document.getElementById("company_name").value;
            var main_business_income_2015=Number(document.getElementById("main_business_income_2015").value);
            var main_business_income_2014=Number(document.getElementById("main_business_income_2014").value);
            var userList = new Array();
            userList.push({
//                "company_id": "1ER",
//                "company_name": company_name,
//                "user_id":167,
//                "main_business_income_2015":main_business_income_2015,
//                "main_business_income_2014":main_business_income_2014

                "studentName":"李四",
                "studentNo":"111"

            });
            $.ajax({
                url:"<%=request.getContextPath()%>/insertCompanyInfo",
                type:"post",
                data: JSON.stringify(userList),
                dataType:"json",
                contentType: "application/json",
                success:function (data) {
                    alert("data");
                }
            })
        }


    </script>
</head>
<body>
<input type="text"  id="data"><br><br>
<input type="button" value="根据输入的用户id输出公司id" onclick="showCompanyId()"><br><br>
<input type="button" value="根据输入的公司id输出公司信息" onclick="showCompanyInfo()"><br><br>
<input type="button" value="根据输入的公司id删除数据" onclick="deleteData()"><br><br>

<hr>

<form id="insertdata">
    公司名：<input id="company_name" type="text"><br><br>
    2015年营业收入：<input id="main_business_income_2015" type="text"><br><br>
    2014年营业收入：<input id="main_business_income_2014" type="text"><br><br>
    <input type="button"value="添加" onclick="insertCompany()">
</form>
</body>
</html>
