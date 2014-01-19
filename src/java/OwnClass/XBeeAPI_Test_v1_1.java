/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OwnClass;
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
public class XBeeAPI_Test_v1_1 {
      
       public XBeeAPI_Test_v1_1(int signal) throws XBeeException
       {
        //int value;                                                         
        XBee xbee = new XBee();
       
                
        
        
        
        try{
            xbee.open("/dev/ttyUSB0", 9600);                
            XBeeAddress64 address64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x8b, 0x2e, 0x54);
            int[] payload;
            payload = new int[1];
            payload[0] = signal;
            System.out.println("La senal es : " + signal);    
            ZNetTxRequest request = new ZNetTxRequest(address64, payload);
            //while(true){

                try{
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
            //}
           
      }finally{
          xbee.close();
      }
       }
                
                
    
}
