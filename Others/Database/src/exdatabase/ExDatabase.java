/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exdatabase;

import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class ExDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String a= ConnecttoDatabase.getInstancia().getDispositivosXBee().toString();
        System.out.println(a);
        // TODO code application logic here
    }
}
