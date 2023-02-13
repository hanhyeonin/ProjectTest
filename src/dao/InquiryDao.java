package dao;

public class InquiryDao {
	private static final InquiryDao dao = new InquiryDao();
	private InquiryDao() {}
	public static InquiryDao getInstance() {  return dao;  }
	
	
}
