package edu.ict.ex.notice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewUsVO {

	private int seq_no; 
	private int goods_code;
	private String notice_title;
	private String notice_content;
	private int status;
	private String regist_id;
	private String regist_date;
	private String last_chg_date;
	private String expire_id;
	private String expire_date;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	
}
