package br.com.dbserver.pickaplace.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dbserver.pickaplace.untils.DateUtil;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> validateError(ConstraintViolationException ex) {
		ErrorDetailJson errorDetailJson = new ErrorDetailJson();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.USA_FORMAT);
		
		errorDetailJson.setDate(simpleDateFormat.format(date));
		errorDetailJson.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDetailJson.setTitle("BAD REQUEST");
		errorDetailJson.setDetail(ex.getMessage());
		
		return new ResponseEntity<>(errorDetailJson, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherErrors(Exception ex) {
		
		ErrorDetailJson errorDetailJson = new ErrorDetailJson();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.USA_FORMAT);
		
		errorDetailJson.setDate(simpleDateFormat.format(date));
		errorDetailJson.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetailJson.setTitle("INTERNAL SERVER ERROR");
		errorDetailJson.setDetail(ex.getMessage());
		
		return new ResponseEntity<>(errorDetailJson, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
