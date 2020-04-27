package br.com.gft.cursojava.modulomap.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		Map<String, Integer> map = new LinkedHashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String nomeCandidato = fields[0];
				int numeroVotos = Integer.parseInt(fields[1]);
				
				if (map.containsKey(nomeCandidato)) {
					int votos = map.get(nomeCandidato);
					map.put(nomeCandidato, votos + numeroVotos);
				} else {
					map.put(nomeCandidato, numeroVotos);
				}
				
				itemCsv = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());

		}
		
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		
		sc.close();

	}

}
