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
public class InquiryVo {
	private int ino;
	private String ititle;
	private String icontent;
	private String mid;
	private char icheck;
}
