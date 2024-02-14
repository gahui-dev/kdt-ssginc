package com.example;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dto.DeptDTO;
import com.example.service.DeptServiceImpl;
import com.example.exception.DuplicatedDeptnoException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Service 얻기
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		DeptServiceImpl service = ctx.getBean("service", DeptServiceImpl.class);

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
				List<com.example.dto.DeptDTO> list = service.findAll();
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

				int n = service.remove(deptno);

				System.out.println(n + " 개가 삭제 되었습니다.");

			} else if (num.equals("0")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		} // end while

	}

}
