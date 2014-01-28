/**
 * Copyright (c) 2008 Andrew Rapp. All rights reserved.
 *
 * This file is part of XBee-API.
 *
 * XBee-API is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * XBee-API is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * XBee-API. If not, see <http://www.gnu.org/licenses/>.
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
 * Example of performing a node discover for Series 2 XBees. You must connect to
 * the coordinator to run this example and have one or more end device/routers
 * that are associated.
 *
 * @author andrew
 *
 */
public class NodeDiscoverExample {

    private final static Logger log = Logger.getLogger(NodeDiscoverExample.class);
    List<XBeeAddress64> nodeList = new ArrayList<>();
    private XBee xbee = new XBee();
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

    public NodeDiscoverExample() throws XBeeException, InterruptedException {

        try {
            // replace with your serial port
            xbee.open("/dev/ttyUSB0", 9600);

            // get the Node discovery timeout
            xbee.sendAsynchronous(new AtCommand("NT"));
            AtCommandResponse nodeTimeout = (AtCommandResponse) xbee.getResponse();

            // default is 6 seconds
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

    public static void main(String[] args) throws XBeeException, InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        NodeDiscoverExample nd = new NodeDiscoverExample();
        System.out.println("Empieza lo bueno");
        for(int i=0;i<nd.getNodeList().size();i++){
            System.out.println("El id es el siguiente"+nd.getNodeList().get(i).toString());
        }
        
        for(int i=0;i<nd.getIdXBee().size();i++){
            for(int j=0;j<8;j++){
                System.out.println("El id es el siguiente"+nd.getIdXBee().get(i)[j]);
            }
        }
        // System.out.println("\n\n\n\n");
        /*XBeeNodeId id= new XBeeNodeId();
        String idXBee="";
        for(int i=0;i<id.getNodeList().size();i++){
            idXBee=id.getNodeList().get(i).toString();
            //System.out.println("El id es el siguiente"+id.getNodeList().get(i).toString());
            System.out.println("Xbee64 "+id.getXBeeId64(id.getNodeList().get(i)));
        }
        
        for(int i=0;i<id.getIdXBee().size();i++){
            for(int j=0;j<8;j++){
                System.out.println("El id es el siguiente"+id.getIdXBee().get(i)[j]);
            }
        }*/
       
    }
}
