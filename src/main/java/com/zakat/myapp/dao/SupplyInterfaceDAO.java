package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Supply;

import java.util.List;

public interface SupplyInterfaceDAO {

    public List<Supply> getAllSupply();

   public void saveSupply(Supply supply);


   public Supply getSupply(int id);

   public void deleteSupply(int id);

   public List<Supply> getSupplyByStatus(String statusValue);
}
