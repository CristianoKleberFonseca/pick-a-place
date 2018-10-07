package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.ResultDao;
import br.com.dbserver.pickaplace.model.Result;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class ResultDaoImpl implements ResultDao {
	private static List<Result> resultBD;

	static {
		resultBD = new ArrayList<Result>();
	}

	@Override
	public Result saveResult(Result result) {
		result.setId(DataBaseUntil.generateID());
		resultBD.add(result);
		
		return result;
	}

	@Override
	public Result checkingResult(Integer monthResult, Integer yearResult, Integer weekOfMonthResult) {
		Result resultReturn = null;

		resultReturn = resultBD.stream()
				.filter((result -> result.getMonthResult().equals(monthResult)
						&& result.getWeekOfMonthResult().equals(weekOfMonthResult)
						&& result.getYearResult().equals(yearResult)))
				.findAny().orElse(null);

		return resultReturn;
	}

	@Override
	public Result findResulByWeek(Integer monthResult, Integer yearResult, Integer weekOfMonthResult, String restaurantName) {
		Result resultReturn = null;

		resultReturn = resultBD.stream()
				.filter((result -> result.getMonthResult().equals(monthResult)
						&& result.getWeekOfMonthResult().equals(weekOfMonthResult)
						&& result.getRestaurant().getName().equals(restaurantName)))
				.findAny().orElse(null);

		return resultReturn;
	}

	@Override
	public Result findResulByWeek(Integer monthResult, Integer yearResult, Integer weekOfMonthResult) {
		Result resultReturn = null;

		resultReturn = resultBD.stream()
				.filter((result -> result.getMonthResult().equals(monthResult)
						&& result.getWeekOfMonthResult().equals(weekOfMonthResult)))
				.findAny().orElse(null);

		return resultReturn;
	}
}
