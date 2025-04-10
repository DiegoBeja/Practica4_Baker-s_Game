package com.mycompany.practica4;

import java.util.ArrayList;

public class BakersGame{
    private Baraja baraja;
    private ArrayList<Carta> celda;
    private ArrayList<Carta> fundacion1;
    private ArrayList<Carta> fundacion2;
    private ArrayList<Carta> fundacion3;
    private ArrayList<Carta> fundacion4;

    public BakersGame() {
        baraja = new Baraja<Carta>();
        celda = new ArrayList<>();
        fundacion1 = new ArrayList<>();
        fundacion2 = new ArrayList<>();
        fundacion3 = new ArrayList<>();
        fundacion4 = new ArrayList<>();    }
    
    public boolean sePuedeMover(Carta origen, Carta destino){
        if((destino.getNumero() == origen.getNumero() + 1) && (destino.getPalo().equals(destino.getPalo()))){
            return true;
        }
        return false;
    }
    
    public boolean agregarFundacion(Carta cartaF, int cualFundacion){
        switch(cualFundacion){
            case 1:
                if(fundacion1.isEmpty()){
                    fundacion1.add(cartaF);
                    return true;
                } else if(!fundacion1.isEmpty() && fundacion1.getLast().getNumero() < cartaF.getNumero()){
                    fundacion1.add(cartaF);
                    return true;
                }
                break;
                
            case 2:
                if(fundacion2.isEmpty()){
                    fundacion2.add(cartaF);
                    return true;
                } else if(!fundacion2.isEmpty() && fundacion2.getLast().getNumero() < cartaF.getNumero()){
                    fundacion2.add(cartaF);
                    return true;
                }
                break;
                
            case 3:
                if(fundacion3.isEmpty()){
                    fundacion3.add(cartaF);
                    return true;
                } else if(!fundacion3.isEmpty() && fundacion3.getLast().getNumero() < cartaF.getNumero()){
                    fundacion3.add(cartaF);
                    return true;
                }
                break;
                
            case 4:
                if(fundacion4.isEmpty()){
                    fundacion4.add(cartaF);
                    return true;
                } else if(!fundacion4.isEmpty() && fundacion4.getLast().getNumero() < cartaF.getNumero()){
                    fundacion4.add(cartaF);
                    return true;
                }
                break;
        }
        return false;
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
}

