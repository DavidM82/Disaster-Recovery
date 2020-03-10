package com.peter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peter.bean.TimeCardBean;

import com.peter.model.TimeCard;
import com.peter.service.GenericService;

@Controller
public class DisasterRecoveryController {

	@Autowired
	@Qualifier("jobCodeService")
	private GenericService jobService;
	
	@Autowired
	@Qualifier("machineCodeService")
	private GenericService machineService;
	
	@Autowired
	@Qualifier("timeCardService")
	private GenericService timeService;
	
	@RequestMapping(value = "/saveTimeCard", method = RequestMethod.POST)
	public ModelAndView saveTimeCard(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		TimeCard timeCard = prepareTimeCard(timeCardBean);
		timeService.add(timeCard);
		return new ModelAndView("redirect:/add.html");
	}
	
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/timecards", method = RequestMethod.GET)
	public ModelAndView listTimeCards() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timecards", prepareTimeCardBeans(timeService.getAll()));
		return new ModelAndView("timecardList", model);
	}
	
	@RequestMapping(value="/removeTimeCard", method = RequestMethod.GET)
	public ModelAndView deleteTimeCard(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		timeService.delete(timeCardBean.getTimeCodeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timecard", null);
		model.put("timecards", prepareTimeCardBeans(timeService.getAll()));
		
		return new ModelAndView("index", model);
	}
	
	private TimeCard prepareTimeCard(TimeCardBean timeCardBean){
		TimeCard timecard = new TimeCard();
		timecard.setApproval(timeCardBean.getApproval());
		timecard.setContractorName(timeCardBean.getContractorName());
		timecard.setSiteCode(timeCardBean.getSiteCode());
		timecard.setTimeCardId(timeCardBean.getTimeCodeId());
		timecard.setTotalAmount(timeCardBean.getTotalAmount());
		timecard.setTotalHours(timeCardBean.getTotalHours());
		return timecard;
	}
	
	private TimeCardBean prepareTimeCardBean(TimeCard timeCard) {
		TimeCardBean bean = new TimeCardBean();
		bean.setApproval(timeCard.getApproval());
		bean.setContractorName(timeCard.getContractorName());
		bean.setSiteCode(timeCard.getSiteCode());
		bean.setTimeCodeId(timeCard.getTimeCardId());
		bean.setTotalAmount(timeCard.getTotalAmount());
		bean.setTotalHours(timeCard.getTotalHours());
		return bean;
	}
	
	private List<TimeCardBean> prepareTimeCardBeans(List<Object> timecards){
		List<TimeCardBean> timecardBeans = null;
		
		if (!timecards.isEmpty() && timecards != null) {
			timecardBeans = new ArrayList<TimeCardBean>();
			for (Object t: timecards) {
				if (t instanceof TimeCard) {
					TimeCardBean tb = prepareTimeCardBean( (TimeCard) t);
					timecardBeans.add(tb);					
				} else {
					System.out.println("Object in prepareTimeCardBeans is not a TimeCard: " + t.toString());
				}

			}
		}
		return timecardBeans; 
	}
}
