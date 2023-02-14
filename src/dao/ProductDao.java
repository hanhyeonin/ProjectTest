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

	// 메인글 목록 가져오기 - 할일 : 한번에(즉 한페이지에) 글 10개씩 가져오도록 변경
	public List<ProductVo> pagelist(Map<String, Integer> map) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		List<ProductVo> list = mapperSession.selectList("product.pagelist", map);
		mapperSession.close();
		return list;
	}
	

}
