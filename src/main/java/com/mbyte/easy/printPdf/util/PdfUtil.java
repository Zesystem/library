package com.mbyte.easy.printPdf.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mbyte.easy.book.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName PdfUtil
 * @Description
 * @Author 戴书博
 * @Date 2019/11/19 23:09
 * @Version 1.0
 **/
@Slf4j
public class PdfUtil {

    public static void createPDF(Document document, PdfWriter writer, Book book) throws IOException {
        log.info("进入createPDF");
        //Document document = new Document(PageSize.A4);
        try {
            document.addTitle("sheet of product");
            document.addAuthor("scurry");
            document.addSubject("product sheet.");
            document.addKeywords("product.");
            document.open();
            PdfPTable table = createTable(writer,book);
            document.add(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static PdfPTable createTable(PdfWriter writer,Book book) throws IOException, DocumentException {
        log.info("进入createTable");
        log.info("book => {}",book);

        PdfPTable table = new PdfPTable(2);//生成一个两列的表格
        PdfPCell cell;
        int size = 20;


//        Font font = new Font(BaseFont.createFont("C://Windows//Fonts//simfang.ttf", BaseFont.IDENTITY_H,
//                BaseFont.NOT_EMBEDDED));

        BaseFont baseFont = BaseFont.createFont(new ClassPathResource("/simfang.ttf").getPath(), BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        log.info("baseFont => {}",baseFont);
        Font font = new Font(baseFont);
        cell = new PdfPCell(new Phrase("编号：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getBookNumber()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("名称：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getName()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("出版社：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getPublishName()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("出版日期：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getPublishDate()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("存放位置：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getStorageName()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("剩余总量：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(book.getTotalNumber()+"",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        return table;
    }
}
