package nju.library;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        path = path.substring(0, path.length()-8);
        System.out.println(path);
//        Calendar cal=Calendar.getInstance();
//        cal.add(Calendar.MONTH, 0);
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        Date l = cal.getTime();
//        int betweenDays=
//                Integer.parseInt(String.valueOf((new Date().getTime() -l.getTime())/(1000*3600*24)));
//
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        System.out.println(betweenDays);
//        String file = System.getProperty("user.dir") + "/src/main/resources/books/" +
//                "assignment" + ".docx";
//        System.out.println(trans(file));
//        docxToHtml();
//PoiWord07ToHtml();
    }
    public static void PoiWord07ToHtml()throws IOException{

        String path= System.getProperty("user.dir") + "/src/main/resources/bookPictures";
        String file = System.getProperty("user.dir") + "/src/main/resources/books/" +
                "assignment" + ".docx";
        String file2 =System.getProperty("user.dir") + "/src/main/resources/bookHtmls/" + "assignment" +
                ".html";
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("Sorry File does not Exists!");
        } else {
            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {
                //读取文档内容
                InputStream in = new FileInputStream(f);
                XWPFDocument document = new XWPFDocument(in);

                File imageFolderFile = new File(path);
                //加载html页面时图片路径
                XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("./"));
                //图片保存文件夹路径
                options.setExtractor(new FileImageExtractor(imageFolderFile));
                OutputStream out = new FileOutputStream(new File(file2));
                XHTMLConverter.getInstance().convert(document, out, options);
                out.close();
            } else {
                System.out.println("Enter only MS Office 2007+ files");
            }
        }

    }

    public static String docxToHtml() throws Exception {
        String sourceFileName = System.getProperty("user.dir") + "/src/main/resources/books/" +
                "assignment" + ".docx";
        String imagePath = System.getProperty("user.dir") + "/src/main/resources/bookPictures";
//        String sourceFileName = path.getAbsolutePath() + "\\static\\test.docx";
        String targetFileName = System.getProperty("user.dir") + "/src/main/resources/bookHtmls/" + "assignment" +
                ".html";
//
        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePath)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver("image"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            System.out.println(xhtmlConverter);
            System.out.println(document);
            System.out.println(outputStreamWriter);
            System.out.println(options);
            xhtmlConverter.convert(document, outputStreamWriter, options);
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
        return targetFileName;
    }

    // 只有这个能用
    public static String trans(String path){
        String s = "";
        try {
            if(path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                s = ex.getText();
            }else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                s = extractor.getText();
            }else {
                System.out.println("传入的word文件不正确:"+path);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer bf = new StringBuffer(s);
        return bf.toString();
    }
}
