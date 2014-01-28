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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class XBeeLights {
    XBee xbee;
    XBeeAddress64 address64;

    public XBeeLights() throws XBeeException {
         xbee = new XBee();
         address64 = new XBeeAddress64(0,0x13,0xa2,0,0x40,0x89,0xec,0x55);
         //0x00,0x13,0xa2,0x00,0x40,0x89,0xec,0x55
         // address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54);
         xbee.open("/dev/ttyUSB0", 9600);
    }

    public XBeeLights(String id)throws XBeeException {
        xbee = new XBee();
        address64= new XBeeAddress64(id);
         xbee.open("/dev/ttyUSB0", 9600);
    }
    
    
    
    public void turnOnLights(int signal[]){
        try {
            ZNetTxRequest request = new ZNetTxRequest(address64, signal);
            ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 100000);
            request.setFrameId(xbee.getNextFrameId());
             if(response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS){
                System.out.println("Success!The lightbulb is on");
             }else{
                 System.out.println("Packet failed due to" + response.getDeliveryStatus());
             }
             
        } catch (XBeeTimeoutException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void turnOffLights(int signal[]){
        try {
            ZNetTxRequest request = new ZNetTxRequest(address64, signal);
            ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 100000);
            request.setFrameId(xbee.getNextFrameId());
             if(response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS){
                System.out.println("Success!The lightbulb is off");
             }else{
                 System.out.println("Packet failed due to" + response.getDeliveryStatus());
             }
             
        } catch (XBeeTimeoutException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void areLightsOn(int signal[]){
        try {
            
                XBeeResponse resp = xbee.getResponse(100000);
                System.out.println("Entro a ver el estatus");
                if(resp.getApiId() == ApiId.ZNET_RX_RESPONSE){
                    ZNetRxResponse rxResponse = (ZNetRxResponse)resp;
                    System.out.println("Received RX packet, option is " + rxResponse.getOption() + ", sender 64 address is " + ByteUtils.toBase16(rxResponse.getRemoteAddress64().getAddress()) + ", remote 16-bit address is " + ByteUtils.toBase16(rxResponse.getRemoteAddress16().getAddress()) + ", data is " + ByteUtils.toBase16(rxResponse.getData()));
                    int []x;
                    x=rxResponse.getData();
                    if(x[0]==10){
                        System.out.println("El foco 0 se encuentra encendido");
                    }
                    else if(x[0]==15){
                        System.out.println("El foco 0 se encuentra apagado");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                    if(x[1]==20){
                        System.out.println("El foco 11 se encuentra encendido");
                    }
                    else if(x[1]==25){
                        System.out.println("El foco 11 se encuentra apagado");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                    
                    if(x[2]==30){
                        System.out.println("El foco 12 se encuentra encendido");
                    }
                    else if(x[2]==35){
                        System.out.println("El foco 12 se encuentra apagado");
                    }
                    else{
                        System.out.println("Hay un error");
                    }
                }
                else{
                    System.out.println("NO se recibio");
                }
             
             
        } catch (XBeeTimeoutException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getRadios(){
       final List<NodeDiscover> nodeList= new ArrayList<NodeDiscover>();
        try {
            xbee.sendAsynchronous(new AtCommand("NT"));
             XBeeResponse resp = xbee.getResponse();
            if( resp instanceof AtCommandResponse ){
                AtCommandResponse nodeTimeout = (AtCommandResponse) resp;
                long nodeDiscoveryTimeout = ByteUtils.convertMultiByteToInt(nodeTimeout.getValue()) * 100;
                xbee.addPacketListener(new PacketListener() {
                    public void processResponse(XBeeResponse response) {
                        if (response.getApiId() == ApiId.AT_RESPONSE) {
                            NodeDiscover nd = NodeDiscover.parse((AtCommandResponse)response);
                            nodeList.add(nd);
                        }
                    }
                });
                for(int i=0;i>nodeList.size();i++){
                    System.out.println("EL codigo XBee es de"+nodeList.get(i));
                }
            }
        } catch (XBeeException ex) {
            Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) throws XBeeException {
        Scanner input = new Scanner(System.in);
        int[] payload;
        payload = new int[1];
        int [] infor= new int[1];
        //XBeeLights xbeel= new XBeeLights();
        while(true){
            System.out.println("Comando para el LED: 0 para APAGAR EL LED , 1 para ENCENDERLO, 2 para ver status");
            payload[0] = (int)input.nextByte();
            if(payload[0]==0){
                infor[0]=1;
                //infor[1]=0 ;  
                XBeeControlLights xbe = new XBeeControlLights();
                xbe.turnOffLights(infor);
               //xbeel.turnOffLights(payload);
            }
            else if(payload[0]==1){
                infor[0]=0;
                //infor[1]=1 ;  
                XBeeControlLights xbe = new XBeeControlLights();
                xbe.turnOnLights(infor);
                //xbeel.turnOnLights(payload);
            }
            else if (payload[0]==2){
                //xbeel.areLightsOn(payload);
                XBeeLightDetails lig = new XBeeLightDetails();
                try {
                    String a=lig.areLightsOn(payload);
                    System.out.println(a);
                } catch (IOException ex) {
                    Logger.getLogger(XBeeLights.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (payload[0]== 3){
               // xbeel.getRadios();
            }
            else{
                System.out.println("Error comando no valido");
            }
        }
    }
    
    
}
