package exam03;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMybatisTest {
	public static void main(String[] args) {

		/*
		  1. 환경설정
	           - DB 설치: MySQL
	           - 설치된 DB 회사에서 제공한 라이브러리 필요 (드라이버라고 부른다,  *.jar )
			   - MyBatis 라이브러리 필요 ( *.jar )
			      mybatis.org
			      
	           - STS에서 *.jar 인식 ====> 빌드패스(build path)
	             mybatis-3.5.14.jar
	             mysql-connector-j-8.0.33.jar
	             
	      2. mysql(oracle) 연동시 4가지 정보 필요  
	         ==> 외부파일(properties)에서 저장하고  호출해서 사용
	         ==> 예> src 폴더에 패키지 형태로 저장 가능 ( jdbc.properties )  
	         
	      3. 2 개의 xml 파일 작성
	       ==> 예> src 폴더에 패키지 형태로 저장 가능
	       
	         가. 전반적인 DB 연동 관련 설정 파일
	       - Configuration.xml
	       - 4가지 작업
	          a. jdbc.properties 설정
	          b. jdbc.properties 정보 조회해서 설정
	          c. Mapper 등록
	          d. DTO 별칭
	          
	         나.  SQL 문 저장 파일 
	       - 테이블당 하나씩 생성
	       - 테이블명Mapper.xml 형식 권장
	              예> DeptMapper.xml
	      
	      4. DeptDTO 작성
	       ==> 테이블의 하나의 레코드 저장용
	      ==> MyBatis는 자동으로 DeptDTO에 저장해준다.
	                       필요시 List에 누적도 가능하다.
	        *****주의할점은 반드시 select 문장의 컬럼헤더값과
	        DTO 의  변수명과 일치해야 된다. (원래는 setter 메서드명과 일치)
	                   만약 일치 안되면 별칭으로 해결한다.
	        
	      5. Configuration.xml 불러오기
	     	
	     	==> 최종적으로 SqlSessionFactory 리턴한다.
	     
	      6. jdbc의 Connection 역할의 SqlSession 얻는다.
	        == > SqlSessionFactory 에서 SqlSession 얻는다.
	        
	      7. SqlSession의 메서드를 이용해서 Mapper의 태그 호출
	                    가. select 문
	          List<DeptDTO> list =  session.selectList("namespace.id값");
	          List<DeptDTO> list =  session.selectList("namespace.id값", 값); 
	           
	           
	          DeptDTO dto = session.selectOne("namespace.id값");
	          
	      8. SqlSession 닫기
	         session.close();
	   */	
		String resource = "exam03/Configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory =
		        new SqlSessionFactoryBuilder().build(inputStream);
		
		//SqlSession 얻기
		SqlSession session = sqlSessionFactory.openSession();
		
		//전체 목록 보기
		List<DeptDTO> list = session.selectList("exam03.DeptMapper2.findAll");
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("#########################");
		List<DeptDTO> list2 = session.selectList("findAllOrder");
		for (DeptDTO dto : list2) {
			System.out.println(dto);
		}
		System.out.println("#########################");
		//조건지정 1
		int search_deptno = 10;
		List<DeptDTO> list3 = 
				session.selectList("exam03.DeptMapper.findByDeptno", 
						search_deptno);
		for (DeptDTO dto : list3) {
			System.out.println(dto);
		}
		System.out.println("#########################");
		//조건지정 2
		DeptDTO xxx = new DeptDTO();
		xxx.setDname("개발");
		xxx.setLoc("부산");
		List<DeptDTO> list4 = 
				session.selectList("exam03.DeptMapper.findByDnameAndLoc", 
						xxx);
		for (DeptDTO dto : list4) {
			System.out.println(dto);
		}
		System.out.println("#########################");
		//조건지정 3
		HashMap<String, String> map=
				new HashMap<String, String>();
		map.put("xxx", "개발");
		map.put("yyy", "부산");
		List<DeptDTO> list5 = 
				session.selectList("exam03.DeptMapper.findByDnameAndLocHashMap", 
						map);
		for (DeptDTO dto : list5) {
			System.out.println(dto);
		}
		
		session.close();
	}//end main

}
