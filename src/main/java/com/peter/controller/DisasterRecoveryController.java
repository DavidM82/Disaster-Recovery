package com.peter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peter.bean.JobCodeBean;
import com.peter.bean.MachineCodeBean;
import com.peter.bean.TimeCardBean;
import com.peter.bean.UserBean;
import com.peter.model.JobCode;
import com.peter.model.MachineCode;
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
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome(@ModelAttribute("command") UserBean userbean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject(userbean);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView logIn(@ModelAttribute("command") UserBean userbean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		//user admin password root, user con pwd con
		String user = userbean.getUsername();
		String pwd = userbean.getPassword();
		if (user.equals("admin") && pwd.equals("root")) {
			System.out.println("hello admin");
			mav.setViewName("redirect:/jobCodes.html");
		} else if (user.equals("con") && pwd.equals("con")) {
			System.out.println("hello Con");
			mav.setViewName("redirect:/timecardsCon.html");
		} else {
			System.out.println("Incorrect login");
			mav.setViewName("badlogin");
		}
		return mav;
	}
	
	@RequestMapping(value = "/savetimecardAdmin", method = RequestMethod.POST)
	public ModelAndView saveTimeCardAdmin(@ModelAttribute("command") TimeCard timeCard, BindingResult result) {
		timeService.add(timeCard);
		return new ModelAndView("redirect:/machineCodes.html");
	}
	
	@RequestMapping(value="/timecardsAdmin", method = RequestMethod.GET)
	public ModelAndView showTimeCardsAdmin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeCards", timeService.getAll());
		mav.setViewName("timecardmgt");
		return mav;
	}
		
	@RequestMapping(value="/timecardAdmin", method = RequestMethod.GET)
	public ModelAndView editTimeCard(@ModelAttribute("command") TimeCard timeCard, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeCard", timeCard);
		mav.setViewName("timecardapproval");
		return mav;
	}
	
	@RequestMapping(value="/timecardsCon", method = RequestMethod.GET)
	public ModelAndView showTimeCardsContractor() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeCards", timeService.getAll());
		mav.setViewName("timecardscon");
		return mav;
	}
	
	@RequestMapping(value="/timecardCon", method = RequestMethod.GET)
	public ModelAndView showTimeCardContractor(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		TimeCard timeCard = new TimeCard();
		mav.setViewName("timecardform");
		mav.addObject("timeCard", timeCard);
		mav.addObject("jobCodes", jobService.getAll());
		mav.addObject("machineCodes", machineService.getAll());
		return mav;
	}
	
	@RequestMapping(value="/savetimecardCon", method = RequestMethod.POST)
	public ModelAndView saveTimeCardContractor(@ModelAttribute("command") TimeCard timeCard, BindingResult result) {
		timeService.add(timeCard);
		return new ModelAndView("redirect:/timecardsCon.html");
	}
	
	@RequestMapping(value = "/addnewMachineCode", method = RequestMethod.GET)
	public ModelAndView switchtoMachineCodeForm(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		MachineCode machineCode = new MachineCode();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/machinecodeform");
		mav.addObject("machineCode", machineCode);
		return mav;
	}
	
	@RequestMapping(value="/machineCode", method = RequestMethod.POST)
	public ModelAndView saveMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		MachineCode machineCode = prepareMachineCode(machineCodeBean);
		machineService.add(machineCode);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/machineCodes.html");
		return mav;
	}
	
	@RequestMapping(value="/machineCodes", method = RequestMethod.GET)
	public ModelAndView listMachineCodes() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("machineCodes", machineService.getAll());
		mav.setViewName("machinecodemgt");
		return mav;
	}
	
	@RequestMapping(value="/removeMachineCode", method = RequestMethod.GET)
	public ModelAndView removeMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		machineService.delete(machineCodeBean.getMachineCodeId());
		return new ModelAndView("redirect:/machineCodes.html");
	}
	
	@RequestMapping(value="/editMachineCode", method = RequestMethod.GET)
	public ModelAndView editMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("machineCode", machineService.get(machineCodeBean.getMachineCodeId()));
		mav.setViewName("machinecodeform");
		return mav;
	}
	
	@RequestMapping(value="/addnewJobCode", method = RequestMethod.GET)
	public ModelAndView switchToJobCodeForm(@ModelAttribute("command") JobCodeBean jobCodeBean, BindingResult result) {
		JobCode jobCode = new JobCode();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jobcodeform");
		mav.addObject("jobCode", jobCode);
		return mav;
	}
	
	@RequestMapping(value="/jobCode", method = RequestMethod.POST)
	public ModelAndView saveJobCode(@ModelAttribute("command") JobCodeBean jobCodeBean, BindingResult result) {
		JobCode jobCode = prepareJobCode(jobCodeBean);
		jobService.add(jobCode);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/jobCodes.html");
		return mav;
	}
	
	@RequestMapping(value="/jobCodes", method = RequestMethod.GET)
	public ModelAndView listJobCodes() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("jobCodes", jobService.getAll());
		mav.setViewName("jobcodemgt");
		return mav;
	}
	
	@RequestMapping(value="/removeJobCode", method = RequestMethod.GET)
	public ModelAndView removeJobCode(@ModelAttribute("commmand") JobCodeBean jobCodeBean, BindingResult result) {
		jobService.delete(jobCodeBean.getJobCodeId());
		
		return new ModelAndView("redirect:/jobCodes.html");
	}
	
	@RequestMapping(value ="/editJobCode", method = RequestMethod.GET)
	public ModelAndView editJobCode(@ModelAttribute("command") JobCodeBean jobCodeBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("jobCode", jobService.get(jobCodeBean.getJobCodeId()) );
		mav.setViewName("jobcodeform");
		return mav;
	}
	
	private JobCode prepareJobCode(JobCodeBean jobCodeBean) {
		JobCode jobCode = new JobCode();
		jobCode.setDescription(jobCodeBean.getDescription());
		jobCode.setHourlyRate(jobCodeBean.getHourlyRate());
		jobCode.setJobCodeId(jobCodeBean.getJobCodeId());
		jobCode.setMaxHours(jobCodeBean.getMaxHours());
		jobCode.setJobCode(jobCodeBean.getJobCode());
		return jobCode;
	}
	
	private MachineCode prepareMachineCode(MachineCodeBean machineCodeBean) {
		MachineCode machineCode = new MachineCode();
		machineCode.setMachineCode(machineCodeBean.getMachineCode());
		machineCode.setDescription(machineCodeBean.getDescription());
		machineCode.setHourlyRate(machineCodeBean.getHourlyRate());
		machineCode.setMachineCodeId(machineCodeBean.getMachineCodeId());
		machineCode.setMaxHours(machineCodeBean.getMaxHours());
		return machineCode;
	}
	
	private TimeCard prepareTimeCard(TimeCardBean timeCardBean){
		TimeCard timecard = new TimeCard();
		timecard.setApproval(timeCardBean.getApproval());
		timecard.setContractorName(timeCardBean.getContractorName());
		timecard.setSiteCode(timeCardBean.getSiteCode());
		timecard.setTimeCardId(timeCardBean.getTimeCardId());
		timecard.setTotalAmount(timeCardBean.getTotalAmount());
		timecard.setTotalHours(timeCardBean.getTotalHours());
		return timecard;
	}
	
}
