package exam07;

import java.util.List;

public interface DeptMybatisService {
	public List<DeptDTO> findAll() ;
	
	public int save(DeptDTO dto)throws DuplicatedDeptnoException ;
	public int update(DeptDTO dto);
	public int remove(int deptno);
	public int updateAndRemove(DeptDTO dto, int deptno);
	
}

/*
    부모 메서드:         public void a() throws Exception{}
    
    
  자식 재정의 메서드:             void a()



  * 예외클래스
  *              Object
  *                 |
  *              Throwable
  *                 |
  *        Error(무시)                     Exception
                                             |
                        RuntimeException            IOException,SQLException
                          |                           |
                          NullPointerException       FileNotFoundException
                          ArrayIndexOutofBoundsEx~
                          ClassCastException
                          ...











*/