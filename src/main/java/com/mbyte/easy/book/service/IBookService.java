package com.mbyte.easy.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.publish.entity.Publish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              图书业务接口
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface IBookService extends IService<Book> {
    /**
     * 显示列表
     */
    IPage<Book> listPage(IPage<Book> page,Book book);

    /**
     * 根据id查询
     */
    Book selectByPrimaryKey(Long id);

    /**
     * 添加出版社
     */
    int insertBook(Book book);

    /**
     * 编辑出版社
     */
    int updateBookById(Book book);

    /**
     * 删除单个
     */
    int deleteBookById(Long id);

    /**
     * 批量删除
     */
    int deleteBookAllByIds(List<Long> ids);

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
