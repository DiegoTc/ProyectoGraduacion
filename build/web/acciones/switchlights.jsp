<%-- 
    Document   : switchlights
    Created on : 01-19-2014, 06:48:11 AM
    Author     : diego
--%>

<%@page import="exdatabase.ConnecttoDatabase" %>

<%
    String data=exdatabase.ConnecttoDatabase.getInstancia().getLightsSwitch().toString();
    out.println(data);
%>
