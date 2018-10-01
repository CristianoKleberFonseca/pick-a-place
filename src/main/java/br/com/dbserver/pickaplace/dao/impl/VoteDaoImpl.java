package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.VoteDao;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.Vote;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class VoteDaoImpl implements VoteDao {

	private static List<Vote> voteBD;
	
	static {
		voteBD = new ArrayList<Vote>();
	}

	@Override
	public Vote voting(Vote vote) {
		vote.setId(DataBaseUntil.generateID());
		voteBD.add(vote);
		
		return vote;
	}

	@Override
	public Map<Restaurant, Integer> resultVoting(Date dateResult) {
		return null;
	}

}
