package com.example.interfejs;
import javax.persistence.*;
@Table
@Entity
public class KontrabasHibernate {

    String Nazwa;
    String Drewno;
    Integer Wysokosc;
    Integer Cena;
    @Id
    @Column(name = "ID_KontrabasHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    public KontrabasHibernate() {
    }

    public KontrabasHibernate(String nazwa, String drewno, Integer wysokosc, Integer cena, Integer ID) {
        Nazwa = nazwa;
        Drewno = drewno;
        Wysokosc = wysokosc;
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

    public Integer getWysokosc() {
        return Wysokosc;
    }

    public void setWysokosc(Integer wysokosc) {
        Wysokosc = wysokosc;
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
