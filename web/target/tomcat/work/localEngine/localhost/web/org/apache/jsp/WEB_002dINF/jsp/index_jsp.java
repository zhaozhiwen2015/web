package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<title>");
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
      out.write("<script type='text/javascript' >\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("    $(\".easyui-accordion\").accordion({\r\n");
      out.write("         collapsible: true,\r\n");
      out.write("         active: 0\r\n");
      out.write("     });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("function logout(){\r\n");
      out.write("\t\r\n");
      out.write("\t $.messager.confirm(\"提示\", \"确认退出系统？\", function (r) {  \r\n");
      out.write("\t        if (r) {  \r\n");
      out.write("\t        \twindow.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\";\t        }  \r\n");
      out.write("\t    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\" style=\"width:100%;height:100%;\">\r\n");
      out.write("        <div data-options=\"region:'north',split:false\" style=\"width:100%;height:100px;font-size:20px;\">\r\n");
      out.write("           <div class=\"easyui-layout\"  data-options=\"fit:true\" style=\"width:100%;height:100%\">\r\n");
      out.write("             <div data-options=\"region:'center',split:false\" style=\"overflow:hidden;background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/top2.jpg) repeat-x\"> \r\n");
      out.write("<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/top1.jpg\"/>\r\n");
      out.write(" \t\t\t</div>\r\n");
      out.write("             <div data-options=\"region:'south',split:false,border:false\">\r\n");
      out.write("             <div style=\"height:28px;line-height:28px;overflow:hidden;padding-left:10px;background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/0.jpg) repeat-x\">\r\n");
      out.write("             欢迎您：            <s:set name=\"ui\" value=\"(#session['loginUser'])\"></s:set>\r\n");
      out.write("             <font color=red  id='xnn'>\r\n");
      out.write("             <s:property value=\"#ui.usrName\" /></font>\r\n");
      out.write("            <span style=\"display:none\" id='uid'><s:property value=\"#ui.id\" /></span>\r\n");
      out.write("            <span>【");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("】</span>\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  style=\"color:red\" plain=\"true\" onclick=\"logout()\">退出系统</a>\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("    </div>        </div>\r\n");
      out.write("          </div>\r\n");
      out.write("       \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div data-options=\"region:'west',split:false,fit:false\" title=\"系统菜单\" style=\"width:200px;\">\r\n");
      out.write("        \r\n");
      out.write("\t\t<div class=\"easyui-accordion\" style=\"width:200px;\" data-options=\"fit:true,border:false\">\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("           <div   data-options=\"border:false,iconCls:'icon-edit'\" title=\"录帐管理\" class=\"west-class-title\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"west_menu_ul\">\r\n");
      out.write("\t\t\t\t\t\t<li><label src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/item/referItemLst.do\" class=\"newLink\">数据列表</label></li> \r\n");
      out.write("\t\t\t\t\t</ul>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div  title=\"汇总表格\"  data-options=\"border:false,iconCls:'icon-print'\"  class=\"west-class-title\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"west_menu_ul\">\r\n");
      out.write("\t\t\t\t\t<s:iterator id='iit' value='dateLst' status='st'>\r\n");
      out.write("\t\t\t\t\t\t<li><label src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/referSheetLst.do?ym=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${iit}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"newLink\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${iit}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("总表</label></li>\r\n");
      out.write("\t\t\t\t\t</s:iterator>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div   title=\"店铺管理\"  data-options=\"border:false,iconCls:'icon-search'\" class=\"west-class-title\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"west_menu_ul\">\r\n");
      out.write("\t\t\t\t\t\t<li><label src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/shop/referShopLst.do\" class=\"newLink\">店铺列表</label></li> \t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("           <div  title=\"用户管理\"  data-options=\"border:false,iconCls:'icon-reload'\" class=\"west-class-title\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"west_menu_ul\">\r\n");
      out.write("\t\t\t\t\t\t<li><label src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/referUsrLst.do\" class=\"newLink\">用户维护</label></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div data-options=\"border:false,iconCls:'icon-tip'\" title=\"个人信息\" class=\"west-class-title\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"west_menu_ul\">\r\n");
      out.write("\t\t\t\t\t\t<li><label src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/referUsrInf.do\" class=\"newLink\">信息修改</label></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t</div>\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("        <div data-options=\"region:'center'\">\r\n");
      out.write("            <div id=\"centerTab\" class=\"easyui-tabs\" data-options=\"fit:true,border:false\">\r\n");
      out.write("\t\t\t<!-- <div id=\"tabs1\" title=\"首页\" iconCls=\"icon-ok\"> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("            <div data-options=\"region:'south',split:false\" style=\"height:35px;line-height:35px;overflow:hidden;text-align:center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${copyRight}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/index.jsp(60,19) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(false);
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("普通用户");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/index.jsp(60,55) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(false);
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("主管用户");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsp/index.jsp(60,91) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(false);
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('管');
        out.write('理');
        out.write('员');
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
