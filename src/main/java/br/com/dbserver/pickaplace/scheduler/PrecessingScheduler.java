package br.com.dbserver.pickaplace.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Result;
import br.com.dbserver.pickaplace.service.ResultService;

@Component
public class PrecessingScheduler {
	
	private static final Logger LOGGER = LogManager.getLogger(PrecessingScheduler.class);	
    @Autowired
    private ResultService resultService;
    
    @Scheduled(cron = "0 30 11 * * *")
    public void processingVotes() {
    	Result result = null;
    	try {
			LOGGER.info("Start of vote processing.");
			result = this.resultService.votingProcessingResult();
			LOGGER.info(result.toString());
		} catch (BusinessException e) {
			LOGGER.error(e.getMessage());			
		} finally {
			LOGGER.info("End of vote processing.");
		}
    	
    }

}
