package org.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.pojo.vo.BorrowingRecordVO;


@Mapper
public interface BorrowingRecordMapper {

    void addBorrow(BorrowingRecordVO borrowingRecordVO);

    void deleteBorrowingRecord(Integer id);

    BorrowingRecordVO getBorrowingRecordById(Integer id);

    void updateBorrowingRecord(BorrowingRecordVO borrowingRecordVO);

    List<BorrowingRecordVO> searchBorrowingRecord(BorrowingRecordVO borrowingRecordVO);
    
}
