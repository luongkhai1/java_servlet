package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.khachHang;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class khachHangRepo {

    public List<khachHang> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<khachHang> listkh = (ArrayList<khachHang>) session.createQuery("from khachHang order by ngayTao desc").list();
        return listkh;
    }

    public khachHang add(khachHang khachHang){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(khachHang);
            session.getTransaction().commit();
            return khachHang;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public khachHang edit(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(khachHang.class,id);
    }

    public khachHang Update(khachHang khachHang){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(khachHang);
            session.getTransaction().commit();
            return khachHang;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public khachHang Delete(int id){
        khachHang khachHang = edit(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.remove(khachHang);
            session.getTransaction().commit();
            return khachHang;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public khachHang find(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        TypedQuery<khachHang> query = session.createQuery("from khachHang order by ngayTao desc");
        query.setMaxResults(1);
        khachHang khachHang = query.getSingleResult();
        return khachHang;
    }

    public List<khachHang> FindBynameorphone( String sdt){
        Session session = Hibernateutlis.getFACTORY().openSession();
        TypedQuery<khachHang> query = session.createQuery("from khachHang where hoTen like :hoten or sdt like :hoten");
        if (sdt == null || sdt.trim().isEmpty()){
            query.setParameter("hoten","%%");
        }else {
            query.setParameter("hoten","%"+sdt+"%");
        }
        List<khachHang> khachHangList = query.getResultList();
        return khachHangList;
    }

}
