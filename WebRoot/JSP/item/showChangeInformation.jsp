<%@page import="com.ATMMS.imudges.DAO.Itemchange"%>
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
		Itemchange itemchange = (Itemchange)request.getAttribute("itemChange");
	%>
	<div style="margin:20px;">
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
			      <div class="panel-heading">
			        <h3 class="panel-title">文档名称</h3>
			      </div>
			      <div class="panel-body">
			      	<%=item.getName()%>
			      </div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-<%
				if(item.getName().equals(itemchange.getName())){
				%>default<%
				}else{
				%>danger<%
				}
				%>">
			      <div class="panel-heading">
			        <h3 class="panel-title">文档名称</h3>
			      </div>
			      <div class="panel-body">
			      	<%=itemchange.getName()%>
			      </div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
			      <div class="panel-heading">
			        <h3 class="panel-title">所属科室</h3>
			      </div>
			      <div class="panel-body">
			      	<%=item.getAscription()%>
			      </div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-<%
				if(item.getAscription().equals(itemchange.getAscription())){
				%>default<%
				}else{
				%>danger<%
				}
				%>">
			      <div class="panel-heading">
			        <h3 class="panel-title">所属科室</h3>
			      </div>
			      <div class="panel-body">
			      	<%=itemchange.getAscription()%>
			      </div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
			      <div class="panel-heading">
			        <h3 class="panel-title">科室负责人</h3>
			      </div>
			      <div class="panel-body">
			      	<%=item.getPrincipal()%>
			      </div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-<%
				if(item.getPrincipal().equals(itemchange.getPrinclpal())){
				%>default<%
				}else{
				%>danger<%
				}
				%>">
			      <div class="panel-heading">
			        <h3 class="panel-title">科室负责人</h3>
			      </div>
			      <div class="panel-body">
			      	<%=itemchange.getPrinclpal()%>
			      </div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
			      <div class="panel-heading">
			        <h3 class="panel-title">资料介质</h3>
			      </div>
			      <div class="panel-body">
			      	<%=item.getMedium()%>
			      </div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-<%
				if(item.getMedium().equals(itemchange.getMedium())){
				%>default<%
				}else{
				%>danger<%
				}
				%>">
			      <div class="panel-heading">
			        <h3 class="panel-title">资料介质</h3>
			      </div>
			      <div class="panel-body">
			      	<%=itemchange.getMedium()%>
			      </div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
			      <div class="panel-heading">
			        <h3 class="panel-title">备注</h3>
			      </div>
			      <div class="panel-body">
			      	<%=item.getRemark()%>
			      </div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-<%
				if(item.getRemark().equals(itemchange.getRemark())){
				%>default<%
				}else{
				%>danger<%
				}
				%>">
			      <div class="panel-heading">
			        <h3 class="panel-title">备注</h3>
			      </div>
			      <div class="panel-body">
			      	<%=itemchange.getRemark()%>
			      </div>
				</div>
			</div>
		</div>
		<%
	    	if(request.getSession().getValue("userType").equals("1")){
	    %>
		<form  action="<%=basePath%>itemChangeDone.action" method="post">
		<input type="text" name="id" style="display:none;" class="form-control" value="${changeId}" placeholder="" aria-describedby="basic-addon1" required="required">
		<input type="text" name="state" style="display:none;" class="form-control" value="true" placeholder="" aria-describedby="basic-addon1" required="required">
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-success">通过修改</button>
            </div>
        </div>
		</form>
		<br>
		<form  action="<%=basePath%>itemChangeDone.action" method="post">
		<input type="text" name="id" style="display:none;" class="form-control" value="${changeId}" placeholder="" aria-describedby="basic-addon1" required="required">
		<input type="text" name="state" style="display:none;" class="form-control" value="false" placeholder="" aria-describedby="basic-addon1" required="required">
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-default">不通过修改</button>
            </div>
        </div>
		</form>
		<%
	    	}
	    %>
	</div>
	
</body>
</html>
