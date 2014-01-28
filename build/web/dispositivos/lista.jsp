<%-- 
    Document   : lista
    Created on : 07-12-2013, 01:44:45 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="OwnClass.XBeeAPI_Test_v1_1" %>
<%
String id= request.getParameter("id");
int signal=Integer.parseInt(id);
if(signal==0){
    String data=com.dataBase.connecttoDatabase.getInstancia().getComboXbee().toString();
    out.println(data);
}
else{
    String xbee=request.getParameter("value");
    String data=com.dataBase.connecttoDatabase.getInstancia().getComboXbeeSelected(xbee).toString();
    out.println(data);
}
%>



%>

