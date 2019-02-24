package jsr303.controller;

import jsr303.entity.Book;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Created by sunlele
 * Date 2019/2/24 21:26
 * Description
 */

@Validated
@RestController
public class ValidateController {

    @GetMapping("/test1")
    public String test1(@NotBlank(message = "name不能为空")
                        @Length(min = 2,max = 10,message = "name长度需在{min} - {max}之内") String name){
        return "success";
    }

    @GetMapping("/test2")
    public String test2(@Validated Book book){
       return "success";
    }
}
