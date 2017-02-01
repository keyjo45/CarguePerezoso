package co.com.techandsolve.cargueperezoso.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.websphere.jaxrs20.multipart.IMultipartBody;

import co.com.techandsolve.cargueperezoso.business.Archivo;
import co.com.techandsolve.cargueperezoso.business.CalculoCarga;
import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;
import co.com.techandsolve.cargueperezoso.exception.ValidacionException;
import co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo.FileManager;

@Path("/file")
public class ArchivoServices {
	
	
	private FileManager uploadFile=new FileManager();
	private CalculoCarga calculoCarga=new CalculoCarga();
	private Archivo archivo=new Archivo();

	@POST
	@Path("/loadingFile/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void recibirArchivo(IMultipartBody multipartBody)throws ReadingTextException, ValidacionException{
		try {
			List<Integer> listArchivo=new ArrayList<>();
			File file=uploadFile.uploadFile(multipartBody.getAllAttachments().get(0).getDataHandler().getInputStream());
			listArchivo=archivo.procesarArchivo(file);
						
			if(!listArchivo.isEmpty()){
				calculoCarga.calcularCargue(listArchivo);
			}
		} catch (Exception e) {
			throw new ReadingTextException(e, "Error al leer el archivo o el archivo esta vacio. Revise que la extension sea .txt ");
		}
	}

}
