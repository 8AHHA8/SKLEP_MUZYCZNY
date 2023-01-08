module com.example.interfejs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires java.naming;
    requires java.sql;
    requires java.xml;
    requires jakarta.activation;
    requires jakarta.inject;
    requires java.persistence;
    requires org.hibernate.orm.core;


    exports com.example.interfejs;
    opens com.example.interfejs to javafx.fxml, org.hibernate.orm.core;
}