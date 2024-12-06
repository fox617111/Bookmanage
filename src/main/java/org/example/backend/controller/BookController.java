package org.example.backend.controller;

import java.util.List;

import org.example.backend.pojo.Result;
import org.example.backend.pojo.vo.BookVO;
import org.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(@RequestBody BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Result<String> addBook(@RequestBody BookVO bookVO) {
        bookService.addBook(bookVO);
        return Result.success();

    }

    @DeleteMapping
    public Result<String> deleteBook(@RequestBody BookVO bookVO) {
        bookService.deleteBook(bookVO);
        return Result.success();
    }

    @PutMapping
    public Result<String> updateBook(@RequestBody BookVO bookVO) {
        bookService.updateBook(bookVO);
        return Result.success();
    }

    @GetMapping
    public Result<List<BookVO>> searchBook(@RequestBody BookVO bookVO) {
        List<BookVO> bookVOList = bookService.searchBook(bookVO);
        return Result.success(bookVOList);
    }
}
