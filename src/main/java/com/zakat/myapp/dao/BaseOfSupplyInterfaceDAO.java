package com.zakat.myapp.dao;

import com.zakat.myapp.entity.BaseOfSupply;

import java.util.List;

public interface BaseOfSupplyInterfaceDAO {
    public List<BaseOfSupply> getAllBaseOfSupply();

    public void saveBaseOfSupply(BaseOfSupply baseOfSupply);

    public BaseOfSupply getBase(int id);

    public void deleteBase(int id);
}
