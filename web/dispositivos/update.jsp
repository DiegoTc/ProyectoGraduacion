<%-- 
    Document   : update
    Created on : 07-17-2013, 10:51:33 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dataBase.connecttoDatabase" %>

<%
String id= request.getParameter("id");
if(id.equals("tomacorriente")){
    String codigo=request.getParameter("codigo");
    String xbee=request.getParameter("xbee");
    String descripcion= request.getParameter("descripcion");
    com.dataBase.connecttoDatabase.getInstancia().updateTomacorrientes(codigo, descripcion, xbee);
}
else if(id.equals("luces")){
    String descripcion=request.getParameter("descripcion");
    String xbee=request.getParameter("xbee");
    String codigo= request.getParameter("codigo");
    String watts= request.getParameter("watts");
    com.dataBase.connecttoDatabase.getInstancia().updateLuces(codigo, descripcion, xbee, watts);
}
else if(id.equals("xbee")){
    String codigo=request.getParameter("codigo");
    String xbee=request.getParameter("xbee");
    String descripcion= request.getParameter("descripcion");
    com.dataBase.connecttoDatabase.getInstancia().updateXBee(codigo, descripcion, xbee);
}

%>
