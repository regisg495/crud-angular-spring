package br.com.project.join.util.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class CategoryNameAlreadyExistsException extends DataIntegrityViolationException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNameAlreadyExistsException(String msg) {
        super(msg);
    }

}
