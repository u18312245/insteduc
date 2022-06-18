package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.*;
import java.util.*;

public final class modulo_005fcursos_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    ArrayList listarCurso = (ArrayList) session.getAttribute("ListarCurso");
    if (listarCurso == null) {
        listarCurso = new ArrayList();
    }
    String mensaje = (String) request.getAttribute("Mensaje");
    if (mensaje == null) {
        mensaje = "";
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\n");
      out.write("        <h1 class=\"h3 mb-4 text-gray-800\">Gestionar Cursos</h1>\n");
      out.write("        <div class=\"btn-toolbar mb-2 mb-md-0\">\n");
      out.write("            <div class=\"btn-group mr-2\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\" data-toggle=\"modal\" data-target=\"#myModalCrear\">Crear</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\" onclick=\"java:ModificarCurso()\">Modificar</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\" onclick=\"java:DeleteCurso()\">Eliminar</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"table-responsive\">\n");
      out.write("        <form name=\"lista\" id=\"lista\" method=\"get\" >\n");
      out.write("            <table class=\"table table-striped table-sm\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>#</th>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Nombre Curso</th>\n");
      out.write("                        <th>Descripcion</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        ");
for (int i = 0; i < listarCurso.size(); i++) {
                                Curso be = (Curso) listarCurso.get(i);

                        
      out.write("\n");
      out.write("                        <td><input class=\"form-check-input\" type=\"radio\" name=\"idcurso\" id=\"idcurso\" value=\"");
      out.print(be.getIdCurso());
      out.write("\"></td>\n");
      out.write("                        <td>");
      out.print(be.getIdCurso());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(be.getNomCurso());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(be.getDescripCurso());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        ");
      out.print( mensaje);
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
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
