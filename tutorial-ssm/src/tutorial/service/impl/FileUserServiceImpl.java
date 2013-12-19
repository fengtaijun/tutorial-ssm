package tutorial.service.impl;

import org.apache.log4j.Logger;

import tutorial.model.User;
import tutorial.service.UserService;

public class FileUserServiceImpl implements UserService {
	private static final Logger LOG = Logger.getLogger(FileUserServiceImpl.class);
	
	@Override
	public User findUser() {
		LOG.debug("Get user data from File.");
		User user = new User();
		user.setUsername("Sam");
		return user;
	}

}
