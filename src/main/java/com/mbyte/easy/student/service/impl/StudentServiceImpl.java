package com.mbyte.easy.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.book.mapper.BookMapper;
import com.mbyte.easy.book.service.IBookService;
import com.mbyte.easy.common.entity.Middle;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.student.entity.Student;
import com.mbyte.easy.student.mapper.StudentMapper;
import com.mbyte.easy.student.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbyte.easy.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              学生
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Slf4j
@Transactional
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private BookMapper bookMapper;
    /**
     * 显示列表
     */
    public IPage<Student> listPage(Student student,IPage<Student> page){
        return page.setRecords(this.baseMapper.listPage(student,page));
    }

    /**
     * 根据id查询
     */
    public Student selectByPrimaryKey(Long id){
        return this.baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 插入学生信息
     */
    public int insertStudent(Student student){
        student.setArrearsNum(0);
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        return this.baseMapper.insertStudent(student);
    }

    /**
     * 更新学生信息
     */
    public int updateStudentById(Student student){
        student.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.updateStudentById(student);
    }

    /**
     * 根据id删除学生的信息
     */
    public int deleteStudentById(@Param("id")Long id){
        return this.baseMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public int deleteStudentAllByIds(@Param("ids") List<Long> ids){
        return this.baseMapper.deleteStudentAllByIds(ids);
    }

    /**
     * 查询出所有的图书
     */
    public List<Book> selectAllBook(){
        return this.baseMapper.selectAllBook();
    }

    /**
     * 借书
     */
    public AjaxResult borrowBook(String certificateNumber,Long bookId){
        log.info("certificateNumber => {},bookId => {}",certificateNumber,bookId);

        QueryWrapper<Student> queryWrapperStudent = new QueryWrapper<>();
        queryWrapperStudent = queryWrapperStudent.eq("certificate_number",certificateNumber);
        Student student = this.baseMapper.selectOne(queryWrapperStudent);
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if (student != null&&book!=null){
            Integer arrearsNum = student.getArrearsNum();
            Integer maxBookNum = student.getMaxBookNum();
            Integer totalNumber = book.getTotalNumber();
            if(arrearsNum == 0&&totalNumber > 0 && maxBookNum > 0){
                //更新
                student.setMaxBookNum(student.getMaxBookNum() - 1);
                book.setTotalNumber(book.getTotalNumber() - 1);
                this.baseMapper.updateStudentById(student);
                bookMapper.updateBookById(book);
                //添加到中间表
                this.baseMapper.insertModdle(bookId,student.getId(),LocalDateTime.now());
                return AjaxResult.success();
            }
        }
        return AjaxResult.error();
    }

    /**
     * 还书
     */
    public AjaxResult returnBook(String certificateNumber ,String bookNumber){
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper = bookQueryWrapper.eq("book_number",bookNumber);
        Book book = bookMapper.selectOne(bookQueryWrapper);

        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper = studentQueryWrapper.eq("certificate_number",certificateNumber);
        Student student = this.baseMapper.selectOne(studentQueryWrapper);

        if(book!=null&&student!=null){
            Long moddleId = this.baseMapper.selectModdleId(book.getId(),student.getId());
            if(moddleId!=null){
                student.setMaxBookNum(student.getMaxBookNum()+1);
                book.setTotalNumber(book.getTotalNumber()+1);

                this.baseMapper.updateStudentById(student);
                bookMapper.updateBookById(book);

                this.baseMapper.deleteModdleById(moddleId);
                return AjaxResult.success();
            }
        }
        return AjaxResult.error();
    }

    /**
     * 查询出学生的借书数
     */
    public IPage<Book> selectStuBook(Long stuId,IPage<Book> page){
        return page.setRecords(this.baseMapper.selectStuBook(stuId,page));
    }

    /**
     * 定时任务
     */
    public void scheduling(){
        List<Student> students = this.baseMapper.selectList(new QueryWrapper<>());
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime returnTime = nowTime.minusMonths(2);
        if(students!=null){
            for(Student student:students){
                Long studentId = student.getId();
                int count = this.baseMapper.selectMiddle(studentId,returnTime);
                log.info("两个月未归还书数 => {}",count);
                if(count > 0){
                    student.setArrearsNum(student.getArrearsNum() + count * 2);
                    this.baseMapper.updateStudentById(student);
                }
            }
        }
    }

}
