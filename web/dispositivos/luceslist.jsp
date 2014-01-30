<%-- 
    Document   : luceslist
    Created on : 06-26-2013, 04:18:56 PM
    Author     : diego
--%>



<%@page import="exdatabase.ConnecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=exdatabase.ConnecttoDatabase.getInstancia().getDispositivosLuces().toString();
    out.println(data);
%>

