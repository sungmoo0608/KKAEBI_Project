package edu.ict.ex.transaction.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.transaction.vo.TransactionVO;


@Mapper
public interface TransactionMapper {

	TransactionVO getTransactionInitFetch(String user_id,Integer goods_code);

}
