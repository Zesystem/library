package com.mbyte.easy.printPdf.controller;

import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.book.service.IBookService;
import com.mbyte.easy.printPdf.common.ViewPDF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PrintPdfController
 * @Description 打印controller
 * @Author 戴书博
 * @Date 2019/11/19 22:52
 * @Version 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/printController")
public class PrintPdfController {

    @Autowired
    private IBookService bookService;

    /**
     * @Method printBookPdf
     * @Author 戴书博
     * @Description 打印controller
     * @param booId
     * @Return org.springframework.web.servlet.ModelAndView
     * @Date 2019/11/20 0:06
     * @Version  1.0
     */
    @RequestMapping("printBookPdf")
    public ModelAndView printBookPdf(Long bookId){
        log.info("进入printBookPdf");
        //根据id,查询出图书
        Book book = bookService.selectDetail(bookId);
        Map<String, Object> model = new HashMap<>();
        model.put("book", book);
        return new ModelAndView(new ViewPDF(), model);
    }
}
