package com.programaciongratis.aplicaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BytesEjemploMain {

	public static void main(String[] args) {
		
		// creamos una variable para leer y otra para escribir
		// input es para leer informacion
		FileInputStream input = null;
		
		// output es para escribir informacion
		FileOutputStream output = null;
		
		// esto significa que vamos a "intentar" hacer algo
		// que puede causar errores. 
		try {
			
			long comenzo = System.currentTimeMillis();
			
			// aqui creamos un objeto especificando de donde vamos
			// a leer informacion
			input = new FileInputStream("resources/shakespeare_the_sonnets.txt");
			
			// aqui creamos un objeto especificando a donde vamos
			// a escribir la informacion leida.
			output = new FileOutputStream("resources/resultados_byte.txt");
			
			// esta varibale va guardar cada valor entero de cada byte que
			// vamos a leer.
			int byteActual;
			
			int counter = 0;
			
			// vamos a ejecutar el codigo 'mientras' el resultado de
			// input.read() NO sea igual a -1. si es igual a -1 dejamos
			// de ejecutar el codigo.
			while ((byteActual = input.read()) != -1) {
				
				// esto dice que vamos a escribir solo la letra 'a'
				if (byteActual == 'a') {
					System.out.println("Encontramos un: " + byteActual);
					output.write(byteActual);
					
					// esto es para escribir cada 'a' que encontremos en una
					// linea diferente. Si no ponemos esto, entonces output.write()
					// va sobre escribir la informacion. ¡CUIDADO!
					output.write('\n');
					
					counter++;
				}
					
			}
			
			long termino = System.currentTimeMillis() - comenzo;
			
			System.out.println("Ejemplo Byte:");
			System.out.println("Tiempo de ejecucion: " + termino);
			System.out.println("counter: " + counter);
		
		// catch significa que si el error "FileNotFoundException" ocurre,
		// entonces se ejecuta la linea 56.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // lo mismo aqui...
			e.printStackTrace();
			
		// esto es el mas importante. Esto significa que a pesar de los errores
		// que puedan pasar o ocurrir, el siguiente codigo siempre se va ejecutar.	
		// IMPORTANTE: Nunca olviden esto porque sino sus archivos pueden quedarse
		// abiertos y pueden causar "information leakage". Lo que significa que hackers
		// podrian llegar a ver su informacion.	
		} finally {
			
			if (input != null) {
				
				// el siguiente codigo se lee de la siguiente manera:
				// intenta cerrar input. Si el error 'IOException' ocurre, entonces
				// ejecuta el codigo en la linea 75.
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (output != null) {
				
				// lo mismo aqui.
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
