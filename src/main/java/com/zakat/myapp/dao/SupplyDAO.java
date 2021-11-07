package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Supply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class SupplyDAO implements SupplyInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Supply> getAllSupply() {
        Session session = sessionFactory.getCurrentSession();
List<Supply> listOfSupply = session.createQuery("from Supply", Supply.class).getResultList();
        return listOfSupply;
    }

    @Override
    public void saveSupply(Supply supply) {
        Session session = sessionFactory.getCurrentSession();
session.saveOrUpdate(supply);
    }

    @Override
    public Supply getSupply(int id) {
        Session session = sessionFactory.getCurrentSession();
return session.get(Supply.class, id);
    }

    @Override
    public void deleteSupply(int id) {
        Session session = sessionFactory.getCurrentSession();
Supply supply = session.get(Supply.class, id);
session.delete(supply);
    }

    @Override
    public List<Supply> getSupplyByStatus(String statusValue) {
        Session session = sessionFactory.getCurrentSession();
Query query = session.createQuery("from Supply S where S.status = :statusValue");
query.setParameter("statusValue", statusValue);


        return (List<Supply>) query.getResultList();
    }


}
