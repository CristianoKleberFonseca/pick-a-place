package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.VoteDao;
import br.com.dbserver.pickaplace.model.Vote;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;
import br.com.dbserver.pickaplace.untils.DateUtil;

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
	public List<Vote> findAllVoteByDate(Date date) {
		List<Vote> listVotesReturn = null;

		listVotesReturn = voteBD.stream().filter(vote -> DateUtil.brazilianFormatDate(vote.getDateVoting()).equals(DateUtil.brazilianFormatDate(date))).collect(Collectors.toList());

		return listVotesReturn;
	}

	@Override
	public Vote employeeVoteOnDay(Date dateVote, Long idEmployee) {
		Vote voteReturn = null;

		voteReturn = voteBD.stream().filter((vote ->  DateUtil.brazilianFormatDate(vote.getDateVoting()).equals(DateUtil.brazilianFormatDate(dateVote))
				&& vote.getUser().getEmployee().getId().equals(idEmployee))).findAny().orElse(null);

		return voteReturn;
	}

}
