<%-- 
    Document   : switchlights
    Created on : 01-19-2014, 06:48:11 AM
    Author     : diego
--%>

<%@page import="dataBase.connecttoDatabase" %>

<%
    String data1=dataBase.connecttoDatabase.getInstancia().getDispositivosXBee().toString();
    String data=connecttoDatabase.getInstancia().getLightsSwitch().toString();
    out.println(data);
%>
