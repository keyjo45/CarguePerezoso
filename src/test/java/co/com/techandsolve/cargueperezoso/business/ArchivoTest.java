package co.com.techandsolve.cargueperezoso.business;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;

public class ArchivoTest {
	
	private Archivo archivo=new Archivo();
	
	@Test
	public void debeProcesarArchivo() throws ReadingTextException{
		int diasTrabajados=5;
		String fileLocation="src/test/resources/co/com/techandsolve/cargueperezoso/archivo/lazy_loading_example_input.txt";
		
		File file = new File(fileLocation);
		List<Integer>listaResultante=archivo.procesarArchivo(file);
		Assert.assertNotNull(listaResultante);
		
		Assert.assertEquals(diasTrabajados, listaResultante.get(0).intValue());
	}

	@Test
	public void debeGenerarArchivo() throws ReadingTextException{
		
		String rutaDestino=System.getenv("RUTA_ARCHIVO_SALIDA");
		String nombreArchivo="lazy_loading_example_output.txt";
		int diasTrabajados=6;
		List<Integer> listDatosResultantes=new ArrayList<>();
		
		listDatosResultantes.add(2);
		listDatosResultantes.add(3);
		listDatosResultantes.add(3);
		listDatosResultantes.add(3);
		listDatosResultantes.add(8);
		listDatosResultantes.add(8);
		
		archivo.generarArchivo(listDatosResultantes,diasTrabajados);
		
		Assert.assertTrue(Files.exists(Paths.get(rutaDestino+nombreArchivo)));
		
	}
}
