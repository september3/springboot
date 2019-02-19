package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlele
 * Date 2019/2/19 21:56
 * Description
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value ="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello man";
    }
}
