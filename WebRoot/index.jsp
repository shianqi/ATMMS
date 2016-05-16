<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Login</title>
    <link href="css/styles.css" type="text/css" media="screen" rel="stylesheet" />    

</head>
<body id="login">
    <div id="wrappertop">
    </div>
    <div id="wrapper">
        <div id="content">
            <div id="header">
                <h1>
                    <a href=""></a>
                </h1>
            </div>
            <div id="darkbanner" class="banner320">
                <h2>
                    Login  System</h2>
            </div>
            <div id="darkbannerwrap">
            </div>
            <form method="post" action="<%=basePath%>login.action">
            	<fieldset class="form">
	                <p>
	                    <label class="loginlabel" for="user_name">
	                        Username:</label>
	                    <input class="logininput" name="username" id="user_name" type="text" value="" />
	                </p>
	                <p>
	                    <label class="loginlabel" for="user_password">Password:</label>
	                    <span>
	                        <input class="logininput" name="password" id="user_password" type="password"/>
	                    </span>
	                </p>
	                <input id="loginbtn" type="submit" value="登陆"/>
            	</fieldset>
           	</form>
        </div>
    </div>
</body>

