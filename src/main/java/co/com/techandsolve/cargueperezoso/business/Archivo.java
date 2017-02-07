package co.com.techandsolve.cargueperezoso.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;

public class Archivo {

	public List<Integer> procesarArchivo(File file) throws ReadingTextException {

		List<Integer> lstFilas = new ArrayList<>();

		try {
			FileReader archivoALeer = new FileReader(file);
			BufferedReader buffer = new BufferedReader(archivoALeer);

			String linea;
			while ((linea = buffer.readLine()) != null) {
				lstFilas.add(Integer.parseInt(linea));
			}
			archivoALeer.close();

		} catch (Exception e) {
			throw new ReadingTextException(e, "Error al llenar lista ");

		}
		return lstFilas;
	}

	public void generarArchivo(List<Integer> resultado, int n) throws ReadingTextException {

		try {
			String nombreArchivo = "lazy_loading_example_output.txt";
			FileWriter fichero = new FileWriter(System.getenv("RUTA_ARCHIVO_SALIDA") + nombreArchivo);
			PrintWriter pw = new PrintWriter(fichero);

			int caso;
			for (int i = 0; i < n; i++) {
				caso = i + 1;
				pw.println("Case #" + caso + ": " + resultado.get(i));
			}
			fichero.close();

		} catch (Exception e) {
			throw new ReadingTextException(e, "Error al escribir dato de salida");
		}

	}

}
