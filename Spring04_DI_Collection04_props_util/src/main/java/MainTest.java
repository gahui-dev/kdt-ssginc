import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("user.xml");
		
		UserService service = ctx.getBean("service", UserService.class);
		
		Properties xxx = service.getProps();
		
		// HashMap인 경우 key만 얻을 때 keySet() 사용
		// HashMap인 경우 value 얻을 때 get(key) 사용 
		
		Set<String> keys = xxx.stringPropertyNames();
		
		for(String key: keys) {
			System.out.println(key + "\t" + xxx.getProperty(key));
		}
	}
}
