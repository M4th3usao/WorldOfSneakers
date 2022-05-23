package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Calculadora;

import org.springframework.ui.Model;

@Controller
@ComponentScan("com.example.model")
public class FormController {
	
	@GetMapping("/calcsomar")
	public String formSoma(Model model) {
		model.addAttribute("calc", new Calculadora(0,0));
		return "formsoma";
	}
	
	@PostMapping("/calcsomar")
	public String calcularSoma(@ModelAttribute Calculadora calc
								, Model model) {
		int n1 = calc.getN1();
		int n2 = calc.getN2();
		int soma = n1+n2;
		model.addAttribute("resultado", soma);
		return "calcsoma";
	}
}
