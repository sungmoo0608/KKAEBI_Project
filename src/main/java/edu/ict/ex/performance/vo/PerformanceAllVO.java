package edu.ict.ex.performance.vo;

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
public class PerformanceAllVO {
	   //변수와 변수 각각의 데이터 타입 표시
		private String 	user_id;
		private String 	name;
		private String 	birthday;
		private String 	create_date;
		private String 	grade;
		private String 	trkwa_amt;
		private String 	trforign_amt;
		private String 	val_amt;
		private String 	sonik_amt;
		private String 	suik_rate;
		private int 	in_grade;
		private int 	out_grade;
		private int 	st_grade;
		private int 	end_grade;
		
}

