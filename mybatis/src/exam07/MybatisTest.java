package exam07;

import java.util.List;
import java.util.Scanner;

public class MybatisTest {

	public static void main(String[] args) {

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
				DeptMybatisService service = new DeptMybatisServiceImpl();
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
				DeptMybatisService service = new DeptMybatisServiceImpl();
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
				DeptMybatisService service = new DeptMybatisServiceImpl();
				int n = service.update(dto);
				
				System.out.println(n + " 개가 수정되었습니다.");
				
			} else if (num.equals("4")) {
				System.out.println("삭제할 부서번호 입력하시오 ");
				int deptno = sc.nextInt();
				
				DeptMybatisService service = new DeptMybatisServiceImpl();
				int n = service.remove(deptno);
				
				System.out.println(n + " 개가 삭제 되었습니다.");

			} else if (num.equals("5")) {
				System.out.println("수정할 부서번호를 입력하시오");
				int deptno = sc.nextInt();
				System.out.println("수정할 부서명 입력하시오");
				String dname = sc.next();
				System.out.println("수정할 부서 위치 입력하시오");
				String loc = sc.next();
				DeptDTO dto = new DeptDTO(deptno, dname, loc);

				System.out.println("삭제할 부서번호를 입력하시오");
				int del_deptno = sc.nextInt();
				
				DeptMybatisService service = new DeptMybatisServiceImpl();
				int n = service.updateAndRemove(dto, del_deptno);

			} else if (num.equals("0")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		} // end while
	}
}
