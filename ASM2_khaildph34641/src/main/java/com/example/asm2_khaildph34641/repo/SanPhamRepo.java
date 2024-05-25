package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.sanPham;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepo {

    public List<sanPham> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<sanPham> listsanpham = (List<sanPham>) session.createQuery("from sanPham order by ngayTao desc ").list();
        return listsanpham;
    }

    public sanPham Add(sanPham sanPham){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.save(sanPham);
            session.getTransaction().commit();
            return sanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public sanPham FindbyId(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(sanPham.class,id);
    }

    public sanPham Delete(int id){
        sanPham sanPham = FindbyId(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.remove(sanPham);
            session.getTransaction().commit();
            return sanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public sanPham Update(sanPham sanPham){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.update(sanPham);
            session.getTransaction().commit();
            return sanPham;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

}
