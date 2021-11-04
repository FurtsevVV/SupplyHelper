package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Supply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
