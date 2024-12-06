package org.example.backend.controller;

import java.util.List;

import org.example.backend.pojo.Result;
import org.example.backend.pojo.vo.BorrowingRecordVO;
import org.example.backend.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/borrowingRecord")
public class BorrowingRecordController {
    private final BorrowingRecordService borrowingRecordService;

    @Autowired
    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @PostMapping
    public Result<String> addBorrow(@RequestBody BorrowingRecordVO borrowingRecordVO) {
        try{
            borrowingRecordService.addBorrow(borrowingRecordVO);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @GetMapping
    public Result<List<BorrowingRecordVO>> searchBorrowingRecord(@RequestBody BorrowingRecordVO borrowingRecordVO) {
        System.out.println(borrowingRecordVO);
        List<BorrowingRecordVO> borrowingRecordVOList = borrowingRecordService.searchBorrowingRecord(borrowingRecordVO);
        return Result.success(borrowingRecordVOList);
    }

    @DeleteMapping
    public Result<String> deleteBorrowingRecord(@RequestParam Integer record_id) {
        borrowingRecordService.deleteBorrowingRecord(record_id);
        return Result.success();
    }

    @PutMapping
    public Result<String> updateBorrowingRecord(@RequestBody BorrowingRecordVO borrowingRecordVO) {
        borrowingRecordService.updateBorrowingRecord(borrowingRecordVO);
        return Result.success();
    }

    @GetMapping("/info")
    public Result<BorrowingRecordVO> getBorrowingRecordById(@RequestParam Integer record_id) {
        BorrowingRecordVO borrowingRecordVO = borrowingRecordService.getBorrowingRecordById(record_id);
        System.out.println(borrowingRecordVO);
        return Result.success(borrowingRecordVO);
    }
}
