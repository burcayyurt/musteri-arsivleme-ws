package com.example.ws.dao.impl;

import com.example.ws.dao.MusteriArsivlemeDao;
import com.example.ws.dto.DosyaDTO;
import com.example.ws.dto.MusteriDTO;
import com.example.ws.entity.Dosya;
import com.example.ws.entity.Musteri;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class MusteriArsivlemeDaoImpl implements MusteriArsivlemeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Musteri musteri;
    private Dosya dosya;

    @Autowired
    public MusteriArsivlemeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Musteri musteriKaydet(MusteriDTO musteriDTO) {
        musteri = new Musteri();
        musteri.setMusteriAd_Soyad(musteriDTO.getMusteriAdi());
        musteri.setMusteriEmail(musteriDTO.getMusteriEmail());
        sessionFactory.getCurrentSession().save(musteri);

        return musteri;
    }

    @Override
    public boolean musteriSil(Long musteriId) {

        try {
            Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Musteri.class,"musteri");
            crIlgili.add(Restrictions.eq("id",musteriId));

            musteri = (Musteri) crIlgili.uniqueResult();
            sessionFactory.getCurrentSession().delete(musteri);
            return true;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public Musteri musteriGuncelle(MusteriDTO musteriDTO,Long id) {
        Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Musteri.class,"musteri");
        crIlgili.add(Restrictions.eq("id",id));

        musteri = (Musteri) crIlgili.uniqueResult();

        musteri.setMusteriAd_Soyad(musteriDTO.getMusteriAdi());
        musteri.setMusteriEmail(musteriDTO.getMusteriEmail());

        sessionFactory.getCurrentSession().saveOrUpdate(musteri);

        return musteri;
    }

    @Override
    public List<Musteri> musterileriListele() {

        Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Musteri.class,"musteri");
        List<Musteri> result = crIlgili.list();

        return result;
    }

    @Override
    public boolean dosyaSil(Long dosyaId) {
        try {
            Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Dosya.class,"dosya");
            crIlgili.add(Restrictions.eq("id",dosyaId));

            dosya = (Dosya) crIlgili.uniqueResult();
            sessionFactory.getCurrentSession().delete(dosya);
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Dosya dosyaKaydet(DosyaDTO dosyaDTO,Long id) {
        dosya = new Dosya();
        dosya.setDosya(dosyaDTO.getDosya());
        dosya.setDosyaAdi(dosyaDTO.getDosyaAdi());
        dosya.setMusteri_id(id);
        sessionFactory.getCurrentSession().save(dosya);

        return dosya;
    }

    @Override
    public Dosya dosyaGuncelle(DosyaDTO dosyaDTO, Long id) {

        Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Dosya.class,"dosya");
        crIlgili.add(Restrictions.eq("id",id));

        dosya = (Dosya) crIlgili.uniqueResult();

        dosya.setDosyaAdi(dosyaDTO.getDosyaAdi());

        sessionFactory.getCurrentSession().saveOrUpdate(dosya);

        return dosya;
    }

    @Override
    public Musteri dosyalariGetir(Long musteriId) {
        Criteria crIlgili = sessionFactory.getCurrentSession().createCriteria(Musteri.class,"musteri");
        crIlgili.add(Restrictions.eq("id",musteriId));

        musteri = (Musteri) crIlgili.uniqueResult();

        return musteri;

    }

}
