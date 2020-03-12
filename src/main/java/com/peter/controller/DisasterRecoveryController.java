package com.peter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peter.bean.JobCodeBean;
import com.peter.bean.MachineCodeBean;
import com.peter.bean.TimeCardBean;

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
	public ModelAndView welcome() {
		System.out.println("Welcome");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/jobCodes.html");
		return mav;
	}
	
	@RequestMapping(value = "/saveTimeCard", method = RequestMethod.POST)
	public ModelAndView saveTimeCard(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		TimeCard timeCard = prepareTimeCard(timeCardBean);
		timeService.add(timeCard);
		return new ModelAndView("redirect:/timecardstatus");
	}
	
	@RequestMapping(value="/timecards", method = RequestMethod.GET)
	public ModelAndView listTimeCards() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timecards", prepareTimeCardBeans(timeService.getAll()));
		return new ModelAndView("Contractor/timecardstatus", model);
	}
	
	@RequestMapping(value="/removeTimeCard", method = RequestMethod.GET)
	public ModelAndView deleteTimeCard(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		timeService.delete(timeCardBean.getTimeCodeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timecard", null);
		model.put("timecards", prepareTimeCardBeans(timeService.getAll()));
		
		return new ModelAndView("timecardapp", model);
	}
	
	@RequestMapping(value="/timecard", method = RequestMethod.GET)
	public ModelAndView editTimeCard(@ModelAttribute("command") TimeCardBean timeCardBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timecard", prepareTimeCardBean(timeService.get(timeCardBean.getTimeCodeId())));
		model.put("timecards", prepareTimeCardBeans(timeService.getAll()));
		return new ModelAndView("/Admin/timecardapp", model);
	}
	
	@RequestMapping(value="/machinecode", method = RequestMethod.POST)
	public ModelAndView saveMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		MachineCode machineCode = prepareMachineCode(machineCodeBean);
		machineService.add(machineCode);
		return new ModelAndView("redirect:/machinecodemgt");
	}
	
	@RequestMapping(value="/machinecodes", method = RequestMethod.GET)
	public ModelAndView listMachineCodes() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("machinecodes", prepareMachineCodeBeans(machineService.getAll()));
		return new ModelAndView("redirect:/machinecodemgt", model);
	}
	
	@RequestMapping(value="/removeMachineCode", method = RequestMethod.GET)
	public ModelAndView removeMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		machineService.delete(machineCodeBean.getMachineCodeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("machineCode", null);
		model.put("machineCodes", prepareMachineCodeBeans(machineService.getAll()));
		return new ModelAndView("redirect:/machinecodemgt", model);
	}
	
	@RequestMapping(value="/editMachineCode", method = RequestMethod.GET)
	public ModelAndView editMachineCode(@ModelAttribute("command") MachineCodeBean machineCodeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("machineCode", prepareMachineCode(machineCodeBean));
		model.put("machineCodes", prepareMachineCodeBeans(machineService.getAll()));
		return new ModelAndView("/Admin/machinecodemgt", model);
	}
	
	@RequestMapping(value="/addnewJobCode", method = RequestMethod.GET)
	public ModelAndView switchToJobCodeForm(@ModelAttribute("command") JobCodeBean jobCodeBean, BindingResult result) {
		JobCode jobCode = new JobCode();
		ModelAndView mav = new ModelAndView();
		System.out.println("new JobCode");
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
	
	private JobCodeBean prepareJobCodeBean(JobCode jobCode) {
		JobCodeBean jobCodeBean = new JobCodeBean();
		jobCodeBean.setDescription(jobCode.getDescription());
		jobCodeBean.setHourlyRate(jobCode.getHourlyRate());
		jobCodeBean.setJobCodeId(jobCode.getJobCodeId());
		jobCodeBean.setJobCode(jobCode.getJobCode());
		jobCodeBean.setMaxHours(jobCode.getMaxHours());
		return jobCodeBean;
	}
	
	private List<JobCodeBean> prepareJobCodeBeans(List<Object> objects){
		List<JobCodeBean> jobCodeBeans = null;
		if (!objects.isEmpty() && objects != null) {
			jobCodeBeans = new ArrayList<JobCodeBean>();
			for (Object j: objects) {
				if (j instanceof JobCode) {
					JobCodeBean jb = prepareJobCodeBean((JobCode) j);
					jobCodeBeans.add(jb);					
				} else {
					System.out.println("object in prepareJobCodeBeans was not JobCode object");
					System.out.println(j.toString());
					return null;
				}

			}
		} 
		return jobCodeBeans;
	}

	private List<MachineCodeBean> prepareMachineCodeBeans(List<Object> objects){
		List<MachineCodeBean> machineCodeBeans = null;
		if (!objects.isEmpty() && objects !=null) {
			machineCodeBeans = new ArrayList<MachineCodeBean>();
			for (Object m: objects) {
				if (m instanceof MachineCode) {
					MachineCodeBean mb = prepareMachineCodeBean((MachineCode) m);
					machineCodeBeans.add(mb);
				} else {
					System.out.println("object in prepareMachineCodeBeans was not MachineCode object.");
					System.out.println(m.toString());
					return null;
				}
			}
		}
		return machineCodeBeans;
	}
	
	private MachineCodeBean prepareMachineCodeBean(MachineCode machineCode) {
		MachineCodeBean machineCodeBean = new MachineCodeBean();
		machineCodeBean.setDescription(machineCode.getDescription());
		machineCodeBean.setHourlyRate(machineCode.getHourlyRate());
		machineCodeBean.setMachineCodeId(machineCode.getMachineCodeId());
		machineCodeBean.setMaxHours(machineCode.getMaxHours());
		return machineCodeBean;
	}
	
	private MachineCode prepareMachineCode(MachineCodeBean machineCodeBean) {
		MachineCode machineCode = new MachineCode();
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
		timecard.setTimeCardId(timeCardBean.getTimeCodeId());
		timecard.setTotalAmount(timeCardBean.getTotalAmount());
		timecard.setTotalHours(timeCardBean.getTotalHours());
		return timecard;
	}
	
	private TimeCardBean prepareTimeCardBean(Object timecard) {
		TimeCardBean bean = new TimeCardBean();
		if (timecard instanceof TimeCard) {
			TimeCard timeCard = (TimeCard) timecard;
			bean.setApproval(timeCard.getApproval());
			bean.setContractorName(timeCard.getContractorName());
			bean.setSiteCode(timeCard.getSiteCode());
			bean.setTimeCodeId(timeCard.getTimeCardId());
			bean.setTotalAmount(timeCard.getTotalAmount());
			bean.setTotalHours(timeCard.getTotalHours());
			return bean;			
		} else {
			System.out.println("prepareTimeCardBean recieved object that's not a TimeCard.");
			System.out.println(timecard.toString());
			return null;
		}
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
