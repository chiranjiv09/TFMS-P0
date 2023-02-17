/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-02-17 12:23:59 UTC
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <meta\n");
      out.write("      name=\"viewport\"\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"icon\" href=\"../images/people.png\" />\n");
      out.write("    <link\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"stylesheet\" href=\"../fonts/icomoon/style.css\" />\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/login.bootstrap.min.css\" />\n");
      out.write("\n");
      out.write("    <!-- Style -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/login.style.css\" />\n");
      out.write("\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <title>Tech Wallah</title>\n");
      out.write("  </head>\n");
      out.write("  <body style=\"overflow: hidden;\">\n");
      out.write("    <div class=\"content\" style=\"height: 93vh\">\n");
      out.write("      <h3>\n");
      out.write("        Welcome to <span style=\"font-weight: 700\">Tech Wallah</span> Institute\n");
      out.write("      </h3>\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-md-6 order-md-2\">\n");
      out.write("            <img\n");
      out.write("              src=\"assets/img/Login.jpg\"\n");
      out.write("              alt=\"Image\"\n");
      out.write("              class=\"img-fluid\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-6 contents\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("              <div class=\"col-md-8\">\n");
      out.write("                <div class=\"mb-4\">\n");
      out.write("                  <h3>Log In to <strong>Associate Admin</strong></h3>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"login\" method=\"post\">\n");
      out.write("                  <div class=\"form-group first\">\n");
      out.write("                    <label for=\"username\">Username</label>\n");
      out.write("                    <input name=\"username\" type=\"text\" class=\"form-control\" id=\"username\" />\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group last mb-4\">\n");
      out.write("                    <label for=\"password\">Password</label>\n");
      out.write("                    <input\n");
      out.write("                    name=\"password\"\n");
      out.write("                      type=\"password\"\n");
      out.write("                      class=\"form-control\"\n");
      out.write("                      id=\"id_password\"\n");
      out.write("                    />\n");
      out.write("                    <i\n");
      out.write("                      class=\"far fa-eye-slash\"\n");
      out.write("                      id=\"togglePassword\"\n");
      out.write("                      style=\"\n");
      out.write("                        display: flex;\n");
      out.write("                        float: right;\n");
      out.write("                        margin-top: -35px;\n");
      out.write("                        position: relative;\n");
      out.write("                      \"\n");
      out.write("                    ></i>\n");
      out.write("                  </div>\n");
      out.write("                  <input\n");
      out.write("                    type=\"submit\"\n");
      out.write("                    value=\"Login\"\n");
      out.write("                    class=\"btn text-white btn-block btn-primary\"\n");
      out.write("                    style=\"background-color: skyblue; border-color: skyblue\"\n");
      out.write("                  />\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <footer\n");
      out.write("        style=\"\n");
      out.write("          display: flex;\n");
      out.write("          justify-content: center;\n");
      out.write("          position: sticky;\n");
      out.write("          background-color: skyblue;\n");
      out.write("          padding: 10px 10px;\n");
      out.write("          bottom: 0;\n");
      out.write("        \"\n");
      out.write("      >\n");
      out.write("        @Copyright | CodeTech | 2022- All Right Reserved.\n");
      out.write("      </footer>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"assets/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/login.main.js\"></script>\n");
      out.write("    <script src=\"assets/js/show-fun.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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