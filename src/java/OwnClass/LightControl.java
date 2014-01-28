/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OwnClass;
import com.rapplogic.xbee.api.*;
import com.rapplogic.xbee.api.zigbee.NodeDiscover;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxStatusResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.util.ByteUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class LightControl {
    
    XBee xbee;
    XBeeAddress64 address64;

    public LightControl() throws XBeeException {
         xbee = new XBee();
         //address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x89, 0xec, 0x92);
          address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54);
         xbee.open("/dev/ttyUSB0", 9600);
    }

    public LightControl(String id)throws XBeeException {
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
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
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
                        System.out.println("El foco se encuentra encendido");
                    }
                    else if (x[0]==20){
                        System.out.println("El foco se encuentra apagado");
                    }else{
                        System.out.println("Hay un error");
                    }
                }
                else{
                    System.out.println("NO se recibio");
                }
             
             
        } catch (XBeeTimeoutException ex) {
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XBeeException ex) {
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LightControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
