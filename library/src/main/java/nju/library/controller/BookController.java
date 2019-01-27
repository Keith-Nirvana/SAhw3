package nju.library.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @ResponseBody
    @RequestMapping(value = "/allBooks", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAllBooks(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        System.out.println(userId);

        // TODO

        JSONObject result = new JSONObject();

        return result.toJSONString();
    }
}