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


    
    
}

