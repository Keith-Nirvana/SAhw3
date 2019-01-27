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

        JSONObject result = new JSONObject();
        result.put("userList", jsonArray);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getUserById(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        System.out.println(userId);

        User user = userService.getUserById(userId);

        JSONObject result = new JSONObject();
        result.put("userId", user.getUserId());
        result.put("userName", user.getUserName());
        result.put("department", user.getDepartment());
        result.put("email", user.getEmail());
        result.put("type", user.getType());
        result.put("permission", user.getPermission());

        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createUser(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        String password = jsonParam.getString("password");
        String userName = jsonParam.getString("userName");
        String department = jsonParam.getString("department");
        String email = jsonParam.getString("email");
        String type = jsonParam.getString("type");

        boolean result = userService.createUser(userId, password, userName, department, email, type);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyUser(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        String userName = jsonParam.getString("userName");
        String department = jsonParam.getString("department");
        String email = jsonParam.getString("email");
        String type = jsonParam.getString("type");

        boolean result = userService.modifyUser(userId, userName, department, email, type);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/grant", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String grantPermission(@RequestBody JSONObject jsonParam){
        
        String userId = jsonParam.getString("userId");
        String permission = jsonParam.getString("perimission");

        // TODO
        boolean result = userService.grantPermission(userId, permission);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }
}
