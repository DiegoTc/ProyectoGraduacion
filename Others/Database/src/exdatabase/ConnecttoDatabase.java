/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exdatabase;

/**
 *
 * @author diego
 */
import java.sql.*;
import java.util.ArrayList;

public class ConnecttoDatabase {

    private static ConnecttoDatabase instancia = null;

    public static ConnecttoDatabase getInstancia() {
        if (instancia == null) {
            instancia = new ConnecttoDatabase();
        }
        return instancia;
    }

    private ConnecttoDatabase() {
    }

    private String getHeader() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n").append("\"id\": -1,\n").append("\"error\": \"\",").append("\"fieldErrors\": [],");
        builder.append("\"data\": [],").append("\"aaData\": [\n");
        return builder.toString();
    }

    public StringBuilder getDispositivosTomacorrientes() throws ClassNotFoundException, SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(getHeader());

        ArrayList<StringBuilder> lista = getDispositivosTomacorrientes1();
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i));
            if (i < lista.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]\n}");
        return builder;
    }

    public ArrayList<StringBuilder> getDispositivosTomacorrientes1() throws ClassNotFoundException, SQLException {
        ArrayList<StringBuilder> lista = new ArrayList<StringBuilder>();
        StringBuilder query = new StringBuilder();
        //
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select * from tomacorrientes");
            ResultSet rs = statement.executeQuery(query.toString());
            String tmp, tmp1, tmp2,tmp3;
            while (rs.next()) {
                tmp = rs.getString("codigo");
                tmp1 = rs.getString("descripcion");
                tmp2 = rs.getString("xbee_id");
                if (tmp != null) {
                    StringBuilder builder = new StringBuilder();
                    builder.append("{");
                    builder.append("\"codigo\": \"");
                    builder.append(tmp).append("\",\n");
                    builder.append("\"xbee_id\": \"");
                    builder.append(tmp2).append("\",\n");
                    builder.append("\"descripcion\": \"");
                    builder.append(tmp1).append("\",\n");
                    builder.append("\"switch\": \"");
                    builder.append("").append("\"\n");
                    builder.append("}");   
                    lista.add(builder);
                }
                tmp = "";
                tmp1 = "";
                tmp2 = "";
            }
            //builder.append("]\n}");
            statement.close();
            return lista;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return lista;
    }

    public StringBuilder getComboXbee() throws ClassNotFoundException, SQLException {
        StringBuilder builder = new StringBuilder();
        StringBuilder query = new StringBuilder();

        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select xbee from dispositivosxbee");
            ResultSet rs = statement.executeQuery(query.toString());
            String tmp, tmp1, tmp2, tmp3;
            while (rs.next()) {
                tmp = rs.getString("xbee");
                builder.append("<option>").append(tmp).append("</option>\n");
            } 

            statement.close();
            return builder;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return builder;
    }

    public StringBuilder getComboXbeeSelected(String id) throws ClassNotFoundException, SQLException {
        StringBuilder builder = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select xbee from dispositivosxbee");
            ResultSet rs = statement.executeQuery(query.toString());
            String tmp, tmp1, tmp2, tmp3;
            while (rs.next()) {
                tmp = rs.getString("xbee");
                if (!tmp.equals(id)) {
                    builder.append("<option>").append(tmp).append("</option>\n");
                } else {
                    builder.append("<option selected=\"selected\">").append(tmp).append("</option>\n");
                }

            } 

            statement.close();
            return builder;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return builder;
    }

    public StringBuilder getLightsSwitch() throws ClassNotFoundException, SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(getHeader());

        ArrayList<StringBuilder> lista = getLightsSwitchoOnOff();
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i));
            if (i < lista.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]\n}");
        return builder;//getLightsSwitchoOnOff
    }
    
     public ArrayList<StringBuilder> getLightsSwitchoOnOff() throws ClassNotFoundException, SQLException {
        ArrayList<StringBuilder> lista = new ArrayList<StringBuilder>();

        StringBuilder query = new StringBuilder();

        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select * from luces");
            ResultSet rs = statement.executeQuery(query.toString());
            String tmp, tmp1, tmp2, tmp3;
            while (rs.next()) {
                tmp = rs.getString("codigo");
                tmp1 = rs.getString("descripcion");
                tmp2 = rs.getString("xbee_id");
                tmp3 = rs.getString("Watts");

                if (tmp != null) {
                    StringBuilder builder = new StringBuilder();
                    builder.append("{");
                    builder.append("\"codigo\": \"");
                    builder.append(tmp).append("\",\n");
                    builder.append("\"descripcion\": \"");
                    builder.append(tmp1).append("\",\n");
                    builder.append("\"xbee_id\": \"");
                    builder.append(tmp2).append("\",\n");
                    builder.append("\"switch\": \"");
                    //builder.append("<span class=\'checkslide\'><input type=\'checkbox\' id=\'").append(tmp).append("\'/><label data-on=\'ON\' data-off=\'OFF\'></label></span>").append("\",\n");
                    builder.append("").append("\"\n");
                    builder.append("}");
                    lista.add(builder);
                }
                tmp = "";
                tmp1 = "";
                tmp2 = "";
                


            }

            statement.close();
            return lista;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return lista;
    }
    
    public StringBuilder getDispositivosLuces() throws ClassNotFoundException, SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(getHeader());

        ArrayList<StringBuilder> lista = getDispositivosLuces1();
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i));
            if (i < lista.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]\n}");
        return builder;
    }

    public ArrayList<StringBuilder> getDispositivosLuces1() throws ClassNotFoundException, SQLException {
        ArrayList<StringBuilder> lista = new ArrayList<StringBuilder>();

        StringBuilder query = new StringBuilder();

        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select * from luces");
            ResultSet rs = statement.executeQuery(query.toString());
            String tmp, tmp1, tmp2, tmp3;
            while (rs.next()) {
                tmp = rs.getString("codigo");
                tmp1 = rs.getString("descripcion");
                tmp2 = rs.getString("xbee_id");
                tmp3 = rs.getString("Watts");

                if (tmp != null) {
                    StringBuilder builder = new StringBuilder();
                    builder.append("{");
                    builder.append("\"codigo\": \"");
                    builder.append(tmp).append("\",\n");
                    builder.append("\"descripcion\": \"");
                    builder.append(tmp1).append("\",\n");
                    builder.append("\"xbee_id\": \"");
                    builder.append(tmp2).append("\",\n");
                    builder.append("\"watts\": \"");
                    builder.append(tmp3).append("\"\n");
                    builder.append("}");
                    lista.add(builder);
                }
                tmp = "";
                tmp1 = "";
                tmp2 = "";


            }

            statement.close();
            return lista;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return lista;
    }

    public StringBuilder getDispositivosXBee() throws ClassNotFoundException, SQLException {
         StringBuilder builder = new StringBuilder();
        builder.append(getHeader());

        ArrayList<StringBuilder> lista = getDispositivosXBee1();
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i));
            if (i < lista.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]\n}");
        return builder;
    }

    public ArrayList<StringBuilder> getDispositivosXBee1() throws ClassNotFoundException, SQLException {
        
        StringBuilder query = new StringBuilder();
        ArrayList<StringBuilder> lista= new ArrayList<StringBuilder>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        Boolean flag = false;
        String tmp, tmp1, tmp2;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            query.append("select * from dispositivosxbee");
            ResultSet rs = statement.executeQuery(query.toString());
            while (rs.next()) {
                tmp = rs.getString("codigo");
                tmp1 = rs.getString("xbee");
                tmp2 = rs.getString("ubicacion");
                if (tmp2 == null) {
                    tmp2 = "";
                }
                
                if(tmp!=""){
                    StringBuilder builder = new StringBuilder();
                builder.append("{");
                builder.append("\"codigo\": \"");
                builder.append(tmp).append("\",\n");
                builder.append("\"xbee\": \"");
                builder.append(tmp1).append("\",\n");
                builder.append("\"ubicacion\": \"");
                builder.append(tmp2).append("\"\n");
                builder.append("}");
                lista.add(builder);
                }
                tmp="";
                tmp1="";
                tmp2="";

            } 

            statement.close();
            return lista;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return lista;
    }
    
    public void insertTomacorrientes(String descripcion, String xbee) throws ClassNotFoundException, SQLException {

        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("insert into tomacorrientes(descripcion,xbee_id) values('").append(descripcion).append("','").append(xbee).append("')");
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

    }
    
     public void insertXBee(String ubicacion, String xbee) throws ClassNotFoundException, SQLException {

        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("insert into dispositivosxbee(ubicacion,xbee) values('").append(ubicacion).append("','").append(xbee).append("')");
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

    }

    public void insertLuces(String descripcion, String xbee, String watts) throws ClassNotFoundException, SQLException {

        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("insert into luces(descripcion,xbee_id,Watts) values('").append(descripcion).append("','").append(xbee).append("', '").append(watts).append("')");
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

    }

    public void deleteTomacorrientes(String id) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("delete from tomacorrientes where  codigo=").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void deleteLuces(String id) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("delete from luces where  codigo=").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    
    public void deleteXBee(String id) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("delete from dispositivosxbee where  codigo=").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void updateTomacorrientes(String id, String descripcion, String xbee) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("update tomacorrientes set descripcion = '").append(descripcion).append("', xbee_id = '").append(xbee).append("' ");
            query.append("where codigo = ").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    
     public void updateXBee(String id, String ubicacion, String xbee) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("update dispositivosxbee set ubicacion = '").append(ubicacion).append("', xbee = '").append(xbee).append("' ");
            query.append("where codigo = ").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void updateLuces(String id, String descripcion, String xbee, String watts) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/diego/UNITEC/ProyectoGraduacion/SitioWebDomoticaV2/db/DomoticaDatabase");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            query.append("update luces set descripcion = '").append(descripcion).append("', xbee_id = '").append(xbee).append("', Watts = '").append(watts).append("'");
            query.append("where codigo = ").append(id);
            statement.executeQuery(query.toString());
            statement.close();

        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    
    
}
