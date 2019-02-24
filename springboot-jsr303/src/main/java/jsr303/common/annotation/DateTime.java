package jsr303.common.annotation;

import javafx.print.PageLayout;
import jsr303.controller.DateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by sunlele
 * Date 2019/2/24 22:00
 * Description 自定义注解
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {
    String message() default  "格式错误";

    String format() default "yyyy-MM-dd";

    Class<?>[] groups() default  {} ;

    Class<? extends Payload>[] payload() default  {};
}
