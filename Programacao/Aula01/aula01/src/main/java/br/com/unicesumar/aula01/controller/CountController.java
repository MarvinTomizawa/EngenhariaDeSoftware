package br.com.unicesumar.aula01.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicesumar.aula01.service.CountService;

@RestController
@RequestMapping("/")
public class CountController {

	private CountService countService = new CountService();
	
	@GetMapping
	public String count() {
		List<Integer> numeros = countService.count(0,10);
		return numeros.toString();
	}
	
	@GetMapping
	public String countPar() {
		List<String> numeros = countService.apresentaPar(0,10);
		return numeros.toString();
	}
}
