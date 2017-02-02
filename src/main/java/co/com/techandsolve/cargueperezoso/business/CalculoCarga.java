package co.com.techandsolve.cargueperezoso.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.com.techandsolve.cargueperezoso.exception.ReadingTextException;
import co.com.techandsolve.cargueperezoso.exception.ValidacionException;
import co.com.techandsolve.cargueperezoso.utilidades.lista.Cargue;
import co.com.techandsolve.cargueperezoso.utilidades.procesamientoarchivo.Validaciones;

public class CalculoCarga {
	
	
	private Validaciones validacion=new Validaciones();
	private Archivo archivo=new Archivo();
	
	private int viajesTotales;
	
	public void calcularCargue(List<Integer> listaACalcular) throws ValidacionException, ReadingTextException, IOException{
				
		int diasTrabajado=listaACalcular.get(0);
		int[]datos=new int[listaACalcular.size()];
		
		if(validacion.validarDiasTrabajados(diasTrabajado)){
			datos=asignarArreglo(listaACalcular);
			
			List<Integer>listResultado=calcularViajesRealizados(datos);
			
			if(!listResultado.isEmpty()){
				archivo.generarArchivo(listResultado, diasTrabajado);
			}
		}else{
			throw new ValidacionException("Los dias trabajados no son los correctos");
		}
	}
	
	public int [] asignarArreglo(List<Integer> lista){
		int [] arreglo=new int[lista.size()];
		for(int i=1;i<lista.size();i++){
			arreglo[i]=lista.get(i).intValue();
		}
		return arreglo;
	}
	
	public List<Integer> calcularViajesRealizados(int [] datos) throws ValidacionException{
		
		List<Integer> listaResultado=new ArrayList<>();
		int i=1; 
		int indiceDatos=1;
		
		while(i<=datos.length-1){
			if(validacion.validarElementos(datos[i])){
			int[] arreglo=new int [datos[i]];
			indiceDatos=i+1;
			int indice=0;
			while(indice<=arreglo.length-1){
				if(validacion.validarElementos(datos[indiceDatos])){
					arreglo[indice]=datos[indiceDatos];
				}else{
					throw new ValidacionException("Los pesos no son correctos");
				}
				indiceDatos++;
				indice++;
			}
			CalculoCarga calculoInicial=new CalculoCarga();
			int viajesRealizados=calculoInicial.calcularViajes(arreglo, datos[i]);
			listaResultado.add(viajesRealizados);
			i=i+datos[i]+1;
			}else{
				throw new ValidacionException("Cantidad de elementos no validos");
			}
		}	
		return listaResultado;
	}

	public int calcularViajes(int[] arreglo, int cantidadElementosArreglo) {
		int [] arregloOrdenado=Cargue.ordenarArreglo(arreglo);
		int	elementosArreglo=0;
		for(int i=0; i<=arregloOrdenado.length-1; i++){
			
			if(arregloOrdenado[i]>=50){
				viajesTotales++;
				cantidadElementosArreglo--;
			}else{
				if(elementosArreglo<=cantidadElementosArreglo){
					elementosArreglo=calcularElementosBolsa(arregloOrdenado[i], cantidadElementosArreglo);
					cantidadElementosArreglo=cantidadElementosArreglo-elementosArreglo;
				}else{
					break;
				}
			}
		}
		return viajesTotales;
	}
	
	public int calcularElementosBolsa(int peso, int cantidadElementos){
		int elementos=2;
		while(elementos<=cantidadElementos){
			if((peso*elementos)>=50){
				viajesTotales++;
				break;
			}
			elementos++;
		}
		return elementos;
	}	

}
