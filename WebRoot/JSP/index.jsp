<%@page import="com.ATMMS.imudges.DAO.Option"%>
<%@page import="com.ATMMS.imudges.DAO.Item"%>
<%@page import="com.ATMMS.imudges.DAO.Factory"%>
<%@page import="com.ATMMS.imudges.DAO.Subsystem"%>
<%@page import="com.ATMMS.imudges.DAO.Major"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE></TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/demo.css" type="text/css">
	<link rel="stylesheet" href="css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" href="http://bootswatch.com/flatly/bootstrap.min.css">
	
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>
	<SCRIPT type="text/javascript">
		
		window.onload=function()//用window的onload事件，窗体加载完毕的时候
		{
		  	document.getElementById('left_size').style.height = (document.body.clientHeight-60) + 'px';
		  	document.getElementById('treeDemo').style.height = (document.body.clientHeight-60-42) + 'px';
		  	document.getElementById('J_iframe').width = (document.body.clientWidth-320) + 'px';
		  	document.getElementById('J_iframe').height = (document.body.clientHeight-65) + 'px';
		}
			
		
		
		window.onresize = function () {
			document.getElementById('left_size').style.height = (document.body.clientHeight-60) + 'px';
			document.getElementById('treeDemo').style.height = (document.body.clientHeight-60-42) + 'px';
			document.getElementById('J_iframe').width = (document.body.clientWidth-320) + 'px';
			document.getElementById('J_iframe').height = (document.body.clientHeight-65) + 'px';
		}
		var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				keep: {
					parent:true,
					leaf:true
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onClick: onClick
			}
		};

		var zNodes =[
			<%
				List<Major> list = (List<Major>)request.getAttribute("allMajor");
				for(int i=0;i<list.size();i++){
					Major major = list.get(i);
			%>
					{ id:"<%=major.getNum()%>", pId:0, name:"<%=major.getName()%>",type:"major", open:true, isParent:true},
			<%
				}
			%>
			
			
			<%
				List<Subsystem> list2 = (List<Subsystem>)request.getAttribute("allSubsystem");
				for(int i=0;i<list2.size();i++){
					Subsystem subsystem = list2.get(i);
			%>
					{ id:"<%=subsystem.getNum()%>", pId:"<%=subsystem.getParent()%>", name:"<%=subsystem.getName()%>",type:"subsystem", open:true, isParent:true},
			<%
				}
			%>
			
			<%
				List<Factory> list3 = (List<Factory>)request.getAttribute("allFactory");
				List<Option> list4 = (List<Option>)request.getAttribute("allOption");
				for(int i=0;i<list3.size();i++){
					Factory factory = list3.get(i);
			%>
					{ id:"<%=factory.getNum()%>", pId:"<%=factory.getParent()%>", name:"<%=factory.getName()%>",type:"factory", open:false, isParent:true},
			<%
					for(int j=0;j<list4.size();j++){
						Option option = list4.get(j);
			%>
						{ id:"<%=factory.getNum()%>-<%=option.getNum()%>", pId:"<%=factory.getNum()%>", name:"<%=option.getName()%>", type:"option", open:false, isParent:true},
			<%
					}
				}
			%>
			
			<%
				List<Item> list5 = (List<Item>)request.getAttribute("allItem");
				for(int i=0;i<list5.size();i++){
					Item item = list5.get(i);
			%>
					{ id:"<%=item.getNum()%>", pId:"<%=item.getParent()%>", name:"<%=item.getName()%>", type:"item", open:false, isParent:false ,href:"<%=basePath%>showItem.action?id=<%=item.getId()%>"},
			<%
				}
			%>
			
		];
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function onClick(event, treeId, treeNode, clickFlag) {
			//console.log(""+treeNode.name+" ---- "+treeNode.id+" ---- "+treeNode.pId);
			if(treeNode.href!=null){
				document.getElementById('J_iframe').src=treeNode.href;
			}
			
			//window.open(treeNode.link);
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		var newCount = 1;
		function add(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			isParent = e.data.isParent,
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if(typeof(treeNode)=="undefined"){
				date={
					pId:0,
					pType:"major",
					isParent:isParent
				}
			}else{
				date={
					pId:treeNode.id,
					pType:treeNode.type,
					isParent:isParent
				}
			}
			
			$.post(
				"<%=basePath%>addItem.action",
				date,
				function(id,state){
					if(state){
						if (treeNode) {
							treeNode = zTree.addNodes(treeNode, {id:id, pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
						} else {
							treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:true, name:"new folder" + (newCount++)});
						}
						if (treeNode) {
							zTree.editName(treeNode[0]);
						} else {
							alert("叶子节点被锁定，无法增加子节点");
						}
					}
				}
			);
		};
		function edit() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0) {
				alert("请先选择一个节点");
				return;
			}
			zTree.editName(treeNode);
		};
		function remove(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0) {
				alert("请先选择一个节点");
				return;
			}
			var callbackFlag = $("#callbackTrigger").attr("checked");
			zTree.removeNode(treeNode, callbackFlag);
		};
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#addParent").bind("click", {isParent:true}, add);
			$("#addLeaf").bind("click", {isParent:false}, add);
			$("#edit").bind("click", edit);
			$("#remove").bind("click", remove);
		});
		//-->
	</SCRIPT>
</HEAD>

<BODY>
<nav class="navbar navbar-default" style="margin:0">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="http://www.shianqi.com" target="J_iframe">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设置 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<div id="left_size">
		<ul id="treeDemo" class="ztree"></ul>
		<div class="right">
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addParent" href="#" title="增加父节点" onclick="return false;">增加文件夹</a> ]
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addLeaf" href="#" title="增加叶子节点" onclick="return false;">增加文件</a> ]
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="edit" href="#" title="编辑名称" onclick="return false;">编辑名称</a> ]<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="remove" href="#" title="删除节点" onclick="return false;">删除节点</a> ]
		</div>
	</div>
	
	<iframe id="J_iframe" class="J_iframe" name="J_iframe" width="100%" height="100%" src="" seamless></iframe>

</BODY>
</HTML>
