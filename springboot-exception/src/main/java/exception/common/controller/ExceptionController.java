package exception.common.controller;

import exception.common.exceptions.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by sunlele
 * Date 2019/2/24 17:31
 * Description
 */
@RestController
public class ExceptionController {


    @GetMapping("/test3")
    public String test3(Integer num){
        if(num == null){
            throw new CustomException(400,"num不能为空");
        }
        int i = 10/num;
        return "result:" + i;
    }
}
