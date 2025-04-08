package com.mycompany.practica4;

public class Carta implements Comparable<Carta>{
    private int numero;
    private String palo;
    
    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }
    
    public Carta(){
        
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getPalo(){
        return palo;
    }
    
    @Override
    public int compareTo(Carta x){
        if(this.getPalo() == x.getPalo()){
            if(this.getNumero() > x.getNumero()){
                return 1;
            } else if(this.getNumero() < x.getNumero()){
                return -1;
            } else{
                return 0;
            }
        } else{
            return 0;
        }
    }
}
