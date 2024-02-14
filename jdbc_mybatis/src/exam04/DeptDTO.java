package exam04;


// dept 테이블의 하나의 레코드 저장용
public class DeptDTO {

	 int no;  // 실제 컬럼명: deptno
	 String name;  //실제 컬럼명: dname
	 String location; // 실제컬럼명: loc
	 
	public DeptDTO() {
	}

	public DeptDTO(int no, String name, String location) {
		this.no = no;
		this.name = name;
		this.location = location;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "DeptDTO [no=" + no + ", name=" + name + ", location=" + location + "]";
	}
	 
	 
	
}
