package com.zakat.myapp.entity.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckBaseOfSupplyValidator.class)
public @interface CheckBaseOfSupply {
    public String value() default "KRU3";

    public String message() default "No this Base of Supply in database";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
