package exam06;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMybatisTest {

	public static void main(String[] args) {
		/*
		 * 1. 환경 설정 - DB 설치 : MySQL - 설치된 DB 회사에서 제공한 라이브러리 필요 (*.jar) - Mybatis 라이브러리
		 * 필요 - mybatis.org 에서 다운 - STS에서 *.jar 인식 ====> 빌드패스(build path)
		 * mybatis-3.5.14.jar / mysql-connector-j-8.0.33.jar
		 * 
		 * 
		 * 2. mysql(oracle도 같은 방식) 연동 (4가지 필요) ==> 외부파일(properties)에서 저장하고 호출해서 사용 ==>
		 * 예) src 폴더에 패키지 형태로 저장 가능 (jdbc.properties)
		 * 
		 * 
		 * 3. 2개의 xml 파일 작성 가. 전반적인 DB 연동 관련 설정 파일 - Configuration.xml - 4가지 작업 a.
		 * jdbc.properties 설정 b. jdbc.properties 정보 조회해서 설정(연결) c. Mapper 등록 d. DTO 별칭
		 * 
		 * 나. SQL문 저장 - 테이블 당 하나씩 생성 - 테이블명 Mapper.xml 형식 권장 - 예) DeptMapper.xml
		 * 
		 * 
		 * 4. DeptDTO 작성 - 테이블의 하나의 레코드 저장용 - MyBatis는 자동으로 DeptDTO에 저장해준다. - 필요 시 List에
		 * 누적도 해준다. - 주의할 점은 반드시 select 문장의 컬럼 헤더 값과 DTO의 변수명이 일치해야 한다. - (원래는 setter
		 * 메서드명과 일치해야 한다.) - 만약 일치안되면 별칭으로 해결한다.
		 * 
		 * 5. Configuration.xml 불러오기 - 최종적으로 SqlSessionFactory 반환한다.
		 * 
		 * 
		 * 6. jdbc의 Connection 역할의 SqlSession 얻는다. - SqlSessionFactory 에서 SqlSession을
		 * 얻는다.
		 * 
		 * 
		 * 7. SqlSession의 메서드를 이용해서 Mapper의 태그 호출 가. select 문
		 * session.selectList("namespace.id 값"); 메서드가 있고
		 * session.selectOne("namespace.id 값", 값); 메서드가 있다.
		 * 
		 * List<DeptDTO> list = session.selectList("id값"); DeptDTO dto =
		 * session.selectOne("id값");
		 * 
		 * 
		 * 8. SqlSession 닫기 session.close();
		 */

		String resource = "exam06/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// SqlSession 얻기
		SqlSession session = sqlSessionFactory.openSession();

		// 1. 멀티 insert
		// Oracle => insert all into ~

		/*
		 * insert into dept(deptno, dname, loc) values(2, '개발', '서울'), (3, '개발', '서울');
		 * 
		 */
//		DeptDTO dto1 = new DeptDTO(2, "개발", "서울");
//		DeptDTO dto2 = new DeptDTO(3, "개발", "서울");
//
//		// 뭉쳐서 전달해야 한다. 리스트에 넣기
//		List<DeptDTO> list = Arrays.asList(dto1, dto2);
//
//		int n = session.insert("exam06.DeptMapper.multiInsert", list);
//		session.commit();
//		System.out.println("멀티인설트 결과 > " + n);
//
//		session.commit();
		
		// 2. 멀티 delete
		/*
		 * delete from dept
		 * where deptno IN(2, 3)
		 * */
		
//		List<Integer> list2 = Arrays.asList(2, 3);		
//		int n2 = session.delete("exam06.DeptMapper.multiDelete", list2);
//		session.commit();
		
		// 3. 멀티 select
		/*
		 * select * from dept
		 * where deptno IN (10, 20);
		 * */
//		List<Integer> list3 = Arrays.asList(10, 20);
//		List<DeptDTO> result = session.selectList("exam06.DeptMapper.multiSelect", list3);
//		System.out.println(result);
//		
		// 4. 조건이 여러개
		/*
		 * select *
		 * from dept 
		 * where deptno = #{} 또는
		 * where dname = #{}
		 * */
		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("searchName", "deptno");
//		map.put("searchValue", 10);
		
		map.put("searchName", "dname");
		map.put("searchValue", "개발");
		
		List<DeptDTO> list4 = session.selectList("exam06.DeptMapper.multiChoose2", map);
		System.out.println(list4);
		
		session.close();
	}

}
