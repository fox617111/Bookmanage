package org.example.backend.service;

import java.util.List;

import org.example.backend.pojo.vo.BookVO;

public interface BookService {

    /**
     * 添加图书
     * @param bookVO
     */
    void addBook(BookVO bookVO);

    /**
     * 删除图书
     * @param bookVO
     */
    void deleteBook(BookVO bookVO);

    /**
     * 更新图书信息
     * @param bookVO
     */
    void updateBook(BookVO bookVO);

    /**
     * 查询图书列表
     * @param bookVO
     * @return
     */
    List<BookVO> searchBook(BookVO bookVO);
    
}
