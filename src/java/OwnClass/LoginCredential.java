/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OwnClass;

import org.jasypt.util.password.BasicPasswordEncryptor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author diego
 */
public class LoginCredential {
    String user;
    String password;

    private static LoginCredential instancia=null;
    public static LoginCredential getInstancia()
    {
        if(instancia== null){
            instancia= new LoginCredential();
        }
        return instancia;
    }
    
    public String getEncryptedPassword(String password)
    {
        BasicPasswordEncryptor pass= new BasicPasswordEncryptor();
        String passencriptado=pass.encryptPassword(password);
        return passencriptado;
    }
    
    private Boolean verifiedPassword(String userpass,String dbpass)
    {
        BasicPasswordEncryptor pass= new BasicPasswordEncryptor();
        if(pass.checkPassword(userpass, dbpass)){
            return true;
        }
        else{
            return false;
        }       
    }
    
    public Boolean verifiedUser(String user, String ipass) throws ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag=false;
        try
        {
            connection=DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            StringBuilder query=new StringBuilder();
            query.append("Select Password from usuarios where Usuario= '");
            query.append(user);
            query.append("'");
            ResultSet rs = statement.executeQuery(query.toString());
            if(rs.next())
            {
                String passw=rs.getString("Password");
                flag=verifiedPassword(ipass, passw);
                if(connection != null)
                connection.close();
                return flag;
            }
        }
        catch(SQLException e)
        {
            if(connection != null)
                connection.close();
            return flag;
        }
        finally
        {
            try
            {
                if(connection != null)
                connection.close();
                return flag;
            }
            catch(SQLException e)
            {
                return flag;
            }
        }   
    }
}
