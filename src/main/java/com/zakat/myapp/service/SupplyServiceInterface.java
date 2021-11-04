package com.zakat.myapp.service;

import com.zakat.myapp.entity.Supply;

import java.util.List;

public interface SupplyServiceInterface {

    public List<Supply> getAllSupply();

   public void saveSupply(Supply supply);


}
