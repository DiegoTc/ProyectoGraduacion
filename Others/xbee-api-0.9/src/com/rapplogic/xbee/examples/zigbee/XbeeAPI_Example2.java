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
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class XbeeAPI_Example2 {
    
    final static int TURN_LIGHT_ON = 100;
    final static int TURN_LIGHT_OFF = 101;
    final static int LIGHT_IS_GOING_ON = 102;
    final static int LIGHT_IS_GOING_OFF = 103;
    final static int LIGHT_ERROR = 104;
    final static int LIGH_WAS_ON = 105;
    final static int LIGH_wAS_OFF = 106;
    
  
    public static void main(String[] args) throws XBeeException {
        XBee xbee = new XBee();
        
        try{
        //OPEN SERIAL PORT
            xbee.open("/dev/ttyUSB0", 9600);                 
            
            Scanner input = new Scanner(System.in);
            XBeeAddress64 address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54);
            int[] payload;
            int sign;
            payload = new int[1];
            
            System.out.println("Comando para el LED: 0 para APAGAR EL LED , 1 para ENCENDERLO");
            sign=input.nextInt();
            while(true){
                if(sign == 1){
                    {
                        int[] payload1 = new int[] { TURN_LIGHT_ON };
                        // first request we just send 64-bit address.  we get 16-bit network address with status response
                        ZNetTxRequest request = new ZNetTxRequest(address64, payload);
                        System.out.println("Enviando senal a la luz"+ request);	
                        long start = System.currentTimeMillis();
                        ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 10000);
                        System.out.println("Received response in [" + (System.currentTimeMillis() - start) + "]: " + response);		
                        if (response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS) {
                            System.out.println("Se encendio exitosamente el foco");
                            // the packet was successfully delivered
//                          log.info("Packet received by Garage Door XBee");
                        } else {
                            // packet failed
                            // it's easy to create this error by unplugging/powering off your remote xbee.  when doing so I get: packet failed due to error: ADDRESS_NOT_FOUND  				
                            System.out.println("ZigBee command delivery failed: " + response.getDeliveryStatus());
                        }
                        System.out.println("Comando para el LED: 0 para APAGAR EL LED , 1 para ENCENDERLO");
                        sign=input.nextInt();
                    }
                }
                else if(sign ==0){
                    int[] payload1 = new int[] { TURN_LIGHT_OFF };
                        // first request we just send 64-bit address.  we get 16-bit network address with status response
                        ZNetTxRequest request = new ZNetTxRequest(address64, payload);
                        System.out.println("Enviando senal a la luz para apagarla"+ request);	
                        long start = System.currentTimeMillis();
                        ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 10000);
                        System.out.println("Received response in [" + (System.currentTimeMillis() - start) + "]: " + response);		
                        if (response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS) {
                            System.out.println("Se ha apagado exitosamente el foco");
                            // the packet was successfully delivered
//                          log.info("Packet received by Garage Door XBee");
                        } else {
                            // packet failed
                            // it's easy to create this error by unplugging/powering off your remote xbee.  when doing so I get: packet failed due to error: ADDRESS_NOT_FOUND  				
                            System.out.println("ZigBee command delivery failed: " + response.getDeliveryStatus());
                        }
                        System.out.println("Comando para el LED: 0 para APAGAR EL LED , 1 para ENCENDERLO");
                        sign=input.nextInt();
                }  
            }    
      }finally{
          xbee.close();
      }
    }
}
