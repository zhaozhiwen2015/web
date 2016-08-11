package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登录--");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</title>\r\n");
      out.write("<link rel='icon' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.ico' type='image/x-icon' />\r\n");
      out.write("<link rel='shortcut icon' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.ico' type='image/x-icon' />\r\n");
      out.write("<script type='text/javascript' language='JavaScript' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.0.min.js' charset='UTF-8'></script>\r\n");
      out.write("<script type='text/javascript' language='JavaScript' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.easyui.min.js' charset='UTF-8'></script>\r\n");
      out.write("<script type='text/javascript' language='JavaScript' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-lang-zh_CN.js' charset='UTF-8'></script>\r\n");
      out.write("<script type='text/javascript' language='JavaScript' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/index.js' charset='UTF-8'></script>\r\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/themes/default/easyui.css' charset='UTF-8'/>\r\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/themes/icon.css' charset='UTF-8'/>\r\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/index-layout.css' charset='UTF-8'/>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("\t$('#sub').click(function(){\r\n");
      out.write("\t\tvalidLoginForm();\r\n");
      out.write("\t\t//$.messager.alert('警告','密码不能为空！！','error',function(){});\r\n");
      out.write("\t\t//$('#tf').submit();\r\n");
      out.write("\t});\r\n");
      out.write("\t$('#xxx').click(function(){\r\n");
      out.write("\t\t//window.location.reload();\r\n");
      out.write("\t\t$(this).attr('src','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/validCode/randomImg?R=+Math.random()');\r\n");
      out.write("\t});\r\n");
      out.write("\t$('#res').click(function(){\r\n");
      out.write("\t\t$('#uname').val(\"\");\r\n");
      out.write("\t\t$('#upwd').val(\"\");\r\n");
      out.write("\t\t$('#code').val(\"\");\r\n");
      out.write("\t});\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var validLoginForm = function(){\r\n");
      out.write("\r\n");
      out.write("\tif($.trim($('#uname').val())==\"\"){\r\n");
      out.write("\t\t$.messager.alert('警告','用户名不能为空！！','error',function(){});\r\n");
      out.write("\t\t return;\r\n");
      out.write("\t }\r\n");
      out.write("\t\tif($.trim($('#upwd').val())==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert('警告','密码不能为空！！','error',function(){});\r\n");
      out.write("\t\t return;\r\n");
      out.write("\t }\r\n");
      out.write("\t if($.trim($('#code').val())==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert('警告','验证码不能为空！！','error',function(){});\r\n");
      out.write("\t\t return;\r\n");
      out.write("\t }\r\n");
      out.write("\t $('#tf').submit();\r\n");
      out.write("\t return ;\r\n");
      out.write("\t $.ajax( {\r\n");
      out.write("\t\t\turl :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/validCode/getCode\",\r\n");
      out.write("\t\t\ttype :\"post\",\r\n");
      out.write("\t\t\tdata : {},\r\n");
      out.write("\t\t\tasync :false,\r\n");
      out.write("\t\t\tdataType :'json',\r\n");
      out.write("\t\t\tcache :false,\r\n");
      out.write("\t\t\tsuccess : function(code) {\r\n");
      out.write("            \tif($.trim($('#code').val())!=code){\r\n");
      out.write("    \t\t\t\t$.messager.alert('警告','验证码输入有误！！','error',function(){});\r\n");
      out.write("    \t\t\t\t$('#xxx').click();\r\n");
      out.write("            \t}else{\r\n");
      out.write("            \t\t$('#tf').submit();\r\n");
      out.write("            \t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t$.messager.alert('警告','出错了！','error',function(){});\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}); \t\t\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div style='width:890px;height:461px;background:transparent;position:abosulte;margin:auto;z-index:0;background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/loginx.jpg)'>\r\n");
      out.write("<form method=post action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/login\" id='tf' style='position:relative;padding-left:520px;padding-top:200px;'>\r\n");
      out.write("<table border=0>\r\n");
      out.write("<tbody>\r\n");
      out.write("<tr><td>用户名</td><td><input type=text value='' name='user.usrName' id='uname' class=input_195 maxLength=\"10\" /></td></tr>\r\n");
      out.write("<tr><td>密&nbsp;&nbsp;码</td><td><input type=password value='' id='upwd' name='user.usrRemark' class=input_195  maxLength=\"14\" /></td></tr>\r\n");
      out.write("<tr><td>验证码</td><td><img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/validCode/randomImg?R=");
      out.print(Math.random());
      out.write("' width=\"100\" height=\"30\" id='xxx' align=\"absmiddle\" class=input_code /><input type=text value='' id='code'  name='code' class=input_98 maxLength=\"6\" /></td></tr>\r\n");
      out.write("<tr><td colspan=2 align=\"center\"><a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" id=\"sub\">登录</a>   <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" id=\"res\">重置</a></td></tr>\r\n");
      out.write("<tr><td colspan=2 align=\"center\"> </td></tr>\r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
