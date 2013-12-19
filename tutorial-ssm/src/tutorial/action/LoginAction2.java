package tutorial.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import tutorial.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction2 extends ActionSupport {

	private static final long serialVersionUID = 3501101122776283355L;

	private static final Logger LOG = Logger.getLogger(LoginAction2.class);

	/* model attributes */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/* model objects */
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		LOG.debug(String.format("user => %s", user));

		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			message = "Username or Password is empty.";
			return ERROR;
		}
		else if (!StringUtils.equals(user.getUsername(), user.getPassword())) {
			message = "Username or Password incorrect.";
			return INPUT;
		}
		message = "Hi!" + user.getUsername();

		return SUCCESS;
	}

}
