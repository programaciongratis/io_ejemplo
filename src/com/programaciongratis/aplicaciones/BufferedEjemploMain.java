package com.programaciongratis.aplicaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedEjemploMain {

	public static void main(String[] args) {
		
		BufferedReader input = null;
		PrintWriter output = null;
		
		try {
			
			long comienzo = System.currentTimeMillis();
			
			input = new BufferedReader(new FileReader("resources/shakespeare_the_sonnets.txt"));
			output = new PrintWriter("resources/resultados_buffered.txt");
			
			String linea;
			
			int counter = 0;
			
			while ((linea = input.readLine()) != null) {
				
				// Aqui usamos el metodo contains de la clase String.
				// Este metodo verifica si la palabra, "Shakespeare", existe en
				// nuestro String linea.
				if (linea.contains("Shakespeare")) { // puedes cambiar Shakespeare por otra palabra y hacer la prueba
					output.write(linea + "\n");
					counter++; // va contar cuantas lineas que contienen "Shakespeare" existen.
				}
				
			}
			
			long termino = System.currentTimeMillis() - comienzo;
			
			System.out.println("Tiempo de ejcucion: " + termino);
			System.out.println("counter: " + counter);
			
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
				output.close();
			}
			
		}

	}

}
