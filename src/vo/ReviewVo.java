package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewVo {
	private int rno;
	private String mid;
	private int pno;
	private String rphoto;
	private String rtitle;
	private int star;
	private String rcontent;
	
}
