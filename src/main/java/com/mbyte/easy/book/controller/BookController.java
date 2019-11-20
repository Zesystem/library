package com.mbyte.easy.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.book.service.IBookService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.publish.entity.Publish;
import com.mbyte.easy.util.PageInfo;
import com.mbyte.easy.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * @Author                   戴书博
 * @Description              图书controller
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Slf4j
@Controller
@RequestMapping("/book/book")
public class BookController extends BaseController  {

    private String prefix = "book/book/";

    @Autowired
    private IBookService bookService;


    @RequestMapping("test")
    public String test(){
        return "index";
    }

   /**
    * @Method                   index
    * @Author                   戴书博
    * @Description              显示后台
    * @param model              model
    * @param pageNo             当前页
    * @param pageSize           每页的页数
    * @param publishDateSpace   出版时间
    * @param book               book类
    * @Return                   java.lang.String
    * @Date                     2019/11/11 20:55
    * @Version                  1.0
    */
    @RequestMapping
    public String index(Model model,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                        @ModelAttribute("publishDateSpace")String publishDateSpace,
                        Book book) {
        Page<Book> page = new Page<>(pageNo, pageSize);

            if (!ObjectUtils.isEmpty(publishDateSpace)){
                try {
                    LocalDateTime[] localDateTimes = DateUtil.stringToLocals(publishDateSpace);
                    book.setBeginTime(localDateTimes[0]);
                    book.setEndTime(localDateTimes[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        IPage<Book> pageInfo = bookService.listPage(page,book);
        model.addAttribute("publishDateSpace", publishDateSpace);
        model.addAttribute("searchInfo", book);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"list";
    }

    /**
     * @Method          addBefore
     * @Author          戴书博
     * @Description     跳转添加页面
     * @Return          java.lang.String
     * @Date            2019/11/11 20:57
     * @Version         1.0
     */
    @GetMapping("addBefore")
    public String addBefore(Model model){
        List<Publish> publishList = bookService.selectAllPublish();
        List<Location> locationList = bookService.selectAllLocation();
        log.info("publishList => {}",publishList);
        log.info("locationList => {}",locationList);
        model.addAttribute("locationList",locationList);
        model.addAttribute("publishList",publishList);
        return prefix+"add";
    }

    /**
     * @Method          add
     * @Author          戴书博
     * @Description     添加图书信息
     * @param book      图书类
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 20:57
     * @Version         1.0
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Book book){
        return toAjax(bookService.insertBook(book));
    }

    /**
     * @Method          editBefore
     * @Author          戴书博
     * @Description     编辑跳转页面
     * @param model     model
     * @param id        题数的id
     * @Return          java.lang.String
     * @Date            2019/11/11 20:58
     * @Version         1.0
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("book",bookService.selectByPrimaryKey(id));

        List<Publish> publishList = bookService.selectAllPublish();
        List<Location> locationList = bookService.selectAllLocation();
        log.info("publishList => {}",publishList);
        log.info("locationList => {}",locationList);

        model.addAttribute("locationList",locationList);
        model.addAttribute("publishList",publishList);
        return prefix+"edit";
    }

    /**
     * @Method          edit
     * @Author          戴书博
     * @Description     编辑
     * @param book      图书实体类
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 20:59
     * @Version         1.0
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Book book){
        return toAjax(bookService.updateBookById(book));
    }

    /**
     * @Method          delete
     * @Author          戴书博
     * @Description     删除单个
     * @param id        删除图书的id
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 20:59
     * @Version         1.0
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(bookService.deleteBookById(id));
    }

    /**
     * @Method          deleteAll
     * @Author          戴书博
     * @Description     批量删除
     * @param ids       图书的ids
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 21:00
     * @Version         1.0
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(bookService.deleteBookAllByIds(ids));
    }

}

