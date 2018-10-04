package br.com.dbserver.pickaplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Vote;
import br.com.dbserver.pickaplace.service.VoteService;

@RestController
@RequestMapping(value = "/api/votes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Vote> voting(@RequestBody Vote vote) throws BusinessException {
		Vote voteReturn = null;
		
		voteReturn = this.voteService.voting(vote);
		
		return ResponseEntity.ok(voteReturn);
	}
}
