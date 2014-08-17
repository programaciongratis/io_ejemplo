package com.programaciongratis.aplicaciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterEjemploMain {

	public static void main(String[] args) {
		
		FileReader input = null;
		FileWriter output = null;
		
		int character;
		
		int counter = 0;
		
		try {
			
			long comienzo = System.currentTimeMillis();
			
			input = new FileReader("resources/shakespeare_the_sonnets.txt");
			output = new FileWriter("resources/resultados_character.txt");
			
			while ((character = input.read()) != -1) {
			
				if (character == 'a') {
					System.out.println("character code: " + character);
					output.write(character);
					output.write('\n');
					
					counter++;
				}
				
			}
			
			long termino = System.currentTimeMillis() - comienzo;
			
			System.out.println("Ejemplo Character:");
			System.out.println("tiempo de ejecucion: " + termino);
			System.out.println("counter: " + counter);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
