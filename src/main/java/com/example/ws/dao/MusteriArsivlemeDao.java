package com.example.ws.dao;

import com.example.ws.dto.DosyaDTO;
import com.example.ws.dto.MusteriDTO;

import com.example.ws.entity.Dosya;
import com.example.ws.entity.Musteri;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface MusteriArsivlemeDao {

    Musteri musteriKaydet(MusteriDTO musteriDTO);

    boolean musteriSil(Long musteriId);

    Musteri musteriGuncelle(MusteriDTO musteriDTO,Long id);

    List<Musteri> musterileriListele();

    Dosya dosyaKaydet(DosyaDTO dosyaDTO,Long id);

    boolean dosyaSil(Long dosyaId);

    Dosya dosyaGuncelle(DosyaDTO dosyaDTO, Long id);

    Musteri dosyalariGetir(Long musteriId);
}
