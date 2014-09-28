package org.manu.cucumber.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public long add(final long num1, final long num2) {
		return num1 + num2;
	}

}
