import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;
import com.service.UserService;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("user.xml");
		
		UserService service = ctx.getBean("service", UserService.class);
		List<Cat> list = service.getList();
		
		System.out.println(list);
	}
}
