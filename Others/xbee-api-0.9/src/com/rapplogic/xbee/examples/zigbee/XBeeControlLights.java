/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapplogic.xbee.examples.zigbee;

import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxStatusResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class XBeeControlLights {
    XBee xbee;
    XBeeAddress64 address64;
    
    public XBeeControlLights() throws XBeeException {
         xbee = new XBee();
         address64 = new XBeeAddress64(0,0x13,0xa2,0,0x40,0x89,0xec,0x55);
         //0x00,0x13,0xa2,0x00,0x40,0x89,0xec,0x55
          //address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54);
         //xbee.open("/dev/ttyUSB0", 9600);
    }

    public XBeeControlLights(String id)throws XBeeException {
        xbee = new XBee();
        address64= new XBeeAddress64(id);
         //xbee.open("/dev/ttyUSB0", 9600);
    }
    
    public void turnOnLights(int signal[]){
        try {
            xbee.open("/dev/ttyUSB0", 9600);
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
        finally{
            xbee.close();
        }
    }
    
    public void turnOffLights(int signal[]){
        try {
            xbee.open("/dev/ttyUSB0", 9600);
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
        finally{
            xbee.close();
        }
    }
}
