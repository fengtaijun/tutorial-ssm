package tutorial.demo;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial.model.User;
import tutorial.service.UserService;

public class SpringDemo {
	private static final Logger LOG = Logger.getLogger(SpringDemo.class);
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void execute() {
		User user = userService.findUser();
		LOG.info(String.format("user => %s", user));
	}

	public static void main(String[] args) {
		AbstractXmlApplicationContext ctx = null;
		try {
			// initial spring container
			ctx = new ClassPathXmlApplicationContext("classpath*:tutorial/demo/applicationContext.xml");
			
			// get spring bean
			SpringDemo demo = ctx.getBean(SpringDemo.class);
			demo.execute();

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			ctx.destroy();
		}
	}

}
