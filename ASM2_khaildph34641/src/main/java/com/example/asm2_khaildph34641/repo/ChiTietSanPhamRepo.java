package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.chiTietSanPham;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class ChiTietSanPhamRepo {

    public List<chiTietSanPham> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<chiTietSanPham> chiTietSanPhamList = session.createQuery("from chiTietSanPham ").list();
        return chiTietSanPhamList;
    }

    public List<chiTietSanPham> getAll(int idsp){
        Session session = Hibernateutlis.getFACTORY().openSession();
        String selectSql = "select ctsp from chiTietSanPham ctsp where ctsp.idSanPham.id = :idsp";
        TypedQuery<chiTietSanPham> typedQuery = session.createQuery(selectSql, chiTietSanPham.class);
        typedQuery.setParameter("idsp",idsp);
        List<chiTietSanPham> listchitietsp = typedQuery.getResultList();
        return listchitietsp;
    }

    public chiTietSanPham Findbyid(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(chiTietSanPham.class,id);
    }

    public chiTietSanPham Add(chiTietSanPham chiTietSanPham){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(chiTietSanPham);
            session.getTransaction().commit();
            return chiTietSanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public chiTietSanPham Update(chiTietSanPham chiTietSanPham){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(chiTietSanPham);
            session.getTransaction().commit();
            return chiTietSanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public chiTietSanPham Delete(int id){
        chiTietSanPham chiTietSanPham = Findbyid(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.remove(chiTietSanPham);
            session.getTransaction().commit();
            return chiTietSanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
