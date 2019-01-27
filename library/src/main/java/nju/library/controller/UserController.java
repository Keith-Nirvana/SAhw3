package nju.library.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nju.library.entity.User;
import nju.library.service.UserService;
import nju.library.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    public UserController() {userService = new UserServiceImpl();}

    @ResponseBody
    @RequestMapping(value = "/allUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllUser(){
        // TODO
        JSONArray jsonArray = new JSONArray();

        List<User> users = userService.getAllUsers();
        for (User user: users){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", user.getUserId());
            jsonObject.put("userName", user.getUserName());
            jsonObject.put("department", user.getDepartment());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("type", user.getType());
            jsonObject.put("permission", user.getPermission());

            jsonArray.add(jsonObject);
        }
//        return result.toJSONString();
        return jsonArray.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getUserById(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        System.out.println(userId);

        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createUser(@RequestBody JSONObject jsonParam){
//        String userId = jsonParam.getString("userId");
//        System.out.println(userId);

        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyUser(@RequestBody JSONObject jsonParam){
//        String userId = jsonParam.getString("userId");
//        System.out.println(userId);

        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/grant", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String grantPermission(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        System.out.println(userId);

        String permission = jsonParam.getString("perimission");
        System.out.println(permission);

        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
    }
}
