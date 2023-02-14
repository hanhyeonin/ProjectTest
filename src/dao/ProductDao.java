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

	public List<ProductVo> selectList() {
		SqlSession mapper = SqlSessionBean.getSession();
		List<ProductVo> list = mapper.selectList("product.selectAll");
		mapper.close();
		return list;
	}

	public int count() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("product.count");
		mapper.commit();
		mapper.close();
		return result;
	}

	// ���α� ��� �������� - ���� : �ѹ���(�� ����������) �� 10���� ���������� ����
	public List<ProductVo> pagelist(Map<String, Integer> map) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		List<ProductVo> list = mapperSession.selectList("product.pagelist", map);
		mapperSession.close();
		return list;
	}
	

}
