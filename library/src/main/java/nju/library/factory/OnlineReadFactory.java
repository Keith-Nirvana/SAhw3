package nju.library.factory;

import nju.library.service.OnlineReader;
import nju.library.serviceImpl.onlineReaderServiceImpl.PDFReader;
import nju.library.serviceImpl.onlineReaderServiceImpl.WordReader;
import nju.library.util.BookFormat;

public class OnlineReadFactory {
    public static OnlineReader getOnlineReader(String bookFormat){
        if(bookFormat.equals(BookFormat.DOCX))
            return new WordReader();
        else
            return new PDFReader();
    }
}
