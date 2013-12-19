package tutorial.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import tutorial.mapper.UserMapper;
import tutorial.model.User;

public class MyBatisDemo {
	private static final Logger LOG = Logger.getLogger(MyBatisDemo.class);

	public static void main(String[] args) {
		SqlSessionFactory factory = null;

		try {
			String resource = "tutorial/demo/mybatis.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}

		SqlSession session = null;
		try {
			session = factory.openSession();
			
			UserMapper mapper = session.getMapper(UserMapper.class);

			List<User> users = mapper.select();
			for (User u : users) {
				LOG.info(String.format("user => %s", u));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			session.close();
		}

	}

}
