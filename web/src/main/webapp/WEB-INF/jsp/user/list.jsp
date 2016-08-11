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
<base href="<%=basePath%>" />
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
<script type="text/javascript">
       var url;
       var valid= function(){
    	   if($.trim($('#un').val())==""){
    		   $.messager.alert("提示","用户名不能为空！","info");
    		   return false;
    	   }
    	   if($.trim($('#up').val())==""){
    		   $.messager.alert("提示","手机号码不能为空！","info");
    		   return false;
    	   }
     	   if($('#ut option:selected').val()==0&&$.trim($('#dp').combobox('getText'))==""){
    		   $.messager.alert("提示","普通用户必须指定店铺名称！","info");
    		   return false;
    	   }
     	   return true;
     	  
       };
       function newUser(){
    	   $('#ui').val('');
    	   $('#un').val('');
    	   $('#up').val('');
    	   $('#uq').val('');
    	   $('#dp').combobox('setText','');
    	   $('#inf').show();
    	   $('#dlg').dialog('open').dialog('setTitle','添加用户');

       }
       function editUser(){
           var row = $('#dg').datagrid('getSelected');
           if (row){
               $('#ui').val(row.id);
               $('#un').val(row.usrName);
      	 	   $('#ug option:selected').text(row.gender);
        	   $('#up').val(row.phone);
        	   $('#uq').val(row.qq);
        	   $('#ut option:selected').val(row.type);
        	//   alert(row.ownerId);
        	   $('#dp').combobox('setValue',row.ownerId).combobox('setText',row.dname);
        	   $('#inf').hide();
        	   $('#dlg').dialog('open').dialog('setTitle','修改用户');
           }else{
          	 $.messager.alert("提示","请选择要修改信息的用户！","info");
           }
       }
       
       function saveUser(){
  			if(true==valid()){
  			   $('#dlg').dialog('close'); 
  	    	   $.ajax( {
  	    			url :"${pageContext.request.contextPath}/jusr/addUser.do",
  	    			type :"post",
  	    			data : $('#fm').serialize(),
  	    			async :false,
  	    			dataType :'json',
  	    			cache :false,
  	    			success : function(t) {
  	                	if(1==t.ret){
  	  	    				$.messager.alert('警告','保存用户成功！','info',function(){
  	  	                       $('#dg').datagrid('reload');  	  	    					
  	  	    				});
  	                	}
  	    			},
  	    			error : function() {
  	    				$.messager.alert('警告','保存用户失败！','error',function(){ $('#dlg').dialog('close');});
  	    				return;
  	    			}
  	    		}); 		  				
  			}
       }
       function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            
            if (row){
//            	alert(JSON.stringify(row));
            	//JSON.parse();
                $.messager.confirm('确认','确认要删除此用户?',function(r){
                    if (r){
                    	if($('#uid', window.parent.document).text()==row.id){
                    		$.messager.alert("警告","不能删除自已！！","warning");    	  
                    		return ;
                    	}
                        $.post('${pageContext.request.contextPath}/jusr/delUser.do',{id:row.id},function(result){
                            if (result.ret==1){
                                $('#dg').datagrid('reload');
                            } else {
                                $.messager.show({    // show error message
                                    title: '错误',
                                    msg: "删除失败！"
                                });
                            }
                        },'json');
                    }
                });
            }else{
            	 $.messager.alert("提示","请选择要删除的用户！","info");
            }
        }
    
       function djUser(type){
           var row = $('#dg').datagrid('getSelected');
           var msg = '';
           if(1==type)msg = '确认要冻结此用户？冻结后该用户将无法登录系统进行录帐操作！！';
           else msg = '确认解冻该用户？';
           if (row){
//           	alert(JSON.stringify(row));
           	//JSON.parse();
               $.messager.confirm('确认',msg,function(r){
                   if (r){
                   	
                       $.post('${pageContext.request.contextPath}/jusr/djUser.do',{id:row.id,'type':type},function(result){
             
                               $('#dg').datagrid('reload');
                        
                       },'json');
                   }
               });
           }else{
           	if(1==type)$.messager.alert("提示","请选择要冻结的用户！","info");
        	else $.messager.alert("提示","请选择要解冻的用户！","info");
           }
       }
       
       $(function(){
    	   
    	   $(window).resize(function() { 
    		   $('#dg').datagrid('resize');
    	   });
		     $('#sbbtn').click(function() { 
		    	 var queryParams = $('#dg').datagrid('options').queryParams;  
			      queryParams.name = $.trim($('#sb').val());  
			      $('#dg').datagrid('options').queryParams=queryParams;        
			      $("#dg").datagrid('reload'); 
    	   });
       });

       
       function role_fm(v,r){
          if(v==0)return '普通用户';    
          else if(v==1)return '主管用户';    
          else if(v==2)return '管理员';    
       }
       function st_fm(v,r){
           if(r.status==0)return '正常';    
           else if(r.status==1)return '冻结';
        }
</script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
	
</head>
<body style="">
<!-- width:700px;height:250px -->
    <table id="dg" title="用户列表" class="easyui-datagrid" style=""
            url="${pageContext.request.contextPath}/user/listUsers"
            toolbar="#toolbar" pagination="true" 
            rownumbers="true" fitColumns="true" striped="true" pageList="[2,20,35,40]"
            singleSelect="true">
        <thead>
            <tr>
               <th field="id" width="40" align="center" hidden="true" >--</t>
                <th field="createTime" width="40" align="center">createTime</th>
                <th field="createUser" width="25" align="center">createUser</th>
                <th field="pos" width="40" align="center">pos</th>
                <th field="name" width="25" align="center">name</th>
                <th field="memo" width="50" align="center" >memo</th>
                <th field="status" width="30" align="center" formatter="st_fm" >状态</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar" style="">
        <div style='float:left;'><a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a></div>
       <div style='float:left;'> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改用户</a></div>
       <div style='float:left;'> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a></div>
              <div style='float:left;'> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="djUser(1)">冻结用户</a></div>
                     <div style='float:left;'> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="djUser(0)">解冻用户</a></div>
		<div class="datagrid-btn-separator" style='float:left;height:16px;margin-left:2px;margin-right:6px;'></div>
        <div><input class='' id='sb' name='' style='vertical-align:middle' title="请输入查找的内容，支持对所有列的查询！"/>
		<a href="javascript:void(0)" id='sbbtn' class="easyui-linkbutton" iconCls="" plain="false" >查询</a>
		</div>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">用户信息</div>
        <form id="fm" method="post" >
            <div class="fitem">
                <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名(<font color=red>*</font>):</label>
                <input name="user.id" type="hidden" id='ui' />
                <input name="user.usrName" type="text" id='un' class="" style="width:160px">
            </div>
            <div class="fitem">
                <label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别(<font color=red>*</font>):</label>
                <s:select name="user.gender" id='ug'  cssStyle="width:160px"  list="{'男','女','未定'}" headerValue="男"  ></s:select>
            </div>
            <div class="fitem">
                <label>手机号码(<font color=red>*</font>):</label>
                <input name="user.phone" id='up' style="width:160px" type="text">
            </div>
            <div class="fitem">
                <label>QQ/MSN:</label>
                <input name="user.qq" class="" id='uq' style="width:160px" type="text">
            </div>
            <div class="fitem">
                <label>所属店面:</label>
                 <select class="easyui-combobox" name="user.ownerId" id="dp" style="width:160px"
			 data-options="url:'${pageContext.request.contextPath}',method:'post',valueField:'id',textField:'name',panelHeight:'auto'">
                 </select>                
            </div>
            <div class="fitem">
                <label>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色(<font color=red>*</font>):</label>
               <%--  <s:select name="user.type" id='ut'  cssStyle="width:160px"  data-options="panelHeight:'auto'" list="#{0:'普通用户',1:'主管用户',2:'管理员'}" listKey="key" listValue="value" ></s:select> --%>
            </div>
            <div class="fitem">
                <label>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态(<font color=red>*</font>):</label>
               <%--  <s:select name="user.status" id='us'  cssStyle="width:160px"  data-options="panelHeight:'auto'" list="#{0:'正常',1:'冻结'}" listKey="key" listValue="value" ></s:select> --%>
            </div>
              <div class="fitem" id='inf'>
            新添用户，密码默认为12345，请新添用户登录系统后，在个人信息菜单内修改密码！
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>


</body>
</html>