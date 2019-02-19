package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by sunlele
 * Date 2019/2/19 23:11
 * Description  Thymeleaf测试文件在不同位置时的访问
 */
@Controller
public class ThymeleafController {
    /**
     *   页面路径为/src/main/resources/templates
     * @return
     */
    @GetMapping("/test1")
    public String index(){
        return "index";
    }

    /**
     * 页面路径为/src/main/resources/templates/admin
     * @return
     */
    @GetMapping("/admin/test2")
    public String hello(){
        return "admin/hello";
    }
}
