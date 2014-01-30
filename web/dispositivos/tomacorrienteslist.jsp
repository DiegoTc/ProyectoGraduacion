<%-- 
    Document   : tomacorrienteslist
    Created on : 06-26-2013, 10:09:10 PM
    Author     : diego
--%>

<%@page import="exdatabase.ConnecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=exdatabase.ConnecttoDatabase.getInstancia().getDispositivosTomacorrientes().toString();
    out.println(data);
%>

