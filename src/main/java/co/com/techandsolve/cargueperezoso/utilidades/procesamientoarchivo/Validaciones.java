package co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo;

public class Validaciones {
	
	public boolean validarDiasTrabajados(int dias){
		boolean valido = false;
		if((1<=dias)&&(dias <= 500)){
			valido=true;	
		}
		return valido;
	}
	
	public boolean  validarElementos(int elementos){
		
		boolean valido = false;
		if((1<=elementos)&&(elementos <= 100)){
			valido=true;	
		}
		return valido;
		
	}

}
