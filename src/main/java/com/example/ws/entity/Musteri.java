package com.example.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "musteri")
public class Musteri extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5278802255307068348L;

    private String musteriAd_Soyad;

    @JsonIgnore
    private Set<Dosya> musteriDosyalari;

    private String musteriEmail;


    @Id
    @SequenceGenerator(name = "musteri_id", sequenceName = "musteri_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musteri_id")
    @Column(name = "musteri_id")
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {

        this.id = id;
    }

    @Column(name = "musteriadsoyad")
    public String getMusteriAd_Soyad() {
        return musteriAd_Soyad;
    }

    public void setMusteriAd_Soyad(String musteriAd_Soyad) {
        this.musteriAd_Soyad = musteriAd_Soyad;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="musteri_id")
    public Set<Dosya> getMusteriDosyalari() {
        return musteriDosyalari;
    }

    public void setMusteriDosyalari(Set<Dosya> musteriDosyalari) {
        this.musteriDosyalari = musteriDosyalari;
    }

    @Column(name = "email")
    public String getMusteriEmail() {
        return musteriEmail;
    }

    public void setMusteriEmail(String musteriEmail) {
        this.musteriEmail = musteriEmail;
    }
}
