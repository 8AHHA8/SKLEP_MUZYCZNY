package com.example.interfejs;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
public class ZamowieniaHibernate {

    LocalDateTime Data_zamowienia;

    Integer Cena;
    Integer ID_Instrumentu;
    @ManyToOne()
    private KlientHibernate ID_Klienta;

    @Id
    @Column(name = "ID_ZamowieniaHibernate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    public ZamowieniaHibernate() {
    }

    public ZamowieniaHibernate(LocalDateTime data_zamowienia, Integer cena, Integer ID_Instrumentu, KlientHibernate ID_Klienta, Integer ID) {
        Data_zamowienia = data_zamowienia;
        Cena = cena;
        this.ID_Instrumentu = ID_Instrumentu;
        this.ID_Klienta = ID_Klienta;
        this.ID = ID;
    }

    public LocalDateTime getData_zamowienia() {
        return Data_zamowienia;
    }

    public void setData_zamowienia(LocalDateTime data_zamowienia) {
        Data_zamowienia = data_zamowienia;
    }

    public Integer getCena() {
        return Cena;
    }

    public void setCena(Integer cena) {
        Cena = cena;
    }

    public Integer getID_Instrumentu() {
        return ID_Instrumentu;
    }

    public void setID_Instrumentu(Integer ID_Instrumentu) {
        this.ID_Instrumentu = ID_Instrumentu;
    }

    public KlientHibernate getID_Klienta() {
        return ID_Klienta;
    }

    public void setID_Klienta(KlientHibernate ID_Klienta) {
        this.ID_Klienta = ID_Klienta;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
