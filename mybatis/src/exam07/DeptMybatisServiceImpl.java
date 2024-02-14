package exam07;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeptMybatisServiceImpl implements DeptMybatisService {
	static SqlSessionFactory sqlSessionFactory = null;

	static {
		// 초기화해야하는 작업들

		String resource = "exam07/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	// 기능 처리
	@Override
	public List<DeptDTO> findAll() {
		List<DeptDTO> list = null;

		// mybatis - 템플릿 코드
		/*
		 * SqlSession session = sqlSessionFactory.openSession(); try { } finally {
		 * session.close(); }
		 */
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMybatisDAO dao = new DeptMybatisDAO();
			list = dao.findAll(session);

		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int save(DeptDTO dto) throws DuplicatedDeptnoException {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMybatisDAO dao = new DeptMybatisDAO();
			n = dao.save(session, dto);
			session.commit();
		} catch (Exception e) { // java.sql.SQLIntegrityConstraintViolationException 예외처
			throw new DuplicatedDeptnoException(dto.getDeptno() + "값이 중복되어 예외 발생 ~ ");
		} finally {
			session.close();
		}

		return n;
	}

	@Override
	public int update(DeptDTO dto) {
		int n = 0;

		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMybatisDAO dao = new DeptMybatisDAO();
			n = dao.update(session, dto);
			session.commit();
		} finally {
			session.close();
		}

		return n;
	}

	@Override
	public int remove(int deptno) {
		int n = 0;

		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMybatisDAO dao = new DeptMybatisDAO();
			n = dao.remove(session, deptno);
			session.commit();
		} finally {
			session.close();
		}

		return n;
	}

	@Override
	public int updateAndRemove(DeptDTO dto, int deptno) {
		int n = 0;

		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMybatisDAO dao = new DeptMybatisDAO();

			// 수정할 작업
			int a = dao.update(session, dto);

			// 삭제할 작업
			int b = dao.remove(session, deptno);

			n = a + b;
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}

		return 0;
	}

}
