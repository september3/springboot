package swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;
import swagger.domain.User;

import java.util.*;

/**
 * @author sunlele
 * @className UserController
 * @date 2019/5/23 12:30
 **/
@RestController
@RequestMapping(value="/users")
public class UserController {


        private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());


        @ApiOperation(value="创建用户", notes="根据User对象创建用户")
        @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
        @RequestMapping(value="", method=RequestMethod.POST)
        public String postUser() {
            return "success";
        }

        @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
        @RequestMapping(value="/{id}", method=RequestMethod.GET)
        public User getUser(@PathVariable Long id) {
            return users.get(id);
        }



        @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
        @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
        public String deleteUser(@PathVariable Long id) {
            users.remove(id);
            return "success";
        }

    }

