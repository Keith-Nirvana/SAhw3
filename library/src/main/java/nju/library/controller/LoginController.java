package nju.library.controller;

import com.alibaba.fastjson.JSONObject;
import nju.library.dao.UserDao;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.UserService;
import nju.library.serviceImpl.UserServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/")
public class LoginController {

    private UserService userService;

    public LoginController(){
        userService = new UserServiceImpl();
    }

    @ResponseBody
    @RequestMapping(value = "user/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody JSONObject jsonParam){
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());
        String userId = jsonParam.getString("userId");
        String password = jsonParam.getString("password");

        User user = DaoFactory.getUserDao().getUserById(userId);
        // 考虑到可能user都拿不到
        boolean validFlag = false;
        System.out.println(user == null);
        if (user != null)
            if (userService.isValidUser(userId, password))
                validFlag = true;

        JSONObject result = new JSONObject();
        if (validFlag) {
            result.put("type", user.getType());
            result.put("permission", user.getPermission());
            result.put("isValid", validFlag);
        }
        else {
            result.put("type", "");
            result.put("permission", "");
            result.put("isValid", validFlag);
        }
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "user/login2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String login2(){
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
//        result.put("data", jsonParam);

        return result.toJSONString();
    }
}
