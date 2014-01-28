<%-- 
    Document   : insert
    Created on : 07-17-2013, 02:21:23 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dataBase.connecttoDatabase" %>

<%
String id= request.getParameter("id");
if(id.equals("tomacorriente")){
    String descripcion=request.getParameter("descripcion");
    String xbee=request.getParameter("xbee");
    com.dataBase.connecttoDatabase.getInstancia().insertTomacorrientes(descripcion, xbee);
}
else if(id.equals("luces")){
    String descripcion=request.getParameter("descripcion");
    String xbee=request.getParameter("xbee");
    String watts=request.getParameter("watts");
    com.dataBase.connecttoDatabase.getInstancia().insertLuces(descripcion, xbee, watts);
}
else if(id.equals("xbee")){
    String descripcion=request.getParameter("descripcion");
    String xbee=request.getParameter("xbee");
    com.dataBase.connecttoDatabase.getInstancia().insertXBee(descripcion, xbee);
}

%>