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
	
	private FileReader archivoALeer;
	private BufferedReader buffer;
	private  List<Integer> lstFilas;
	private FileWriter fichero;
	private PrintWriter pw;
	
	public List<Integer> procesarArchivo(File file)throws ReadingTextException{

	      try {
	    	  lstFilas = new ArrayList<>();
	    	  archivoALeer = new FileReader (file);
	    	  buffer = new BufferedReader(archivoALeer);

	         String linea;
	         while((linea=buffer.readLine())!=null){
	        	 lstFilas.add(Integer.parseInt(linea));
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new ReadingTextException(e, "Error al llenar lista ");
	     	
	      }finally{
	         try{                    
	            if( null != archivoALeer ){   
	            	archivoALeer.close();     
	            }                  
	         }catch (Exception e2){ 
	        	 throw new ReadingTextException(e2, "Error al cerrar el archivo...");
	 	     	
	         }
	      }
		return lstFilas;
	}
	
	public void generarArchivo(List<Integer> resultado, int n)throws ReadingTextException{
		
        try{
        	String nombreArchivo="lazy_loading_example_output.txt";
            fichero = new FileWriter(System.getenv("RUTA_ARCHIVO_SALIDA")+nombreArchivo);
            pw = new PrintWriter(fichero);
            int caso;
            for(int i = 0; i <n; i++){
            	caso=i+1;
                pw.println("Case #"+caso+ ": "+resultado.get(i));
            }

        } catch (Exception e) {
            throw new ReadingTextException(e, "Error al escribir dato de salida");
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              throw new ReadingTextException(e2, "Error al crear el archivo...");
           }
        }
		
	}
	
}
