package dao;

public class LikesDao {
	private static final LikesDao dao = new LikesDao();
	private LikesDao() {}
	public static LikesDao getInstance() { return dao; }
	
	
}
