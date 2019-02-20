package swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import swagger.entity.User;

/**
 * Created by sunlele
 * Date 2019/2/20 22:13
 * Description
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @ApiOperation(value = "条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码"),})
    public User query(String username,String password){
        logger.info("多个参数用@ApiImplicitParams");
        return new User(1L,username,password);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "主键查询（DONE）")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号"),})
    public User get(@PathVariable Long id) {
        logger.info("单个参数用  @ApiImplicitParam");
        return new User(id, "u1", "p1");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户（DONE）")
    @ApiImplicitParam(name = "id", value = "用户编号")
    public void delete(@PathVariable Long id) {
        logger.info("单个参数用 ApiImplicitParam");
    }

    @PostMapping
    @ApiOperation(value = "添加用户（DONE）")
    public User post(@RequestBody User user) {
        logger.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）")
    public void put(@PathVariable Long id, @RequestBody User user) {
        logger.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
    }
}
