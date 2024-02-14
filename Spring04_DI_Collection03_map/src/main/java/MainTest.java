import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;
import com.service.UserService;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("user.xml");

		UserService service = ctx.getBean("service", UserService.class);
		Map<String, Cat> map = service.getMap();

		for (String key : map.keySet()) {
			System.out.println(key + "\t" + map.get(key));
		}

		System.out.println(map);

	}
}
