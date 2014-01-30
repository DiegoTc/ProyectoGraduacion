<%-- 
    Document   : lightaction
    Created on : 04-28-2013, 01:04:55 PM
    Author     : diego
--%>

<%@page import="com.rapplogic.xbee.examples.zigbee.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
String id= request.getParameter("id");
if(id == null){
    XBeeLightDetails lig = new XBeeLightDetails();
    int[] payload= new int[1];
    String json=lig.areLightsOnAd(payload,"/dev/ttyUSB0");
    out.print(json);
}
else{
    int ipOpt=Integer.parseInt(id);
    if(ipOpt==0){
        String action=request.getParameter("action");
        XBeeControlLights control = new XBeeControlLights();
        int opt=Integer.parseInt(action);
        int []infor = new int[1];
         
        if(opt==1){
            infor[0]=0;
            control.turnOnLightsAddr(infor,"/dev/ttyUSB0");
        }
        else if (opt==0){
            infor[0]=1;
            control.turnOnLightsAddr(infor,"/dev/ttyUSB0");
        }
        
    }
    else if(ipOpt==1){
        String action=request.getParameter("action");
        XBeeControlLights control = new XBeeControlLights();
        int opt=Integer.parseInt(action);
        int []infor = new int[1];
         
        if(opt==1){
            infor[0]=2;
            control.turnOnLightsAddr(infor,"/dev/ttyUSB0");
        }
        else if (opt==0){
            infor[0]=3;
            control.turnOnLightsAddr(infor,"/dev/ttyUSB0");
        }
        
    }
}
/*String id= request.getParameter("id");
int signal=Integer.parseInt(id);
out.println(signal);
XBeeAPI_Test_v1_1 test;
test= new XBeeAPI_Test_v1_1(signal);
*/

%>
