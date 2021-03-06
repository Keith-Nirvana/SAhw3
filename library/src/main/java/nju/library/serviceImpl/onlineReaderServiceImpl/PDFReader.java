package nju.library.serviceImpl.onlineReaderServiceImpl;

import nju.library.service.OnlineReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFReader extends OnlineReader {
    private String path = System.getProperty("user.dir");
    @Override
    public String read(String bookName) {
        // 根据文件名转换成多张图片，返回图片的html表示
        int pageNumber = convertToPng(bookName);

        String html = "<body>";

        for (int i = 0; i < pageNumber; i++){
            html = html + "<div>\n" +
                    "    <img src=\""+ "./../static/bookImages/" + bookName + i + ".png" +"\" style=\"width:100%;" +
                    "height:auto\" />\n </div>";
        }

        return html + "</body>";
    }

    private int convertToPng(String bookName) {
        PDDocument doc = null;
        int pageNumber = 0;
        try {
            doc = PDDocument.load(new File(path + "/src/main/resources/books/" +
                    bookName + ".pdf"));

            pageNumber = doc.getNumberOfPages();
            PDFRenderer renderer = new PDFRenderer(doc);

            for (int i = 0; i < pageNumber; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 296);
                ImageIO.write(image, "PNG", new File(path.substring(0, path.length()-8) +
                        "/library-information/static/bookImages/" + bookName + i + ".png"));
            }
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageNumber;
    }
}
