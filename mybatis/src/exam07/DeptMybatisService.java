package exam07;

import java.util.List;

public interface DeptMybatisService {
	public List<DeptDTO> findAll();
	public int save(DeptDTO dto) throws DuplicatedDeptnoException;
	public int update(DeptDTO dto);
	public int remove(int deptno);
	public int updateAndRemove(DeptDTO dto, int deptno);
	
	
	/* 오버라이딩
	 * 
	 * 부모 메서드 		  : public void a() throws Exception {}
	 * 자식 재정의 메서드 : public void a()
	 * 메서드 명, 리턴타입, 파라미터 동일해야 함 
	 * 접근제한자, throws 는 다를 수 있음 
	 *
	 * */
	
	/*
	 * 접근 제한자
	 * public > protected > default > private
	 * 재정의하는 메서드는 부모 접근제한자보다 같거나 확대(위)
	 * 부모 접근제한자 : default
	 * 자식 접근제한자 : public, protected, default
	 * */
	
	/*
	 * 예외클래스
	 * 
	 * 같거나 축소(작게), 같은 계열 
	 * 
	 * 											  Object
	 *   											|
	 * 											Throwable
	 *   			| 													|
	 * Error(무시, 프로그램적으로 제어 불가)						Exception  
	 * 																	|
	 * 							RuntimeException			IOException, SQLException
	 * 									| 								|
	 * 						NullPointerException				FileNotFoundException
	 * 						ArrayIndexOutofBoundsException
	 * 						ClassCastException
	 * 
	 * */
}
