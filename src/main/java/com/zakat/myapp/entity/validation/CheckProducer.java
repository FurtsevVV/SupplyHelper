package com.zakat.myapp.entity.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckProducerValidator.class)
public @interface CheckProducer {
    public String value() default "RIA1";
    public String message() default "No this producer in database";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
