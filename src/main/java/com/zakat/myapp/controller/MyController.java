package com.zakat.myapp.controller;

import com.zakat.myapp.dao.BaseOfSupplyInterfaceDAO;
import com.zakat.myapp.entity.BaseOfSupply;
import com.zakat.myapp.entity.Producer;
import com.zakat.myapp.entity.Supply;
import com.zakat.myapp.service.BaseOfSupplyServiceInterface;
import com.zakat.myapp.service.ProducerServiceInterface;
import com.zakat.myapp.service.SupplyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private BaseOfSupplyServiceInterface baseService;

    @Autowired
    private ProducerServiceInterface producerService;

    @Autowired
    private SupplyServiceInterface supplyService;

    @RequestMapping("/")
    public String showWelcomePage(Model model) {
        return "welcome-page";
    }

    //========+++======Supply==================
    @RequestMapping("/allsupply")
    public String showAllSupply(Model model) {
        List<Supply> supplyList = supplyService.getAllSupply();

        model.addAttribute("allSupply", supplyList);

        return "all-supply";
    }

    @RequestMapping("/newsupply")
    public String addNewSupply(Model model) {
        Supply supply = new Supply();

        model.addAttribute("supply", supply);
        return "new-supply";
    }




    @RequestMapping("/saveSupply")
    public String saveSupply(@Valid @ModelAttribute("supply") Supply supply, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new-supply";
        }
        supplyService.saveSupply(supply);
        return "redirect:/allsupply";
    }


    public void getProducerId(String producerName){
       int producerId =  producerService.getProducerid(producerName);
    }

    //==============Base Of Supply=============


    @RequestMapping("/allbase")
    public String showAllBaseOfSupply(Model model) {
        List<BaseOfSupply> baseOfSupplyList = baseService.getAllBaseOfSupply();
        model.addAttribute("allBaseOfSupply", baseOfSupplyList);
        return "all-base-of-supply";
    }


    @RequestMapping("/newbase")
    public String addNewBaseOfSupply(Model model) {
        BaseOfSupply baseOfSupply = new BaseOfSupply();
        model.addAttribute("baseOfSupply", baseOfSupply);
        return "new-base";
    }

    @RequestMapping("/saveBaseOfSupply")
    public String saveBaseOfSupply(@Valid @ModelAttribute("baseOfSupply") BaseOfSupply baseOfSupply, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-base";
        }
        baseService.saveBaseOfSupply(baseOfSupply);
        return "redirect:/allbase";
    }

    @RequestMapping("/updateBase")
    public String updateBase(@RequestParam("baseId") int id, Model model) {
        BaseOfSupply baseOfSupply = baseService.getBase(id);
        model.addAttribute("baseOfSupply", baseOfSupply);
        return "new-base";
    }

    @RequestMapping("/deleteBase")
    public String deleteBase(@RequestParam("baseId") int id) {
        baseService.deleteBase(id);
        return "redirect:/allbase";
    }

    //==============Producer=============

    @RequestMapping("/allProducer")
    public String showAllProducer(Model model) {

        List<Producer> producerList = producerService.getAllProducer();
        model.addAttribute("allProducer", producerList);
        return "all-producer";
    }

    @RequestMapping("/newProducer")
    public String addNewProducer(Model model) {
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        return "new-producer";
    }

    @RequestMapping("/saveProducer")
    public String saveProducer(@Valid @ModelAttribute("producer") Producer producer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-producer";
        }
        producerService.saveProducer(producer);
        return "redirect:/allProducer";
    }

    @RequestMapping("/updateProducer")
    public String updateProducer(@RequestParam("producerId") int id, Model model) {
        Producer producer = producerService.getProducer(id);
        model.addAttribute("producer", producer);
        return "new-producer";
    }

    @RequestMapping("/deleteProducer")
    public String deleteProducer(@RequestParam("producerId") int id) {
        producerService.deleteProducer(id);
        return "redirect:/allProducer";
    }

}
