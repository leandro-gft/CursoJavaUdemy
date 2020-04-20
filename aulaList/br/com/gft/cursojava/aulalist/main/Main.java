package br.com.gft.cursojava.aulalist.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
	
	List<String> list = new ArrayList<>();

	list.add("Maria");
	list.add("Alex");
	list.add("Bob");
	list.add("Anna");
	list.add(2, "Marco");
	System.out.println(list.size()); //tamanho da lista
	for (String x : list) {
	System.out.println(x);
	}
	System.out.println("---------------------");
	list.removeIf(x -> x.charAt(0) == 'M');	//remove se começa com M
	for (String x : list) {
	System.out.println(x);
	}
	System.out.println("---------------------");
	System.out.println("Index of Bob: " + list.indexOf("Bob"));	//retorna o index(posição na lista)
	System.out.println("Index of Marco: " + list.indexOf("Marco"));	//caso não exista o elemento, retorna -1.
	System.out.println("---------------------");
	List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());	//converte a lista em stream, filtra pelos elementos começados com A e depois reconverte para lista.
	for (String x : result) {
	System.out.println(x);
	}
	System.out.println("---------------------");
	String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);	// retorna o primeiro elemento iniciado com J ou retorna nulo, caso não exista.
	System.out.println(name);
	}
}
