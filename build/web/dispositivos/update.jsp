<%-- 
    Document   : update
    Created on : 07-17-2013, 10:51:33 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="exdatabase.ConnecttoDatabase" %>

<%
String id= request.getParameter("id");
if(id.equals("tomacorriente")){
    String codigo=request.getParameter("codigo");
    String xbee=request.getParameter("xbee");
    String descripcion= request.getParameter("descripcion");
    exdatabase.ConnecttoDatabase.getInstancia().updateTomacorrientes(codigo, descripcion, xbee);
}
else if(id.equals("luces")){
    String descripcion=request.getParameter("descripcion");
    String xbee=request.getParameter("xbee");
    String codigo= request.getParameter("codigo");
    String watts= request.getParameter("watts");
    exdatabase.ConnecttoDatabase.getInstancia().updateLuces(codigo, descripcion, xbee, watts);
}
else if(id.equals("xbee")){
    String codigo=request.getParameter("codigo");
    String xbee=request.getParameter("xbee");
    String descripcion= request.getParameter("descripcion");
   exdatabase.ConnecttoDatabase.getInstancia().updateXBee(codigo, descripcion, xbee);
}

%>
