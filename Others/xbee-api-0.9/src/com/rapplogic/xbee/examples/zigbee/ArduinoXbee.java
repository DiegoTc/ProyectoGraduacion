/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapplogic.xbee.examples.zigbee;

import com.rapplogic.xbee.api.*;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxStatusResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.util.ByteUtils;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class ArduinoXbee {
    public static void main(String[] args) throws XBeeException {
         XBee xbee = new XBee();
        
      try{
        //OPEN SERIAL PORT
            xbee.open("/dev/ttyUSB1", 9600);                 
            
            Scanner input = new Scanner(System.in);
            //XBeeAddress64 address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54); Mi xbee router
            XBeeAddress64 address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x89, 0xec, 0x92); //xbee router Douglas
            int[] payload;
            payload = new int[1];
            
            System.out.println("Comando para el LED: 0 para APAGAR EL LED , 1 para ENCENDERLO");
            payload[0] = (int)input.nextByte();
                
            ZNetTxRequest request = new ZNetTxRequest(address64, payload);
            
            System.out.println("\nZB request is: " + request.getXBeePacket());

             while(true){

                try{
                    
 
                    

                    //System.out.println("Response received"+ response);
                    
                    if (payload[0]==2){
                        ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 10000);
                        request.setFrameId(xbee.getNextFrameId());
                        XBeeResponse resp = xbee.getResponse();
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
                            }
                        else{
                            System.out.println("Hay un error");
                        }
                        }
                    }
                    ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 100000);
                    request.setFrameId(xbee.getNextFrameId());
                    if(response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS){
                        System.out.println("Success!");
                    }else{
                        System.out.println("Packet failed due to" + response.getDeliveryStatus());
                    }
                }catch(XBeeTimeoutException e){
                System.out.println("Me ! Unable to send");
            }
                System.out.println("Enter a new command for LED: 0 to turn the LED OFF, 1 to turn on");
                payload[0] = (int)input.nextByte();
                
                request.setPayload(payload);
            }
      }finally{
          xbee.close();
      }
    }
}
