/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-07 02:13:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/menu.jsp", Long.valueOf(1522854869121L));
  }

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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<!--external css-->\r\n");
      out.write("<link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"assets/js/bootstrap-datepicker/css/datepicker.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"assets/js/bootstrap-daterangepicker/daterangepicker.css\" />\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"assets/css/style-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/bootstrap-datetimepicker.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("      <!-- **********************************************************************************************************************************************************\r\n");
      out.write("      TOP BAR CONTENT & NOTIFICATIONS\r\n");
      out.write("      *********************************************************************************************************************************************************** -->\r\n");
      out.write("      <!--header start-->\r\n");
      out.write("      <header class=\"header black-bg\">\r\n");
      out.write("              <div class=\"sidebar-toggle-box\">\r\n");
      out.write("                  <div class=\"fa fa-bars tooltips\" data-placement=\"right\" data-original-title=\"菜单\"></div>\r\n");
      out.write("              </div>\r\n");
      out.write("            <!--logo start-->\r\n");
      out.write("            <a href=\"index\" class=\"logo\"><b>任务跟踪系统</b></a>\r\n");
      out.write("            <!--logo end-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"top-menu\">\r\n");
      out.write("                <ul class=\"nav pull-right top-menu\">\r\n");
      out.write("                    <li><a class=\"logout\" href=\"login.html\">退出登录</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("      <!--header end-->\r\n");
      out.write("\t      <!-- **********************************************************************************************************************************************************\r\n");
      out.write("      MAIN SIDEBAR MENU ： 边缘菜单\r\n");
      out.write("      *********************************************************************************************************************************************************** -->\r\n");
      out.write("      <!--边缘菜单栏 start-->\r\n");
      out.write("      <aside>\r\n");
      out.write("          <div id=\"sidebar\"  class=\"nav-collapse \">\r\n");
      out.write("              <!-- sidebar menu start-->\r\n");
      out.write("              <ul class=\"sidebar-menu\" id=\"nav-accordion\">\r\n");
      out.write("              \r\n");
      out.write("                  <p class=\"centered\"><a href=\"profile.html\"><img src=\"assets/img/ui-sam.jpg\" class=\"img-circle\" width=\"60\"></a></p>\r\n");
      out.write("\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\"fa fa-desktop\"></i>\r\n");
      out.write("                          <span>项目管理</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"add_project_form\">新增项目</a></li>\r\n");
      out.write("                          <li><a  href=\"buttons.html\">浏览项目</a></li>\r\n");
      out.write("                          <li><a  href=\"panels.html\">修改项目</a></li>\r\n");
      out.write("                      </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\"fa fa-cogs\"></i>\r\n");
      out.write("                          <span>任务管理</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"gallery.html\">新增任务</a></li>\r\n");
      out.write("                          <li><a  href=\"calendar.html\">浏览任务</a></li>\r\n");
      out.write("                          <li><a  href=\"todo_list.html\">修改任务</a></li>\r\n");
      out.write("                      </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\"fa fa-book\"></i>\r\n");
      out.write("                          <span>待开发</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <!-- <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"blank.html\">Blank Page</a></li>\r\n");
      out.write("                          <li><a  href=\"login.html\">Login</a></li>\r\n");
      out.write("                          <li><a  href=\"lock_screen.html\">Lock Screen</a></li>\r\n");
      out.write("                      </ul> -->\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\"fa fa-tasks\"></i>\r\n");
      out.write("                          <span>待开发</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <!-- <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"form_component.html\">Form Components</a></li>\r\n");
      out.write("                      </ul> -->\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\"fa fa-th\"></i>\r\n");
      out.write("                          <span>待开发</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <!-- <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"basic_table.html\">Basic Table</a></li>\r\n");
      out.write("                          <li><a  href=\"responsive_table.html\">Responsive Table</a></li>\r\n");
      out.write("                      </ul> -->\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"sub-menu\">\r\n");
      out.write("                      <a href=\"javascript:;\" >\r\n");
      out.write("                          <i class=\" fa fa-bar-chart-o\"></i>\r\n");
      out.write("                          <span>待开发</span>\r\n");
      out.write("                      </a>\r\n");
      out.write("                      <!-- <ul class=\"sub\">\r\n");
      out.write("                          <li><a  href=\"morris.html\">Morris</a></li>\r\n");
      out.write("                          <li><a  href=\"chartjs.html\">Chartjs</a></li>\r\n");
      out.write("                      </ul> -->\r\n");
      out.write("                  </li>\r\n");
      out.write("\r\n");
      out.write("              </ul>\r\n");
      out.write("              <!-- 边缘菜单 end-->\r\n");
      out.write("          </div>\r\n");
      out.write("      </aside>\r\n");
      out.write("      <!--sidebar end-->\r\n");
      out.write("\r\n");
      out.write("\t<!-- js placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"assets/js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script class=\"include\" type=\"text/javascript\"\r\n");
      out.write("        src=\"assets/js/jquery.dcjqaccordion.2.7.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.scrollTo.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.nicescroll.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.sparkline.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!--common script for all pages-->\r\n");
      out.write("    <script src=\"assets/js/common-scripts.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\"\r\n");
      out.write("        src=\"assets/js/gritter/js/jquery.gritter.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/js/gritter-conf.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/ajaxFileUpload.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("      <!-- **********************************************************************************************************************************************************\r\n");
      out.write("      MAIN CONTENT\r\n");
      out.write("      *********************************************************************************************************************************************************** -->\r\n");
      out.write("      <!--main content start-->\r\n");
      out.write("      <section id=\"main-content\">\r\n");
      out.write("          <section class=\"wrapper\">\r\n");
      out.write("            <h3><i class=\"fa fa-angle-right\"></i> 项目信息一览</h3>\r\n");
      out.write("                <div class=\"row mt\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                      <div class=\"content-panel\">\r\n");
      out.write("                      <h4><i class=\"fa fa-angle-right\"></i> 项目信息表</h4>\r\n");
      out.write("                          <section id=\"unseen\">\r\n");
      out.write("                            <table class=\"table table-bordered table-striped table-condensed\">\r\n");
      out.write("                              <thead>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <th>项目编号</th>\r\n");
      out.write("                                  <th>项目名称</th>\r\n");
      out.write("                                  <th class=\"numeric\">开始日期</th>\r\n");
      out.write("                                  <th class=\"numeric\">持续日期</th>\r\n");
      out.write("                                  <th class=\"numeric\">预计耗时</th>\r\n");
      out.write("                                  <th class=\"numeric\">项目负责人</th>\r\n");
      out.write("                                  <th class=\"numeric\">参与人数</th>\r\n");
      out.write("                                  <th class=\"numeric\">目前进度</th>\r\n");
      out.write("                                  <th class=\"numeric\">是否完成</th>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              </thead>\r\n");
      out.write("                              <tbody>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AAC</td>\r\n");
      out.write("                                  <td>AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.38</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.01</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.36%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.39</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.39</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.38</td>\r\n");
      out.write("                                  <td class=\"numeric\">9,395</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AAD</td>\r\n");
      out.write("                                  <td>ARDENT LEISURE GROUP</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.15</td>\r\n");
      out.write("                                  <td class=\"numeric\">  +0.02</td>\r\n");
      out.write("                                  <td class=\"numeric\">1.32%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.14</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.15</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.13</td>\r\n");
      out.write("                                  <td class=\"numeric\">56,431</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AAX</td>\r\n");
      out.write("                                  <td>AUSENCO LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$4.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.04</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.99%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$4.01</td>\r\n");
      out.write("                                  <td class=\"numeric\">$4.05</td>\r\n");
      out.write("                                  <td class=\"numeric\">$4.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">90,641</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>ABC</td>\r\n");
      out.write("                                  <td>ADELAIDE BRIGHTON LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">  +0.06</td>\r\n");
      out.write("                                  <td class=\"numeric\">2.04%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$2.98</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">$2.96</td>\r\n");
      out.write("                                  <td class=\"numeric\">862,518</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>ABP</td>\r\n");
      out.write("                                  <td>ABACUS PROPERTY GROUP</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.91</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.00%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.92</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.93</td>\r\n");
      out.write("                                  <td class=\"numeric\">$1.90</td>\r\n");
      out.write("                                  <td class=\"numeric\">595,701</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>ABY</td>\r\n");
      out.write("                                  <td>ADITYA BIRLA MINERALS LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.77</td>\r\n");
      out.write("                                  <td class=\"numeric\">  +0.02</td>\r\n");
      out.write("                                  <td class=\"numeric\">2.00%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.76</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.77</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.76</td>\r\n");
      out.write("                                  <td class=\"numeric\">54,567</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>ACR</td>\r\n");
      out.write("                                  <td>ACRUX LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.71</td>\r\n");
      out.write("                                  <td class=\"numeric\">  +0.01</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.14%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.70</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.72</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.68</td>\r\n");
      out.write("                                  <td class=\"numeric\">191,373</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>ADU</td>\r\n");
      out.write("                                  <td>ADAMUS RESOURCES LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.72</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.00</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.00%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.73</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.74</td>\r\n");
      out.write("                                  <td class=\"numeric\">$0.72</td>\r\n");
      out.write("                                  <td class=\"numeric\">8,602,291</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AGG</td>\r\n");
      out.write("                                  <td>ANGLOGOLD ASHANTI LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$7.81</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.22</td>\r\n");
      out.write("                                  <td class=\"numeric\">-2.74%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$7.82</td>\r\n");
      out.write("                                  <td class=\"numeric\">$7.82</td>\r\n");
      out.write("                                  <td class=\"numeric\">$7.81</td>\r\n");
      out.write("                                  <td class=\"numeric\">148</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AGK</td>\r\n");
      out.write("                                  <td>AGL ENERGY LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$13.82</td>\r\n");
      out.write("                                  <td class=\"numeric\">  +0.02</td>\r\n");
      out.write("                                  <td class=\"numeric\">0.14%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$13.83</td>\r\n");
      out.write("                                  <td class=\"numeric\">$13.83</td>\r\n");
      out.write("                                  <td class=\"numeric\">$13.67</td>\r\n");
      out.write("                                  <td class=\"numeric\">846,403</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                  <td>AGO</td>\r\n");
      out.write("                                  <td>ATLAS IRON LIMITED</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.17</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.02</td>\r\n");
      out.write("                                  <td class=\"numeric\">-0.47%</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.11</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.22</td>\r\n");
      out.write("                                  <td class=\"numeric\">$3.10</td>\r\n");
      out.write("                                  <td class=\"numeric\">5,416,303</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              </tbody>\r\n");
      out.write("                          </table>\r\n");
      out.write("                          </section>\r\n");
      out.write("                  </div><!-- /content-panel -->\r\n");
      out.write("               </div><!-- /col-lg-4 -->         \r\n");
      out.write("            </div><!-- /row -->\r\n");
      out.write("\r\n");
      out.write("        </section><!--/wrapper -->\r\n");
      out.write("      </section><!-- /MAIN CONTENT -->\r\n");
      out.write("      <!--main content end-->\r\n");
      out.write("  </section>\r\n");
      out.write("\r\n");
      out.write("    <!-- js placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"assets/js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script class=\"include\" type=\"text/javascript\" src=\"assets/js/jquery.dcjqaccordion.2.7.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.scrollTo.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.nicescroll.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/js/jquery.sparkline.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!--common script for all pages-->\r\n");
      out.write("    <script src=\"assets/js/common-scripts.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/js/gritter/js/jquery.gritter.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/js/gritter-conf.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!--script for this page-->\r\n");
      out.write("    <script src=\"assets/js/sparkline-chart.js\"></script>    \r\n");
      out.write("    <script src=\"assets/js/zabuto_calendar.js\"></script>    \r\n");
      out.write("    <script type=\"application/javascript\">\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $(\"#date-popover\").popover({html: true, trigger: \"manual\"});\r\n");
      out.write("            $(\"#date-popover\").hide();\r\n");
      out.write("            $(\"#date-popover\").click(function (e) {\r\n");
      out.write("                $(this).hide();\r\n");
      out.write("            });\r\n");
      out.write("        \r\n");
      out.write("            $(\"#my-calendar\").zabuto_calendar({\r\n");
      out.write("                action: function () {\r\n");
      out.write("                    return myDateFunction(this.id, false);\r\n");
      out.write("                },\r\n");
      out.write("                action_nav: function () {\r\n");
      out.write("                    return myNavFunction(this.id);\r\n");
      out.write("                },\r\n");
      out.write("                ajax: {\r\n");
      out.write("                    url: \"show_data.php?action=1\",\r\n");
      out.write("                    modal: true\r\n");
      out.write("                },\r\n");
      out.write("                legend: [\r\n");
      out.write("                    {type: \"text\", label: \"Special event\", badge: \"00\"},\r\n");
      out.write("                    {type: \"block\", label: \"Regular event\", }\r\n");
      out.write("                ]\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        function myNavFunction(id) {\r\n");
      out.write("            $(\"#date-popover\").hide();\r\n");
      out.write("            var nav = $(\"#\" + id).data(\"navigation\");\r\n");
      out.write("            var to = $(\"#\" + id).data(\"to\");\r\n");
      out.write("            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("  \r\n");
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
