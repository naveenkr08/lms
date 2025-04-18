package com.infosys.lms.responsestructure;


public class ResponseStructure<T> {
   private int status;
   private String message;
   private T body;
     
   
public ResponseStructure() {
	super();
}
public ResponseStructure(int status, String message, T body) {
	super();
	this.status = status;
	this.message = message;
	this.body = body;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public T getBody() {
	return body;
}
public void setBody(T body) {
	this.body = body;
}
@Override
public String toString() {
	return "ResponseStructure [status=" + status + ", message=" + message + ", body=" + body + "]";
}
   
   
   
   
   
}

