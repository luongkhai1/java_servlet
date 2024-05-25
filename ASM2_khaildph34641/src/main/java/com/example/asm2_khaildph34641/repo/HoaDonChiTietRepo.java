package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.HDCT;
import com.example.asm2_khaildph34641.model.HoaDon;
import com.example.asm2_khaildph34641.model.chiTietSanPham;
import com.example.asm2_khaildph34641.model.khachHang;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class HoaDonChiTietRepo {

    HoaDonRepo hoaDonRepo = new HoaDonRepo();

    public List<HDCT> getAll(HoaDon idhd){
        Session session = Hibernateutlis.getFACTORY().openSession();
        TypedQuery<HDCT> query = session.createQuery("from HDCT where idHoaDon = :id");
        query.setParameter("id",idhd);
        List<HDCT> hdctList = query.getResultList();
        return hdctList;
    }

    public Float getTongTien(int id){
        HoaDon hoaDon = hoaDonRepo.find(id);
        List<HDCT> hdctList = getAll(hoaDon);
        float tongtien =0;
        for (HDCT hdct : hdctList){
            tongtien += hdct.getTongTien();
        }
        return tongtien;
    }
    public HDCT add(HDCT hdct){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(hdct);
            session.getTransaction().commit();
            return hdct;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public HDCT Update(HDCT hdct){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(hdct);
            session.getTransaction().commit();
            return hdct;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public HDCT edit(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(HDCT.class,id);
    }

    public HDCT Delete(int id){
        HDCT hdct = edit(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.remove(hdct);
            session.getTransaction().commit();
            return hdct;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
