package com.example.interfejs;

import java.sql.Connection;
import java.sql.DriverManager;

public class SkrzypceBazaDanych {
        public static Connection connectDb() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/SkrzypceHibernate", "root", "");
                return connect;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
