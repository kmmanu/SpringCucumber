package org.manu.cucumber.web;

import org.manu.cucumber.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/calculator")
public class CalculatorController {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	private CalculatorService calculator;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public Long add(@RequestParam(value="num1") final long num1, @RequestParam(value="num2") final long num2) {
		return this.calculator.add(num1, num2);
	}

}
