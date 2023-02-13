package mybatis;

import java.io.IOException;
import java.io.InputStream;

// Mybatis �����ӿ��� Ŭ������
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionBean {
/*
 * Mybatis ���̺귯���� SqlSession Ŭ������ SQL ����޼ҵ带 �����մϴ�.
 * SqlSesseionFactoryBuilder -> SqlSessionFactory ��ü ����
 *  -> SqlSession ��ü ����  : Ŭ���� ��������
 *** SqlSession ��ü�� dao���� db sql�� �����մϴ�.
 * 
 * https://mybatis.org/mybatis-3/ko/getting-started.html ����� �ۼ��մϴ�.
 * String resource = "org/mybatis/example/mybatis-config.xml";
   InputStream inputStream = Resources.getResourceAsStream(resource);
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
 * 
 */
	public static SqlSessionFactory sqlSessionFactory;
	static {   //�������� static ������ ����˴ϴ�.
		String resource = "mybatis/mybatis-config.xml";    //mybatis ��������
		InputStream inputStream=null;			//������ �б����� �Է� ��Ʈ��
	
	
		try {
			inputStream = Resources.getResourceAsStream(resource);   //���ҽ� ���� �ڿ� �о����
		}catch(IOException e) {
			System.out.println("mybatis ���� ���� �б� �����Դϴ�.");
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);   
		//�о�� ���Ϸ� factory ����
	}
	
	public static SqlSession getSession() {    
		//**������ sqlSessionFactory �����ϴ� �޼ҵ� -> sql �����ϴ� ��ü
		return sqlSessionFactory.openSession();
	}
}