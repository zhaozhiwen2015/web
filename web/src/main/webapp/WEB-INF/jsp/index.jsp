<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${proName}</title>
<link rel='icon' href='${pageContext.request.contextPath}/images/favicon.ico' type='image/x-icon' />
<link rel='shortcut icon' href='${pageContext.request.contextPath}/images/favicon.ico' type='image/x-icon' />
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/jquery-1.8.0.min.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/jquery.easyui.min.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/index.js' charset='UTF-8'></script>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/themes/default/easyui.css' charset='UTF-8'/>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/themes/icon.css' charset='UTF-8'/>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/index-layout.css' charset='UTF-8'/>
<script type='text/javascript' >
$(function(){

    $(".easyui-accordion").accordion({
         collapsible: true,
         active: 0
     });


});
function logout(){
	
	 $.messager.confirm("提示", "确认退出系统？", function (r) {  
	        if (r) {  
	        	window.location.href="${pageContext.request.contextPath}/user/logout";	        }  
	    });


}
</script>
<style>
</style>
</head>
<body class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'north',split:false" style="width:100%;height:100px;font-size:20px;">
           <div class="easyui-layout"  data-options="fit:true" style="width:100%;height:100%">
             <div data-options="region:'center',split:false" style="overflow:hidden;background:url(${pageContext.request.contextPath}/images/top2.jpg) repeat-x"> 
<img src="${pageContext.request.contextPath}/images/top1.jpg"/>
 			</div>
             <div data-options="region:'south',split:false,border:false">
             <div style="height:28px;line-height:28px;overflow:hidden;padding-left:10px;background:url(${pageContext.request.contextPath}/images/0.jpg) repeat-x">
             欢迎您：            <s:set name="ui" value="(#session['loginUser'])"></s:set>
             <font color=red  id='xnn'>
             <s:property value="#ui.usrName" /></font>
            <span style="display:none" id='uid'><s:property value="#ui.id" /></span>
            <span>【<c:if test="#ui.type==0">普通用户</c:if><c:if test="#ui.type==1">主管用户</c:if><c:if test="#ui.type==2">管理员</c:if>】</span>
			<span>
			<a href="javascript:void(0)" class="easyui-linkbutton"  style="color:red" plain="true" onclick="logout()">退出系统</a>
			</span>
    </div>        </div>
          </div>
       
        </div>

        <div data-options="region:'west',split:false,fit:false" title="系统菜单" style="width:200px;">
        
		<div class="easyui-accordion" style="width:200px;" data-options="fit:true,border:false">
		



           <div   data-options="border:false,iconCls:'icon-edit'" title="录帐管理" class="west-class-title" >
					<ul class="west_menu_ul">
						<li><label src="${pageContext.request.contextPath}/user/list" class="newLink">数据列表</label></li> 
					</ul>			
			</div>
			
			<div  title="汇总表格"  data-options="border:false,iconCls:'icon-print'"  class="west-class-title" >
					<ul class="west_menu_ul">
					<s:iterator id='iit' value='dateLst' status='st'>
						<li><label src="${pageContext.request.contextPath}/user/referSheetLst.do?ym=${iit}" class="newLink">${iit}总表</label></li>
					</s:iterator>
					<%-- 	<li><label src="${pageContext.request.contextPath}/user/referSheetLst.do" class="newLink">查看总表</label></li> --%>
					</ul>
			</div>

			<div   title="店铺管理"  data-options="border:false,iconCls:'icon-search'" class="west-class-title" >
					<ul class="west_menu_ul">
						<li><label src="${pageContext.request.contextPath}/shop/referShopLst.do" class="newLink">店铺列表</label></li> 							
					</ul>
				
			</div>
			
			
           <div  title="用户管理"  data-options="border:false,iconCls:'icon-reload'" class="west-class-title" >
					<ul class="west_menu_ul">
						<li><label src="${pageContext.request.contextPath}/user/referUsrLst.do" class="newLink">用户维护</label></li>
					</ul>
				
			</div>
   


		<div data-options="border:false,iconCls:'icon-tip'" title="个人信息" class="west-class-title" >
					<ul class="west_menu_ul">
						<li><label src="${pageContext.request.contextPath}/user/referUsrInf.do" class="newLink">信息修改</label></li>

					</ul>
				
			</div>

		   
		</div>
        
        </div>
        <div data-options="region:'center'">
            <div id="centerTab" class="easyui-tabs" data-options="fit:true,border:false">
			<!-- <div id="tabs1" title="首页" iconCls="icon-ok"> 
				
				</div> -->
			</div>
        </div>
            <div data-options="region:'south',split:false" style="height:35px;line-height:35px;overflow:hidden;text-align:center">${copyRight}</div>

</body>
</html>