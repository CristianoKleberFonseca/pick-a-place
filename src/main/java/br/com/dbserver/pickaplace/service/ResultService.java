package br.com.dbserver.pickaplace.service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.ResultDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.Result;
import br.com.dbserver.pickaplace.model.Vote;
import br.com.dbserver.pickaplace.untils.DateUtil;

@Service
public class ResultService {
	@Autowired
	private ResultDao resultDao;
	@Autowired
	private VoteService voteService;
	@Autowired
	private RestaurantService restaurantService;

	public Result votingProcessingResult() throws BusinessException {
		Result resultReturn = new Result();
		Date dateResult = new Date();
		Restaurant restaurant = null;
		Map<Long, Integer> resultDaily = null;
		Long key = null;
		Integer value, monthResult, yearResult, weekOfMonthResult = null;
		
		monthResult = DateUtil.getMonth(dateResult); 
		yearResult = DateUtil.getYear(dateResult);
		weekOfMonthResult = DateUtil.getWeekOfMonth(dateResult);

		if(this.resultDao.findResulByWeek(monthResult, yearResult, weekOfMonthResult) != null) {
			throw new BusinessException(String.format("Result of day %s already processed.", DateUtil.brazilianFormatDate(dateResult)));
		}
		resultDaily = this.processResultDaily(dateResult);
		value = Collections.max(resultDaily.values());
		key = this.getKeyByValue(resultDaily, value);
		restaurant = this.restaurantService.findRestaurantById(key);
		
		resultReturn.setMonthResult(monthResult);
		resultReturn.setYearResult(yearResult);
		resultReturn.setWeekOfMonthResult(weekOfMonthResult);
		resultReturn.setProcessingDateResult(dateResult);
		resultReturn.setRestaurant(restaurant);
		resultReturn.setQuantityVotes(value);

		this.resultDao.saveResult(resultReturn);

		return resultReturn;
	}

	public Result checkingResult(Date dateResult) throws BusinessException {
		Result resultReturn = null;
		Integer monthResult = null;
		Integer yearResult = null;
		Integer weekOfMonth = null;

		// Validar se a data foi informada.
		if (dateResult == null) {
			throw new BusinessException("Processing date no informed.");
		}

		monthResult = DateUtil.getMonth(dateResult);
		yearResult = DateUtil.getYear(dateResult);
		weekOfMonth = DateUtil.getWeekOfMonth(dateResult);
		resultReturn = this.resultDao.checkingResult(monthResult, yearResult, weekOfMonth);
		// Validar se o processamento foi realizado.
		if (resultReturn == null) {
			throw new BusinessException(String.format("Processing of day %s no realized so far.",
					DateUtil.brazilianFormatDate(dateResult)));
		}

		return resultReturn;
	}

	public Boolean isRestaurantChosenInWeek(Integer monthResult, Integer yearResult, Integer weekOfMonth,
			String restaurantName) {
		Boolean isChosenResult = false;
		Result resultWeek = null;

		resultWeek = this.resultDao.findResulByWeek(monthResult, yearResult, weekOfMonth, restaurantName);

		if (resultWeek != null) {
			isChosenResult = true;
		}

		return isChosenResult;
	}

	private Map<Long, Integer> processResultDaily(Date dateVoting) throws BusinessException {
		Map<Long, Integer> processResulDailyReturn = null;
		List<Vote> voteDailyProcessed = null;

		voteDailyProcessed = this.voteService.findAllVoteByDate(dateVoting);
		if(voteDailyProcessed == null || voteDailyProcessed.isEmpty()) {
			throw new BusinessException("Don't have vote registry for today.");			
		}
		processResulDailyReturn = this.generateResult(voteDailyProcessed);

		return processResulDailyReturn;
	}

	private Map<Long, Integer> generateResult(List<Vote> listVotes) {
		Map<Long, Integer> mapGenerate = new HashMap<Long, Integer>();
		Map<Long, Integer> sortedMapGenerateResult = new HashMap<Long, Integer>();

		listVotes.forEach((Vote vote) -> {
			if (mapGenerate.get(vote.getRestaurant().getId()) == null) {
				mapGenerate.put(vote.getRestaurant().getId(), 1);
			} else {
				mapGenerate.computeIfPresent(vote.getRestaurant().getId(), (k, v) -> v + 1);
			}
		});

		sortedMapGenerateResult = mapGenerate.entrySet().stream()
				.sorted((value1, value2) -> Integer.compare(value1.getValue(), value2.getValue())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value2, LinkedHashMap::new));

		return sortedMapGenerateResult;
	}

	private Long getKeyByValue(final Map<Long, Integer> map, final Integer value) {
		Long keyReturn = null;

		keyReturn = map.entrySet().stream().filter(e -> e.getValue().equals(value)).findFirst().map(Map.Entry::getKey)
				.orElse(null);

		return keyReturn;
	}
}
