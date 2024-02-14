import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class MainTest {
	public static void main(String[] args) {
		// "classpath:user-dev.xml" "classpath:user-prod.xml"

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

		// profile 설정
		ctx.getEnvironment().setActiveProfiles("prod"); // dev or prod
		ctx.load("classpath:user-dev.xml", "classpath:user-prod.xml");
		ctx.refresh();

		// 인터페이스
		UserService service = ctx.getBean("service", UserService.class);
		System.out.println(service.getService());
	}
}
