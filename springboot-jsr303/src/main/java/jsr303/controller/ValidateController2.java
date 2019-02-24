package jsr303.controller;

import jsr303.common.annotation.DateTime;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunlele
 * Date 2019/2/24 22:19
 * Description
 */
@Validated
@RestController
public class ValidateController2 {
    @GetMapping("/test3")
    public String test(@DateTime(message = "您输入的格式错误，正确的格式为：{format}",
            format = "yyyy-MM-dd HH:mm") String date){
       return "success";
    }
}
