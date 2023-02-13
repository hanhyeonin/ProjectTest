package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlSessionBean;
import vo.ProductVo;

public class ProductDao {
	private static final ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	public List<ProductVo> ProductList(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<ProductVo> list = mapper.selectList("travel.ProductSelectAll");
		mapper.close();
		return list;
	}
	
	public int count() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("travel.count");
		mapper.commit();
		mapper.close();
		return result;
	}
	
	//���α� ��� �������� - ���� : �ѹ���(�� ����������) �� 10���� ���������� ����
		public List<ProductVo> pagelist(Map<String,Integer> map) {
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<ProductVo> list = mapperSession.selectList("travel.pagelist",map);
			mapperSession.close(); 
			return list;
		}
}
