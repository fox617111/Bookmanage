package org.example.backend.service;

import java.util.List;

import org.example.backend.pojo.vo.BorrowingRecordVO;

public interface BorrowingRecordService {

    /**
     * 添加借阅记录
     * @param borrowingRecordVO
     */
    void addBorrow(BorrowingRecordVO borrowingRecordVO);

    /**
     * 删除借阅记录
     * @param id
     */
    void deleteBorrowingRecord(Integer id);

    /**
     * 根据id获取借阅记录
     * @param id
     * @return
     */
    BorrowingRecordVO getBorrowingRecordById(Integer id);

    /**
     * 根据借阅记录查询借阅记录
     * @param borrowingRecordVO
     * @return 
     */
    List<BorrowingRecordVO> searchBorrowingRecord(BorrowingRecordVO borrowingRecordVO);

    /**
     * 更新借阅记录
     * @param borrowingRecordVO
     */
    void updateBorrowingRecord(BorrowingRecordVO borrowingRecordVO);
    
}
