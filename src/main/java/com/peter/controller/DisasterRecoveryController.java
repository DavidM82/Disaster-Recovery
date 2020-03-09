package com.peter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.peter.service.GenericService;

@Controller
public class DisasterRecoveryController {

	@Autowired
	GenericService service;
}
