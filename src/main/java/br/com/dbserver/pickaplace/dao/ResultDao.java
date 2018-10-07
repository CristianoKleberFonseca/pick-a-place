package br.com.dbserver.pickaplace.dao;

import br.com.dbserver.pickaplace.model.Result;

public interface ResultDao {
	
	public Result saveResult(Result result);
	public Result checkingResult(Integer monthResult, Integer yearResult, Integer weekOfMonth);
	public Result findResulByWeek(Integer monthResult, Integer yearResult, Integer weekOfMonth, String restaurantName);
	public Result findResulByWeek(Integer monthResult, Integer yearResult, Integer weekOfMonthResult);
}
