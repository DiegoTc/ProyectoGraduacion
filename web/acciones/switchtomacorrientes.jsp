d<%-- 
    Document   : switchtomacorrientes
    Created on : 01-24-2014, 05:14:09 PM
    Author     : diego
--%>


<%@page import="exdatabase.ConnecttoDatabase" %>

<%
    //String data1=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=exdatabase.ConnecttoDatabase.getInstancia().getDispositivosTomacorrientes().toString();
    out.println(data);
%>
