package com.example.asm2_khaildph34641.repo;

import com.example.asm2_khaildph34641.model.mauSac;
import com.example.asm2_khaildph34641.utils.Hibernateutlis;
import org.hibernate.Session;

import java.util.List;

public class mauSacRepo {

    public List<mauSac> getAll(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<mauSac> listmausac = session.createQuery("from mauSac order by ngayTao desc").list();
        return listmausac;
    }

    public List<mauSac> Findbyid(){
        Session session = Hibernateutlis.getFACTORY().openSession();
        List<mauSac> listmausac = session.createQuery("from mauSac where trangThai = :tt").setParameter("tt","Active").list();
        return listmausac;
    }

    public mauSac Add(mauSac mauSac){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.save(mauSac);
            session.getTransaction().commit();
            return mauSac;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public mauSac Edit(int id){
        Session session = Hibernateutlis.getFACTORY().openSession();
        return session.find(mauSac.class,id);
    }



    public mauSac Delete(int id){
        mauSac mauSac1 = Edit(id);
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.remove(mauSac1);
            session.getTransaction().commit();
            return mauSac1;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public mauSac Update(mauSac mauSac){
        Session session = Hibernateutlis.getFACTORY().openSession();
        try {
            session.beginTransaction();
            session.update(mauSac);
            session.getTransaction().commit();
            return mauSac;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException();
        }
    }


}
