<%@page import="com.ATMMS.imudges.DAO.Item"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://bootswatch.com/flatly/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>查看用户信息</title>
</head>
<body>
	<% 
		Item item = (Item)request.getAttribute("item");
	%>
	<form style="margin:20px;" action="<%=basePath%>fixItemDown.action" method="post">
		<input style="display:none;" type="text" name="id" class="form-control" value="${id}" placeholder="" aria-describedby="basic-addon1" required="required">
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;文档名称&nbsp;&nbsp;&nbsp;</span>
		  <input id="name" type="text" name="name" class="form-control" value="<%=item.getName()%>" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;所属科室&nbsp;&nbsp;&nbsp;</span>
		  <input id="ascription" type="text" name="ascription" class="form-control" value="<%=item.getAscription()%>" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">科室负责人</span>
		  <input id="principal" type="text" name="principal" class="form-control" value="<%=item.getPrincipal()%>" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>	
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;资料介质&nbsp;&nbsp;&nbsp;</span>
		  <select id="medium" class="form-control" name="medium">
				<option value="纸质">纸质</option>
				<option value="电子">电子</option>
		  </select>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;文档备注&nbsp;&nbsp;&nbsp;</span>
		  <input id="remark" type="text" name="remark" class="form-control" value="<%=item.getRemark()%>" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-default">确认修改信息</button>
            </div>
        </div>
	</form>
</body>
</html>
