package vo;

import java.sql.Timestamp;

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
public class ChecksVo {
	private int cno;
	private String mid;
	private int pno;
	private Timestamp checkin;
	private Timestamp checkout;
}
