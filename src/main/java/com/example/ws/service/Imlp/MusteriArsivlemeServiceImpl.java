package com.example.ws.service.Imlp;

import com.example.ws.dao.MusteriArsivlemeDao;
import com.example.ws.dto.DosyaDTO;
import com.example.ws.dto.MusteriDTO;
import com.example.ws.entity.Dosya;
import com.example.ws.entity.Musteri;
import com.example.ws.service.MusteriArsivlemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class MusteriArsivlemeServiceImpl implements MusteriArsivlemeService {

    private final MusteriArsivlemeDao musteriArsivlemeDao;

    @Autowired
    public MusteriArsivlemeServiceImpl(MusteriArsivlemeDao musteriArsivlemeDao) {
        this.musteriArsivlemeDao = musteriArsivlemeDao;
    }

    @Transactional
    public Musteri musteriKaydet(MusteriDTO musteriDTO){
        return musteriArsivlemeDao.musteriKaydet(musteriDTO);
    }

    @Override
    public boolean musteriSil(Long musteriId) {
        return musteriArsivlemeDao.musteriSil(musteriId);
    }

    @Override
    public Musteri musteriGuncelle(MusteriDTO musteriDTO,Long id) {
        return musteriArsivlemeDao.musteriGuncelle(musteriDTO, id);
    }

    @Override
    public List<Musteri> musterileriListele() {
        return musteriArsivlemeDao.musterileriListele();
    }

    @Override
    public Dosya dosyaKaydet(DosyaDTO dosyaDTO,Long id) {
        return musteriArsivlemeDao.dosyaKaydet(dosyaDTO,id);
    }

    @Override
    public boolean dosyaSil(Long dosyaId) {
        return musteriArsivlemeDao.dosyaSil(dosyaId);
    }

    @Override
    public Dosya dosyaGuncelle(DosyaDTO dosyaDTO, Long id) {
        return musteriArsivlemeDao.dosyaGuncelle(dosyaDTO,id);
    }

    @Override
    public Musteri dosyalariGetir(Long musteriId) {
        return musteriArsivlemeDao.dosyalariGetir(musteriId);
    }
}