package arbolesGenericos;

//import arbolesGenericos.AB.Nodo;

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
	/**
	 * Devuelve la cantidad de nodos cuyo valor es mayor o igual que elem y son hojas. Implementar todos los metodos
	 * nesesarios utilizando el IREP de un ABB para escribir el algortimo
	 */
	public int mayoresHojas(T elem) {
		if(raiz == null) {
			return 0;
		}
		return mayoresHojas(raiz, elem);
	}
	protected int mayoresHojas(Nodo padre, T elem) {
		if(padre == null) {
			return 0;
		}
		if(padre.elem.compareTo(elem) >= 0 && esHoja(padre)) {
			return 1;
		}
		return mayoresHojas(padre.izq, elem) + mayoresHojas(padre.der, elem);	
	}
	/**
	 * Un nodo es hoja si no tiene hijos izq y der
	 */
	protected boolean esHoja(Nodo nodo) {
		return nodo.izq == null && nodo.der == null;
	}
	/**
	 * El metodo debe retornar la cantidad de nodos cuyos valor es mayor el que el
	 * elem y no son hojas. resollver... 
	 * -Sin utilizar el metodo esHoja 
	 * -Utilizando
	 * el IREP de un ABB para escribiir el algoritmo 
	 * IREP ARBOL BINARIO: ● Se puede
	 * llegar a todos los nodos desde la raíz ● Cada nodo tiene un solo padre ● No
	 * tiene ciclos ● Cada nodo puede tener a lo sumo 2 hijos. ABB(a) sii a es un AB
	 * tal que -Todos los nodos de a.izq son menos que a.info -Todos los nodos de
	 * a.der son mayores que a.info -ABB(a.izq) -ABB(a.der)
	 */
	
	/**
	 * es interno si tiene 1 o mas hijos en este caso por IREP maximo dos hijos
	 */
	protected boolean esInterno(Nodo nodo) {
		return nodo.izq != null || nodo.der != null;
	}
	public int mayoresNoHojas(T elem) {
		if(raiz == null) {
			return 0;
		}
		return mayoresNoHojas(raiz, elem);
	}
	protected int mayoresNoHojas(Nodo nodo, T elem) {
		if(nodo == null) {
			return 0;
		}
		if(nodo.elem.compareTo(elem) > 0 && esInterno(nodo)) {
			return 1;
		}
		return mayoresNoHojas(nodo.izq, elem) + mayoresNoHojas(nodo.der, elem);
	}
	/**
	 * crear un metodo String elemsDesde(T elem) que retorna un String con los elementos de los nodos
	 *  que hay que recorrer desde elem hasta la llegar a la raiz.
	 * - Si elem no esta en el arbol, se debe retornar "";
	 * - Si el arbol se encuentra vacio retorna "";
	 */
	public String elemsDesde(T elem) {
		if(raiz == null) {
			return "";
		}
		return elemsDesde(raiz, elem);
	}
	protected String elemsDesde(Nodo nodo, T elem) {
		if(nodo == null) {
			return "";
		}
		if(nodo.elem.equals(elem)) {
			return nodo.elem.toString();
		}
		String resultado = elemsDesde(nodo.izq, elem);
        if(!resultado.isEmpty()) {
            return resultado + " " + nodo.elem.toString();
        }
        resultado = elemsDesde(nodo.der, elem);
        if(!resultado.isEmpty()) {
            return resultado + " " + nodo.elem.toString();
        }
        return "";
	}
	
	
	
	
	

}
