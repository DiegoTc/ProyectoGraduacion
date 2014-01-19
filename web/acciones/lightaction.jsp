<%-- 
    Document   : lightaction
    Created on : 04-28-2013, 01:04:55 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="OwnClass.XBeeAPI_Test_v1_1" %>
<%
String id= request.getParameter("id");
int signal=Integer.parseInt(id);
out.println(signal);
XBeeAPI_Test_v1_1 test;
test= new XBeeAPI_Test_v1_1(signal);


%>
