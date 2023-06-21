package arbolesGenericos;

import arbolesGenericos.AB.Nodo;

public class ABB<T extends Comparable<T>> extends AB<T>  {
	
	
	
	@Override
	protected Nodo agregar(Nodo nodo, T elem) {
		if(nodo == null) {
			return new Nodo(elem);
		}
		if(nodo.elem.compareTo(elem)>0) {
			nodo.izq = agregar(nodo.izq, elem);
		}else if(nodo.elem.compareTo(elem)<0) {
			nodo.der = agregar(nodo.der, elem);	
		}
		return nodo;
	}
	@Override
	protected boolean pertenece(Nodo nodo, T elem) {
		if (nodo == null)
			return false;

		if (nodo.elem.equals(elem))
			return true;

		if (nodo.elem.compareTo(elem)>0)
			return pertenece(nodo.izq, elem);
		else
			return pertenece(nodo.der, elem);
	}
	public int maximo() {
		if(raiz == null) {
			throw new RuntimeException("el arbol esta vacio");
		}else {
			return maximo(raiz);
		}
	}
	protected int maximo(Nodo nodo) {
		if(nodo.der == null) {
			return (int) nodo.elem;
		}
		return maximo(nodo.der);
	}
	
	/**
	 * implementar el motodo Integer sumaMayorMenor() que dado un ABB devuelve la suma del menor y el mayor elemento
	 * si el arbol esta vacio devuelve 0, si solo tiene un lemento no realiza la suma.
	 */
	/**
	 * por definicion de ABB sabemos que el menor elemento esta en al final de la rama izq y el mayor lemento esta al
	 * final de la rama derecha
	 */
	public int sumaMayorMenor() {
		if(raiz == null || raiz.izq == null && raiz.der == null) {
			return 0;
		}
		return sumaMayorMenor(raiz);
	}
	protected int sumaMayorMenor(Nodo nodo) {
		return minimo() + maximo();
	}	

}
