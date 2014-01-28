/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapplogic.xbee.examples.zigbee;
import com.rapplogic.xbee.api.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rapplogic.xbee.api.zigbee.NodeDiscover;
import com.rapplogic.xbee.util.ByteUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class XBeeNodeId {
    private final static Logger log = Logger.getLogger(XBeeNodeId.class);
    List<XBeeAddress64> nodeList = new ArrayList<XBeeAddress64>();
    //private XBee xbee =XBeeGeneral.getInstancia().getXbee();
    private XBee xbee= new XBee();
    List<int[]> idXBee = new ArrayList<int[]>();

    public static int convert(int n) {
        return Integer.valueOf(String.valueOf(n), 16);
    }

    public List<int[]> getIdXBee() {
        return idXBee;
    }

    public List<XBeeAddress64> getNodeList() {
        return nodeList;
    }
    
    public String getXBeeId64(XBeeAddress64 addr){
        String id,idx64="";
        //for(int i=0;i<nodeList.size();i++){
            id=addr.toString();
            for(int j=0;j<id.length();j++){
                if(j==2||j==3||j==7||j==8||j==12||j==13||j==17||j==18||j==22||j==23||j==27||j==28||j==32||j==33||j==37||j==38){
                    //0x00,0x13,0xa2,0x00,0x40,0x89,0xec,0x55
                    idx64+=id.charAt(j);
                }
            }
        //}
        return idx64;
    }

    public XBeeNodeId() throws XBeeException, InterruptedException{
        try {
            xbee.open("/dev/ttyUSB0", 9600);
            xbee.sendAsynchronous(new AtCommand("NT"));
            AtCommandResponse nodeTimeout = (AtCommandResponse) xbee.getResponse();
            long nodeDiscoveryTimeout = ByteUtils.convertMultiByteToInt(nodeTimeout.getValue()) * 100;
            log.debug("Node discovery timeout is " + nodeDiscoveryTimeout + " milliseconds");
            xbee.addPacketListener(new PacketListener() {

                public void processResponse(XBeeResponse response) {
                    if (response.getApiId() == ApiId.AT_RESPONSE) {
                        NodeDiscover nd = NodeDiscover.parse((AtCommandResponse) response);
                        nodeList.add(nd.getNodeAddress64());
                        idXBee.add(nd.getNodeAddress64().getAddress());
                        log.debug("Node discover response is: " + nd);
                    } else {
                        log.debug("Ignoring unexpected response: " + response);
                    }
                }
            });

            log.debug("Sending node discover command");
            xbee.sendAsynchronous(new AtCommand("ND"));

            // wait for nodeDiscoveryTimeout milliseconds
            Thread.sleep(nodeDiscoveryTimeout);

            log.debug("Time is up!  You should have heard back from all nodes by now.  If not make sure all nodes are associated and/or try increasing the node timeout (NT)");
        } finally {
            xbee.close();
        }
    }
    
    
}
