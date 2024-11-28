package edu.ict.ex.transaction.service;

import org.springframework.stereotype.Service;

import edu.ict.ex.transaction.mapper.TransactionMapper;
import edu.ict.ex.transaction.vo.TransactionVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService{
    
    private final TransactionMapper transactionMapper;
    
    public TransactionVO getTransactionInitFetch(String user_id,Integer goods_code) {
        return transactionMapper.getTransactionInitFetch(user_id,goods_code);
    }

    public TransactionVO getTransactionCheckFetch(String user_id,Integer goods_code,double tr_number,double tr_price,double tr_amt) {
        return transactionMapper.getTransactionCheckFetch(user_id,goods_code,tr_number,tr_price,tr_amt);
    }
    
    public TransactionVO getTransactionRecheckFetch(String user_id,Integer goods_code,double tr_amt) {
        return transactionMapper.getTransactionRecheckFetch(user_id,goods_code,tr_amt);
    }
    
    

    public void createTransactionDeposit(TransactionVO transaction) {
    	transactionMapper.createTransactionDeposit(transaction); // 게시물 생성 메서드
    }

    public void createTransactionFund(TransactionVO transaction) {
    	transactionMapper.createTransactionFund(transaction); // 게시물 생성 메서드
    }

    public void createTransactionExchange(TransactionVO transaction) {
    	transactionMapper.createTransactionExchange(transaction); // 게시물 생성 메서드
    }

    public void createTransactionStock(TransactionVO transaction) {
    	transactionMapper.createTransactionStock(transaction); // 게시물 생성 메서드
    }
    
}

