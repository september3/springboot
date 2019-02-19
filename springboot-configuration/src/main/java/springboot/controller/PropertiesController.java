package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.properties.MyProperties1;

/**
 * Created by sunlele
 * Date 2019/2/19 22:29
 * Description 简单配置测试
 */
@RestController
@RequestMapping("/properties")
public class PropertiesController {

    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties1 myProperties1;

    /**
     * Spring4.x 以后，推荐使用构造函数的形式注入属性
     * @param myProperties1
     */
    @Autowired
    public PropertiesController(MyProperties1 myProperties1) {
        this.myProperties1 = myProperties1;
    }

    @GetMapping("/1")
    public MyProperties1 myProperties1() {
        log.info("=================================================================================================");
        log.info(myProperties1.toString());
        log.info("=================================================================================================");
        return myProperties1;
    }
}
