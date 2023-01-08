package com.example.interfejs;
import javax.persistence.*;

@Entity
public class WiolonczelaHibernate {

    String Nazwa;
    String Drewno;
    Integer Waga;
    Integer Cena;
    @Id
    @Column(name = "ID_WiolonczelaHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    public WiolonczelaHibernate() {
    }

    public WiolonczelaHibernate(String nazwa, String drewno, Integer waga, Integer cena, Long ID) {
        Nazwa = nazwa;
        Drewno = drewno;
        Waga = waga;
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

    public Integer getWaga() {
        return Waga;
    }

    public void setWaga(Integer waga) {
        Waga = waga;
    }

    public Integer getCena() {
        return Cena;
    }

    public void setCena(Integer cena) {
        Cena = cena;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
