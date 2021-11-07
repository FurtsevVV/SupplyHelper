package com.zakat.myapp.service;

import com.zakat.myapp.dao.ProducerDAO;
import com.zakat.myapp.entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProducerService implements ProducerServiceInterface {

    @Autowired
    private ProducerDAO producerDAO;


    @Override
    @Transactional
    public List<Producer> getAllProducer() {
        List<Producer> producerList = producerDAO.getAllProducer();
        return producerList;
    }

    @Override
    @Transactional
    public void saveProducer(Producer producer) {
        producerDAO.saveProducer(producer);
    }

    @Override
    @Transactional
    public Producer getProducer(int id) {
       return producerDAO.getProducer(id);
    }

    @Override
    @Transactional
    public void deleteProducer(int id) {
        producerDAO.deleteProducer(id);
    }


}
