package dao;

public class ServiceDao {
		private static final ServiceDao dao = new ServiceDao();
		private ServiceDao() {}
		public static ServiceDao getInstance() { return dao; }
	   
	   
}
