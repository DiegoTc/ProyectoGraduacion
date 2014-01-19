<%-- 
    Document   : newjsp1
    Created on : 06-28-2013, 12:23:02 AM
    Author     : diego
--%>

<%@page import="com.floorplanner.rest.FloorplannerClient"%>
<%@page import="com.floorplanner.rest.beans.*"%>



<%
FloorplannerClient floor= new FloorplannerClient("9579728a19f10af986a49432694db440f0f0687a","http://diegoturcios.floorplanner.com");
Project pro = new Project();
pro.setName("Test1");
pro.setId("5");
pro.setDescription("Esto es una prueba");
Project p=floor.createProject("diegoturcios", pro);
Project pr= floor.getProjectById(5);
int a;
%>

<script src="http://fpcdn.s3.amazonaws.com/apps/viewer-mobile/1.5/viewer-mobile.js" 
    type="text/javascript"></script>
    
<script type="text/javascript">
    var projectXmlText="";
    var appContainer = "9579728a19f10af986a49432694db440f0f0687a";
    var app = new fp.ViewerMobile.App(appContainer, "projectXmlText");
 
</script>    