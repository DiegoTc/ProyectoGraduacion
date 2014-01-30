<%-- 
    Document   : lista
    Created on : 07-12-2013, 01:44:45 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="OwnClass.XBeeAPI_Test_v1_1" %>
<%@page import="exdatabase.ConnecttoDatabase" %>
<%
String id= request.getParameter("id");
int signal=Integer.parseInt(id);
if(signal==0){
    String data=exdatabase.ConnecttoDatabase.getInstancia().getComboXbee().toString();
    out.println(data);
}
else{
    String xbee=request.getParameter("value");
    String data=exdatabase.ConnecttoDatabase.getInstancia().getComboXbeeSelected(xbee).toString();
    out.println(data);
}
%>



%>

