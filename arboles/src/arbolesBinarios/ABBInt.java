package arbolesBinarios;

import java.util.ArrayList;
import java.util.List;

public class ABBInt {
	private class NodoInt {
		int elem;
		NodoInt der, izq;

		NodoInt(int valor) {
			elem = valor;
		}
	}

	private NodoInt raiz;

	public void agregar(int elem) {
		raiz = agregar(raiz, elem);
	}

	private NodoInt agregar(NodoInt nodo, int elem) {
		if (nodo == null)
			return new NodoInt(elem);

		if (nodo.elem > elem)
			nodo.izq = agregar(nodo.izq, elem);
		else if (nodo.elem < elem)
			nodo.der = agregar(nodo.der, elem);

		return nodo;
	}

	public boolean pertenece(int elem) {
		return pertenece(raiz, elem);
	}

	private boolean pertenece(NodoInt nodo, int elem) {
		if (nodo == null)
			return false;

		if (nodo.elem == elem)
			return true;

		if (nodo.elem > elem)
			return pertenece(nodo.izq, elem);
		else
			return pertenece(nodo.der, elem);
	}
	
	public int cantNodos() {
		return cantNodos(raiz);
	}

	private int cantNodos(NodoInt nodo) {
		if (nodo == null)
			return 0;
		return 1 + cantNodos(nodo.izq) + cantNodos(nodo.der);
	}

	public String toStringInOrder() {
		return inOrder(raiz);
	}

	private String inOrder(NodoInt n) {
		if (n==null)
			return "";
		return inOrder(n.izq) +" " + n.elem + " " + inOrder(n.der);
	}

	public String toStringPreOrder() {
		return preOrder(raiz);
	}
	private String preOrder(NodoInt n) {
		if (n==null)
			return "";
		return n.elem +"[ "+ preOrder(n.izq)+ " - "+ preOrder(n.der) + " ]";
	}
	
	// 20230530
	
	public int cantELementosMayores(int valor) {
		return cantElementosMayores(raiz, valor);
	}

	private int cantElementosMayores(NodoInt nodo, int valor) {
		if (nodo==null)
			return 0;
		if (nodo.elem>valor)
			return 1+cantNodos(nodo.der)
				+cantElementosMayores(nodo.izq, valor);
		else if (nodo.elem==valor)
			return cantNodos(nodo.der);
		
		return cantElementosMayores(nodo.der,valor);
	}
	public boolean estaBalanceado() {
	    return estaBalanceado(raiz);
	}

	private boolean estaBalanceado(NodoInt nodo) {
	    if (nodo == null) return true;
	    int leftHeight = altura(nodo.izq);
	    int rightHeight = altura(nodo.der);
	    if (Math.abs(leftHeight - rightHeight) <= 1 && estaBalanceado(nodo.izq) && estaBalanceado(nodo.der))
	        return true;
	    return false;
	}

	private int altura(NodoInt nodo) {
	    if (nodo == null) return 0;
	    return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
	}
	
	/**
	 * 	Este método verifica si el árbol cumple con la propiedad de árbol binario de búsqueda: 
	 * 	para cada nodo en el árbol, todos los nodos en su subárbol izquierdo deben tener valores menores que su valor
		y todos los nodos en su subárbol derecho deben tener valores mayores que su valor. 
		Si esta propiedad se cumple para cada nodo en el árbol, entonces es un árbol binario de búsqueda.
	 *
	 */
	public boolean esABB() {
	    return esABB(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean esABB(NodoInt nodo, int min, int max) {
	    if (nodo == null) return true;
	    if (nodo.elem < min || nodo.elem > max) return false;
	    return esABB(nodo.izq, min, nodo.elem - 1) && esABB(nodo.der, nodo.elem + 1, max);
	}
	/**
	 * Este método verifica si el árbol binario de búsqueda es completo. 
	 * Un árbol binario completo es un árbol binario en el que todos los niveles están completamente llenos 
	 * excepto posiblemente el último nivel y todos los nodos están lo más a la izquierda posible. 
	 * Si el árbol cumple con esta propiedad, entonces es un árbol binario de búsqueda completo.
	 */
	
	public boolean esCompleto() {
		int nodeCount = contarNodos(raiz);
		return esCompleto(raiz, 0, nodeCount);
	}

	private boolean esCompleto(NodoInt nodo, int index, int nodeCount) {
		if (nodo == null) return true;
		if (index >= nodeCount) return false;
		return esCompleto(nodo.izq, 2 * index + 1, nodeCount) && esCompleto(nodo.der, 2 * index + 2, nodeCount);
	}

	private int contarNodos(NodoInt nodo) {
		if (nodo == null) return 0;
		return 1 + contarNodos(nodo.izq) + contarNodos(nodo.der);
	}
	/**
	 * Este código crea un método público internosMenorIgual que toma un elemento elem como parámetro y 
	 * devuelve un string con los elementos de los nodos internos cuyos valores son menores o iguales a elem. 
	 * El método llama a un método privado recursivo internosMenorIgual que toma un nodo, un elemento elem y 
	 * una lista de resultados como parámetros. Este método recorre el árbol en orden y 
	 * agrega los elementos de los nodos internos cuyos valores son menores o iguales a elem a la lista de resultados.
	 *  Finalmente, el método público internosMenorIgual convierte la lista de resultados en un string y lo devuelve.
		Espero que esto te ayude a implementar el método internosMenorIgual. Si tienes alguna pregunta o necesitas más ayuda, no dudes en hacerme saber
	 */
	public String internosMenorIgual(int elem) {
	    List<Integer> result = new ArrayList<>();
	    internosMenorIgual(raiz, elem, result);
	    return result.toString();
	}

	private void internosMenorIgual(NodoInt nodo, int elem, List<Integer> result) {
	    if (nodo == null) return;

	    internosMenorIgual(nodo.izq, elem, result);

	    if (nodo.elem <= elem && (nodo.izq != null || nodo.der != null)) {
	        result.add(nodo.elem);
	    }

	    internosMenorIgual(nodo.der, elem, result);
	}
		
		
	

}
