#include <XBee.h>
#include <SoftwareSerial.h>
int debugLED = 13;           //Flash light to indicate rx
int pin0=9;
int pin1=10;
int pin2=11;
int pin3=12;

XBee xbee = XBee();
uint8_t payload[]={-1,-1,-1,-1};

XBeeAddress64 addr64 = XBeeAddress64(0x0013a200, 0x408b2e66);
ZBTxStatusResponse txStatus = ZBTxStatusResponse();
ZBTxRequest zbTx = ZBTxRequest(addr64, payload, sizeof(payload));

void setup() {
  // start serial
  //pinMode(pin,INPUT);
  pinMode(pin0,OUTPUT);
  pinMode(pin1,OUTPUT);
  pinMode(pin2,OUTPUT);
  pinMode(pin3,OUTPUT);
  xbee.begin(9600);
}
void loop() {    
    if(digitalRead(pin0)== HIGH){
      payload[0]=0;
    }
    else{
      payload[0]=5;
    }
    
    if(digitalRead(pin1)== HIGH){
      payload[1]=10;
    }
    else{
      payload[1]=15;
    }
    
    if(digitalRead(pin2)== HIGH){
      payload[2]=20;
    }
    else{
      payload[2]=25;
    }
    
    if(digitalRead(pin3)== HIGH){
      payload[3]=30;
    }
    else{
      payload[3]=35;
    }
    
    xbee.send(zbTx);
    if (xbee.readPacket(5000)) {
      if (xbee.getResponse().getApiId() == TX_STATUS_RESPONSE) {
        xbee.getResponse().getZBTxStatusResponse(txStatus);
        if (txStatus.isSuccess()) {
          digitalWrite(debugLED, HIGH);
          delay(3000);
          digitalWrite(debugLED, LOW); 
        }
      }
    }
    
   
}
