package com.filehandler.exception;

public class FileException extends RuntimeException {
	
	
	private static final long serialVersionUID = 97986623432L;

	public FileException() {
		super();
	}
	
	public FileException(String msg) {
		super(msg);
	}
	
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
