package nju.library.controller;

import com.alibaba.fastjson.JSONObject;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/")
public class LoginController {
    @ResponseBody
    @RequestMapping(value = "user/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody JSONObject jsonParam){
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());
        String userId = jsonParam.getString("userId");
        String password = jsonParam.getString("password");

        User user = DaoFactory.getUserDao().getUserById(userId);
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("type", "OFFICE");
        result.put("permission", "23");
        result.put("isValid", true);

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
