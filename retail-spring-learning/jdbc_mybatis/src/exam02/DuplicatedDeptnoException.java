package exam02;


// extends Exception 하면 예외처리가 가능하다.
public class DuplicatedDeptnoException extends Exception{

	public DuplicatedDeptnoException(String message) {
		super(message);
	}
}
