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

    @Override
    public List<Supply> sortedListOfSupplyByStatusAndSum(String status, double sortedSum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Supply S where S.status=:status AND S.sum > :sortedSum", Supply.class);
        query.setParameter("status", status);
        query.setParameter("sortedSum", sortedSum);

        return (List<Supply>) query.getResultList();
    }

    @Override
    public List<Supply> sortedListOfSupplyByStatusSumBase(String status, double sortedSum, int baseId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE statussup = :status AND sum > :sortedSum and baseOfSupply_id = :baseId").addEntity(Supply.class);
        query.setParameter("status", status);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("baseId", baseId);
        return (List<Supply>) query.list();
    }

    @Override
    public List<Supply> sortedListOfSupplyByStatusSumProducer(String status, double sortedSum, int producerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE statussup = :status AND sum > :sortedSum and producer_id = :producerId").addEntity(Supply.class);
        query.setParameter("status", status);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("producerId", producerId);
        return (List<Supply>) query.list();

    }

    @Override
    public List<Supply> sortedListOfSupplyByStatusSumBaseProducer(String status, double sortedSum, int producerId, int baseId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE statussup = :status AND sum > :sortedSum and producer_id = :producerId and baseOfSupply_id = :baseId").addEntity(Supply.class);
        query.setParameter("status", status);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("producerId", producerId);
        query.setParameter("baseId", baseId);
        return (List<Supply>) query.list();

    }

    @Override
    public List<Supply> sortedListOfSupplyBySum(double sortedSum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Supply S where S.sum > :sortedSum", Supply.class);
        query.setParameter("sortedSum", sortedSum);

        return (List<Supply>) query.getResultList();
    }

    @Override
    public List<Supply> sortedListOfSupplyBySumBase(double sortedSum, int baseId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE baseOfSupply_id = :baseId and sum > :sortedSum ").addEntity(Supply.class);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("baseId", baseId);
        return (List<Supply>) query.list();
    }

    @Override
    public List<Supply> sortedListOfSupplyBySumProducer(double sortedSum, int producerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE producer_id = :producerId and sum > :sortedSum ").addEntity(Supply.class);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("producerId", producerId);
        return (List<Supply>) query.list();
    }

    @Override
    public List<Supply> sortedListOfSupplyBySumBaseProducer(double sortedSum, int producerId, int baseId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM Supply WHERE sum > :sortedSum and producer_id = :producerId and baseOfSupply_id = :baseId").addEntity(Supply.class);
        query.setParameter("sortedSum", sortedSum);
        query.setParameter("producerId", producerId);
        query.setParameter("baseId", baseId);
        return (List<Supply>) query.list();
    }


}
