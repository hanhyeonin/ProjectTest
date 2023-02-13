package dao;

public class ReviewDao {
	private static final ReviewDao dao = new ReviewDao();
	private ReviewDao() {}
	public static ReviewDao getInstance() { return dao; }
	
	
}
