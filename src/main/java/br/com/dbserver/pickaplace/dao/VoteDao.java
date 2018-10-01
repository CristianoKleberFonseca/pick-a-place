package br.com.dbserver.pickaplace.dao;

import java.util.Date;
import java.util.Map;

import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.Vote;

public interface VoteDao {
	
	public Vote voting(Vote vote);
	
	public Map<Restaurant, Integer> resultVoting(Date dateResult);

}
