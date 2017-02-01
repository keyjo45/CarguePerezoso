package co.com.techandsolve.cargueperezoso.utilidades.lista;

import org.junit.Assert;
import org.junit.Test;

public class CargueTest {
	
	@Test
	public void debeOrdenarArreglo(){
		
		int[] arreglo={2,90,1,60,20};
		int [] arregloResutante=new int [5];
		arregloResutante=Cargue.ordenarArreglo(arreglo);
		
		Assert.assertEquals(90, arregloResutante[0]);
		Assert.assertEquals(60, arregloResutante[1]);
		Assert.assertEquals(20, arregloResutante[2]);
		Assert.assertEquals(2, arregloResutante[3]);
		Assert.assertEquals(1, arregloResutante[4]);
	}

}
