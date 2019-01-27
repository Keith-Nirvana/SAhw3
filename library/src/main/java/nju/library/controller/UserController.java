package nju.library.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @ResponseBody
    @RequestMapping(value = "/allUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllUser(){


        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
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
