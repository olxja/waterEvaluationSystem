<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.bean.Notepad,java.util.*" %>
<%
    String username = (String) request.getSession().getAttribute("username");
    List<Notepad> list = (List<Notepad>) request.getAttribute("notepads");
    Notepad notepad = null;
    String company_name = "";
    String demand = "";
    ;
    String user_name = "";
    String bumen_name = "";
    if (request.getAttribute("param") != null) {
        notepad = (Notepad) request.getAttribute("param");
        company_name = notepad.getCompany_name();
        demand = notepad.getDemand();
        user_name = notepad.getUser_name();
        bumen_name = notepad.getBumen_name();
    }
    if (company_name == null) {
        company_name = "";
    }
    if (user_name == null) {
        user_name = "";
    }
    if (demand == null) {
        demand = "";
    }
    String start_time1 = (String) request.getAttribute("start_time");
    String end_time1 = (String) request.getAttribute("end_time");
    String start_time = "";
    String end_time = "";
    if (start_time1 != null && !"".equals(start_time1)) {
        start_time = start_time1;
    }
    if (end_time1 != null && !"".equals(end_time1)) {
        end_time = end_time1;
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
    <title>记事本</title>
    <link rel="stylesheet" href="/static/css/reset.css">
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">

    <script src="/static/js/jquery-1.11.1.js"></script>
    <script src="/static/js/public.js"></script>
    <script src="/static/js/notepad.js"></script>
    <script src="/static/js/ajaxfileupload.js"></script>
    <script src="/static/laydate/laydate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="content" class='notepad'>
    <div class="content-inner clearfix">
        <div id="show">
            <div class="show-inner">
                <div class="show-top">
                    <div class="edit-title">记事本</div>
                    <div class="operation clearfix">
                        <form action="/notepad/findNotepad" id="form1">
                            <div class="condition condition-box">
                                <ul class="condition-list clearfix">
                                    <li>
                                        <span>公司名称：</span>
                                        <input type="text" id="reset_name" name="company_name" value="<%=company_name%>"
                                               placeholder="公司名称">
                                    </li>

                                    <li>
                                        <span>创建人：</span>
                                        <input type="text" id="reset_username" name="user_name" value="<%=user_name%>"
                                               placeholder="创建人">
                                    </li>
                                    <!-- <li>
                                        <span>部门：</span>
                                        <select>
                                            <option value="start">项目部</option>
                                            <option value="one">111</option>
                                            <option value="two">222</option>
                                            <option value="three">333</option>
                                        </select>
                                    </li> -->
                                    <li class="range-li">
                                        <span>更新时间：</span>
                                        <input type="text" value="<%=start_time %>"
                                               onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="start_time"
                                               id="start_time">
                                        <span>至</span>
                                        <input type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
                                               value="<%=end_time %>" name="end_time" id="end_time">
                                    </li>
                                    <li>
                                        <span>需求：</span>
                                        <select name="demand" id="deman">
                                            <option value="">请选择</option>
                                        </select>
                                    </li>
                                    <li>
                                        <a class="button reset-btn" onclick="reset_data();">重置</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="action-button">
                                <a class="button search-btn" id="testquery" onclick="commitForm();">查询</a>
                                <a class="button add-btn">添加</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="show-bottom">
                    <div class="result notepad-result">
                        <table>
                            <thead>
                            <tr>
                                <td>序号</td>
                                <td>企业名称</td>
                                <td>主题</td>
                                <td>内容</td>
                                <td>需求</td>
                                <td>创建者</td>
                                <td>星级</td>
                                <td>创建时间</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                int i = 0;
                                for (Notepad notepad1 : list) { %>
                            <tr>
                                <td><%=++i %>
                                </td>
                                <td><%=notepad1.getCompany_name() %>
                                </td>
                                <td><%=notepad1.getSubject() %>
                                </td>
                                <td class="handle-str"><%=notepad1.getContent() %>
                                </td>
                                <td>
                                    <%--<%=notepad1.getDemand().replace(",", "</br>") %>--%>
                                    <%
                                        String[] demands = new String[0];
                                        if (notepad1.getDemand() != null) {
                                            demands = notepad1.getDemand().split(",");
                                        }
                                        for (int a = 0; a < demands.length && a < 3; a++) {
                                    %>
                                        <%=demands[a]%></br>
                                    <%
                                        }
                                    %>
                                </td>
                                <td><%=notepad1.getUser_name() %>
                                </td>
                                <td><%=notepad1.getAll_score() %>
                                </td>
                                <td><%=notepad1.getCreatetime() %>
                                </td>
                                <td>
                                    <div class="td-btn td-btn1 clearfix">
                                        <a class="list-detail"
                                           onclick="javascript:notepadDetail('<%=notepad1.getId()%>')"><img
                                                src="${pageContext.request.contextPath}/static/images/td-show.png"
                                                alt=""></a>
                                        <%if (username.equals(notepad1.getUser_name())) {%>
                                        <a class="list-del"
                                           onclick="javascript:deleteNotepad('<%=notepad1.getId()%>')"><img
                                                src="${pageContext.request.contextPath}/static/images/td-del.png"
                                                alt=""></a>
                                        <a class="list-edit"
                                           onclick="javascript:updateNotepad('<%=notepad1.getId()%>')"><img
                                                src="${pageContext.request.contextPath}/static/images/td-edit.png"
                                                alt=""></a>
                                        <%}%>
                                        <%--如果不是本人--%>
                                        <%if (!username.equals(notepad1.getUser_name())) {%>
                                        <shiro:hasPermission name="dNotepad">
                                            <a class="list-del"
                                               onclick="javascript:deleteNotepad('<%=notepad1.getId()%>')"><img
                                                    src="${pageContext.request.contextPath}/static/images/td-del.png"
                                                    alt=""></a>
                                        </shiro:hasPermission>
                                        <shiro:hasPermission name="uNotepad">
                                            <a class="list-edit"
                                               onclick="javascript:updateNotepad('<%=notepad1.getId()%>')"><img
                                                    src="${pageContext.request.contextPath}/static/images/td-edit.png"
                                                    alt=""></a>
                                        </shiro:hasPermission>
                                        <%}%>
                                    </div>
                                </td>
                            </tr>
                            <%} %>
                            </tbody>
                        </table>
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
                </div>
            </div>
        </div>
    </div>
</div>
<div class='eject add-eject notepad-add-eject'>
    <!-- 记事本开始 -->
    <div class="eject-box">
        <div class="eject-box-title">
            <h3>添加记事本</h3>
            <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
        </div>
        <div class="eject-box-content-box">
            <div class="eject-box-content">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业名称：</span>
                    <div class='company_name_box' id="bbb">
                        <input class='input1' type="text" id="company_name" placeholder="匹配库里的数据展示">
                        <input class='input1' type="hidden" id="company_id" placeholder="匹配库里的数据展示">
                        <em>*</em>
                    </div>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>联系人：</span>
                    <input class='input1' id="contact" type="text" placeholder="请输入联系人">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>联系方式：</span>
                    <input class='input1' id="contact_tel" type="text" placeholder="请输入联系方式">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>板块：</span>
                    <select id="plate" name="plate">
                        <option value="暂无">请选择</option>
                        <option value="标准版">标准板</option>
                        <option value="孵化板">孵化板</option>
                        <option value="大创板">大创板</option>
                        <option value="科创板">科创板</option>
                        <option value="创新板">创新板</option>
                         <option value="其它">其它</option>
                    </select>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业标签：</span>
                    <select id="enterprise_one_label"
                            onChange="label_two('enterprise_one_label','enterprise_two_label');">
                        <option value="">请选择</option>
                    </select>
                    <select id="enterprise_two_label">
                        <option value="">请选择</option>
                    </select>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>主题：</span>
                    <input class='input1' id="subject" type="text" placeholder="请输入主题">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面时间：</span>
                    <input class='input6' type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
                           id="meet_time" placeholder="">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面地点：</span>
                    <input class='input1' id="meet_address" type="text" placeholder="请输入会面地点">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>对方人员：</span>
                    <input class='input1' id="other_person" type="text" placeholder="请输入对方人员">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>我方人员：</span>
                    <input class='input8' id="my_person" type="text" disabled="disabled" placeholder="请选择我方人员">
                    <em>*</em>
                    <input class="input-btn select-person" type="button" value="选择人员" onclick="addSelectPersonFun()">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>内容：</span>
                    <textarea id="content_add" cols="30" rows="10" placeholder="请输入内容"></textarea>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>需求：</span>
                    <ul class="checkbox-list clearfix" id="demand">
                    </ul>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>评价：</span>
                    <div class="star-list-box">
                        <div class="star-list clearfix">
                            <span>商业模式</span>
                            <ul>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="shahngyemoshi_score"></span>
                        </div>
                        <div class="star-list clearfix">
                            <span>团队能力</span>
                            <ul>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="team_score"></span>
                        </div>
                        <div class="star-list clearfix">
                            <span>业务能力</span>
                            <ul>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="yewu_score"></span>
                        </div>
                    </div>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>描述：</span>
                    <textarea id="description" cols="30" rows="10" placeholder="请输入描述"></textarea>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>附件：</span>
                    <input type="hidden" name="fileUrl" id="fileUrl" value=""/>
                    <input class='input-btn input-btn1' id="file1" type="file" name="uploadFileName" value="添加附件">
                    <button onclick="ajaxFileUpload('file1')">提交图片</button>
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="addNotepad();">确定</a>
                <a class="eject-cancel-a" name="quxiao">取消</a>
            </div>
        </div>
    </div>
</div>
<div class='eject edit-eject notepad-edit-eject'>
    <div class="eject-box">
        <div class="eject-box-title">
            <h3>修改记事本</h3>
            <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
        </div>
        <div class="eject-box-content-box">
            <div class="eject-box-content">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业名称：</span>
                    <input type="hidden" id="notepadid"/>
                    <input class='input1' name="company_name" id="update_company_name" type="text"
                           placeholder="匹配库里的数据展示">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>联系人：</span>
                    <input class='input1' id="update_contact" type="text" placeholder="请输入联系人">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>联系方式：</span>
                    <input class='input1' id="update_contact_tel" type="text" placeholder="请输入联系方式">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>板块：</span>
                    <select id="update_plate" name="plate">
                        <option value="暂无">请选择</option>
                        <option value="标准版">标准板</option>
                        <option value="孵化板">孵化板</option>
                        <option value="大创板">大创板</option>
                        <option value="科创板">科创板</option>
                        <option value="创新板">创新板</option>
                          <option value="其它">其它</option>
                    </select>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业标签：</span>
                    <select id="update_enterprise_one_label"
                            onChange="label_two('update_enterprise_one_label','update_enterprise_two_label')"
                            name="enterprise_one_label">
                        <option value="">一级标签</option>
                    </select>
                    <select id="update_enterprise_two_label" name="enterprise_two_label">
                        <option value="">二级标签</option>
                    </select>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>主题：</span>
                    <input class='input1' name="subject" id="update_subject" type="text">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面时间：</span>
                    <input class='input6' type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
                           name="meet_time" id="update_meet_time" placeholder="年">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面地点：</span>
                    <input class='input1' name="meet_address
                    " id="update_meet_address" type="text">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>对方人员：</span>
                    <input class='input1' name="other_person" id="update_other_person" type="text">
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>我方人员：</span>
                    <input class='input8' name="my_person" id="update_my_person"  disabled="disabled" type="text">
                    <em>*</em>
                    <input class="input-btn select-person" type="button" value="选择人员" onclick="editSelectPersonFun()">
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>内容：</span>
                    <textarea name="content" id="update_content" cols="30" rows="10"></textarea>
                    <em>*</em>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>需求：</span>
                    <ul class="checkbox-list clearfix" id="update_demand">
                    </ul>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>评价：</span>
                    <div class="star-list-box">
                        <div class="star-list clearfix">
                            <span>商业模式</span>
                            <ul id="update_shangyemoshi">
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="update_shangyemoshi_s"></span>
                        </div>
                        <div class="star-list clearfix">
                            <span>团队能力</span>
                            <ul id="update_tuanduinengli">
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="update_tuanduinengli_s"></span>
                        </div>
                        <div class="star-list clearfix">
                            <span>业务能力</span>
                            <ul id="update_yewunengli">
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="update_yewunengli_s"></span>
                        </div>
                    </div>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>描述：</span>
                    <textarea name="" id="update_desc" cols="30" rows="10"></textarea>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>附件：</span>
                    <input type="hidden" name="fileUrl" id="update_fileUrl" value="ceshidizhi"/>
                    <input class='input-btn input-btn1' id="file2" type="file" name="uploadFileName" value="添加附件">
                    <button onclick="ajaxFileUpload('file2')">提交图片</button>
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="javascript:addUpdateNotepad();">确定</a>
                <a class="eject-cancel-a" name="quxiao">取消</a>
            </div>
        </div>
    </div>
</div>
<div class='eject show-eject notepad-show-eject'>
    <div class="eject-box">
        <div class="eject-box-title">
            <h3>记事本详情</h3>
            <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
        </div>
        <div class="eject-box-content-box">
            <div class="eject-box-content">
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业名称：</span>
                    <span id="detail_company">北京信息服务有限公司</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>板块：</span>
                    <span id="detail_bankuai">创新板块</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>企业标签：</span>
                    <span id="detail_enterprise_one_label">金融</span>
                    <span id="detail_enterprise_two_label">基金</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>主题：</span>
                    <span id="detai_subject">融资需求沟通交谈</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面时间：</span>
                    <span id="detail_meet_time">2016-11-16</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>会面地点：</span>
                    <span id="detail_address">北京海淀区中关村国际创客中心</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>对方人员：</span>
                    <span id="detail_other">李碧涛</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>我方人员：</span>
                    <span id="detail_my">陈涛</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>内容：</span>
                    <p id="detail_content"></p>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>需求：</span>
                    <span>政策</span>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>评价：</span>
                    <div class="star-list-box">
                        <div class="star-list clearfix">
                            <span>商业模式</span>
                            <ul id="shangyemoshi">
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="shangyemoshi_s">4星</span>
                        </div>
                        <div class="star-list clearfix">
                            <span>团队能力</span>
                            <ul id="tuanduinengli">
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="tuanduinengli_s">2星</span>
                        </div>
                        <div class="star-list clearfix">
                            <span>业务能力</span>
                            <ul id="yewunengli">
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star1.png" alt=""></li>
                                <li><img src="/static/images/star2.png" alt=""></li>
                            </ul>
                            <span id="yewunengli_s">4星</span>
                        </div>
                    </div>
                </div>
                <div class='item-list clearfix'>
                    <span class='item-list-name'>描述：</span>
                    <p id="detail_desc"> 公司发展良好，创新能力强，团队强大</p>
                </div>
                <div class='item-list clearfix' id="fufile">
                    <span class='item-list-name'>附件：</span>

                    <!-- <a id="file_query" href=""><input class='input-btn input-btn1' type="button" value="查看附件"/></a> -->
                </div>
            </div>
            <div class="eject-btn">
                <a class="eject-cancel-a">返回</a>
            </div>
        </div>
    </div>
</div>

<div class='eject add_select-person-eject'>
    <div class="eject-box">
        <div class="eject-box-title">
            <h3>请选择我方人员</h3>
            <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
        </div>
        <div class="eject-box-content-box">
            <input type="hidden" id="person_id" name="person_id">
            <ul id="addMyPersonTree" class="easyui-tree" name="easyui"
                url="/getMyPerson"
                checkbox="true">
            </ul>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="addMyPerson()">确定</a>
                <a class="eject-cancel-a" name="">取消</a>
            </div>
        </div>
    </div>
</div>

<div class='eject edit_select-person-eject'>
    <div class="eject-box">
        <div class="eject-box-title">
            <h3>修改我方人员</h3>
            <a class="eject-close"><img src="${pageContext.request.contextPath}/static/images/close.png" alt=""></a>
        </div>
        <div class="eject-box-content-box">
            <input type="hidden" id="edit_person_id" name="edit_person_id">
            <ul id="editMyPersonTree" class="easyui-tree" name="easyui"
                url="/getMyPerson"
                checkbox="true">
            </ul>
            <div class="eject-btn">
                <a class="eject-confirm" onclick="editMyPerson()">确定</a>
                <a class="eject-cancel-a" name="">取消</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script type="text/javascript">
    $(function () {
        document.onkeydown = function (e) {
            var ev = document.all ? window.event : e;
            if (ev.keyCode == 13) {
                $("#testquery").click();
            }
        }
        getNeed('', 'demand');//添加需求
        label_one('enterprise_one_label');
        label_one('update_enterprise_one_label');
        findDDemand();

    })

    function findDDemand() {
        $.ajax({

            type: "post",

            url: "/app/needList",

            dataType: "json",

            success: function (data) {
                var datan = data.needs;
                for (var i = 0; i < datan.length; i++) {
                    if ('全部' != datan[i].name) {
                        if ('<%=demand%>' == datan[i].name) {
                            $("#deman").append('<option selected="selected" value="' + datan[i].name + '">' + datan[i].name + '</option>');
                        } else {
                            $("#deman").append('<option value="' + datan[i].name + '">' + datan[i].name + '</option>');
                        }
                    }
                }

            }
        });
    }
    function commitForm() {
        $("#form1").submit();
    }
    //获取需求
    function getNeed(need, id) {
        $.ajax({

            type: "post",

            url: "/app/needList",

            dataType: "json",

            success: function (data) {
                var content0 = '<li><input class="input1" id="' + id + '"name="demand" value="';
                var content0_afert = '" type="checkbox"><span>';
                var content = '<li><input class="input1" id="' + id + '" name="demand" checked="checked" value="';
                var content_after = '"type="checkbox"><span>';
                var content1 = '</span></li>';
                var needs = data.needs;
                $("#" + id).html('');
                for (var i = 0; i < needs.length; i++) {
                    if ('全部' != needs[i].name) {
                        if (need != '' && need.indexOf(needs[i].name) != -1) {
                            $("#" + id).append(content + needs[i].name + content0_afert + needs[i].name + content1);
                        } else {
                            $("#" + id).append(content0 + needs[i].name + content_after + needs[i].name + content1);
                        }
                    }
                }

            }
        });

    }

    //上传附件
    function ajaxFileUpload(id) {
        $.ajaxFileUpload
        (
                {
                    type: 'post',
                    url: '/notepad/uploadFile', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: id, //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                        alert('上传成功');
                        $("[name='fileUrl']").val(data.url);
                    },
                    error: function (data, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
        )
        return false;
    }
    function deleteNotepad(id) {
        if (confirm("确定删除?")) {
            $.ajax({

                type: "post",

                url: "/notepad/deletePage",

                data: {id: id},

                dataType: "json",

                success: function (data) {
                    window.location.reload();
                }
            });
        }
    }
    function notepadDetail(id) {
        $.ajax({

            type: "post",

            url: "/notepad/notepadDetail",

            data: {id: id},

            dataType: "json",

            success: function (data) {
                $("#detail_company").text(data.company_name);
                $("#detail_meet_time").text(data.meet_time);
                $("#detail_enterprise_one_label").text(data.enterprise_one_label);
                $("#detail_enterprise_two_label").text(data.enterprise_two_label);
                $("#detail_bankuai").text(data.plate);
                $("#detai_subject").text(data.subject);
                $("#detail_address").text(data.meet_address);
                $("#detail_other").text(data.other_person);
                $("#detail_my").text(data.my_person);
                $("#detail_content").text(data.content);
                $("#detail_desc").text(data.description);
                $("#detail_desc").text(data.description);
                //新版本
                var files = data.fu_file.split(",");
                $("#fufile").html('<span class="item-list-name">附件：</span>');
                for (var i = 0; i < files.length; i++) {
                    var fileName = files[i].split(";")[0];
                    $("#fufile").append('<span>' + fileName + '</span><a id="file_query" target="_blank" href="' +files[i].split(";")[1] + '"><input class="input-btn input-btn1" type="button" value="查看附件"/></a></br>');
                }
                //旧版本好使用
                /*   var files = data.fu_file.split(",");
                 for (var i = 0; i < files.length; i++) {
                 var fileName = files[i].substring(files[i].lastIndexOf("/") + 1, files[i].length);
                 ;
                 $("#fufile").append('<span>' + fileName + '</span><a id="file_query" target="_blank" href="' + files[i] + '"><input class="input-btn input-btn1" type="button" value="查看附件"/></a></br>');
                 } */

                var shangyemoshi = data.shangye_score;
                var tuanduinengli = data.team_score;
                var yewunengli = data.yewu_score;
                var imagecontent = '<li><img src="/static/images/star1.png" alt=""></li>';
                $("#shangyemoshi").html("");
                $("#tuanduinengli").html("");
                $("#yewunengli").html("");
                for (var i = 1; i <= shangyemoshi; i++) {
                    $("#shangyemoshi").append(imagecontent);
                }
                $("#shangyemoshi_s").text(shangyemoshi + "星");
                $("#tuanduinengli_s").text(tuanduinengli + "星");
                $("#yewunengli_s").text(yewunengli + "星");
                for (var i = 1; i <= tuanduinengli; i++) {
                    $("#tuanduinengli").append(imagecontent);
                }
                for (var i = 1; i <= yewunengli; i++) {
                    $("#yewunengli").append(imagecontent);
                }
            }
        });

    }
    //修改方法(查出之前的数据)
    function updateNotepad(id) {
        $.ajax({

            type: "post",

            url: "/notepad/notepadDetail",

            data: {id: id},

            dataType: "json",

            success: function (data) {
                $("#notepadid").val(data.id);
                $("#update_company_name").val(data.company_name);
                $("#update_plate").val(data.plate);
                var dat= data.plate;
                $("#update_plate").find("option").each(function(){
                	if($(this).attr("value")==dat){
                		$(this).attr("selected","selected");
                	}
                })
                $("#update_contact").val(data.contact);
                $("#update_contact_tel").val(data.contact_tel);
                $("#update_subject").val(data.subject);
                $("#update_meet_address").val(data.meet_address);
                $("#update_other_person").val(data.other_person);
                $("#update_my_person").val(data.my_person);
                $("#update_content").text(data.content);
                $("#update_desc").text(data.description);
                $("#update_meet_time").val(data.meet_time);
                $("#update_fileUrl").val(data.fu_file);
                $("#update_enterprise_one_label option").each(function () {
                    if (data.enterprise_one_label == $(this).val()) {
                        $(this).attr("selected", "selected");
                    }
                })
                $("#update_enterprise_two_label").html('<option value="' + data.enterprise_two_label + '">' + data.enterprise_two_label + '</option>');
                data.enterprise_two_label
                //以上是修改的信息
                var shangyemoshi = data.shangye_score;
                var tuanduinengli = data.team_score;
                var yewunengli = data.yewu_score;
                if (typeof(shangyemoshi) == "undefined") {
                    shangyemoshi = 0;
                }
                if (typeof(tuanduinengli) == "undefined") {
                    tuanduinengli = 0;
                }
                if (typeof(yewunengli) == "undefined") {
                    yewunengli = 0;
                }
                var imagecontent = '<li><img src="/static/images/star1.png" alt=""></li>';
                var imagecontent1 = '<li><img src="/static/images/star2.png" alt=""></li>';
                $("#update_shangyemoshi").html("");
                $("#update_tuanduinengli").html("");
                $("#update_yewunengli").html("");
                $("#update_shangyemoshi_s").text(shangyemoshi + "星");
                $("#update_tuanduinengli_s").text(tuanduinengli + "星");
                $("#update_yewunengli_s").text(yewunengli + "星");
                for (var i = 1; i <= shangyemoshi; i++) {
                    $("#update_shangyemoshi").append(imagecontent);
                }
                for (var i = 1; i <= tuanduinengli; i++) {
                    $("#update_tuanduinengli").append(imagecontent);
                }
                for (var i = 1; i <= yewunengli; i++) {
                    $("#update_yewunengli").append(imagecontent);
                }
                //没被选中的图片
                for (var i = 0; i < 5 - tuanduinengli; i++) {
                    $("#update_tuanduinengli").append(imagecontent1);
                }
                for (var i = 0; i < 5 - yewunengli; i++) {
                    $("#update_yewunengli").append(imagecontent1);
                }
                for (var i = 0; i < 5 - shangyemoshi; i++) {
                    $("#update_shangyemoshi").append(imagecontent1);
                }
                getNeed(data.demand, 'update_demand');//循环放在想要的位置
                $("#update_company_name").attr("disabled","disabled");
            	$("#update_contact").attr("disabled","disabled");
            	$("#update_contact_tel").attr("disabled","disabled");
            	$("#update_plate").attr("disabled","disabled");
            	$("#update_enterprise_one_label").attr("disabled","disabled");
            	$("#update_enterprise_two_label").attr("disabled","disabled");
            }

        });

    }
    //添加(修改数据)方法
    function addUpdateNotepad() {
        var notepadid = $("#notepadid").val();
        var update_company_name = $("#update_company_name").val();
        var meettime = $("#update_meet_time").val();
        var update_plate = $("#update_plate").val();
        var update_contact = $("#update_contact").val();
        var update_contact_tel = $("#update_contact_tel").val();
        var update_subject = $("#update_subject").val();
        var update_meet_address = $("#update_meet_address").val();
        var update_other_person = $("#update_other_person").val();
        var update_my_person = $("#update_my_person").val();
        var update_content = $("#update_content").val();
        var update_desc = $("#update_desc").val();
        var update_fileUrl = $("#update_fileUrl").val();
        var update_yewunengli_s = $("#update_yewunengli_s").text().replace('星', '');
        var update_shangyemoshi_s = $("#update_shangyemoshi_s").text().replace('星', '');
        var update_tuandui_s = $("#update_tuanduinengli_s").text().replace('星', '');
        var enterprise_one_label = $("#update_enterprise_one_label").val();
        var enterprise_two_label = $("#update_enterprise_two_label").val();
        var demands = '';
        $("[id='update_demand']:checked").each(function (i) {
            demands += $(this).val() + ",";
        });
        demands = demands.substring(0, demands.length - 1);
        $.ajax({

            type: "post",

            url: "/notepad/addNotepad",

            data: {
                meet_time: meettime,
                contact: update_contact,
                contact_tel: update_contact_tel,
                demand: demands,
                team_score: update_tuandui_s,
                shangye_score: update_shangyemoshi_s,
                yewu_score: update_yewunengli_s,
                fu_file: update_fileUrl,
                enterprise_one_label: enterprise_one_label,
                enterprise_two_label: enterprise_two_label,
                id: notepadid,
                company_name: update_company_name,
                plate: update_plate,
                subject: update_subject,
                meet_address: update_meet_address,
                other_person: update_other_person,
                my_person: update_my_person,
                content: update_content,
                description: update_desc
            },

            dataType: "json",

            success: function (data) {
                alert('修改成功');
                window.location.reload();
            }

        });

    }
    //新添加笔记本
    function addNotepad() {
        var update_company_name = $("#company_name").val();
        if (update_company_name == '' || update_company_name == null) {
            alert("企业不能为 空!");
            return;
        }
        var contact = $("#contact").val();
        if (contact == '' || contact == null) {
            alert("联系人不能为 空!");
            return;
        }
        var contact_tel = $("#contact_tel").val();
        if (contact_tel == '' || contact_tel == null) {
            alert("联系人电话不能为 空!");
            return;
        }
        var company_id = $("#company_id").val();
        var update_plate = $("#plate").val();
        var update_subject = $("#subject").val();
        if (update_subject == '' || update_subject == null) {
            alert("主题不能为 空!");
            return;
        }
        var update_meet_address = $("#meet_address").val();
        if (update_meet_address == '' || update_meet_address == null) {
            alert("会见地址不能为 空!");
            return;
        }
        var meet_time = $("#meet_time").val();
        if (meet_time == '' || meet_time == null) {
            alert("会见时间不能为 空!");
            return;
        }
        var update_other_person = $("#other_person").val();
        if (update_other_person == '' || update_other_person == null) {
            alert("对方人员不能为 空!");
            return;
        }
        var update_my_person = $("#my_person").val();
        if (update_my_person == '' || update_my_person == null) {
            alert("我方人员不能为 空!");
            return;
        }
        var enterprise_one_label = $("#enterprise_one_label").val();
        if (enterprise_one_label == '' || enterprise_one_label == null) {
            alert("一级标签不能为 空!");
            return;
        }
        var enterprise_two_label = $("#enterprise_two_label").val();
        if (enterprise_two_label == '' || enterprise_two_label == null) {
            alert("二级标签不能为 空!");
            return;
        }
        var shahngyemoshi_score = $("#shahngyemoshi_score").text().replace('星', '');
        if (shahngyemoshi_score == '' || shahngyemoshi_score == null) {
            alert("商业评分不能为 空!");
            return;
        }
        var team_score = $("#team_score").text().replace('星', '');
        if (team_score == '' || team_score == null) {
            alert("团队评分不能为 空!");
            return;
        }
        var yewu_score = $("#yewu_score").text().replace('星', '');
        if (yewu_score == '' || yewu_score == null) {
            alert("业务评分不能为 空!");
            return;
        }
        var update_content = $("#content_add").val();
        if (update_content == '' || update_content == null) {
            alert("内容不能为 空!");
            return;
        }
        var update_desc = $("#description").val();
        if (update_desc == '' || update_desc == null) {
            alert("评价不能为 空!");
            return;
        }
        var demands = '';
        $("[id='demand']:checked").each(function (i) {
            demands += $(this).val() + ",";
        });
        if (demands == '' || demands == null) {
            alert("需求不能为 空!");
            return;
        }
        demands = demands.substring(0, demands.length - 1);
        var fileUrl = $("#fileUrl").val();
        $.ajax({

            type: "post",

            url: "/notepad/addNotepad",

            data: {
                contact: contact,
                contact_tel: contact_tel,
                companyId: company_id,
                plate: plate,
                meet_time: meet_time,
                demand: demands,
                fu_file: fileUrl,
                shangye_score: shahngyemoshi_score,
                team_score: team_score,
                yewu_score: yewu_score,
                enterprise_one_label: enterprise_one_label,
                enterprise_two_label: enterprise_two_label,
                company_name: update_company_name,
                plate: update_plate,
                subject: update_subject,
                meet_address: update_meet_address,
                other_person: update_other_person,
                my_person: update_my_person,
                content: update_content,
                description: update_desc
            },

            dataType: "json",

            success: function (data) {
                alert('添加成功');
                window.location.href = '/notepad/findNotepad';
            }

        });
    }
    //企业一级标签
    function label_one(id) {
        $.ajax({

            type: "post",

            url: "/notepad/label_one",

            dataType: "json",

            success: function (data) {
                //添加一级标签数据
                for (var i = 0; i < data.length; i++) {
                    $("#" + id).append('<option value="' + data[i].label_name + '" >' + data[i].label_name + "</option>");
                }
            }
        });
    }
    //企业二级标签
    function label_two(id, idt) {
        var name = $('#' + id).val();
        $.ajax({

            type: "post",

            url: "/notepad/label_two",

            data: {labelName: name},

            dataType: "json",

            success: function (data) {

                //添加二级标签数据
                $("#" + idt).html('');
                for (var i = 0; i < data.length; i++) {
                    $("#" + idt).append('<option  value="' + data[i].label_name + '" >' + data[i].label_name + "</option>");

                }
            }
        });

    }
    function reset_data() {
        $("#reset_name").val('');
        $("#reset_username").val('');
        $("#start_time").val('');
        $("#end_time").val('');
        $("#deman").find('option').each(function () {
            if ($(this).text() == '请选择') {
                $(this).attr("selected", "selected");
            }
            else {
                $(this).removeAttr("selected");
            }

        })
    }
    /*选择我方人员*/
    function addSelectPersonFun() {
        $(".add_select-person-eject").show(500);
        var winheight = $(window).height();
        var thisHeight = $(".add_select-person-eject").find(".eject-box").height();
        var toTop = (winheight - thisHeight) / 2;
        $(".add_select-person-eject").find(".eject-box").css({"margin-top": toTop});
    }
    ;
    function editSelectPersonFun() {
        var notepadId = $("#notepadid").val();
        $('#editMyPersonTree').tree({
            url: '/getMyPerson?notepadId=' + notepadId
        });
        $(".edit_select-person-eject").show(500);
        var winheight = $(window).height();
        var thisHeight = $(".edit_select-person-eject").find(".eject-box").height();
        var toTop = (winheight - thisHeight) / 2;
        $(".edit_select-person-eject").find(".eject-box").css({"margin-top": toTop});
    }
    ;
    function addMyPerson() {
        var nodes = $('#addMyPersonTree').tree('getChecked');
        var text = "";
        for (var i = 0; i < nodes.length; i++) {
            var node = nodes[i];
            if (node.userId != undefined) {
                text += node.text + ",";
            }
        }
        var length = text.length;
        if (length > 0) {
            text = text.substring(0, length - 1);
        }
        $("#my_person").attr("value", text);
        $(".add_select-person-eject").hide(500);
    }
    /*结束*/
    function editMyPerson() {
        var nodes = $('#editMyPersonTree').tree('getChecked');
        var text = "";
        for (var i = 0; i < nodes.length; i++) {
            var node = nodes[i];
            if (node.userId != undefined) {
                text += node.text + ",";
            }
        }
        var length = text.length;
        if (length > 0) {
            text = text.substring(0, length - 1);
        }
        $("#update_my_person").val(text)
        $(".edit_select-person-eject").hide(500);
    }
    /*结束*/
</script>