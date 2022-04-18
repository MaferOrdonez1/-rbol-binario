/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;
import java.lang.Math;
/**
 *
 * @author mafer
 */
public class FuncionesArbol {
    NodoArbol raiz;
   
    public FuncionesArbol(){
        this.raiz = null;
    }

    //insertar un nodo
    public void addNodo(int dato){
        NodoArbol nuevo = new NodoArbol(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol aux = raiz;
            NodoArbol padre;
            while (true) {
                padre = aux;
                if (dato < aux.dato) {
                    aux = aux.hijoIzquierdo;
                    if (aux == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    aux = aux.hijoDerecho;
                    if (aux == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    public boolean eliminar (int dato){
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean eshijoizq = (aux.hijoIzquierdo != null);
        while (aux.dato != dato) {
            padre = aux;
            if (dato < aux.dato) {
                aux = aux.hijoIzquierdo;
                eshijoizq = true;
            } else {// si es mayor
                aux = aux.hijoDerecho;
                eshijoizq = false;
            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.hoja()){  
            eliminarhoja(padre, aux, eshijoizq);
        } 

        return true;
    }
    private void eliminarhoja(NodoArbol padre, NodoArbol aux, boolean eshijoizq) {
        if (aux == raiz) {
            raiz = null;
        } else {
            if (eshijoizq) {
                padre.hijoIzquierdo=null;
            } else {
                padre.hijoDerecho=null;
            }
        }
    }
    //Empieza desde el padre
    public void Preorden(NodoArbol Nodo){
        if (Nodo == null) {
            return;
        } else {
            System.out.print(Nodo.dato + " ");
            Preorden(Nodo.hijoIzquierdo);
            Preorden(Nodo.hijoDerecho);

        }
    }
    // Empieza desde los hijos
    public void PostOrden(NodoArbol Nodo){
        if (Nodo == null) {
            return;
        } else {
            Preorden(Nodo.hijoIzquierdo);
            Preorden(Nodo.hijoDerecho);
            System.out.print(Nodo.dato + " ");

        }
    }
    // Empieza desde los primeros izquierdos desde abajo para arriba
    public void Inorden(NodoArbol Nodo){
        if (Nodo == null) {
            return;
        } else {
            Inorden(Nodo.hijoIzquierdo);
            System.out.print(Nodo.dato + " ");
            Inorden(Nodo.hijoDerecho);

        }
    }
    public int ObtenerlaRaíz(){
        return raiz.dato;
    
    }
    public int Altura(NodoArbol Nodo){
        if (Nodo != null) {
            return (1 + Math.max(Altura(Nodo.hijoIzquierdo), Altura(Nodo.hijoDerecho)));
        }
        return 0;
    }
    public int Contar(NodoArbol Nodo){
        if (Nodo != null) {
            return (1 + Contar(Nodo.hijoIzquierdo) + Contar(Nodo.hijoDerecho));
        }
        return 0;
    }

    public NodoArbol Buscar(int dato){
        NodoArbol aux = raiz;
        while (aux.dato != dato) {
            if (dato < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }
}