package dao;

import utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnexion {
    Connection con;

    public void connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con =  DriverManager.getConnection(Constants.CONNECTION,
                Constants.USER_CONNECTION, Constants.PASS_CONNECTION);
    }

    public void disconnect() throws SQLException {
        this.con.close();
    }
}
