package co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;

public class FileManager {
	
	private String fileLocation="lazy_loading_example_input.txt";
	
	public File uploadFile(InputStream fileInput) throws ReadingTextException {
		File file = new File(fileLocation);
		try (OutputStream out = new FileOutputStream(file)) {

			byte[] buffer = new byte[1024];
			int bytes = 0;
			while ((bytes = fileInput.read(buffer)) != -1) {
				out.write(buffer, 0, bytes);
			}
			out.flush();
			return file;
		} catch (IOException ex) {
			throw new ReadingTextException(ex, "Error escribiendo archivo en la ruta " + fileLocation);
		}
	}
	
	public byte[] read(File file) throws IOException {
	    
	    try(ByteArrayOutputStream ous =  new ByteArrayOutputStream();
	    	InputStream ios =  new FileInputStream(file);) {
	        byte[] buffer = new byte[1024];
	        int read = 0;
	        while ((read = ios.read(buffer)) != -1) {
	            ous.write(buffer, 0, read);
	        }
	        return ous.toByteArray();
	    }
	   
	}

}
