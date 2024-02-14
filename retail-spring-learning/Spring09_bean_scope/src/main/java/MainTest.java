import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.DeptServiceImpl;

public class MainTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("com/config/user.xml");
		
		// 빈 얻기
		DeptServiceImpl service = ctx.getBean("xxx", DeptServiceImpl.class);
		String mesg = service.getMesg();
		System.out.println("첫번째 bean: " + mesg);
		
		DeptServiceImpl service2 = ctx.getBean("xxx", DeptServiceImpl.class);
		String mesg2 = service2.getMesg();
		System.out.println("첫번째 bean: " + mesg2);
		
		System.out.println(service == service2);
		
	}
}
