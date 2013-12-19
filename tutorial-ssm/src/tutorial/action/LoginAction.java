package tutorial.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 8262061063574713801L;
	private static final Logger LOG = Logger.getLogger(LoginAction.class);

	/* model attributes */
	private String username;
	private String password;
	private String message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception {
		LOG.debug(String.format("username => %s", username));
		LOG.debug(String.format("password => %s", password));

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			message = "Username or Password is empty.";
			return ERROR;
		}
		else if (!StringUtils.equals(username, password)) {
			message = "Username or Password incorrect.";
			return INPUT;
		}
		message = "Hi!" + username;

		return SUCCESS;
	}
}
