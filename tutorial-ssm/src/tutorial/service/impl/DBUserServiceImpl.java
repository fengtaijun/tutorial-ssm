package tutorial.service.impl;

import org.apache.log4j.Logger;

import tutorial.model.User;
import tutorial.service.UserService;

public class DBUserServiceImpl implements UserService {
	private static final Logger LOG = Logger.getLogger(DBUserServiceImpl.class);

	@Override
	public User findUser() {
		LOG.debug("Get user data from DB.");
		User user = new User();
		user.setUsername("SamChen");
		return user;
	}

}
