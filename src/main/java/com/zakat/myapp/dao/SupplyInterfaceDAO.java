package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Supply;

import java.util.List;

public interface SupplyInterfaceDAO {

    public List<Supply> getAllSupply();

    public void saveSupply(Supply supply);


    public Supply getSupply(int id);

    public void deleteSupply(int id);

    public List<Supply> getSupplyByStatus(String statusValue);

    public List<Supply> sortedListOfSupplyByStatusAndSum(String status, double sortedSum);

    public List<Supply> sortedListOfSupplyByStatusSumBase(String status, double sortedSum, int baseId);

    public List<Supply> sortedListOfSupplyByStatusSumProducer(String status, double sortedSum, int producerId);

    public List<Supply> sortedListOfSupplyByStatusSumBaseProducer(String status, double sortedSum, int producerId, int baseId);

    public List<Supply> sortedListOfSupplyBySum(double sortedSum);

    public List<Supply> sortedListOfSupplyBySumBase(double sortedSum, int baseId);

    public List<Supply> sortedListOfSupplyBySumProducer(double sortedSum, int producerId);

    public List<Supply> sortedListOfSupplyBySumBaseProducer(double sortedSum, int producerId, int baseId);
}
