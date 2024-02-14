import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class MainTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user.xml");
		
		UserService service = ctx.getBean("service", UserService.class);
		service.getMessage();
	}

}
