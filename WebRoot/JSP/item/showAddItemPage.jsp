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
	
	<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#submitItem").bind("click", addItem);
		});
		
		function addItem(){
			var zTree = window.parent.$.fn.zTree.getZTreeObj("treeDemo",parent.document);
			var nodes = zTree.getNodesByParam("id",'${pId}',null);
			var treeNode = nodes[0];
			
			var name = $("#name").val();
			var ascription = $("#ascription").val();
			var principal = $("#principal").val();
			var medium = $("#medium").val();
			var remark = $("#remark").val();
			
			var date={
					pId:'${pId}',
					pType:"option",
					isParent:"false",
					name:name,
					ascription:ascription,
					principal:principal,
					medium:medium,
					remark:remark
				};
			alert(principal);
			$.post(
				"<%=basePath%>addItem.action",
				date,
				function(date){
					if(date.code=="true"){
						treeNode = zTree.addNodes(treeNode, {
							id:date.id,
							pId:date.pId, 
							name:name, 
							isParent:false, 
							type:"item", 
							open:false, 
							href:"<%=basePath%>showItem.action?id="+date.id
						});
						if (treeNode) {
							//zTree.editName(treeNode[0]);
						} else {
							alert("叶子节点被锁定，无法增加子节点");
						}
					}
				}
			);
		}
	</script>
    <title></title>
</head>
<body>
	<form style="margin:20px;" action="<%=basePath%>addItem.action" method="post">		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;文档名称&nbsp;&nbsp;&nbsp;</span>
		  <input id="name" type="text" name="name" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">&nbsp;&nbsp;&nbsp;所属科室&nbsp;&nbsp;&nbsp;</span>
		  <input id="ascription" type="text" name="ascription" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">科室负责人</span>
		  <input id="principal" type="text" name="principal" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
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
		  <input id="remark" type="text" name="remark" class="form-control" placeholder="" aria-describedby="basic-addon1" required="required">
		</div>
		<br>
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
		    <div class="btn-group" role="group">
		    	<button id="submitItem" type="button" class="btn btn-default">确认提交</button>
		    </div>
	    </div>
	</form>
</body>
</html>
