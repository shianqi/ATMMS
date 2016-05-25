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
	
    <title></title>
</head>
<body>
	<form style="margin:20px;" action="<%=basePath%>adminFixPasswordDown.action" method="post">		
		<input style="display:none;" type="text" name="id" value="${id}" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;新密码&nbsp;&nbsp;&nbsp;</span>
		  <input id="remark" type="password" name="password" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-default">确认修改</button>
            </div>
        </div>
	</form>
</body>
</html>
