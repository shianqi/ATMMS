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
		          <th>用户名</th>
		          <th>用户类型</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		      <% 
		      	List<User> list = (List<User>)request.getAttribute("userList");
		      	if(list!=null){
		      		for(int i=0;i<list.size();i++){
						User user = (User)list.get(i);
			   %>
				<tr class="">
		          <th scope="row"><%=i+1%></th>
		          <td><%=user.getUsername()%></td>
		          <td>
		          <%
		           	if(user.getUserType().equals("1")){
		          %>
		          <span class="label label-primary">管理员</span>
		          <% 		
		           	}
		           	if(user.getUserType().equals("2")){
		          %>
		          <span class="label label-default">科室负责人</span>
		          <% 
		          	}
		          %>
		          </td>
		          <td>
		          	<a href="${basePath}adminFixPassword.action?id=<%=user.getId()%>">修改密码</a>
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