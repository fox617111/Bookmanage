package org.example.backend.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class BorrowingRecordVO {
    private Integer record_id;
    private Integer user_id;
    private Integer book_id;
    private LocalDateTime borrow_date;
    private LocalDateTime due_date;
    private LocalDateTime return_date;
}
