package arbolesGenericos;

public class AB<T> {
	
	protected class Nodo{
		T elem;
		Nodo der, izq;
		
		Nodo(T valor){
			elem = valor;
		}
		@Override
		public String toString() {
			return this.elem.toString();
		}
	}
	
	protected Nodo raiz;
	
	public void agregar(T elem) {
		raiz = agregar(raiz, elem);
	}
	
	protected Nodo agregar(Nodo padre, T elem) {
		if(padre == null) {
			return new Nodo(elem);
		}
		if(padre.der != null) {
			padre.izq = agregar(padre.izq, elem);
		}else {
			padre.der = agregar(padre.der, elem);
		}
		
		return padre;
	}
	
	public boolean pertenece(T elem) {
		return pertenece(raiz, elem);
	}
	protected boolean pertenece(Nodo padre, T elem) {
		if(padre == null) {
			return false;
		}
		if(padre.equals(elem)) {
			return true;
		}
		return pertenece(padre.izq, elem) || pertenece(padre.der, elem);
	}
	
	public int cantNodos() {
		return cantNodos(raiz);
	}
	protected int cantNodos(Nodo padre) {
		if(padre == null) {
			return 0;
		}
		return 1 + cantNodos(padre.izq) + cantNodos(padre.der);
	}
	public int altura() {
		return altura(raiz);
	}
	protected int altura(Nodo padre) {
		if(padre == null) {
			return 0;
		}
		return 1 + Math.max(altura(padre.izq) , altura(padre.der)); 
	}
	
	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}
	protected boolean estaBalanceado(Nodo padre) {
		if(padre == null) {
			return true;
		}
		int alturaNodoDer = altura(padre.der);
		int alturaNodoIzq = altura(padre.izq);
		int diferenciaDeAltura = Math.abs(alturaNodoDer - alturaNodoIzq);
		
		if(diferenciaDeAltura > 1) {
			return false;
		}
		
		return estaBalanceado(padre.der) && estaBalanceado(padre.izq);
	}
	
	public int minimo() {
		if(raiz == null) {
			throw new RuntimeException("el arbol esta vacio");
		}
		return minimo(raiz);
	}
	
	protected int minimo(Nodo padre) {
		if(padre.izq == null) {
			return (int) padre.elem;
		}
		return minimo(padre.izq);
	}
	// TODO Agregar Métodos faltantes.

	public String toStringInOrder() {
		return inOrder(raiz);
	}

	protected String inOrder(Nodo n) {
		if (n == null)
			return "";
		return inOrder(n.izq) + " " + n.elem + " " + inOrder(n.der);
	}

	public String toStringPreOrder() {
		return preOrder(raiz);
	}

	protected String preOrder(Nodo n) {
		if (n == null)
			return "";
		return n.elem + "[ " + preOrder(n.izq) + " - " + preOrder(n.der) + " ]";
	}
	
	public String toStringPostOrden() {
		return postOrden(raiz);
	}
	protected String postOrden(Nodo n) {
		if(n == null) {
			return "";
		}
		return "[" + postOrden(n.izq) + " - " + postOrden(n.der) + n.elem + "]";
	}
	public int cantidadNodosVisitados(T elemento) {
	    return cantidadNodosVisitadosRecursivo(raiz, elemento);
	}

	protected int cantidadNodosVisitadosRecursivo(Nodo nodo, T elemento) {
	    if (nodo == null) {
	        return 0;
	    }
	    if (nodo.elem.equals(elemento)) {
	        return 0;
	    }
	    return 1 + cantidadNodosVisitadosRecursivo(nodo.izq, elemento) + cantidadNodosVisitadosRecursivo(nodo.der, elemento);
	}
	/**
	 * implementar el metodo dosHijos() que retorne un String con el valor de los nodos que cumplan que el nodo
	 * tenga dos hijos que no sean nulos
	 */
	protected boolean tieneDosHijos(Nodo nodo) {
		return nodo.der != null && nodo.izq != null;
	}
	public String dosHijos() {
		if(raiz == null) {
			return "vacio";
		}
		return dosHijos(raiz);
	}
	protected String dosHijos(Nodo nodo) {
		if(nodo == null) {
			return "";
		}
		if(tieneDosHijos(nodo)) {
			return  nodo.elem.toString();
		}
		return " { " + dosHijos(nodo.izq) + dosHijos(nodo.der) + " } "; 
	}
	/**
	 * El metodo busca ek nayor valor y este pasa a ser la raiz, luego recorre el arbol y aumenta todos los valores
	 * en los nodos, con valores consecutivos a partir del valor del nodo raiz.
	 */
	public void aumentarValor() {
		if(raiz == null) {
			throw new RuntimeException("el arbol esta vacio");
		}
		aumentarValor(raiz);
	}
	protected void aumentarValor(Nodo padre) {
		Integer max = (Integer) maximo();
	}

	private Integer maximo() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Meotdo el cual cuando un nodo tiene ambos hijos izquierdo y derecho distinto de null, copia el elemento
	 * del nodo izquierdo en el elemento del nodo derecho
	 */
	public void copiaHermanosIzq() {
		copiaHermanosIzq(raiz);
	}
	protected void copiaHermanosIzq(Nodo nodo) {
		if(nodo == null) {
			return; //break artificial
		}
		if(nodo.izq != null && nodo.der != null) {
			nodo.der.elem = nodo.izq.elem;
		}
		copiaHermanosIzq(nodo.izq);
		copiaHermanosIzq(nodo.der);
	}
	
	
	
	

}
