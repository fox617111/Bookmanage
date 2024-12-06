package org.example.backend.service.impl;

import java.util.List;

import org.example.backend.mapper.BookMapper;
import org.example.backend.pojo.vo.BookVO;
import org.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl implements BookService {
    
    private final BookMapper bookMapper;
    
    @Autowired
    public BookServiceimpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public void addBook(BookVO bookVO) {
        bookMapper.addBook(bookVO);
    }

    @Override
    public void deleteBook(BookVO bookVO) {
        
        bookMapper.deleteBook(bookVO);
    }

    @Override
    public void updateBook(BookVO bookVO) {
        bookMapper.updateBook(bookVO);
    }

    @Override
    public List<BookVO> searchBook(BookVO bookVO) {
        System.out.println(bookVO);
        return bookMapper.searchBook(bookVO);
    }
}
