package com.mycompany.practica4;

public class NodoDoble <Carta>{
    private Carta info;
    private NodoDoble<Carta> sig;
    private NodoDoble<Carta> ant;

    public NodoDoble(){

    }

    public NodoDoble(Carta info, NodoDoble<Carta> ant, NodoDoble<Carta> sig){
        this.info = info;
        this.ant = ant;
        this.sig = sig;
    }

    public void setSig(NodoDoble<Carta> sig){
       this.sig = sig;
    }

    public NodoDoble<Carta> getSig(){
        return sig;
    }

    public void setAnt(NodoDoble<Carta> ant){
        this.ant = ant;
    }

    public NodoDoble<Carta> getAnt(){
        return ant;
    }

    public void setInfo(Carta info){
        this.info = info;
    }

    public Carta getInfo(){
        return info;
    }

    @Override
    public String toString(){
        return info + " ";
    }
}

