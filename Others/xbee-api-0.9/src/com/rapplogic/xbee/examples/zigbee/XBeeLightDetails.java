/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapplogic.xbee.examples.zigbee;
import com.rapplogic.xbee.api.*;
import com.rapplogic.xbee.api.zigbee.NodeDiscover;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxStatusResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.util.ByteUtils;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONValue;

/**
 *
 * @author diego
 */
public class XBeeLightDetails {
    XBee xbee;
    XBeeAddress64 address64;
    public XBeeLightDetails() throws XBeeException {
         xbee = new XBee();
    }
    
    public String areLightsOn(int signal[]) throws IOException{
        try {
                xbee.open("/dev/ttyUSB0", 9600);
                XBeeResponse resp = xbee.getResponse(100000);
                Map obj=new LinkedHashMap();
                System.out.println("Entro a ver el estatus");
                if(resp.getApiId() == ApiId.ZNET_RX_RESPONSE){
                    ZNetRxResponse rxResponse = (ZNetRxResponse)resp;
                    System.out.println("Received RX packet, option is " + rxResponse.getOption() + ", sender 64 address is " + ByteUtils.toBase16(rxResponse.getRemoteAddress64().getAddress()) + ", remote 16-bit address is " + ByteUtils.toBase16(rxResponse.getRemoteAddress16().getAddress()) + ", data is " + ByteUtils.toBase16(rxResponse.getData()));
                    int []x;
                    x=rxResponse.getData();
                    if(x[0]==0){
                        System.out.println("El foco 9 se encuentra encendido");
                        obj.put("id0", "1");
                    }
                    else if(x[0]==5){
                        System.out.println("El foco 9 se encuentra apagado");
                        obj.put("id0", "0");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                    if(x[1]==10){
                        System.out.println("El foco 10 se encuentra encendido");
                        obj.put("id1", "1");
                    }
                    else if(x[1]==15){
                        System.out.println("El foco 10 se encuentra apagado");
                        obj.put("id1", "0");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                    if(x[2]==20){
                        System.out.println("El foco 11 se encuentra encendido");
                        obj.put("id2", "1");
                    }
                    else if(x[2]==25){
                        System.out.println("El foco 11 se encuentra apagado");
                        obj.put("id2", "0");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                    if(x[3]==30){
                        System.out.println("El foco 12 se encuentra encendido");
                        obj.put("id3", "1");
                    }
                    else if(x[3]==35){
                        System.out.println("El foco 12 se encuentra apagado");
                        obj.put("id3", "0");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                }
                else{
                    System.out.println("NO se recibio");
                }
            StringWriter out = new StringWriter();
            JSONValue.writeJSONString(obj, out);
            String jsonText = out.toString();
            System.out.print(jsonText);
            return jsonText;
             
        } catch (XBeeTimeoutException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
            return "-1";
        } catch (XBeeException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
            return "-1";
        }
        finally {
            xbee.close();
        }
    }

}
