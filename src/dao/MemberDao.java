package dao;

public class MemberDao {
	private static final MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {  return dao;}
	
	
}
