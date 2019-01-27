package nju.library.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nju.library.dao.RecordDao;
import nju.library.daoImpl.RecordDaoImpl;
import nju.library.entity.Record;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.StatisticService;
import nju.library.serviceImpl.StatisticServiceImpl;
import nju.library.util.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/statistic")
public class StatisticController {
    private StatisticService statisticService;

    public StatisticController() {
        statisticService = new StatisticServiceImpl();
    }

    @ResponseBody
    @RequestMapping(value = "/getBorrowedRecords", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getBorrowedRecords(){
        List<Record> records = statisticService.getAllRecord();
        JSONArray jsonArray = new JSONArray();

        for (Record record: records){
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("recordId", record.getRecordId());
            jsonObject.put("bookId", record.getBookId());
            jsonObject.put("readerId", record.getReaderId());
            jsonObject.put("borrowDate", DateFormatHandler(record.getBorrowDate()));
            if (record.getReturnDate() != null)
                jsonObject.put("returnDate", DateFormatHandler(record.getReturnDate()));
            else
                jsonObject.put("returnDate", "");

            jsonArray.add(jsonObject);
        }

        JSONObject result = new JSONObject();
        result.put("recordList", jsonArray);
        return result.toJSONString();
    }

    /**
     * 加入了一个返回值maxborroweddays，如果对组件影响较大就不要展示了
     */
    @ResponseBody
    @RequestMapping(value = "/getPenaltyRecords", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getOverduePenaltyRecords(){
        List<Record> records = statisticService.getOverduePenaltyRecords();
        JSONObject result = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        for (Record record: records){
            JSONObject item = new JSONObject();
            User user = DaoFactory.getUserDao().getUserById(record.getReaderId());

            item.put("recordId", record.getRecordId());
            item.put("bookId", record.getBookId());
            item.put("readerId", record.getReaderId());
            item.put("borrowDate", DateFormatHandler(record.getBorrowDate()));
            if (record.getReturnDate() != null)
                item.put("returnDate", DateFormatHandler(record.getReturnDate()));
            else
                item.put("returnDate", "");
            item.put("payment", record.getPayment());
            item.put("maxDays", UserType.getMaxBorrowDay(user.getType()));

            jsonArray.add(item);
        }

        result.put("penaltyList", jsonArray);
        return result.toJSONString();
    }

    private String DateFormatHandler(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
