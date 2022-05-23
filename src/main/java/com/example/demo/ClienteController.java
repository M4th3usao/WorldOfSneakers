package com.example.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Cliente;
import com.example.model.ClienteService;


@Controller
@ComponentScan("com.example.model")
public class ClienteController {
	
	@Autowired
	private ApplicationContext context;
	
	
	@GetMapping("/cliente")
	public String formcli(Model model) {
		model.addAttribute("cli", new Cliente(0, "",""));
		return "formcli";
	}
	
	@PostMapping("/cliente")
	public String inserircli(@ModelAttribute Cliente cli) {
		ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
		return "sucesso";
	}
}
