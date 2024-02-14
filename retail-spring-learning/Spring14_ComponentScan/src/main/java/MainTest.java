import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("user.xml");

		// 빈 얻기
//		UserService service = ctx.getBean("userService", UserService.class);
		UserService service = ctx.getBean("xxx", UserService.class);
		System.out.println(service.getMesg());
	}

}
