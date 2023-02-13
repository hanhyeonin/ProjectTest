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
public class MemberVo {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private char gender;
	private String auth;
}
