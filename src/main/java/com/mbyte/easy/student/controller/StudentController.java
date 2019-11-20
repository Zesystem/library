package com.mbyte.easy.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.student.entity.Student;
import com.mbyte.easy.student.service.IStudentService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @Author                   戴书博
 * @Description              学生
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Slf4j
@Controller
@RequestMapping("/student/student")
public class StudentController extends BaseController  {

    private String prefix = "student/student/";

    @Autowired
    private IStudentService studentService;

    /**
     * @Method          index
     * @Author          戴书博
     * @Description     返回列表
     * @param model     model
     * @param pageNo    当前页
     * @param pageSize  当前页页数
     * @param student   学生
     * @Return          java.lang.String
     * @Date            2019/11/2 13:44
     * @Version         1.0
     */
    @RequestMapping
    public String index(Model model,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                        String createTimeSpace ,
                        Student student) {
        Page<Student> page = new Page<>(pageNo, pageSize);
        IPage<Student> pageInfo = studentService.listPage(student,page);
        model.addAttribute("searchInfo", student);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"list";
    }

    /**
     * @Method          addBefore
     * @Author          戴书博
     * @Description     弹出添加页面
     * @Return          java.lang.String
     * @Date            2019/11/2 13:03
     * @Version         1.0
     */
    @GetMapping("addBefore")
    public String addBefore(){
        return prefix+"add";
    }

    /**
     * @Method          add
     * @Author          戴书博
     * @Description     添加学生信息
     * @param student   学生信息
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/2 13:02
     * @Version         1.0
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Student student){
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * @Method          editBefore
     * @Author          戴书博
     * @Description     弹出编辑页面
     * @param model     model
     * @param id        学生的id
     * @Return          java.lang.String
     * @Date            2019/11/2 13:04
     * @Version         1.0
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("student",studentService.selectByPrimaryKey(id));
        return prefix+"edit";
    }

    /**
     * @Method          edit
     * @Author          戴书博
     * @Description     编辑
     * @param student   学生信息
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/2 13:04
     * @Version         1.0
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Student student){

        return toAjax(studentService.updateStudentById(student));
    }

    /**
     * @Method          delete
     * @Author          戴书博
     * @Description     删除单条学生记录
     * @param id        学生的id
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/2 13:05
     * @Version         1.0
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentService.deleteStudentById(id));
    }

    /**
     * @Method          deleteAll
     * @Author          戴书博
     * @Description     批量删除学生记录
     * @param ids       学生们的ids
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/2 13:05
     * @Version         1.0
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentService.deleteStudentAllByIds(ids));
    }

    /**
     * @Method          borrowBookBefore
     * @Author          戴书博
     * @Description     跳转到借书页面
     * @param model     model
     * @param id        学生的id
     * @Return          java.lang.String
     * @Date            2019/11/13 23:00
     * @Version         1.0e
     */
    @RequestMapping("borrowBookBefore")
    public String borrowBookBefore(Model model){
        model.addAttribute("bookList",studentService.selectAllBook());
        return prefix + "borrow";
    }

    /**
     * @Method          borrowBook
     * @Author          戴书博
     * @Description     借书
     * @param id        id
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/13 23:04
     * @Version         1.0
     */
    @ResponseBody
    @RequestMapping("borrowBook")
    public AjaxResult borrowBook(String certificateNumber ,Long bookId){
        return studentService.borrowBook(certificateNumber,bookId);
    }

    /**
     * @Method          borrowBookBefore
     * @Author          戴书博
     * @Description     跳转到还书页面
     * @param model     model
     * @Return          java.lang.String
     * @Date            2019/11/13 23:00
     * @Version         1.0e
     */
    @RequestMapping("returnBookBefore")
    public String returnBookBefore(Model model){
        return prefix + "return";
    }

    /**
     * @Method          returnBook
     * @Author          戴书博
     * @Description     还书
     * @param id        id
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/13 23:04
     * @Version         1.0
     */
    @ResponseBody
    @RequestMapping("returnBook")
    public AjaxResult returnBook(String certificateNumber ,String bookNumber){
        return studentService.returnBook(certificateNumber,bookNumber);
    }

    /**
     * @Method          borrowBookBefore
     * @Author          戴书博
     * @Description     跳转到还书页面
     * @param model     model
     * @Return          java.lang.String
     * @Date            2019/11/13 23:00
     * @Version         1.0e
     */
    @RequestMapping("returnBookBefore/{id}")
    public String selectStuBook(Model model,@PathVariable("id")Long id,
                                @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize
                                ){
        Page<Book> page = new Page<>(pageNo, pageSize);
        IPage<Book> pageInfo = studentService.selectStuBook(id,page);
        model.addAttribute("pageInfo",new PageInfo(pageInfo));
        return prefix + "bookList";
    }

    /**
     * @Method          returnMaoney
     * @Author          戴书博
     * @Description     跳转到交纳欠费页面
     * @Return          java.lang.String
     * @Date            2019/11/13 23:00
     * @Version         1.0e
     */
    @RequestMapping("returnMaoneyBefore")
    public String returnMaoneyBefore(Model model){
        return prefix + "returnMoney";
    }

    /**
     * @Method returnMoney
     * @Author 戴书博
     * @Description 返回欠费金额
     * @param certificateNumber
     * @Return java.lang.Integer
     * @Date 2019/11/18 11:40
     * @Version  1.0
     */
    @ResponseBody
    @RequestMapping("returnMoney")
    public AjaxResult returnMoney(String certificateNumber){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.eq("certificate_number",certificateNumber);
        Student student = studentService.getOne(queryWrapper);
        if(student != null) {
            Integer arrearsNum = student.getArrearsNum();
            if(arrearsNum == 0){
                return AjaxResult.error(2,"未欠费");
            }else{
                return AjaxResult.success(arrearsNum);
            }
        }
        return AjaxResult.error();
    }

    /**
     * @Method updateArrearsNum
     * @Author 戴书博
     * @Description 交纳欠费
     * @param certificateNumber
     * @Return com.mbyte.easy.common.web.AjaxResult
     * @Date 2019/11/18 13:03
     * @Version  1.0
     */
    @ResponseBody
    @RequestMapping("updateArrearsNum")
    public AjaxResult updateArrearsNum(String certificateNumber){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.eq("certificate_number",certificateNumber);
        Student student = studentService.getOne(queryWrapper);
        if(student != null) {
           student.setArrearsNum(0);
           studentService.updateById(student);
           return AjaxResult.success();
        }
        return AjaxResult.error();
    }

}

