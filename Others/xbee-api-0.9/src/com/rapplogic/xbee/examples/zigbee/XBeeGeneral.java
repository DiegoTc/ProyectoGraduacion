/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapplogic.xbee.examples.zigbee;

import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;

/**
 *
 * @author diego
 */
public class XBeeGeneral {
    private static XBeeGeneral instancia = null;
    XBee xbee;
    public static XBeeGeneral getInstancia() throws XBeeException {
        if (instancia == null) {
            instancia = new XBeeGeneral();
            
        }
        return instancia;
    }

    private XBeeGeneral() throws XBeeException {
        xbee = new XBee();
        xbee.open("/dev/ttyUSB0", 9600);
    }

    public XBee getXbee() {
        return xbee;
    }

    
}
