<%-- 
    Document   : tomacorrienteslist
    Created on : 06-26-2013, 10:09:10 PM
    Author     : diego
--%>

<%@page import="com.dataBase.connecttoDatabase" %>

<%
    //  String data=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=com.dataBase.connecttoDatabase.getInstancia().getDispositivosTomacorrientes().toString();
    out.println(data);
%>

