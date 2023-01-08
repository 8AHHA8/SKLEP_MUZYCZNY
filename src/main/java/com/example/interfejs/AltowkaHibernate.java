package com.example.interfejs;
import javax.persistence.*;
@Table
@Entity
public class AltowkaHibernate {

    String Nazwa;
    String Kolor;
    Integer Wiek;
    Integer Cena;
    @Id
    @Column(name = "ID_AltowkaHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    public AltowkaHibernate() {
    }

    public AltowkaHibernate(String nazwa, String kolor, Integer wiek, Integer cena, Integer ID) {
        Nazwa = nazwa;
        Kolor = kolor;
        Wiek = wiek;
        Cena = cena;
        this.ID = ID;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getKolor() {
        return Kolor;
    }

    public void setKolor(String kolor) {
        Kolor = kolor;
    }

    public Integer getWiek() {
        return Wiek;
    }

    public void setWiek(Integer wiek) {
        Wiek = wiek;
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
