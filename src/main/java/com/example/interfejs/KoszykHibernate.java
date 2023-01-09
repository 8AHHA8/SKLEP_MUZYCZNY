package com.example.interfejs;

import javax.persistence.*;

@Table
@Entity
public class KoszykHibernate {


    String wlasnosc1;
    String wlasnosc2;
    Integer wlasnosc3;
    Integer Cena;

    @Id
    @Column(name = "ID_KOSZYKHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;


    public KoszykHibernate() {
    }

    public KoszykHibernate(String wlasnosc1, String wlasnosc2, Integer wlasnosc3, Integer cena, Integer ID) {
        this.wlasnosc1 = wlasnosc1;
        this.wlasnosc2 = wlasnosc2;
        this.wlasnosc3 = wlasnosc3;
        Cena = cena;
        this.ID = ID;
    }

    public String getWlasnosc1() {
        return wlasnosc1;
    }

    public void setWlasnosc1(String wlasnosc1) {
        this.wlasnosc1 = wlasnosc1;
    }

    public String getWlasnosc2() {
        return wlasnosc2;
    }

    public void setWlasnosc2(String wlasnosc2) {
        this.wlasnosc2 = wlasnosc2;
    }

    public Integer getWlasnosc3() {
        return wlasnosc3;
    }

    public void setWlasnosc3(Integer wlasnosc3) {
        this.wlasnosc3 = wlasnosc3;
    }

    public Integer getCena() {
        return Cena;
    }

    public void setCena(Integer cena) {
        Cena = cena;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
