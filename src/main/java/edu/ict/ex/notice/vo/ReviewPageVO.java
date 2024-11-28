package edu.ict.ex.notice.vo;

import java.util.List;

import edu.ict.ex.simulation.page.PageVO;
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

public class ReviewPageVO  {
 
    private List<ReviewVO> review;
    private PageVO page;
    
}
