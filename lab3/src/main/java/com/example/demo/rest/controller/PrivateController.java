package com.example.demo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {
	
	@GetMapping("/private")
	public String privateMsg() {
		return "Mensagem privada apenas para usuarios com token!";
	}
	
	@GetMapping("/public")
	public String publicMsg() {
		return "Mensagem publica! Todos podem acessar!!";
	}

}
