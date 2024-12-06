package org.example.backend.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookVO {
    @ExcelProperty("图书编号")
    private Integer book_id;
    @ExcelProperty("书名")
    private String title;
    @ExcelProperty("作者")
    private String author;
    @ExcelProperty("出版社")
    private String publisher;
    @ExcelProperty("结束日期")
    private LocalDateTime publication_date;
    @ExcelProperty("唯一标识")
    private String isbn;
    @ExcelProperty("分类")
    private String category;
    @ExcelProperty("总数量")
    private Integer total_copies;
    @ExcelProperty("可借数量")
    private Integer available_copies;
    @ExcelProperty("介绍")
    private String introduction;
}
