package exam04;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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
		 * List<DeptDTO> list = session.selectList("namespace.id 값"); 메서드가 있고
		 * List<DeptDTO> list = session.selectOne("namespace.id 값", 파라미터 값); 메서드가 있다. where 조건문에 사용된다.
		 * List<DeptDTO> list = session.selectList("namespace.id 값", 파라미터 값, new RowBounds(시작값, 갯수));
		 * List<DeptDTO> list = session.selectList("id값"); DeptDTO dto =
		 * session.selectOne("id값");
		 * 
		 * 
		 * 8. SqlSession 닫기 session.close();
		 */

		String resource = "exam04/Configuration.xml";
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

		// 전체 목록 보기
		List<DeptDTO> list = session.selectList("exam04.DeptMapper.findAll");
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println();

		List<DeptDTO> list2 = session.selectList("findAllOrder");
		for (DeptDTO dto : list2) {
			System.out.println(dto);
		}
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println();

		// 페이징 처리
//		List<DeptDTO> list = session.selectList("id값"); DeptDTO dto =
//				 * session.selectOne("id값");
		// offset은 0부터 시작한다.
		List<DeptDTO> list3 = session.selectList("exam04.DeptMapper.findAllPage", null,
				new RowBounds(0,3));
		for (DeptDTO dto : list3) {
			System.out.println(dto);
		}
		
		
		session.close();
	}

}
