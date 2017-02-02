package co.com.techandsolve.cargueperezoso.utilidades.lista;

public class Cargue {
	
	private Cargue(){
		
	}
	
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
}
