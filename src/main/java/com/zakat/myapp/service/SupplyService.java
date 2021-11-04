package com.zakat.myapp.service;

import com.zakat.myapp.dao.SupplyDAO;
import com.zakat.myapp.entity.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplyService implements SupplyServiceInterface {

    @Autowired
    private SupplyDAO supplyDAO;

    @Override
    @Transactional
    public List<Supply> getAllSupply() {
        return supplyDAO.getAllSupply();
    }

    @Override
    @Transactional
    public void saveSupply(Supply supply) {
        supplyDAO.saveSupply(supply);
    }


}
