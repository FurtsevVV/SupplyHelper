package com.zakat.myapp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zakat.myapp.entity.Producer;
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
    public Map getMap(String producerName) {
        Session session = sessionFactory.getCurrentSession();
        List<Object[]> result = session.createSQLQuery("select id, name from producer").getResultList();
Map<Integer,String> map = new HashMap<>();
        for (Object[] obj: result) {
            Integer id = Integer.parseInt((String) obj[0]);
            String name = obj[1].toString();
            map.put(id, name);
        }
        return map;
    }
}
