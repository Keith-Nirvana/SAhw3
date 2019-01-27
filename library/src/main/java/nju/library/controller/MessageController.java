package nju.library.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nju.library.entity.Message;
import nju.library.service.MessageService;
import nju.library.serviceImpl.MessageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
    private MessageService messageService;

    public MessageController(){
        messageService = new MessageServiceImpl();
    }

    @ResponseBody
    @RequestMapping(value = "/getMessages", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getMessages(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        List<Message> messages = messageService.getUnReadMessageByUserId(userId);

        JSONArray jsonArray = new JSONArray();
        for (Message message: messages){
            JSONObject item = new JSONObject();

            item.put("messageId", message.getMessageId());
            item.put("message", message.getMessage());

            jsonArray.add(item);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageList", jsonArray);
        System.out.println(jsonObject.toJSONString());

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/readMessage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String readMessage(@RequestBody JSONObject jsonParam){
        String messageId = jsonParam.getString("messageId");
        String userId = jsonParam.getString("userId");

        boolean result = messageService.readMessage(messageId, userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }
}
