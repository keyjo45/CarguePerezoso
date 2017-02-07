package co.com.techandsolve.cargueperezoso.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.techandsolve.cargueperezoso.exception.ValidacionException;

public class CalculoCargaTest {

	private List<Integer> listaDatos;

	@Before
	public void setUp() {

		listaDatos = new ArrayList<>();
		listaDatos.add(30);
		listaDatos.add(30);
		listaDatos.add(1);
		listaDatos.add(1);
	}

	@Test
	public void debeAsignarArreglo() {
		CalculoCarga calcular = new CalculoCarga();
		int[] arregloObtenido = new int[listaDatos.size()];
		arregloObtenido = calcular.asignarArreglo(listaDatos);
		Assert.assertEquals(30, arregloObtenido[1]);
	}

	@Test
	public void debeCalcularViajes() {
		int elementos = 11;
		int[] arreglo = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int elementosSegundo = 8;
		int[] arregloSecundario = { 50, 80, 20, 20, 20, 10, 10, 2 };
		int tercerElemento = 8;
		int[] arregloTercero = { 60, 90, 40, 40, 30, 10, 5, 2 };

		int quintoElemento = 6;
		int[] arregloCinco = { 59, 49, 39, 29, 19, 9 };

		int sextoElemento = 3;
		int[] arregloSexto = { 20, 20, 20 };

		CalculoCarga calculo = new CalculoCarga();
		int viajes = calculo.calcularViajes(arreglo, elementos);
		CalculoCarga calculoSecundario = new CalculoCarga();
		int secundoViajes = calculoSecundario.calcularViajes(arregloSecundario, elementosSegundo);
		CalculoCarga calculoTercero = new CalculoCarga();
		int tercerViajes = calculoTercero.calcularViajes(arregloTercero, tercerElemento);

		CalculoCarga calculoQuinto = new CalculoCarga();
		int quintoViaje = calculoQuinto.calcularViajes(arregloCinco, quintoElemento);
		CalculoCarga calculoSexto = new CalculoCarga();
		int sextoViaje = calculoSexto.calcularViajes(arregloSexto, sextoElemento);

		Assert.assertEquals(2, viajes);
		Assert.assertEquals(4, secundoViajes);
		Assert.assertEquals(5, tercerViajes);
		Assert.assertEquals(3, quintoViaje);
		Assert.assertEquals(1, sextoViaje);
	}

	@Test
	public void debeCalcularViajesRealizados() throws ValidacionException {

		List<Integer> listaEsperada = new ArrayList<>();
		listaEsperada.add(2);
		listaEsperada.add(1);
		listaEsperada.add(2);
		listaEsperada.add(3);
		listaEsperada.add(8);

		int[] arreglo = { 5, 4, 30, 30, 1, 1, 3, 20, 20, 20, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 6, 9, 19, 29, 39,
				49, 59, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91 };

		CalculoCarga calcularCargaRealizada = new CalculoCarga();

		List<Integer> lista = calcularCargaRealizada.calcularViajesRealizados(arreglo);

		Assert.assertNotNull(lista);

		Assert.assertEquals(listaEsperada, lista);
	}

	@Test
	public void debeCalcularBolsa() {

		int cantidadElementos = 3;
		int peso = 30;

		CalculoCarga calculoCarga = new CalculoCarga();

		int elementos = calculoCarga.calcularElementosBolsa(peso, cantidadElementos);

		Assert.assertEquals(2, elementos);

	}

}
