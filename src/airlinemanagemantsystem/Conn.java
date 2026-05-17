package airlinemanagemantsystem;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;

public class Conn {
    Connection c;       
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airlinemanagementsystem", "root", "123456789");
            this.s = this.c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
