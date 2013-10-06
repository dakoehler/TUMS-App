package de.dakoehler.tums.de.dakoehler.tums.serverstats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by Max on 19.05.13.
 */
public class Status {


    Connection conn = null;

    public Status(){
        setupSQL();
    }
    public void setupSQL(){
        final String hostname = "vweb05.nitrado.net";
        final String port = "3306";
        final String dbname = "ni12347_3sql12";
        final String user = "ni12347_3sql12";
        final String password = "74937493";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }
        String url = hostname + ":" + port + "/" + dbname + "?user=" + user
                + "&password=" + password;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getOnlinePlayers(){
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM userstatus";
            int ammount =  0;
            ResultSet rs = stat.executeQuery(sql);
            if(rs.last()){
                ammount = rs.getRow();
                rs.beforeFirst();
            }
            String[] values = new String[ammount];
            while(rs.next()){
                values[rs.getRow()-1]= rs.getString("user");
            }
            return values;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getOnlineAmmount(){
        return getOnlinePlayers().length;
    }


}
