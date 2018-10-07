package br.com.dbserver.pickaplace.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/checkingResult/{user}/{dateResult}", method = RequestMethod.GET)
	public ResponseEntity<Result> checkingResult(@RequestParam Date dateResult) throws BusinessException {
		Result resultReturn = null;
		
		resultReturn = this.resultService.checkingResult(dateResult);
				
		return ResponseEntity.ok(resultReturn);
	}

}
