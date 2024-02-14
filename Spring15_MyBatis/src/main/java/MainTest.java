import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;
import com.service.DeptService;


public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		DeptService service = ctx.getBean("service", DeptService.class);
		
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("부서 관리 ");
			System.out.println("1. 부서 목록 보기 ");
			System.out.println("2. 부서 등록 ");
			System.out.println("3. 부서 수정 ");
			System.out.println("4. 부서 삭제 ");
			System.out.println("5. 부서 수정 및 삭제 ");
			System.out.println("0. 종료");
			String num = sc.next();

			if (num.equals("1")) {
				List<DeptDTO> list = service.findAll();
				for (DeptDTO dto : list) {
					System.out.println(dto);
				}

			} else if (num.equals("2")) {
				System.out.println("부서번호 입력하시오 (중복주의) ");
				int deptno = sc.nextInt();
				System.out.println("부서명 입력하시오");
				String dname = sc.next();
				System.out.println("부서 위치 입력하시오");
				String loc = sc.next();

				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				int n = 0;
				try {
					n = service.save(dto);
				} catch (DuplicatedDeptnoException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(n + " 개가 저장되었습니다.");

			} else if (num.equals("3")) {
				System.out.println("수정할 부서번호 입력하시오 ");
				int deptno = sc.nextInt();
				System.out.println("수정할 부서명 입력하시오");
				String dname = sc.next();
				System.out.println("수정할 부서 위치 입력하시오");
				String loc = sc.next();

				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				int n = service.update(dto);

				System.out.println(n + " 개가 수정되었습니다.");

			} else if (num.equals("4")) {
				System.out.println("삭제할 부서번호 입력하시오 ");
				int deptno = sc.nextInt();

				int n = service.delete(deptno);

				System.out.println(n + " 개가 삭제 되었습니다.");

			} else if (num.equals("0")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		} // end while
	}

}
