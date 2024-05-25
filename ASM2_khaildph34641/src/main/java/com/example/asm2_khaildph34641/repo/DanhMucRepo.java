package com.example.asm2_khaildph34641.repo;


import com.example.asm2_khaildph34641.model.danhMuc;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import org.hibernate.Session;

import java.util.List;

public class DanhMucRepo {

    public List<danhMuc>  getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<danhMuc> listdanhmuc = (List<danhMuc>) session.createQuery("from danhMuc order by ngayTao desc ").list();
        return listdanhmuc;
    }

    public danhMuc FindbyId(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(danhMuc.class,id);
    }

    public danhMuc add(danhMuc danhMuc){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.save(danhMuc);
            session.getTransaction().commit();
            return danhMuc;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public danhMuc Delete(int id){
        danhMuc danhMuc1 = FindbyId(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.remove(danhMuc1);
            session.getTransaction().commit();
            return danhMuc1;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public danhMuc Update(danhMuc danhMuc){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.update(danhMuc);
            session.getTransaction().commit();
            return danhMuc;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

}
