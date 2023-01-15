package com.example.interfejs;

import java.sql.Connection;
import java.sql.DriverManager;

public class InstrumentyBazaDanych {
        public static Connection connectDb() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/InstrumentyHibernate", "root", "");
                return connect;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
