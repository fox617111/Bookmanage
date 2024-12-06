package org.example.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.example.backend.mapper.BookMapper;
import org.example.backend.mapper.BorrowingRecordMapper;
import org.example.backend.pojo.vo.BookVO;
import org.example.backend.pojo.vo.BorrowingRecordVO;
import org.example.backend.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingRecordServiceimpl implements BorrowingRecordService {

    private BorrowingRecordMapper borrowingRecordMapper;
    private BookMapper bookMapper;

    @Autowired
    public BorrowingRecordServiceimpl(BorrowingRecordMapper borrowingRecordMapper, BookMapper bookMapper) {
        this.borrowingRecordMapper = borrowingRecordMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public void addBorrow(BorrowingRecordVO borrowingRecordVO) {
        borrowingRecordVO.setBorrow_date(LocalDateTime.now());
        BookVO bookvo = new BookVO();
        bookvo.setBook_id(borrowingRecordVO.getBook_id());
        List<BookVO> bookVOList = bookMapper.searchBook(bookvo);
        if (bookVOList.size() == 1) {
            bookvo=bookVOList.get(0);
            if (bookvo.getAvailable_copies() > 0) {
                Integer available_copies = bookvo.getAvailable_copies() - 1;
                bookvo.setAvailable_copies(available_copies);
                bookMapper.updateBook(bookvo);
                borrowingRecordMapper.addBorrow(borrowingRecordVO);
            }else{
                throw new RuntimeException("图书已无库存");
            }
            
        }else{
            throw new RuntimeException("图书不存在");
        }

        
    }

    @Override
    public void deleteBorrowingRecord(Integer record_id) {
        borrowingRecordMapper.deleteBorrowingRecord(record_id);
    }

    @Override
    public BorrowingRecordVO getBorrowingRecordById(Integer record_id) {
        System.out.println(record_id);
        BorrowingRecordVO borrowingRecordVO = borrowingRecordMapper.getBorrowingRecordById(record_id);
        System.out.println(borrowingRecordVO);
        return borrowingRecordVO;
    }

    @Override
    public List<BorrowingRecordVO> searchBorrowingRecord(BorrowingRecordVO borrowingRecordVO) {
        System.out.println(borrowingRecordVO);
        List<BorrowingRecordVO> borrowingRecordVOList = borrowingRecordMapper.searchBorrowingRecord(borrowingRecordVO);
        System.out.println(borrowingRecordVOList);
        return  borrowingRecordVOList;
        
    }

    @Override
    public void updateBorrowingRecord(BorrowingRecordVO borrowingRecordVO) {
        borrowingRecordMapper.updateBorrowingRecord(borrowingRecordVO);
    }

}
