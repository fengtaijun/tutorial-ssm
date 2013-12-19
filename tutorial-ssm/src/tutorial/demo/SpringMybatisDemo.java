package tutorial.demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial.mapper.UserMapper;
import tutorial.model.User;

public class SpringMybatisDemo {
	private static final Logger LOG = Logger.getLogger(SpringMybatisDemo.class);
	private SqlSessionFactory sqlSessionFactory;
	private UserMapper userMapper;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void execute() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<User> users = userMapper.select();
			
			for (User u : users) {
				LOG.info(String.format("user => %s", u));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			sqlSession.close();
		}
	}

	public static void main(String[] args) {
		AbstractXmlApplicationContext ctx = null;
		try {
			// initial spring container
			ctx = new ClassPathXmlApplicationContext("classpath*:conf/spring-mybatis.xml");

			// get spring bean
			SpringMybatisDemo demo = ctx.getBean(SpringMybatisDemo.class);
			demo.execute();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			ctx.destroy();
		}
	}

}
