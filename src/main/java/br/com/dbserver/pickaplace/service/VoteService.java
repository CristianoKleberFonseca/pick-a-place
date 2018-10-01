package br.com.dbserver.pickaplace.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.VoteDao;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.Vote;

@Service
public class VoteService {
	
	@Autowired
	private VoteDao voteDao;

	public Vote voting(Vote vote) {
		Vote voteReturn = null;
		voteReturn = this.voteDao.voting(vote);
		return voteReturn;		
	}

	public Restaurant resultVoting(Date dateResult)  {
		Restaurant restaurantReturn = null;
		
		return restaurantReturn;		
	}

}
