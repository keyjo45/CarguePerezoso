package co.com.techandsolve.cargueperezoso.utilidades.lista;

import java.util.Arrays;

public class Cargue {
	
	public static int[] ordenarArreglo(int[] n) {
	    int aux;
	    for (int i = 0; i < n.length - 1; i++) {
	        for (int x = i + 1; x < n.length; x++) {
	            if (n[x] > n[i]) {
	                aux = n[i];
	                n[i] = n[x];
	                n[x] = aux;
	            }
	        }
	    }
	    return n;
	}
	
	  public static boolean eliminarDatos(int[] arreglo, int elemento) {
	        boolean resultado = false;
	        for (int i = 0; i < arreglo.length; i++) {
	            if (arreglo[i] == elemento) {
	                for (int j = i; j < arreglo.length - 1; j++) {
	                    arreglo[j] = arreglo[j+1];
	                }
	                arreglo[arreglo.length - 1] = 0;
	                resultado = true;
	            }
	        }
	        return resultado;
	    }

}
