package tutorial.service.impl;

import org.apache.log4j.Logger;

import tutorial.model.User;
import tutorial.service.UserService;

public class H2DBUserServiceImpl implements UserService {
	private static final Logger LOG = Logger.getLogger(H2DBUserServiceImpl.class);

	@Override
	public User findUser() {
		//TODO h2 query
		return null;
	}

}
