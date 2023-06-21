package arbolesBinariosint;

public class ABInt {
	protected class NodoInt {
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

		if (nodo.der != null)
			nodo.izq = agregar(nodo.izq, elem);
		else
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

		return pertenece(nodo.izq, elem) || pertenece(nodo.der, elem);
	}

	public void quitar(int elem) {
		raiz = quitar(raiz, elem);
	}

	private NodoInt quitar(NodoInt nodo, int elem) {
		if (nodo == null)
			return null;
		if (nodo.elem == elem) { // encontre el elemento a quitar
			// TODO refactorizar esto para que quede mas corto
			if (esHoja(nodo))
				return null;
			if (nodo.izq == null)
				return nodo.der;
			if (nodo.der == null)
				return nodo.izq;

			int reemplazo = buscarReemplazoPorIzquierda(nodo.izq);
			nodo.elem = reemplazo;
			nodo.izq = quitar(nodo.izq, reemplazo);

		} else {
			nodo.izq = quitar(nodo.izq, elem);
			nodo.der = quitar(nodo.der, elem);
		}
		return nodo;
	}

	private int buscarReemplazoPorIzquierda(NodoInt nodo) {
		if (nodo.izq == null)
			return nodo.elem;
		return buscarReemplazoPorIzquierda(nodo.izq);
	}

	private boolean esHoja(NodoInt nodo) {
		return nodo.izq == null && nodo.der == null;
	}

	public int cantNodos() {
		return cantNodos(raiz);
	}

	private int cantNodos(NodoInt nodo) {
		if (nodo == null)
			return 0;
		return 1 + cantNodos(nodo.izq) + cantNodos(nodo.der);
	}

	public int altura() {
		return altura(raiz);
	}

	private int altura(NodoInt nodo) {
		if (nodo == null)
			return 0;
		return 1 + max(altura(nodo.izq), altura(nodo.der));
	}

	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}
	private boolean estaBalanceado(NodoInt nodo) {
	    if (nodo == null) {
	        return true;
	    }

	    int alturaIzq = altura(nodo.izq);
	    int alturaDer = altura(nodo.der);
	    int diferenciaAltura = Math.abs(alturaIzq - alturaDer);

	    if (diferenciaAltura > 1) {
	        return false;
	    }

	    return estaBalanceado(nodo.izq) && estaBalanceado(nodo.der);
	}

	public int minimo() {
		if (raiz == null) {
	        throw new RuntimeException("El árbol está vacío");
	    }

	    return minimo(raiz);
	}
	private int minimo(NodoInt nodo) {
	    if (nodo.izq == null) {
	        return nodo.elem;
	    }

	    return minimo(nodo.izq);
	}

	public int maximo() {
		if (raiz == null) {
	        throw new RuntimeException("El árbol está vacío");
	    }

	    return maximo(raiz);
	}
	private int maximo(NodoInt nodo) {
	    if (nodo.der == null) {
	        return nodo.elem;
	    }

	    return maximo(nodo.der);
	}

	public boolean esABB() {
		return esABB(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean esABB(NodoInt nodo, int min, int max) {
	    if (nodo == null) {
	        return true;
	    }

	    if (nodo.elem <= min || nodo.elem >= max) {
	        return false;
	    }

	    return esABB(nodo.izq, min, nodo.elem) && esABB(nodo.der, nodo.elem, max);
	}

	// 20230530

	public boolean esIgual(ABInt ab) {
		if (ab == null)
			return false;
		// O(1) + O(n) => O(n) Aplico R2 y R1
		return esIgual(raiz, ab.raiz);
	}

	// siendo n la cantidad de nodos del arbol,
	// O(n) porque se ejecuta una vez para cada nodo del arbol
	// y el algoritmo es de O(1) => Aplica Regla 5
	private boolean esIgual(NodoInt n1, NodoInt n2) {
		// casos base
		if (n1 == null)
			return n2 == null;
		if (n2 == null)
			return false;
		if (n1.elem != n2.elem)
			return false;
		// llamados recursivos
		return esIgual(n1.izq, n2.izq) && esIgual(n1.der, n2.der);
	}

	public boolean esSubArbol(ABInt ab) {
		if (ab == null)
			return false;
		// O(1) + O(?)
		return esSubArbol(raiz, ab.raiz);
	}

	// n = la cantidad de nodos del arbol
	// m = la cantidad de nodos del arbol 2
	// O(min{n,m}) se repite n veces
	// Por regla 5 => O(n * min{n,m})
	private boolean esSubArbol(NodoInt n1, NodoInt n2) {
		// Casos base
		if (n2 == null)
			return true;
		if (n1 == null)
			return false;
		// Todo lo de arriba es O(1)
		if (esIgual(n1, n2)) // O(min{n,m})
			return true;
		// O(1) y hace los llamados recursivos para visitar
		// cada nodo
		return esSubArbol(n1.izq, n2) || esSubArbol(n1.der, n2);
	}

	public String elementosEnNivel(int nivel) {
		return elementosEnNivel(raiz, nivel);
	}

	private String elementosEnNivel(NodoInt nodo, int nivel) {
		if (nodo == null)
			return "";
		if (nivel == 1)
			return String.valueOf(nodo.elem);

		return elementosEnNivel(nodo.izq, nivel - 1) + " " 
				+ elementosEnNivel(nodo.der, nivel - 1);
	}

	// --------------------------------------------------
	// ------------------- AUXILIARES -------------------
	// --------------------------------------------------

	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	private int min(int a, int b) {
		if (a < b)
			return a;
		return b;
	}

}
