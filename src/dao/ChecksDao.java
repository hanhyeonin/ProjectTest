package dao;

public class ChecksDao {
		private static final ChecksDao dao = new ChecksDao();
	   private ChecksDao() {}
	   public static ChecksDao getInstance() {
	      return dao;
	   }
}
