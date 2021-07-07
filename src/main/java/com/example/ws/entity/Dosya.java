package com.example.ws.entity;

import com.example.ws.ByteArrayDeSerializer;
import com.example.ws.ByteArraySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dosya")
public class Dosya extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5278802255307068340L;

    private Musteri musteri;
    private byte[] musteriDosyasi;
    private String dosyaAdi;
    private Long musteri_id;

    @Id
    @Column(name = "dosya_id")
    @SequenceGenerator(name = "dosya_id", sequenceName = "dosya_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dosya_id")
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {

        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musteri_id", referencedColumnName = "musteri_id", insertable=false, updatable=false)
    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    @Lob
    @JsonSerialize(using = ByteArraySerializer.class)
    @JsonDeserialize(using = ByteArrayDeSerializer.class)
    @Column(name = "dosya", columnDefinition="BLOB")
    public byte[] getDosya() {
        return musteriDosyasi;
    }

    public void setDosya(byte[] dosya) {
        this.musteriDosyasi = dosya;
    }

    @Column(name = "dosya_adi")
    public String getDosyaAdi() {
        return dosyaAdi;
    }

    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }

    @Column(name = "musteri_id")
    public Long getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Long musteri_id) {
        this.musteri_id = musteri_id;
    }
}
