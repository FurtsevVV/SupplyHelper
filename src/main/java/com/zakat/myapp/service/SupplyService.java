package com.zakat.myapp.service;

import com.zakat.myapp.dao.BaseOfSupplyDAO;
import com.zakat.myapp.dao.ProducerDAO;
import com.zakat.myapp.dao.SupplyDAO;
import com.zakat.myapp.entity.BaseOfSupply;
import com.zakat.myapp.entity.Producer;
import com.zakat.myapp.entity.Supply;
import com.zakat.myapp.entity.TempSupply;
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

    @Autowired
    private ProducerDAO producerDAO;

    @Autowired
    private BaseOfSupplyDAO baseOfSupplyDAO;

    @Override
    @Transactional
    public List<Supply> getAllSupply() {
        return supplyDAO.getAllSupply();
    }

    @Override
    @Transactional
    public void saveSupply(TempSupply tempSupply) {
Supply newSupply = new Supply();
        String producerName = tempSupply.getProducerString();
        int producerId = producerDAO.getProducerIdByName(producerName);
        String baseName = tempSupply.getBaseString();
        int baseId = baseOfSupplyDAO.getBaseIdByName(baseName);
        BaseOfSupply bos = baseOfSupplyDAO.getBase(baseId);
        Producer prod = producerDAO.getProducer(producerId);

        newSupply.setId(tempSupply.getId());
newSupply.setMaterial(tempSupply.getMaterial());
newSupply.setPrice(tempSupply.getPrice());
newSupply.setQuantity(tempSupply.getQuantity());
newSupply.setSum(tempSupply.getSum());
newSupply.setDate(tempSupply.getDate());
newSupply.setStatus(tempSupply.getStatus());
newSupply.setCommentary(tempSupply.getCommentary());
newSupply.setBaseOfSupply(bos);
newSupply.setProducer(prod);

supplyDAO.saveSupply(newSupply);
    }

    @Override
    @Transactional
    public TempSupply getTempSupply(int id) {
        Supply supply = supplyDAO.getSupply(id);
        int producerId = supply.getProducer().getId();
        String producerName = producerDAO.getProducerNameById(producerId);
int baseId = supply.getBaseOfSupply().getId();
String baseName = baseOfSupplyDAO.getBaseNameById(baseId);

        TempSupply tempSupply = new TempSupply();
        tempSupply.setId(supply.getId());
        tempSupply.setMaterial(supply.getMaterial());
        tempSupply.setPrice(supply.getPrice());
        tempSupply.setQuantity(supply.getQuantity());
        tempSupply.setSum(supply.getSum());
        tempSupply.setDate(supply.getDate());
        tempSupply.setStatus(supply.getStatus());
        tempSupply.setCommentary(supply.getCommentary());
        tempSupply.setBaseString(baseName);
        tempSupply.setProducerString(producerName);

        return tempSupply;
    }

    @Override
    @Transactional
    public void deleteSupply(int id) {
        supplyDAO.deleteSupply(id);
    }

    @Override
    @Transactional
    public List<Supply> getSupplyByStatus(String statusValue) {
       return supplyDAO.getSupplyByStatus(statusValue);

    }


}
