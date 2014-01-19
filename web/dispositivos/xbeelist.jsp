<%-- 
    Document   : xbeelist
    Created on : 06-26-2013, 10:27:10 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dataBase.connecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
{    
String data=com.dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    out.println(data);
}
%>
