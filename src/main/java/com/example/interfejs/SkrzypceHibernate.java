package com.example.interfejs;
import javax.persistence.*;
@Table
@Entity
public class SkrzypceHibernate {

    String Nazwa;
    String Drewno;
    Integer Wiek;
    Integer Cena;
    @Id
    @Column(name = "ID_SkrzypceHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    public SkrzypceHibernate() {
    }

    public SkrzypceHibernate(String nazwa, String drewno, Integer wiek, Integer cena, Integer ID) {
        Nazwa = nazwa;
        Drewno = drewno;
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

    public String getDrewno() {
        return Drewno;
    }

    public void setDrewno(String drewno) {
        Drewno = drewno;
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