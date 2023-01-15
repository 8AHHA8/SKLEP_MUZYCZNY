package com.example.interfejs;

import javax.persistence.*;

@Table
@Entity
public class KlientHibernate  {


    String Imie;
    String Nazwisko;
    Integer Numer_Telefonu;

    @ManyToOne()
    private InstrumentyHibernate ID_Instrumentu;
    Integer Cena;
    @Id
    @Column(name = "ID_InstrumentyHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_Klienta;

    public KlientHibernate() {
    }

    public KlientHibernate(String imie, String nazwisko, Integer numer_Telefonu, InstrumentyHibernate ID_Instrumentu, Integer cena, Integer ID_Klienta) {
        Imie = imie;
        Nazwisko = nazwisko;
        Numer_Telefonu = numer_Telefonu;
        this.ID_Instrumentu = ID_Instrumentu;
        Cena = cena;
        this.ID_Klienta = ID_Klienta;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public Integer getNumer_Telefonu() {
        return Numer_Telefonu;
    }

    public void setNumer_Telefonu(Integer numer_Telefonu) {
        Numer_Telefonu = numer_Telefonu;
    }

    public InstrumentyHibernate getID_Instrumentu() {
        return ID_Instrumentu;
    }

    public void setID_Instrumentu(InstrumentyHibernate ID_Instrumentu) {
        this.ID_Instrumentu = ID_Instrumentu;
    }

    public Integer getCena() {
        return Cena;
    }

    public void setCena(Integer cena) {
        Cena = cena;
    }

    public Integer getID_Klienta() {
        return ID_Klienta;
    }

    public void setID_Klienta(Integer ID_Klienta) {
        this.ID_Klienta = ID_Klienta;
    }
    @Override
    public String toString() {
        return ID_Klienta+"";
    }

}
