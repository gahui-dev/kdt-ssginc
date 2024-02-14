import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("user.xml");
		
		// 빈 얻기	
		UserService service = ctx.getBean("service", UserService.class);
//		System.out.println(service.sayHello());
//		System.out.println(service.callHello());
		
		try {
			System.out.println(service.echoHello());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
