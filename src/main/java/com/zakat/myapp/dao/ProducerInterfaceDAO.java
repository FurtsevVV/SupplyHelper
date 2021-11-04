package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Producer;

import java.util.List;
import java.util.Map;

public interface ProducerInterfaceDAO {

    public List<Producer> getAllProducer();

  public   void saveProducer(Producer producer);

   public Producer getProducer(int id);

   public void deleteProducer(int id);

  public Map getMap(String producerName);
}
