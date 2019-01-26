package nju.library.serviceImpl.onlineReaderServiceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class PDFReaderTest {

    @Test
    public void read() {
        System.out.println(new PDFReader().read("assignment"));
    }
}