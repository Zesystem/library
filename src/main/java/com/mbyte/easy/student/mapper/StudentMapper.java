package com.mbyte.easy.student.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.common.entity.Middle;
import com.mbyte.easy.student.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              学生
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 显示列表
     */
    List<Student> listPage(@Param("student") Student student,@Param("page") IPage<Student> page);

    /**
     * 根据id查询
     */
    Student selectByPrimaryKey(@Param("id")Long id);

    /**
     * 添加学生信息
     */
    int insertStudent(@Param("student") Student student);

    /**
     * 更新学生信息
     */
    int updateStudentById(@Param("student") Student student);

    /**
     * 根据id删除学生的信息
     */
    int deleteStudentById(@Param("id")Long id);

    /**
     * 批量删除
     */
    int deleteStudentAllByIds(@Param("ids")List<Long> ids);

    /**
     * 查询出所有的图书
     */
    List<Book> selectAllBook();

    /**
     * 插入中间表
     */
    int insertModdle(@Param("bookId")Long bookId,
                     @Param("stuId")Long stuId,
                     @Param("createTime")LocalDateTime createTime);

    /**
     * 查询出id
     */
    Long selectModdleId(@Param("bookId")Long bookId,@Param("stuId")Long stuId);

    /**
     * 根据id删除中间表信息
     */
    int deleteModdleById(@Param("id")Long id);

    /**
     * 查询出学生的借书数
     */
    List<Book> selectStuBook(@Param("stuId") Long stuId,@Param("page")IPage<Book> page);

    /**
     * 查询出中间表信息
     */
    Integer selectMiddle(
            @Param("studentId")Long studentId,
            @Param("returnTime")LocalDateTime returnTime);
}
