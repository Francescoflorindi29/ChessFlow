package it.univaq.lpo.chessflow.errors;

import java.util.function.Supplier;

public class BusinessException extends Exception {
	
	public static void withExceptionThrownAsBusiness(Runnable block) throws BusinessException {
		try {
			block.run();
		} catch (Exception innerException) {
			throw new BusinessException(innerException);
		}
	}
	
	public static <T> T withExceptionThrownAsBusiness(Supplier<T> block) throws BusinessException {
		try {
			return block.get();
		} catch (Exception innerException) {
			throw new BusinessException(innerException);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
