<%-- 
    Document   : xbeelist
    Created on : 06-26-2013, 10:27:10 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="exdatabase.ConnecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
{    
String data=exdatabase.ConnecttoDatabase.getInstancia().getDispositivosXBee().toString();
    out.println(data);
}
%>
