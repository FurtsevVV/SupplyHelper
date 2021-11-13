package com.zakat.myapp.dao;

import com.zakat.myapp.entity.BaseOfSupply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BaseOfSupplyDAO implements BaseOfSupplyInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<BaseOfSupply> getAllBaseOfSupply() {
        Session session = sessionFactory.getCurrentSession();
        List<BaseOfSupply> baseOfSupplyList;
        baseOfSupplyList = session.createQuery("from BaseOfSupply", BaseOfSupply.class).getResultList();
        return baseOfSupplyList;
    }

    @Override
    public void saveBaseOfSupply(BaseOfSupply baseOfSupply) {
        Session session = sessionFactory.getCurrentSession();
        {
            session.saveOrUpdate(baseOfSupply);
        }

    }

    @Override
    public BaseOfSupply getBase(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BaseOfSupply.class, id);
    }

    @Override
    public void deleteBase(int id) {
        Session session = sessionFactory.getCurrentSession();
        BaseOfSupply baseOfSupply = session.get(BaseOfSupply.class, id);
        session.delete(baseOfSupply);
    }

    @Override
    public int getBaseIdByName(String baseName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select B.id from BaseOfSupply B where B.nameOfObject = :baseName");
        query.setParameter("baseName", baseName);
        return (int) query.getSingleResult();
    }

    @Override
    public String getBaseNameById(int baseId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select B.nameOfObject from BaseOfSupply B where B.id = :baseId");
        query.setParameter("baseId", baseId);
        return (String) query.getSingleResult();
    }
}

