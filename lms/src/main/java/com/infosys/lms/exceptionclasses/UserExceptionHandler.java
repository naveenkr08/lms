import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.lms.exceptionclasses.InValidUserIdException;
import com.infosys.lms.exceptionclasses.NoUserFoundException;
import com.infosys.lms.responsestructure.ResponseStructure;

import com.infosys.lms.exceptionclasses.NoUserFoundException;
import com.infosys.lms.responsestructure.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseStructure<String> noUserFoundExceptionHandle(NoUserFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();

		structure.setStatus(404);
		structure.setMessage("No  User Response");
		structure.setBody(e.getMessage());
		return structure;
	}

	@ExceptionHandler(InValidUserIdException.class)
	public ResponseStructure<String> noUserFoundExceptionHandle(InValidUserIdException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();

		structure.setStatus(404);
		structure.setMessage("No  User Response");
		structure.setBody(e.getMessage());
		return structure;
	}

}
public class UserExceptionHandler  {

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseStructure<String> noUserFoundExceptionHandle(NoUserFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();

		structure.setStatus(404);
		structure.setMessage("No  User Response");
		structure.setBody(e.getMessage());
		return structure;
	}

	@ExceptionHandler(InValidUserIdException.class)
	public ResponseStructure<String> noUserFoundExceptionHandle(InValidUserIdException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();

		structure.setStatus(404);
		structure.setMessage("No  User Response");
		structure.setBody(e.getMessage());
		return structure;
	}

}