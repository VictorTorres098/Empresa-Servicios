package arbolesGenericos;

public class Main {

	public static void main(String[] args) {
		AB<Integer> abb = new AB<>();
		abb.agregar(5);
	    abb.agregar(3);
	    abb.agregar(7);
	    abb.agregar(2);
	    abb.agregar(4);
	    abb.agregar(6);
	    abb.agregar(8);
	    //System.out.println(abb.dosHijos()); // Debería imprimir "{5}
	    //System.out.println(arbol.cantidadNodosVisitados(4)); // Debería imprimir 2
	    //System.out.println(arbol.cantidadNodosVisitados(6)); // Debería imprimir 3
	    //System.out.println(arbol.cantidadNodosVisitados(9)); // Debería imprimir 0
	 // Imprimir el árbol antes de llamar al método copaHermanosIzq()
	    System.out.println("Árbol antes de llamar al método copaHermanosIzq():");
	    System.out.println("InOrder: " + abb.toStringInOrder());

	    // Llamar al método copaHermanosIzq()
	    abb.copiaHermanosIzq();

	    // Imprimir el árbol después de llamar al método copaHermanosIzq()
	    System.out.println("Árbol después de llamar al método copaHermanosIzq():");
	    System.out.println("InOrder: " + abb.toStringInOrder());
	    
	    //System.out.println(arbol.toStringPreOrder());
	    
	    ABB<Integer> abbb = new ABB<>();
	    
		/*
		 * abb.agregar(1); abb.agregar(2); abb.agregar(3); abb.agregar(4);
		 * abb.agregar(5);
		 * 
		 * System.out.println(abb.pertenece(3));
		 * System.out.println(abb.toStringInOrder()); System.out.println(abb.minimo());
		 * System.out.println(abb.maximo()); System.out.println(abb.sumaMayorMenor());
		 */
	    abbb.agregar(5);
        abbb.agregar(3);
        abbb.agregar(7);
        abbb.agregar(1);
        abbb.agregar(4);
        abbb.agregar(6);
        abbb.agregar(8);

        //System.out.println(abbb.mayoresHojas(4)); // Debería imprimir 2
        //System.out.println(abbb.mayoresHojas(6)); // Debería imprimir 1
        //System.out.println(abbb.mayoresHojas(8)); // Debería imprimir 0
	
        //System.out.println(abbb.elemsDesde(4)); // Debería imprimir "4 3 5"
        //System.out.println(abbb.elemsDesde(6)); // Debería imprimir "6 7 5"
        //System.out.println(abbb.elemsDesde(9)); // Debería imprimir ""
    
	}
}
