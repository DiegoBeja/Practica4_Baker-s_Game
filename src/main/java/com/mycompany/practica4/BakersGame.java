package com.mycompany.practica4;

import java.util.ArrayList;

public class BakersGame{
    private ArrayList<Carta> celda;
    private ArrayList<Carta> fundacion1;
    private ArrayList<Carta> fundacion2;
    private ArrayList<Carta> fundacion3;
    private ArrayList<Carta> fundacion4;

    public BakersGame(){
        celda = new ArrayList<>();
        fundacion1 = new ArrayList<>();
        fundacion2 = new ArrayList<>();
        fundacion3 = new ArrayList<>();
        fundacion4 = new ArrayList<>();    
    }
    
    public boolean sePuedeMover(Carta origen, Carta destino){
        if((destino.getNumero() == origen.getNumero() + 1) && (destino.getPalo().equals(origen.getPalo()))){
            return true;
        }
        return false;
    }
    
    public boolean sePuedeFundacion(Carta cartaF, int cualFundacion){
        switch(cualFundacion){
            case 1:
                if(fundacion1.isEmpty() && cartaF.getNumero() == 1){
                    return true;
                } else if(!fundacion1.isEmpty() && cartaF.getNumero() - 1 == fundacion1.getLast().getNumero()){
                    return true;
                }
                break;
                
            case 2:
                if(fundacion2.isEmpty()&& cartaF.getNumero() == 1){
                    return true;
                } else if(!fundacion2.isEmpty() && cartaF.getNumero() - 1 == fundacion2.getLast().getNumero()){
                    return true;
                }
                break;
                
            case 3:
                if(fundacion3.isEmpty()&& cartaF.getNumero() == 1){
                    return true;
                } else if(!fundacion3.isEmpty() && cartaF.getNumero() - 1 == fundacion3.getLast().getNumero()){
                    return true;
                }
                break;
                
            case 4:
                if(fundacion4.isEmpty()&& cartaF.getNumero() == 1){
                    return true;
                } else if(!fundacion4.isEmpty() && cartaF.getNumero() - 1 == fundacion4.getLast().getNumero()){
                    return true;
                }
                break;
        }
        return false;
    }
    
    public void agregarFundacion(Carta cartaF, int cualFundacion){
        switch(cualFundacion){
            case 1: fundacion1.add(cartaF); break;
            case 2: fundacion2.add(cartaF); break;
            case 3: fundacion3.add(cartaF); break;
            case 4: fundacion4.add(cartaF); break;
        }
    }
    
    public boolean agregarCelda(Carta carta){
        if(!celdaLlena()){
            celda.add(carta);
            return true;
        }
        return false;
    }
    
    public boolean victoria(){
        if(fundacion1.size() == 13 && fundacion2.size() == 13 && fundacion3.size() == 13 && fundacion4.size() == 13){
            return true;
        }
        return false;
    }
    
    public boolean celdaLlena(){
        if(celda.size() < 4){
            return false;
        }
        return true;
    }
    
    public int getSizeCelda(){
        return celda.size();
    }
    
    public void eliminarCelda(Carta index){
        celda.remove(index);
    }
}

