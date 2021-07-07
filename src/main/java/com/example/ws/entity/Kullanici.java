package com.example.ws.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kullanici")
public class Kullanici extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5278802255307068344L;

    private String kullaniciAdi;
    private String kullaniciSifre;
    private Dosya dosya;
    private Musteri musteri;

    @Id
    @Column(name = "kullanici_id")
    @SequenceGenerator(name = "kullanici_id", sequenceName = "kullanici_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kullanici_id")
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {

        this.id = id;
    }

    @Column(name = "kullanici_adi")
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    @Column(name = "kullanici_sifre")
    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

}
