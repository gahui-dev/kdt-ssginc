package exam02;

import java.util.List;
import java.util.Scanner;

public class DeptTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("부서 관리");
			System.out.println("1. 부서목록보기");
			System.out.println("2. 부서등록");
			System.out.println("3. 부서수정");
			System.out.println("4. 부서삭제");
			System.out.println("5. 부서수정및삭제");
			System.out.println("0. 종료");
			String num = scan.next();
			if("1".equals(num)) {
				//Service 연동
				DeptService service = new DeptServiceImpl();
				List<DeptDTO> list = service.findAll();
				for (DeptDTO dto : list) {
				  System.out.println(dto);
				}
			}else if("2".equals(num)) {
				System.out.println("부서번호 입력하시오(중복주의)");
				int deptno = scan.nextInt();
				System.out.println("부서명 입력하시오");
				String dname = scan.next();
				System.out.println("부서위치 입력하시오");
				String loc = scan.next();
				
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				DeptService service = new DeptServiceImpl();
				int n=0;
				try {
					n = service.save(dto);
				} catch (DuplicatedDeptnoException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(n+" 개가 저장되었습니다.");
			}else if("3".equals(num)) {
				System.out.println("수정할 부서번호 입력하시오");
				int deptno = scan.nextInt();
				System.out.println("수정할 부서명 입력하시오");
				String dname = scan.next();
				System.out.println("수정할 부서위치 입력하시오");
				String loc = scan.next();
				
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				DeptService service = new DeptServiceImpl();
				int n = service.update(dto);
				
				System.out.println(n+" 개가 수정되었습니다.");
			}else if("4".equals(num)) {
				System.out.println("삭제할 부서번호 입력하시오");
				int deptno = scan.nextInt();
				DeptService service = new DeptServiceImpl();
				int n = service.remove(deptno);
				
				System.out.println(n+" 개가 삭제되었습니다.");
			}else if("5".equals(num)) {
				//수정할 정보
				System.out.println("수정할 부서번호 입력하시오");
				int deptno = scan.nextInt();
				System.out.println("수정할 부서명 입력하시오");
				String dname = scan.next();
				System.out.println("수정할 부서위치 입력하시오");
				String loc = scan.next();
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				
				// 삭제할 정보
				System.out.println("삭제할 부서번호 입력하시오");
				int del_deptno = scan.nextInt();
				
				DeptService service = new DeptServiceImpl();
				int n = service.updateAndRemove(dto, del_deptno);
				
				System.out.println(n+" 개가 수정 및 삭제되었습니다.");
			}else if("0".equals(num)) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
		}//end while
		
		
		
		
	}

}
