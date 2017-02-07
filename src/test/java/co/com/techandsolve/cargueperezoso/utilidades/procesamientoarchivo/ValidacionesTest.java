package co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo.Validaciones;

public class ValidacionesTest {

	private Validaciones validacion;
	private boolean valido;

	@Before
	public void setUp() {
		validacion = new Validaciones();
	}

	@Test
	public void debeValidasDias() {

		// arrange
		int diasTrabajados = 1;
		// act
		valido = validacion.validarDiasTrabajados(diasTrabajados);
		// assert
		Assert.assertTrue(valido);
	}

	@Test
	public void debeValidasDiasErroneos() {

		// arrange
		int diasTrabajados = -1;
		// act
		valido = validacion.validarDiasTrabajados(diasTrabajados);
		// assert
		Assert.assertFalse(valido);
	}

	@Test
	public void debeValidarElementos() {
		// arange
		int elemento = 1;
		// act
		valido = validacion.validarElementos(elemento);
		// assert
		Assert.assertTrue(valido);
	}

	@Test
	public void debeValidarElementosErroneos() {
		// arange
		int elemento = 0;
		// act
		valido = validacion.validarElementos(elemento);
		// assert
		Assert.assertFalse(valido);
	}

}
