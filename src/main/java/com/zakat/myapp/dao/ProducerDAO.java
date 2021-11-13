package com.zakat.myapp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zakat.myapp.entity.Producer;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProducerDAO implements ProducerInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Producer> getAllProducer() {
        Session session = sessionFactory.getCurrentSession();
        List<Producer> listOfProducer = session.createQuery("from Producer", Producer.class).getResultList();
        return listOfProducer;
    }

    @Override
    public void saveProducer(Producer producer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(producer);
    }

    @Override
    public Producer getProducer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Producer.class, id);
    }

    @Override
    public void deleteProducer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Producer producer = session.get(Producer.class, id);
        session.delete(producer);
    }


    @Override
    public int getProducerIdByName(String producerName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select P.id from Producer P where P.name = :producerName");
        query.setParameter("producerName", producerName);
        return (int) query.getSingleResult();
    }

    @Override
    public String getProducerNameById(int producerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select P.name from Producer P where P.id = :producerId");
        query.setParameter("producerId", producerId);
        return (String) query.getSingleResult();
    }
}
