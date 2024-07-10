package br.com.project.join.util.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class FieldValueAlreadyExistsException extends DataIntegrityViolationException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldValueAlreadyExistsException(String msg) {
        super(msg);
    }

}
