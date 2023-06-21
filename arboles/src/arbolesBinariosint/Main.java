package arbolesBinariosint;

public class Main {

	public static void main(String[] args) {
		ABBInt arbol = new ABBInt();
	    arbol.agregar(4);
	    arbol.agregar(2);
	    arbol.agregar(6);
	    arbol.agregar(1);
	    arbol.agregar(3);
	    arbol.agregar(5);
	    arbol.agregar(7);

	    System.out.println("¿Es un árbol binario de búsqueda? " + arbol.esABB());
	    System.out.println("¿Está balanceado? " + arbol.estaBalanceado());
	    System.out.println("¿Es completo? " + arbol.esCompleto());
	}

}
