package com.example.interfejs;
import javax.persistence.*;
@Table
@Entity
public class InstrumentyHibernate {

    String Nazwa;
    String Drewno;
    Integer Wiek;
    Integer Cena;
    String Typ;
    @Id
    @Column(name = "ID_InstrumentyHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_Instrumentu;

    public InstrumentyHibernate() {
    }

    public InstrumentyHibernate(String nazwa, String drewno, Integer wiek, Integer cena, String typ, Integer ID_Instrumentu) {
        Nazwa = nazwa;
        Drewno = drewno;
        Wiek = wiek;
        Cena = cena;
        Typ = typ;
        this.ID_Instrumentu = ID_Instrumentu;
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

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String typ) {
        Typ = typ;
    }

    public Integer getID_Instrumentu() {
        return ID_Instrumentu;
    }

    public void setID(Integer ID_Instrumentu) {
        this.ID_Instrumentu = ID_Instrumentu;
    }

    @Override
    public String toString() {
        return ID_Instrumentu+"";
    }
}



