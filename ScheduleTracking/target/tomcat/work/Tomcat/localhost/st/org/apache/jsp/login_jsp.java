/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-03 11:58:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--external css-->\r\n");
      out.write("    <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("        \r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/css/style-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("      <!-- **********************************************************************************************************************************************************\r\n");
      out.write("      MAIN CONTENT\r\n");
      out.write("      *********************************************************************************************************************************************************** -->\r\n");
      out.write("\r\n");
      out.write("      <div id=\"login-page\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("        \r\n");
      out.write("              <form class=\"form-login\" action=\"index\">\r\n");
      out.write("                <h2 class=\"form-login-heading\">登录</h2>\r\n");
      out.write("                <div class=\"login-wrap\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"用户名\" autofocus>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" placeholder=\"密码\">\r\n");
      out.write("                    <label class=\"checkbox\">\r\n");
      out.write("                        <span class=\"pull-right\">\r\n");
      out.write("                            <a data-toggle=\"modal\" href=\"login.html#myModal\"> 忘记密码?</a>\r\n");
      out.write("        \r\n");
      out.write("                        </span>\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <button class=\"btn btn-theme btn-block\" href=\"index.html\" type=\"submit\"><i class=\"fa fa-lock\"></i> 登录 </button>\r\n");
      out.write("                </div>\r\n");
      out.write("        \r\n");
      out.write("                  <!-- 密码找回 -->\r\n");
      out.write("                  <div aria-hidden=\"true\" aria-labelledby=\"myModalLabel\" role=\"dialog\" tabindex=\"-1\" id=\"myModal\" class=\"modal fade\">\r\n");
      out.write("                      <div class=\"modal-dialog\">\r\n");
      out.write("                          <div class=\"modal-content\">\r\n");
      out.write("                              <div class=\"modal-header\">\r\n");
      out.write("                                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                                  <h4 class=\"modal-title\">忘记密码？</h4>\r\n");
      out.write("                              </div>\r\n");
      out.write("                              <div class=\"modal-body\">\r\n");
      out.write("                                  <p>输入邮箱重置密码</p>\r\n");
      out.write("                                  <input type=\"text\" name=\"email\" placeholder=\"Email\" autocomplete=\"off\" class=\"form-control placeholder-no-fix\">\r\n");
      out.write("        \r\n");
      out.write("                              </div>\r\n");
      out.write("                              <div class=\"modal-footer\">\r\n");
      out.write("                                  <button data-dismiss=\"modal\" class=\"btn btn-default\" type=\"button\">关闭</button>\r\n");
      out.write("                                  <button class=\"btn btn-theme\" type=\"button\">提交</button>\r\n");
      out.write("                              </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- modal -->\r\n");
      out.write("        \r\n");
      out.write("              </form>       \r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- js placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"assets/js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!--BACKSTRETCH-->\r\n");
      out.write("    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/js/jquery.backstretch.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $.backstretch(\"assets/img/login-bg.jpg\", {speed: 500});\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
