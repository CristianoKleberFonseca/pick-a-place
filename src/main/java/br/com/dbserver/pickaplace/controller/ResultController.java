package br.com.dbserver.pickaplace.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Result;
import br.com.dbserver.pickaplace.service.ResultService;

@RestController
@RequestMapping(value = "/api/resutls", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	@RequestMapping(value = "/votingProcessingResult", method = RequestMethod.GET)
	public ResponseEntity<Result> votingProcessingResult() throws BusinessException {
		Result processingReturn = null;
		
		processingReturn = this.resultService.votingProcessingResult();
				
		return ResponseEntity.ok(processingReturn);
	}
	
	@RequestMapping(value = "/checkingResult/{dateResult}", method = RequestMethod.GET)
	public ResponseEntity<Result> checkingResult(@PathVariable("dateResult") @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss") Date dateResult) throws BusinessException {
		Result resultReturn = null;
		
		resultReturn = this.resultService.checkingResult(dateResult);
				
		return ResponseEntity.ok(resultReturn);
	}

}
