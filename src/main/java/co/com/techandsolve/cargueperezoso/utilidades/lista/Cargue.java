package co.com.techandsolve.cargueperezoso.utilidades.lista;

public class Cargue {
	
	private Cargue(){
		
	}
	
	public static int[] ordenarArreglo(int[] arreglo) {
	    int auxiliar;
	    for (int i = 0; i < arreglo.length - 1; i++) {
	        for (int x = i + 1; x < arreglo.length; x++) {
	            if (arreglo[x] > arreglo[i]) {
	                auxiliar = arreglo[i];
	                arreglo[i] = arreglo[x];
	                arreglo[x] = auxiliar;
	            }
	        }
	    }
	    return arreglo;
	}
}
