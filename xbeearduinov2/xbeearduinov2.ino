#include <XBee.h>
#include <SoftwareSerial.h>

int debugLED = 13;           //Flash light to indicate rx
int packet,signal;

int pin=8;
int pin0=9;
int pin1=10;
int pin2=11;
int pin3=12;

XBee xbee = XBee();
uint8_t payload[]={0,0};
XBeeAddress64 addr64 = XBeeAddress64(0x0013a200, 0x408b2e66);
ZBTxRequest zbTx = ZBTxRequest(addr64, payload, sizeof(payload));

XBeeResponse response = XBeeResponse(); 
ZBRxResponse rx64 = ZBRxResponse();

ZBTxStatusResponse txStatus = ZBTxStatusResponse();


void setup() {
  // start serial
  xbee.begin(9600);
pinMode(pin0,OUTPUT);
  pinMode(pin,OUTPUT);
  pinMode(pin1,OUTPUT);
  pinMode(pin2,OUTPUT);
  pinMode(pin3,OUTPUT);
  pinMode(debugLED,OUTPUT);
  digitalWrite(pin,HIGH);
}


void loop() {    
    xbee.readPacket();
    
    if (xbee.getResponse().isAvailable()) {
      if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) {
        // got a rx packet
        xbee.getResponse().getRx64Response(rx64);
        //signal= rx64.getData(0);
        packet = rx64.getData(0);
        
        /*
        if (signal == 0x10){
          if(packet == 0x01){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin0, HIGH); 
         }
         else if(packet == 0x00){            //If a '0' was pressed on keyboard side
           digitalWrite(pin0, LOW);               //turn off red LED
         }
        }
        
        if (signal == 0x20){
          if(packet == 0x01){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin1, HIGH); 
         }
         else if(packet == 0x00){            //If a '0' was pressed on keyboard side
           digitalWrite(pin1, LOW);               //turn off red LED
         }
        }
        
        if (signal == 0x30){
          if(packet == 0x01){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin2, HIGH); 
         }
         else if(packet == 0x00){            //If a '0' was pressed on keyboard side
           digitalWrite(pin2, LOW);               //turn off red LED
         }
        }
        
        if (signal == 0x40){
          if(packet == 0x01){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin3, HIGH); 
         }
         else if(packet == 0x00){            //If a '0' was pressed on keyboard side
           digitalWrite(pin3, LOW);               //turn off red LED
         }
        }*/
        
        if(packet == 0x00){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin0, HIGH); 
         }
         else if(packet == 0x01){            //If a '0' was pressed on keyboard side
           digitalWrite(pin0, LOW);               //turn off red LED
         }
         else if(packet == 0x02){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin1, HIGH); 
         }
         else if(packet == 0x03){            //If a '0' was pressed on keyboard side
           digitalWrite(pin1, LOW);               //turn off red LED
         }
         else if(packet == 0x04){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin2, HIGH); 
         }
         else if(packet == 0x05){            //If a '0' was pressed on keyboard side
           digitalWrite(pin2, LOW);               //turn off red LED
         }
         if(packet == 0x06){                  //If a '1' is pressed on keyboard side
          digitalWrite(pin3, HIGH); 
         }
         else if(packet == 0x07){            //If a '0' was pressed on keyboard side
           digitalWrite(pin3, LOW);               //turn off red LED
         }
      }
      //Si no es 0,1,2
      else{                               //Little debug flashing incase something other than 
        for(int i = 0; i < 10; i++)           //'1' or '0' is rx'd.
        {
           digitalWrite(debugLED, HIGH);
           delay(1000);
           digitalWrite(debugLED, LOW);
        }
      }   
    }//no llego nada
    else{
     digitalWrite(debugLED, HIGH);
     delay(2000);
     digitalWrite(debugLED, LOW); 
    }
   
}
