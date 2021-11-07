package com.zakat.myapp.service;

import com.zakat.myapp.entity.Supply;
import com.zakat.myapp.entity.TempSupply;

import java.util.List;

public interface SupplyServiceInterface {

    public List<Supply> getAllSupply();

   public void saveSupply(TempSupply tempSupply);


   public TempSupply getTempSupply(int id);

   public void deleteSupply(int id);

  public   List<Supply> getSupplyByStatus(String statusValue);
}
