package arbolesGenericos;

public class Main {

	public static void main(String[] args) {
		AB<Integer> arbol = new AB<>();
		arbol.agregar(5);
	    arbol.agregar(3);
	    arbol.agregar(7);
	    arbol.agregar(2);
	    arbol.agregar(4);
	    arbol.agregar(6);
	    arbol.agregar(8);
	    
	    //System.out.println(arbol.cantidadNodosVisitados(4)); // Debería imprimir 2
	    //System.out.println(arbol.cantidadNodosVisitados(6)); // Debería imprimir 3
	    //System.out.println(arbol.cantidadNodosVisitados(9)); // Debería imprimir 0
	    
	    //System.out.println(arbol.toStringPreOrder());
	    
	    ABB<Integer> abb = new ABB<>();
	    abb.agregar(1);
	    abb.agregar(2);
	    abb.agregar(3);
	    abb.agregar(4);
	    abb.agregar(5);
	    System.out.println(abb.pertenece(3));
	    
	    System.out.println(abb.toStringInOrder());
	    System.out.println(abb.minimo());
	    System.out.println(abb.maximo());
	    System.out.println(abb.sumaMayorMenor());
	    System.out.println(abb.sumaMayorMenorv2());
	    
	}

}
