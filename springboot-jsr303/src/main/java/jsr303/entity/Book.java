package jsr303.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by sunlele
 * Date 2019/2/24 21:12
 * Description    普通参数属性验证
 */
@Data
public class Book {

    private Integer id;

    @NotBlank(message = "name不允许为空")
    @Length(min=2,max = 10,message = "name长度必须在{min} - {max}之间")
    private String name;

    @NotNull(message = "price不允许为空")
    @DecimalMin(value = "0.1",message = "价格不能低于{value}")
    private BigDecimal price;


}
