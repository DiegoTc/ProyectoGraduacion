<%-- 
    Document   : luceslist
    Created on : 06-26-2013, 04:18:56 PM
    Author     : diego
--%>


<%@page import="com.dataBase.connecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=com.dataBase.connecttoDatabase.getInstancia().getDispositivosLuces().toString();
    out.println(data);
%>

