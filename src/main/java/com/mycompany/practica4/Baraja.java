package com.mycompany.practica4;

public class Baraja <Carta>{
    private NodoDoble<Carta> inicio;
    private NodoDoble<Carta> fin;

    public Baraja(){
        this.inicio = null;
        this.fin = null;
    }

    public void insertarInicio(Carta dato){
        NodoDoble<Carta> n = new NodoDoble<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else{
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }

    public void insertarFin(Carta dato){
        NodoDoble<Carta> n = new NodoDoble<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
            fin = n;
        }
    }

    public Carta eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        Carta dato = inicio.getInfo();

        if(inicio == fin){
            inicio = fin = null;
        } else{
            fin.setSig(inicio.getSig());
            inicio = inicio.getSig();
            inicio.setAnt(fin);
        }

        return dato;
    }

    public Carta elimnarFin(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        Carta dato = fin.getInfo();

        if(inicio == fin){
            inicio = fin = null;
        } else{
            NodoDoble<Carta> r = fin.getAnt();
            r.setSig(inicio);
            inicio.setAnt(r);
            fin = r;
        }
        return dato;
    }

    public void imprimirLista() {
        if(inicio == null){
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<Carta> actual = inicio;
        System.out.print("Lista: ");

        do{
            System.out.print(actual.getInfo() + " ");
            actual = actual.getSig();
        }while(actual != inicio);

        System.out.println();
    }
    
    public int size(){
        if(inicio == null){
            return 0; 
        }

        int contador = 0;
        NodoDoble<Carta> actual = inicio;

        do{
            contador++;
            actual = actual.getSig(); 
        } while(actual != inicio); 

        return contador; 
    }
    
    public Carta getPrimera(){
        return inicio.getInfo();
    }
}
