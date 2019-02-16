package br.com.unicesumar.aula01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CountService {

	public List<Integer> count(int start, int end) {
		List<Integer> numeros = new ArrayList<Integer>();
		
		for(int x = start ; x <= end ; x++) {
			numeros.add(x);
		}
		
		return numeros;
	}
	
	public List<String> apresentaPar(int start, int end){
		List<String> numeros = new ArrayList<String>();
		
		for(int x = start; x <= end; x++) {
			if(x % 2 == 0) {
				numeros.add(x + " é par");
			}else {
				numeros.add(x + " é impar");
			}
		}
		
		return numeros;
	}
}
