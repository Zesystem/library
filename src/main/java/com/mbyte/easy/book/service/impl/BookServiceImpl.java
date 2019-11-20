package com.mbyte.easy.book.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.book.entity.Book;
import com.mbyte.easy.book.mapper.BookMapper;
import com.mbyte.easy.book.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.publish.entity.Publish;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              图书业务实现类
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Slf4j
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    /**
     * 显示列表
     */
    public IPage<Book> listPage(IPage<Book> page,Book book){
        log.info("beginTime =? {}",book.getBeginTime());
        log.info("endTime =? {}",book.getEndTime());
        return this.baseMapper.listPage(page,book);
    }

    /**
     * 根据id查询
     */
    public Book selectByPrimaryKey(Long id){
        return this.baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加出版社
     */
    public int insertBook(Book book){
        book.setCreateTime(LocalDateTime.now());
        book.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.insertBook(book);
    }

    /**
     * 编辑出版社
     */
    public int updateBookById(Book book){
        book.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.updateBookById(book);

    }

    /**
     * 删除单个
     */
    public int deleteBookById(Long id){
        return this.baseMapper.deleteBookById(id);

    }

    /**
     * 批量删除
     */
    public int deleteBookAllByIds(List<Long> ids){
        return this.baseMapper.deleteBookAllByIds(ids);
    }


    /**
     * 查询出所有的书架位置
     */
    public List<Location> selectAllLocation(){
        return this.baseMapper.selectAllLocation();
    }

    /**
     * 查询出所有的出版社信息
     */
    public List<Publish> selectAllPublish(){
        return this.baseMapper.selectAllPublish();
    }

    /**
     * 查询图书详情
     */
    public Book selectDetail(@Param("bookId")Long bookId){
        return this.baseMapper.selectDetail(bookId);
    }

}
