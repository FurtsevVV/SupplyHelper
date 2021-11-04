package com.zakat.myapp.dao;

import com.zakat.myapp.entity.BaseOfSupply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
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
        BaseOfSupply baseOfSupply = session.get(BaseOfSupply.class, id);
        return baseOfSupply;
    }

    @Override
    public void deleteBase(int id) {
        Session session = sessionFactory.getCurrentSession();
        BaseOfSupply baseOfSupply = session.get(BaseOfSupply.class, id);
        session.delete(baseOfSupply);
    }
}
