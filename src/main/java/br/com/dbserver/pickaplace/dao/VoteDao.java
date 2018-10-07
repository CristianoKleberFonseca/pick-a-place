package br.com.dbserver.pickaplace.dao;

import java.util.Date;
import java.util.List;

import br.com.dbserver.pickaplace.model.Vote;

public interface VoteDao {
	
	public Vote voting(Vote vote);
	public List<Vote> findAllVoteByDate(Date date);
	public Vote employeeVoteOnDay(Date dateVote, Long idEmployee);
}
