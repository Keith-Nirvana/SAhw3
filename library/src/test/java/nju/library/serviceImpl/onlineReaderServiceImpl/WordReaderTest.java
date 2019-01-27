package nju.library.serviceImpl.onlineReaderServiceImpl;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.Assert.*;

public class WordReaderTest {

    @Test

    public void read() throws ParserConfigurationException, TransformerException, IOException {
        System.out.println(new WordReader().read("assignment"));

    }
}