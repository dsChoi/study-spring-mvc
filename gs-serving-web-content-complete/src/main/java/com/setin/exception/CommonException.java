package com.setin.exception;

/**
 * @author choids
 *
 */
public class CommonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7434375347876288704L;
	private String message;

	public CommonException(String string) {
		setMessage(string);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
