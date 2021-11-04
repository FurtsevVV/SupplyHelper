package com.zakat.myapp.service;

import com.zakat.myapp.dao.BaseOfSupplyDAO;
import com.zakat.myapp.dao.BaseOfSupplyInterfaceDAO;
import com.zakat.myapp.entity.BaseOfSupply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseOfSupplyService implements BaseOfSupplyServiceInterface {

    @Autowired
    private BaseOfSupplyDAO baseOfSupplyDAO;

    @Override
    @Transactional
    public List<BaseOfSupply> getAllBaseOfSupply() {
        return baseOfSupplyDAO.getAllBaseOfSupply();

    }

    @Override
    @Transactional
    public void saveBaseOfSupply(BaseOfSupply baseOfSupply) {
        baseOfSupplyDAO.saveBaseOfSupply(baseOfSupply);
    }

    @Override
    @Transactional
    public BaseOfSupply getBase(int id) {
        return baseOfSupplyDAO.getBase(id);
    }

    @Override
    @Transactional
    public void deleteBase(int id) {
        baseOfSupplyDAO.deleteBase(id);
    }


}
