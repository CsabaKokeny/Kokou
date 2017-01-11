package my.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	
    final  static String MYBATIS_CONFIG_FILE = "mybatis.xml";

    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSession sqlSession = null;
	

    public static SqlSessionFactory getSqlSessionFactory() {

        if (sqlSessionFactory == null) {
            try {
                
                try (Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG_FILE)) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return sqlSessionFactory;		
    }
        
    public static SqlSession openSqlSession() {
        try {
            return getSqlSessionFactory().openSession();
        } catch (Exception ex) {
            System.err.println(ex);
            sqlSessionFactory = null;
            return getSqlSessionFactory().openSession();
        }
    }
}
