package co.com.techandsolve.cargueperezoso.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.activation.DataHandler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ibm.websphere.jaxrs20.multipart.IAttachment;
import com.ibm.websphere.jaxrs20.multipart.IMultipartBody;
import com.sun.mail.iap.Response;

import co.com.techandsolve.cargueperezoso.business.Archivo;
import co.com.techandsolve.cargueperezoso.business.CalculoCarga;
import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;
import co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo.FileManager;

@RunWith(MockitoJUnitRunner.class)
public class ArchivoServicesTest {

	@InjectMocks
	ArchivoServices archivoServicio;

	@Mock
	FileManager uploadFile;

	@Mock
	CalculoCarga calculoCarga;

	@Mock
	IMultipartBody multipartBody;

	@Mock
	File file;

	@Mock
	List<IAttachment> listAttachment;

	@Mock
	List<Integer> listaArchivo;

	@Mock
	IAttachment Iattachment;

	@Mock
	DataHandler dataHandler;

	@Mock
	InputStream inputStream;

	@Mock
	Response response;

	@Mock
	Archivo archivo;

	@Before
	public void setUp() throws IOException, ReadingTextException {

		// act

		Mockito.when(multipartBody.getAllAttachments()).thenReturn(listAttachment);

		Mockito.when(listAttachment.get(0)).thenReturn(Iattachment);

		Mockito.when(Iattachment.getDataHandler()).thenReturn(dataHandler);

		Mockito.when(dataHandler.getInputStream()).thenReturn(inputStream);
	}

	@Test
	public void debeRecibirArchivo() throws IOException, Exception {

		// act
		Mockito.when(uploadFile.uploadFile(multipartBody.getAllAttachments().get(0).getDataHandler().getInputStream()))
				.thenReturn(file);
		Mockito.when(archivo.procesarArchivo(file)).thenReturn(listaArchivo);

		archivoServicio.recibirArchivo(multipartBody);

		// assert
		Mockito.verify(calculoCarga).calcularCargue(listaArchivo);

	}

}
