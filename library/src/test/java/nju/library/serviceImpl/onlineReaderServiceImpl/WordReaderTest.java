package nju.library.serviceImpl.onlineReaderServiceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordReaderTest {

    @Test
    public void read() {
        System.out.println(new WordReader().read("assignment"));
    }
}