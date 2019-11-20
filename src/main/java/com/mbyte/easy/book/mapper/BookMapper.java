package com.mbyte.easy.book.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.publish.entity.Publish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              图书dao
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 显示列表
     */
    IPage<Book> listPage(@Param("page") IPage<Book> page,@Param("book")Book book);

    /**
     * 根据id查询
     */
    Book selectByPrimaryKey(@Param("id")Long id);

    /**
     * 添加出版社
     */
    int insertBook(@Param("book") Book book);

    /**
     * 编辑出版社
     */
    int updateBookById(@Param("book")Book book);

    /**
     * 删除单个
     */
    int deleteBookById(@Param("id")Long id);

    /**
     * 批量删除
     */
    int deleteBookAllByIds(@Param("ids") List<Long> ids);

    /**
     * 查询出所有的书架位置
     */
    List<Location> selectAllLocation();

    /**
     * 查询出所有的出版社信息
     */
    List<Publish> selectAllPublish();

    /**
     * 查询图书详情
     */
    Book selectDetail(@Param("bookId")Long bookId);
}
