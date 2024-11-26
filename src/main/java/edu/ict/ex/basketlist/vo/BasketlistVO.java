package edu.ict.ex.basketlist.vo;

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
public class BasketlistVO {
	   //변수와 변수 각각의 데이터 타입 표시
		private String 	user_id;
		private String 	name;
		private String 	goods_gubun;
		private String 	goods_gubun_nm;
		private String 	cnt;
}
