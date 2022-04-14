/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol;

import java.util.Scanner;

/**
 *
 * @author mafer
 */
public class Arbol {
    Scanner in = new Scanner(System.in);
    FuncionesArbol binaryTree = new FuncionesArbol();
    
    public static void main(String[] args) {
        Arbol print = new Arbol();
        print.menu();
    }
    public void menu(){
        boolean salir = false;
        int opcion;
        
        while(!salir){
           
           System.out.println("\n"+"1. Insertar un nodo ");
           System.out.println("2. Borrar un nodo ");
           System.out.println("3. Recorrido en Pre orden ");
           System.out.println("4. Recorrido en In orden");
           System.out.println("5. Recorrido en Pos orden ");
           System.out.println("6. Obtener la raíz ");
           System.out.println("7. Determinar la Altura ");
           System.out.println("8. Determinar número de elementos ");
           System.out.println("9. Buscar un elemento ");
           System.out.println("10. exit ");
           System.out.println("Escribe una de las opciones:");
           opcion = in.nextInt();
           
           switch(opcion){
               case 1:
                   System.out.println("Ingrese elemento:");
                   binaryTree.addNodo(in.nextInt());
                   
                   break;
                           
               case 2:
                   System.out.println("Ingrese nodo al borrar:");
                   binaryTree.eliminar(in.nextInt());

                   break;
                case 3:
                   System.out.println("Recorrido en Preorden");
                   binaryTree.Preorden(binaryTree.raiz);
                   
                   break;
                case 4:
                   System.out.println("Recorrido en Inorden");
                   binaryTree.PostOrden(binaryTree.raiz);
                   
                   break;
                case 5:
                   System.out.println("Recorrido en Postorden");
                   binaryTree.Inorden(binaryTree.raiz);
                   
                   break;
                case 6:
                   System.out.println("Obtener la raíz:"+binaryTree.ObtenerlaRaíz());
                   
                   break;
                case 7:
                   System.out.println("La altura del arbol es: " + binaryTree.Altura(binaryTree.raiz));
                   
                   break;
                case 8:
                   System.out.println("Las hojas son:"+binaryTree.Contar(binaryTree.raiz));
                   
                   break;
                case 9:
                   System.out.println("Buscar un elemento:");
                   if(binaryTree.Buscar(in.nextInt())== null){
                       System.out.println("Nodo no encontrado");
                   }else{
                        System.out.println("Nodo encontrado");      
                   }
                   break;
                case 10:
                   salir=true;
                   System.out.println("Programa terminado");
                   
                   break;
                default:
                   System.out.println("Solo números entre 1 y 10");
    
    
            }
        }
    }

}