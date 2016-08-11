$(function(){
	$('.newLink').click(function(){
		var title=$(this).text();
		var src=$(this).attr('src');
		addTab(src,title);
	});

});
function addTab(src,title){
	addTabs(src,title,true);
}
function addTabs(src,title,closable){
	//alert(src);
	if($('#centerTab').tabs('exists',title)){
			var tag=$('#centerTab').tabs('getTab',title);
			 $('#centerTab').tabs('update',{
				tab:tag,
	         	options:{
	            	title: title,
	            	content:'<iframe name="mainForm" scrolling="yes" frameborder="0" src="'+src+'" style="width:100%;height:100%;"></iframe>',
		            closable:closable
	            }
	           });
			$('#centerTab').tabs('select',title);
		}else{
	        $('#centerTab').tabs('add',{
	            title:title,
	            content:'<iframe name="mainForm" scrolling="yes" frameborder="0" src="'+src+'" style="width:100%;height:100%;"></iframe>',
	            closable:closable
	        });  
		}
	return;
	/*	 $.ajax( {
   			url :"ijson/checkSession.do",
   			type :"post",
   			data : {},
   			async :false,
   			dataType :'json',
   			cache :false,
   			success : function(t) {
               	if(1==t.ret){
               	    if($('#centerTab').tabs('exists',title)){
               			var tag=$('#centerTab').tabs('getTab',title);
               			 $('#centerTab').tabs('update',{
               				tab:tag,
               	         	options:{
               	            	title: title,
               	            	content:'<iframe name="mainForm" scrolling="yes" frameborder="0" src="'+src+'" style="width:100%;height:100%;"></iframe>',
               		            closable:closable
               	            }
               	           });
               			$('#centerTab').tabs('select',title);
               		}else{
               	        $('#centerTab').tabs('add',{
               	            title:title,
               	            content:'<iframe name="mainForm" scrolling="yes" frameborder="0" src="'+src+'" style="width:100%;height:100%;"></iframe>',
               	            closable:closable
               	        });  
               		}
               	}else{
               		window.location.href='iusr/referLogin.do';
               	}
   			},
   			error : function() {

   			}
   		}); 		 */
	
}