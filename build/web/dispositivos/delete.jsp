<%-- 
    Document   : delete
    Created on : 07-17-2013, 10:09:58 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dataBase.connecttoDatabase" %>

<%
String id= request.getParameter("id");
if(id.equals("tomacorriente")){
    String codigo=request.getParameter("codigo");
    com.dataBase.connecttoDatabase.getInstancia().deleteTomacorrientes(codigo);
}
else if(id.equals("luces")){
    String codigo=request.getParameter("codigo");
    com.dataBase.connecttoDatabase.getInstancia().deleteLuces(codigo);
}
else if(id.equals("xbee")){
    String codigo=request.getParameter("codigo");
    com.dataBase.connecttoDatabase.getInstancia().deleteXBee(codigo);
}

%>