package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.HoaDon;
import com.example.asm2_khaildph34641.model.chiTietSanPham;
import com.example.asm2_khaildph34641.model.khachHang;
import com.example.asm2_khaildph34641.model.sanPham;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import org.hibernate.Session;

import java.util.List;

public class HoaDonRepo {

    public List<HoaDon> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<HoaDon> hoaDonList = session.createQuery("from HoaDon where trangThai = 'UnPaid'").list();
        return hoaDonList;
    }

    public List<HoaDon> getAlll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<HoaDon> hoaDonList = session.createQuery("from HoaDon where trangThai = 'Paid'").list();
        return hoaDonList;
    }

    public HoaDon add(HoaDon hoaDon){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(hoaDon);
            session.getTransaction().commit();
            return hoaDon;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public HoaDon find(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(HoaDon.class,id);
    }

    public HoaDon Update(HoaDon hoaDon){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(hoaDon);
            session.getTransaction().commit();
            return hoaDon;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public HoaDon Delete(int id){
        HoaDon hoaDon = find(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.remove(hoaDon);
            session.getTransaction().commit();
            return hoaDon;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
