<%@page import="com.ATMMS.imudges.DAO.Itemchange"%>
<%@page import="com.ATMMS.imudges.DAO.User"%>
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
    <title>system—修改用户信息</title>
</head>
<body>
	<div style="margin:20px;">
		
		<div class="panel-body">
	      	<table class="table table-striped">
		      <thead>
		        <tr>
		          <th>#</th>
		          <th>操作者</th>
		          <th>操作类型</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		      <% 
		      	List<Itemchange> list = (List<Itemchange>)request.getAttribute("itemChangeList");
		      	if(list!=null){
		      		for(int i=0;i<list.size();i++){
						Itemchange itemchange = (Itemchange)list.get(i);
			   %>
				<tr class="">
		          <th scope="row"><%=i+1%></th>
		          <th><%=itemchange.getUsername()%></th>
		          <td>
		          <%
		           	if(itemchange.getType().equals("1")){
		          %>
		          <span class="label label-primary">修改</span>
		          <% 		
		           	}
		           	if(itemchange.getType().equals("2")){
		          %>
		          <span class="label label-default">删除</span>
		          <% 
		          	}
		          %>
		          </td>
		          <td>
		          <% 		
		           	if(itemchange.getType().equals("2")){
		          %>
		          	<a href="${basePath}showDelInformation.action?changeId=<%=itemchange.getId()%>">查看</a>
		          <%
					}		
		           	if(itemchange.getType().equals("1")){
		          %>
		          	<a href="${basePath}showChangeInformation.action?changeId=<%=itemchange.getId()%>">查看</a>
		          <%
					}
		      	  %>
		          </td>
		        </tr>
			  <%
					}
				}
		      %>
		      </tbody>
		    </table>
	      </div>
	</div>
</body>
</html>