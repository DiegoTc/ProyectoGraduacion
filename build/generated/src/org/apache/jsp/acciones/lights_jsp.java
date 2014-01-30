package org.apache.jsp.acciones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lights_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\" title=\"currentStyle\">\n");
      out.write("    @import \"../css/jquery.dataTables.css\";\n");
      out.write("    @import \"../css/TableTools.css\";\n");
      out.write("    @import \"../css/dataTables.editor.css\";\n");
      out.write("\n");
      out.write("    #container {\n");
      out.write("        padding-top: 60px !important;\n");
      out.write("        width: 960px !important;\n");
      out.write("    }\n");
      out.write("    #dt_example .big {\n");
      out.write("        font-size: 1.3em;\n");
      out.write("        line-height: 1.45em;\n");
      out.write("        color: #111;\n");
      out.write("        margin-left: -10px;\n");
      out.write("        margin-right: -10px;\n");
      out.write("        font-weight: normal;\n");
      out.write("    }\n");
      out.write("    #dt_example {\n");
      out.write("        font: 95%/1.45em \"Lucida Grande\", Verdana, Arial, Helvetica, sans-serif;\n");
      out.write("        color: #111;\n");
      out.write("    }\n");
      out.write("    div.dataTables_wrapper, table {\n");
      out.write("        font: 13px/1.45em \"Lucida Grande\", Verdana, Arial, Helvetica, sans-serif;\n");
      out.write("    }\n");
      out.write("    #dt_example h1 {\n");
      out.write("        font-size: 16px !important;\n");
      out.write("        color: #111;\n");
      out.write("    }\n");
      out.write("    #footer {\n");
      out.write("        line-height: 1.45em;\n");
      out.write("    }\n");
      out.write("    div.examples {\n");
      out.write("        padding-top: 1em !important;\n");
      out.write("    }\n");
      out.write("    div.examples ul {\n");
      out.write("        padding-top: 1em !important;\n");
      out.write("        padding-left: 1em !important;\n");
      out.write("        color: #111;\n");
      out.write("    } \n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- main content -->\n");
      out.write("<div id=\"contentwrapper\">\n");
      out.write("    <div class=\"main_content\"> \n");
      out.write("        <h3 class=\"heading\">Luces de la casa</h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <div class=\"btn-group\">\n");
      out.write("\n");
      out.write("                <button class=\"btn\" id=\"actualizar\" >Actualizar</button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"table table-bordered\" id=\"example\" width=\"100%\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th width=\"18%\">Codigo</th>\n");
      out.write("                    <th width=\"25%\">Descripcion</th>\n");
      out.write("                    <th width=\"25%\">On/Off</th>\n");
      out.write("                    <th width=\"25%\">ID</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div><!-- End content -->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"../js/jquery.dataTables.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"../js/TableTools.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"../js/dataTables.editor.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../dispositivos/dataTables.fnReloadAjax.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" id=\"init-code\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("   \n");
      out.write("\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        var oTable = $('#example').dataTable( {\n");
      out.write("            \"bProcessing\": true,\n");
      out.write("            \"sAjaxSource\": \"switchlights.jsp\",\n");
      out.write("            \"bFilter\": false,\n");
      out.write("            \"bProcessing\": true,\n");
      out.write("            \"bSort\": true,\n");
      out.write("            \"bInfo\": true,\n");
      out.write("            \"bPaginate\": true,\n");
      out.write("            \"sDom\": 'Tfrtip',\n");
      out.write("            \"aaSorting\": [[ 4, \"asc\" ]],\n");
      out.write("            \"aoColumns\": [\n");
      out.write("                { \"mData\": \"codigo\" },\n");
      out.write("                { \"mData\": \"descripcion\" },\n");
      out.write("                { \"mData\": \"xbee_id\"},\n");
      out.write("                { \"mData\": \"switch\" }\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            ],\n");
      out.write("            \"oTableTools\": {\n");
      out.write("                \"sRowSelect\": \"single\",\n");
      out.write("                \"aButtons\": [  ]\n");
      out.write("            },\n");
      out.write("            aoColumnDefs  : [\n");
      out.write("                {\n");
      out.write("                    aTargets: [3],    // Column number which needs to be modified\n");
      out.write("                    fnRender: function (o, v) {   // o, v contains the object and value for the column\n");
      out.write("                        return '<span class=\"checkslide\"><input type=\"checkbox\" checked=\"false\" /><label data-on=\"ON\" data-off=\"OFF\"></label></span>'\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                { \"bVisible\": false, \"aTargets\": [2] }\n");
      out.write("            ]\n");
      out.write("        } );\n");
      out.write("        \n");
      out.write("         var che, cheVal = new Array();\n");
      out.write("          $( \"#actualizar\" ).button().click(function() {\n");
      out.write("        $.getJSON( \"lightaction.jsp\", function( data ) {\n");
      out.write("            \n");
      out.write("            var i=0;\n");
      out.write("            var idLight=\"id\"+oTable.fnGetData(i).codigo;\n");
      out.write("            che = $(\"input[type=checkbox]\");\n");
      out.write("            \n");
      out.write("            $.each( data, function( key, val ) {\n");
      out.write("               if(key==idLight){\n");
      out.write("                   if(val== 0){\n");
      out.write("                       che.get(i).checked=false;\n");
      out.write("                   }\n");
      out.write("                   else{\n");
      out.write("                       che.get(i).checked=true;\n");
      out.write("                   }\n");
      out.write("                   i++;\n");
      out.write("                   idLight=\"id\"+oTable.fnGetData(i).codigo;\n");
      out.write("               }\n");
      out.write("               \n");
      out.write("               \n");
      out.write("            });\n");
      out.write(" \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("    } );\n");
      out.write("    \n");
      out.write("    var checked, checkedValues = new Array();\n");
      out.write("    $(document).on(\"change\", \"input[type=checkbox]\", function(e) {\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        checked = $(\"input[type=checkbox]:checked\");\n");
      out.write("        checkedValues = checked.map(function(i) { return $(this).val() }).get();\n");
      out.write("        var oTable = TableTools.fnGetInstance( 'example' );\n");
      out.write("        var filas=oTable.fnGetSelectedData();\n");
      out.write("        if ($(this).is(':checked')) {\n");
      out.write("            var idLight=filas[0].codigo;\n");
      out.write("            $.ajax({\n");
      out.write("                url: 'lightaction.jsp',\n");
      out.write("                type: 'GET',\n");
      out.write("                data:  \"id=\"+idLight+\"&action=\"+1\n");
      out.write("                //success: alert(\"Hola\")\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        else\n");
      out.write("        {\n");
      out.write("             var idLight=filas[0].codigo;\n");
      out.write("            $.ajax({\n");
      out.write("                url: 'lightaction.jsp',\n");
      out.write("                type: 'GET',\n");
      out.write("                data:  \"id=\"+idLight+\"&action=\"+0\n");
      out.write("                //success: alert(\"Hola2\")\n");
      out.write("            });    \n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("\n");
      out.write("</script>    \n");
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
