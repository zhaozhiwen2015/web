<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

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
<title>登录--${proName}</title>
<link rel='icon' href='${pageContext.request.contextPath}/images/favicon.ico' type='image/x-icon' />
<link rel='shortcut icon' href='${pageContext.request.contextPath}/images/favicon.ico' type='image/x-icon' />
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/jquery-1.8.0.min.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/jquery.easyui.min.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js' charset='UTF-8'></script>
<script type='text/javascript' language='JavaScript' src='${pageContext.request.contextPath}/js/index.js' charset='UTF-8'></script>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/themes/default/easyui.css' charset='UTF-8'/>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/themes/icon.css' charset='UTF-8'/>
<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/index-layout.css' charset='UTF-8'/>
<script>
$(function(){

	$('#sub').click(function(){
		validLoginForm();
		//$.messager.alert('警告','密码不能为空！！','error',function(){});
		//$('#tf').submit();
	});
	$('#xxx').click(function(){
		//window.location.reload();
		$(this).attr('src','${pageContext.request.contextPath}/validCode/randomImg?R=+Math.random()');
	});
	$('#res').click(function(){
		$('#uname').val("");
		$('#upwd').val("");
		$('#code').val("");
	});	
});

var validLoginForm = function(){

	if($.trim($('#uname').val())==""){
		$.messager.alert('警告','用户名不能为空！！','error',function(){});
		 return;
	 }
		if($.trim($('#upwd').val())==""){
			$.messager.alert('警告','密码不能为空！！','error',function(){});
		 return;
	 }
	 if($.trim($('#code').val())==""){
			$.messager.alert('警告','验证码不能为空！！','error',function(){});
		 return;
	 }
	 $('#tf').submit();
	 return ;
	 $.ajax( {
			url :"${pageContext.request.contextPath}/validCode/getCode",
			type :"post",
			data : {},
			async :false,
			dataType :'json',
			cache :false,
			success : function(code) {
            	if($.trim($('#code').val())!=code){
    				$.messager.alert('警告','验证码输入有误！！','error',function(){});
    				$('#xxx').click();
            	}else{
            		$('#tf').submit();
            	}
			},
			error : function() {
				$.messager.alert('警告','出错了！','error',function(){});
				return;
			}
		}); 		
};
</script>
<style>

</style>
</head>
<body >


 <div style='width:890px;height:461px;background:transparent;position:abosulte;margin:auto;z-index:0;background:url(${pageContext.request.contextPath}/images/loginx.jpg)'>
<form method=post action="${pageContext.request.contextPath}/user/login" id='tf' style='position:relative;padding-left:520px;padding-top:200px;'>
<table border=0>
<tbody>
<tr><td>用户名</td><td><input type=text value='' name='user.usrName' id='uname' class=input_195 maxLength="10" /></td></tr>
<tr><td>密&nbsp;&nbsp;码</td><td><input type=password value='' id='upwd' name='user.usrRemark' class=input_195  maxLength="14" /></td></tr>
<tr><td>验证码</td><td><img src='${pageContext.request.contextPath}/validCode/randomImg?R=<%=Math.random()%>' width="100" height="30" id='xxx' align="absmiddle" class=input_code /><input type=text value='' id='code'  name='code' class=input_98 maxLength="6" /></td></tr>
<tr><td colspan=2 align="center"><a href="javascript:void(0)" class="easyui-linkbutton" id="sub">登录</a>   <a href="javascript:void(0)" class="easyui-linkbutton" id="res">重置</a></td></tr>
<tr><td colspan=2 align="center"> </td></tr>
</tbody>
</table>
</form>
</div>

</body>
</html>