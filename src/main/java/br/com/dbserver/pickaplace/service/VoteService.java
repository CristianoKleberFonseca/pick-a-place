package br.com.dbserver.pickaplace.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.VoteDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.User;
import br.com.dbserver.pickaplace.model.Vote;
import br.com.dbserver.pickaplace.untils.DateUtil;

@Service
public class VoteService {

	@Autowired
	private VoteDao voteDao;
	@Autowired
	private UserService userService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ResultService resultService;

	public Vote voting(Vote vote) throws BusinessException {
		Vote voteReturn = null;
		Integer monthVote = null;
		Integer yearVote = null;
		Integer weekOfMonthVote = null;
		Boolean isRestaurantChosenInWeek = null;
		User userSelected = null;
		Restaurant restaurantSelected = null;
		
		//Verificar se o voto está fora do período elegível.
		if(DateUtil.isAfterHours(new Date())) {
			throw new BusinessException("Voting after hours.");
		}
		
		// Verificar se usuário foi informada.
		if (vote.getUser() == null || vote.getUser().getUserName() == null || vote.getUser().getUserName() == null) {
			throw new BusinessException("User no informed.");
		}
		
		userSelected = this.userService.login(vote.getUser().getUserName(), vote.getUser().getPassword());
		if (userSelected == null) {
			throw new BusinessException("Username or password invalid.");
		}

		// Verificar se a data da votação foi informada.
		if (vote.getRestaurant() == null || vote.getRestaurant().getId() == null) {
			throw new BusinessException("Restaurant no informed.");
		}
		//Verificar se os votos já foram processados. 
		this.resultService.checkingResultProcessed(new Date());
		
		restaurantSelected = this.restaurantService.findRestaurantById(vote.getRestaurant().getId());
		
		vote.setDateVoting(new Date());
		vote.setUser(userSelected);
		vote.setRestaurant(restaurantSelected);
		
		weekOfMonthVote = DateUtil.getWeekOfMonth(vote.getDateVoting());
		monthVote = DateUtil.getMonth(vote.getDateVoting());
		
		Vote voteOfDay = this.voteDao.employeeVoteOnDay(vote.getDateVoting(), vote.getUser().getEmployee().getId());
		// ESTORIA 1 - Um profissional só poderá votar em um restaurante por dia.
		if (voteOfDay != null) {
			throw new BusinessException("You already voted today.");
		}
		// ESTORIA 2 - O mesmo restaurante não pode ser escolhido mais de uma vez durante a semana.
		isRestaurantChosenInWeek = this.resultService.isRestaurantChosenInWeek(monthVote, yearVote, weekOfMonthVote,
				vote.getRestaurant().getName());
		if (Boolean.TRUE.equals(isRestaurantChosenInWeek)) {
			throw new BusinessException(
					String.format("The restaurant %s already choose this week.", vote.getRestaurant().getName()));
		}

		voteReturn = this.voteDao.voting(vote);

		return voteReturn;
	}
	
	public List<Vote> findAllVoteByDate(Date date) {
		List<Vote> listVotesReturn = null;
		
		listVotesReturn = this.voteDao.findAllVoteByDate(date);
		
		return listVotesReturn;
	}
}
