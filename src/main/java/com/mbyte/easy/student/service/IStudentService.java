package com.mbyte.easy.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.student.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              学生
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface IStudentService extends IService<Student> {

    /**
     * 显示列表
     */
    IPage<Student> listPage(Student student,IPage<Student> page);

    /**
     * 根据id查询
     */
    Student selectByPrimaryKey(Long id);

    /**
     * 添加学生信息
     */
    int insertStudent(Student student);

    /**
     * 更新学生信息
     */
    int updateStudentById(Student student);

    /**
     * 根据id删除学生的信息
     */
    int deleteStudentById(Long id);

    /**
     * 批量删除
     */
    int deleteStudentAllByIds(@Param("ids") List<Long> ids);

    /**
     * 借书
     */
    AjaxResult borrowBook(String certificateNumber,Long bookId);

    /**
     * 查询出所有的图书
     */
    List<Book> selectAllBook();

    /**
     * 还书
     */
    AjaxResult returnBook(String certificateNumber ,String bookNumber);

    /**
     * 查询出学生的借书数
     */
    IPage<Book> selectStuBook(Long stuId,IPage<Book> page);

    /**
     * 定时任务
     */
    void scheduling();

}
