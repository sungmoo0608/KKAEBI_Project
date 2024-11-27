package edu.ict.ex.transaction.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.transaction.vo.TransactionVO;


@Mapper
public interface TransactionMapper {

	TransactionVO getTransactionInitFetch(String user_id,Integer goods_code);

	TransactionVO getTransactionCheckFetch(String user_id,Integer goods_code,double tr_number,double tr_price,double tr_amt);

	TransactionVO getTransactionRecheckFetch(String user_id,Integer goods_code,double tr_amt);
	
	
	void createTransactionDeposit(TransactionVO transaction);

	void createTransactionFund(TransactionVO transaction);

	void createTransactionExchange(TransactionVO transaction);

	void createTransactionStock(TransactionVO transaction);
	
	
}
