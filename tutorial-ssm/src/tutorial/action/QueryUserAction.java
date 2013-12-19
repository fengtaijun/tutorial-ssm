package tutorial.action;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import tutorial.mapper.UserMapper;
import tutorial.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class QueryUserAction extends ActionSupport {

	private static final long serialVersionUID = -1956408209739332987L;
	private static final Logger LOG = Logger.getLogger(QueryUserAction.class);

	/* model objects */
	private User user;
	private List<User> users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/* inject */
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

	@Override
	public String execute() throws Exception {
		SqlSession sqlSession = null;
		try {
			LOG.info(sqlSessionFactory);
			sqlSession = sqlSessionFactory.openSession();

			users = userMapper.select();
			for (User u : users) {
				LOG.info(String.format("user => %s", u));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			sqlSession.close();
		}
		return SUCCESS;
	}

}
