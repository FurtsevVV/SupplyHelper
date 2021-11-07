package com.zakat.myapp.entity.validation;

import com.zakat.myapp.entity.Producer;
import com.zakat.myapp.service.ProducerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckProducerValidator implements ConstraintValidator<CheckProducer, String> {

    @Autowired
    private ProducerServiceInterface producerService;

    private String gettingProducerName;

    @Override
    public void initialize(CheckProducer checkProducer) {
gettingProducerName=checkProducer.value();
    }

    @Override
    public boolean isValid(String enteredProducerName, ConstraintValidatorContext constraintValidatorContext) {

       List<Producer> listProducer =  producerService.getAllProducer();
       for(Producer producer: listProducer){
           if(enteredProducerName.equals(producer.getName()))
               return true;
       }
                return false;
    }
}
