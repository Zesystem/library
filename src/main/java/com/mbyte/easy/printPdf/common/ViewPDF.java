package com.mbyte.easy.printPdf.common;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.printPdf.util.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName ViewPDF
 * @Description 配置pdf响应
 * @Author 戴书博
 * @Date 2019/11/19 22:56
 * @Version 1.0
 **/
@Slf4j
public class ViewPDF  extends AbstractPdfView {


    /**
     * 显示预览
     */
    private static final String HEAD_INFO_VIEW = "filename=";

    /**
     * 直接下载
     */
    private static final String HEAD_INFO_DOWOLOAD = "attachment;filename=";

    /**
     * @Method buildPdfDocument
     * @Author 戴书博
     * @Description
     * @Return void
     * @Date 2019/11/20 0:10
     * @Version  1.0
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("进入buildPdfDocument");

        String fileName = new Date().getTime()+"_quotation.pdf";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",HEAD_INFO_VIEW + new String(fileName.getBytes(), "iso8859-1"));

        Book book = (Book) model.get("book");
        log.info("getBook => {}",book);
        PdfUtil.createPDF(document, writer, book);
    }
}
