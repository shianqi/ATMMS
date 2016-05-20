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
	<div style="margin:20px;">
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">文档名称</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getName()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">编号</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getNum()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">建档日期</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getNewTime()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">修订日期</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getFixTime()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">所属科室</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getAscription()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">科室负责人</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getPrincipal()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">资料介质</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getMedium()%>
	      </div>
		</div>
		<div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">备注</h3>
	      </div>
	      <div class="panel-body">
	      	<%=item.getRemark()%>
	      </div>
		</div>
		<form  action="<%=basePath%>fixItem.action" method="post">
		<input type="text" name="id" style="display:none;" class="form-control" value="${id}" placeholder="" aria-describedby="basic-addon1" required="required">
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-default">修改文档</button>
            </div>
        </div>
	</form>
	</div>
	
</body>
</html>
