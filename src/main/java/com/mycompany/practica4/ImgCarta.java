package com.mycompany.practica4;

import javax.swing.ImageIcon;

public class ImgCarta {
    private Carta carta;
    private ImageIcon icon;

    public ImgCarta(Carta carta, ImageIcon icon) {
        this.carta = carta;
        this.icon = icon;
    }
    
    public Carta getCarta(){
        return this.carta;
    }
    
    public ImageIcon getIcon(){
        return this.icon;
    }
}
