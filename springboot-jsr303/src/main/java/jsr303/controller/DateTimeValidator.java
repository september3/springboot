package jsr303.controller;

import jsr303.common.annotation.DateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by sunlele
 * Date 2019/2/24 22:07
 * Description日期格式验证类
 */
public class DateTimeValidator implements ConstraintValidator<DateTime,String> {

    private DateTime dateTime;



    /**
     * initialize： 主要用于初始化，它可以获得当前注解的所有属性
     * @param dateTime
     */
    @Override
    public void initialize(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 进行约束验证的主体方法，其中 value 就是验证参数的具体实例，context 代表约束执行的上下文环境。
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid( String value, ConstraintValidatorContext context) {
        //// 如果 value 为空则不进行格式验证，为空验证可以使用 @NotBlank @NotNull @NotEmpty 等注解来进行控制，职责分离
       if(value == null){
           return true;
       }
       String format = dateTime.format();
       if(value.length() != format.length() ){
           return false;
       }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            simpleDateFormat.parse(value);
        } catch (ParseException e) {
          return false;
        }
        return true;
    }
}
