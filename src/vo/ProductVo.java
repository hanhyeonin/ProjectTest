package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class ProductVo {
	private int pno;
	private String pname; 
	private int price;
	private String photofile;
	private int roomcnt;
	private int ano;
	private int rcount;
	private String pcategory;
	
}
