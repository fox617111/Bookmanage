package org.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.pojo.vo.BookVO;

@Mapper
public interface BookMapper {

    void addBook(BookVO bookVO);

    void deleteBook(BookVO bookVO);

    void updateBook(BookVO bookVO);

    List<BookVO> searchBook(BookVO bookVO);
    
}
