package com.zakat.myapp.service;

import com.zakat.myapp.entity.Producer;

import java.util.List;

public interface ProducerServiceInterface {

    public List<Producer> getAllProducer();

   public void saveProducer(Producer producer);

   public Producer getProducer(int id);

   public void deleteProducer(int id);

}
