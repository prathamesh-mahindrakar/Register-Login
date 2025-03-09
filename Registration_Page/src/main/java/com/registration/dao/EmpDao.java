package com.registration.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.registration.entities.Emp;

public class EmpDao {

    private SessionFactory factory;

    public EmpDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveEmp(Emp emp) {
        boolean f = false;
        Transaction tx = null;
        try (Session s = factory.openSession()) {
            tx = s.beginTransaction();
            s.save(emp);
            tx.commit();
            f = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return f;
    }
}
