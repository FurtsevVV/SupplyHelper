package com.zakat.myapp.entity.validation;

import com.zakat.myapp.entity.BaseOfSupply;
import com.zakat.myapp.service.BaseOfSupplyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckBaseOfSupplySortValidator implements ConstraintValidator<CheckBaseOfSupplySort, String> {
    @Autowired
    BaseOfSupplyServiceInterface baseService;

    private String gettingBaseOfSupplyName;

    @Override
    public void initialize(CheckBaseOfSupplySort checkBase) {
        gettingBaseOfSupplyName = checkBase.value();
    }

    @Override
    public boolean isValid(String enteredBaseName, ConstraintValidatorContext constraintValidatorContext) {
        if (enteredBaseName.equals(""))
            return true;
        List<BaseOfSupply> baseList = baseService.getAllBaseOfSupply();
        for (BaseOfSupply base : baseList) {
            if (enteredBaseName.equals(base.getNameOfObject()))
                return true;
        }

        return false;
    }
}
