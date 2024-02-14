import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		MessageSource resources = new ClassPathXmlApplicationContext("classpath:com/config/user.xml");
		
	    String message = resources.getMessage("greet", new String[] {"홍길동", "!!!"}, "Default", Locale.KOREA);
	    System.out.println(message);
	}

}
