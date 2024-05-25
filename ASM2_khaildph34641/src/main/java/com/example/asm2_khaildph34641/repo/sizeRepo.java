package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.size;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import org.hibernate.Session;

import java.util.List;

public class sizeRepo {

    public List<size> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<size> listsize = session.createQuery("from size order by ngayTao desc ").list();
        return listsize;
    }

    public List<size> Findbyid(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<size> listsize = session.createQuery("from size where trangThai =:tt").setParameter("tt","Active").list();
        return listsize;
    }

    public size Add(size size){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(size);
            session.getTransaction().commit();
            return size;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public size Edit(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(size.class,id);
    }

    public size Delete(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        size size = Edit(id);
        try {
            session.beginTransaction();
            session.remove(size);
            session.getTransaction().commit();
            return size;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public size Update(size size){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(size);
            session.getTransaction().commit();
            return size;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
