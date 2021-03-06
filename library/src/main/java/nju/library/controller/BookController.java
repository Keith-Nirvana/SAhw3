package nju.library.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nju.library.entity.Book;
import nju.library.factory.OnlineReadFactory;
import nju.library.service.BookService;
import nju.library.service.OnlineReader;
import nju.library.serviceImpl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    private BookService bookService;

    public BookController(){
        bookService = new BookServiceImpl();
    }

    @ResponseBody
    @RequestMapping(value = "/allBooks", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAllBooks(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        List<Book> books = bookService.getAllBooks(userId);

        JSONObject result = new JSONObject();
        result.put("bookList", packBooks(books));
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/borrowedBooks", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getBorrowedBooks(@RequestBody JSONObject jsonParam){
        String userId = jsonParam.getString("userId");
        List<Book> books = bookService.getBorrowedBooks(userId);

        JSONObject result = new JSONObject();
        result.put("bookList", packBooks(books));
        return result.toJSONString();
    }

    private JSONArray packBooks(List<Book> books){
        JSONArray jsonArray = new JSONArray();

        for (Book book: books){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("bookId", book.getBookId());
            jsonObject.put("bookName", book.getBookName());
            jsonObject.put("category", book.getCategory());
            jsonObject.put("format", book.getFormat());
            jsonObject.put("isBorrowed", book.isBorrowed());

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value = "/borrowBook", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String borrowBook(@RequestBody JSONObject jsonParam){
        String bookId = jsonParam.getString("bookId");
        String userId = jsonParam.getString("userId");

        boolean result = bookService.borrowBook(bookId, userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String returnBook(@RequestBody JSONObject jsonParam){
        String bookId = jsonParam.getString("bookId");
        String userId = jsonParam.getString("userId");

        boolean result = bookService.returnBook(bookId, userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/modifyBook", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyBook(@RequestBody JSONObject jsonParam){
        String bookId = jsonParam.getString("bookId");
        String bookName = jsonParam.getString("bookName");
        String category = jsonParam.getString("category");

        boolean result = bookService.modifyBookInfo(bookId, bookName, Integer.parseInt(category));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", result);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/readBook", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String readBook(@RequestBody JSONObject jsonParam) throws ParserConfigurationException, TransformerException, IOException {
        String bookId = jsonParam.getString("bookId");
        String bookName = jsonParam.getString("bookName");

        Book book = bookService.getBookById(bookId);

        OnlineReader onlineReader = OnlineReadFactory.getOnlineReader(book.getFormat());

        String html = onlineReader.read(bookName);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("html", html);

        return jsonObject.toJSONString();
    }
}
