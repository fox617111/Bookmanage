package org.example.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.pojo.vo.BookVO;
import org.example.backend.service.BookService;
import org.example.backend.utils.ExcelUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class BookReportFormController {

    private final BookService bookService;

    public BookReportFormController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/load")
    public void downloadReportData(HttpServletResponse response){
        String fileName = "图书库详情数据.xls";
        List<BookVO> bookVOList = bookService.searchBook(null);
        System.out.println( bookVOList);

        try {
            ExcelUtil.process(fileName,bookVOList,BookVO.class,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
