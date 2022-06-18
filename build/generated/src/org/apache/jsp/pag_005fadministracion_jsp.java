package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pag_005fadministracion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    <form name=\"defecto\" id=\"defecto\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"metodo\" id=\"metodo\" >\n");
      out.write("        <input type=\"hidden\" name=\"idmod\" id=\"idmod\" >\n");
      out.write("    </form>\n");
      out.write("    <!-- Begin Page Content -->\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("        <!-- Page Heading -->\n");
      out.write("        <h1 class=\"h3 mb-4 text-gray-800\">Dashboard</h1>\n");
      out.write("\n");
      out.write("   \n");
      out.write("    <!-- /.container-fluid -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <!-- Earnings (Monthly) Card Example -->\n");
      out.write("        <div class=\"col-xl-3 col-md-6 mb-4\">\n");
      out.write("            <div class=\"card border-left-primary shadow h-100 py-2\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <div class=\"row no-gutters align-items-center\">\n");
      out.write("                        <div class=\"col mr-2\">\n");
      out.write("                            <div class=\"text-xs font-weight-bold text-primary text-uppercase mb-1\">\n");
      out.write("                                </div>\n");
      out.write("                            <div class=\"h5 mb-0 font-weight-bold text-gray-800\"><a class=\"collapse-item\" onclick='java:pag_cursos()' role='button'>Cursos</a></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-auto\">\n");
      out.write("                            <i class=\"fas fa-book fa-2x text-gray-300\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write(" </div>\n");
      out.write("</div>\n");
      out.write("<!-- End of Main Content -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Logout.jsp", out, false);
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
