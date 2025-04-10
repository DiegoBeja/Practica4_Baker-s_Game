package com.mycompany.practica4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BakersGameGUI extends javax.swing.JFrame {

    public BakersGameGUI() {
        //initComponents();
        setTitle("Baker's Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(953, 623);
        getContentPane().setBackground(new Color(18, 94, 41));
        setLayout(null);
        baraja = new Baraja();
        baraja1 = new Baraja();
        baraja2 = new Baraja();
        baraja3 = new Baraja();
        baraja4 = new Baraja();
        baraja5 = new Baraja();
        baraja6 = new Baraja();
        baraja7 = new Baraja();
        baraja8 = new Baraja();
        x = new BakersGame();
        
        String[] palos = {"Trebol", "Diamante", "Corazon", "Picas"};
        for(int i=0; i<52; i++){
            ImageIcon imgOriginal = new ImageIcon("C:\\Users\\bombo\\Desktop\\Algoritmos\\Practica4\\src\\main\\java\\face\\" + (i+1) + ".png");
            
            Image img = imgOriginal.getImage();
            Image nuevaImg = img.getScaledInstance(80, 110, Image.SCALE_SMOOTH);
            cartasImg[i] = new ImageIcon(nuevaImg);
            
            int numeroCarta = (i % 13) + 1; 
            int paloIndex = i / 13;         
            String paloCarta = palos[paloIndex];
            Carta carta = new Carta(numeroCarta, paloCarta);
            baraja.insertarFin(carta);
            if (i < 28) { 
                if (i < 7) {
                    baraja1.insertarFin(carta);
                } else if (i < 14) {
                    baraja2.insertarFin(carta);
                } else if (i < 21) {
                    baraja3.insertarFin(carta);
                } else {
                    baraja4.insertarFin(carta);
                }
            } else{ 
                if (i < 34) {
                    baraja5.insertarFin(carta);
                } else if (i < 40) {
                    baraja6.insertarFin(carta);
                } else if (i < 46) {
                    baraja7.insertarFin(carta);
                } else {
                    baraja8.insertarFin(carta);
                }
            }
        }
        
        int cont = 0;
        for(int i = 0; i < 8; i++){
            int columnas = (i < 4) ? 7 : 6;
            for(int j = columnas - 1; j >= 0; j--){
                if(cont < 52){
                    switch(i){
                        case 0:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 1:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 2:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 3:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 4:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 5:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 6:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                        case 7:
                            nuevoLabel("", cartasImg[cont], 25 + (i * 115), 300 + (j * 20), (Carta) baraja.eliminarInicio());
                            break;
                    }
                    cont++;
                }
            }
        }
        
        for(int i=0; i<4; i++){
            nuevoLabel("", null, 25+(i*110), 40, null);
        }
        
        for(int i=0; i<4; i++){
            nuevoLabel("", null, 500+(i*110), 40, null);
        }
        
        baraja1.imprimirLista();
        baraja2.imprimirLista();
        baraja3.imprimirLista();
        baraja4.imprimirLista();
        baraja5.imprimirLista();
        baraja6.imprimirLista();
        baraja7.imprimirLista();
        baraja8.imprimirLista();
    }
    
    private void nuevoLabel(String texto, ImageIcon imagen, int x, int y, Carta carta) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, 80, 110);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        label.setIcon(imagen);
        label.putClientProperty("carta", carta);
        mover(label);
        add(label); 
    }

    private void mover(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Carta carta = (Carta) label.getClientProperty("carta");
                Carta primeraCarta1 = (Carta) baraja1.getPrimera();
                Carta primeraCarta2 = (Carta) baraja2.getPrimera();
                Carta primeraCarta3 = (Carta) baraja3.getPrimera();
                Carta primeraCarta4 = (Carta) baraja4.getPrimera();
                Carta primeraCarta5 = (Carta) baraja5.getPrimera();
                Carta primeraCarta6 = (Carta) baraja6.getPrimera();
                Carta primeraCarta7 = (Carta) baraja7.getPrimera();
                Carta primeraCarta8 = (Carta) baraja8.getPrimera();
                if(carta.equals(primeraCarta1) || carta.equals(primeraCarta2) || carta.equals(primeraCarta3) || carta.equals(primeraCarta4) || carta.equals(primeraCarta5) || carta.equals(primeraCarta6) || carta.equals(primeraCarta7) || carta.equals(primeraCarta8)){
                    if(carta.equals(primeraCarta1)){
                        baraja1.eliminarInicio();
                    } else if(carta.equals(primeraCarta2)){
                        baraja2.eliminarInicio();
                    } else if(carta.equals(primeraCarta3)){
                        baraja3.eliminarInicio();
                    } else if(carta.equals(primeraCarta4)){
                        baraja4.eliminarInicio();
                    } else if(carta.equals(primeraCarta5)){
                        baraja5.eliminarInicio();
                    } else if(carta.equals(primeraCarta6)){
                        baraja6.eliminarInicio();
                    } else if(carta.equals(primeraCarta7)){
                        baraja7.eliminarInicio();
                    } else if(carta.equals(primeraCarta8)){
                        baraja8.eliminarInicio();
                    } 
                    System.out.println("Carta:" + carta.toString());
                    //ME QUEDE AQUI Y LA NETA NO SE QUE HACE
                    for (int i = 0; i < 8; i++) {
                        Carta cartaTope = null;
                        switch(i){
                            case 0: cartaTope = (Carta) baraja1.getPrimera(); break;
                            case 1: cartaTope = (Carta) baraja2.getPrimera(); break;
                            case 2: cartaTope = (Carta) baraja3.getPrimera(); break;
                            case 3: cartaTope = (Carta) baraja4.getPrimera(); break;
                            case 4: cartaTope = (Carta) baraja5.getPrimera(); break;
                            case 5: cartaTope = (Carta) baraja6.getPrimera(); break;
                            case 6: cartaTope = (Carta) baraja7.getPrimera(); break;
                            case 7: cartaTope = (Carta) baraja8.getPrimera(); break;
                        }

                        if (x.sePuedeMover(carta, cartaTope)) {
                            JLabel labelDestino = obtenerLabelDeCarta(cartaTope);
                            if (labelDestino != null) {
                                Point p = labelDestino.getLocation();
                                label.setLocation(p.x, p.y - 20); // Lo colocas encima del tope
                            } else {
                                // Si no hay JLabel (es decir, columna vacía), ubícalo en la posición base de la columna i
                                int xPos = 25 + (i * 115);
                                int yPos = 300 + (0 * 20); // Base de la columna
                                label.setLocation(xPos, yPos);
                            }
                            break; // Ya se movió, sal del bucle
                        }
                    }
                    
                    if(!x.celdaLlena()){
                        x.agregarCelda(carta);
                        switch(x.getSizeCelda()){
                            case 1:
                                label.setLocation(25, 40);
                                break;
                            case 2:
                                label.setLocation(135, 40);
                                break;
                            case 3:
                                label.setLocation(245, 40);
                                break;
                            case 4:
                                label.setLocation(355, 40);
                                break;
                        }
                    }
                }
            }
        });
        
//        label.addMouseMotionListener(new MouseMotionAdapter() {
//            public void mouseDragged(MouseEvent e) {
//                Point current = e.getLocationOnScreen();
//                SwingUtilities.convertPointFromScreen(current, label.getParent());
//                label.setLocation(current.x - offset[0].x, current.y - offset[0].y);
//            }
//        });
    }
    
    private JLabel obtenerLabelDeCarta(Carta cartaBuscada) {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                JLabel lbl = (JLabel) comp;
                Carta carta = (Carta) lbl.getClientProperty("carta");
                if (carta != null && carta.equals(cartaBuscada)) {
                    return lbl;
                }
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartasIzquierda = new javax.swing.JPanel();
        panelBaraja = new javax.swing.JPanel();
        cartasDerecha = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout cartasIzquierdaLayout = new javax.swing.GroupLayout(cartasIzquierda);
        cartasIzquierda.setLayout(cartasIzquierdaLayout);
        cartasIzquierdaLayout.setHorizontalGroup(
            cartasIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        cartasIzquierdaLayout.setVerticalGroup(
            cartasIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBarajaLayout = new javax.swing.GroupLayout(panelBaraja);
        panelBaraja.setLayout(panelBarajaLayout);
        panelBarajaLayout.setHorizontalGroup(
            panelBarajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBarajaLayout.setVerticalGroup(
            panelBarajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cartasDerechaLayout = new javax.swing.GroupLayout(cartasDerecha);
        cartasDerecha.setLayout(cartasDerechaLayout);
        cartasDerechaLayout.setHorizontalGroup(
            cartasDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        cartasDerechaLayout.setVerticalGroup(
            cartasDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBaraja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cartasIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartasDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartasIzquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartasDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBaraja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BakersGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cartasDerecha;
    private javax.swing.JPanel cartasIzquierda;
    private javax.swing.JPanel panelBaraja;
    // End of variables declaration//GEN-END:variables
    private ImageIcon[] cartasImg = new ImageIcon[52];
    private Baraja baraja;
    private Baraja baraja1;
    private Baraja baraja2;
    private Baraja baraja3;
    private Baraja baraja4;
    private Baraja baraja5;
    private Baraja baraja6;
    private Baraja baraja7;
    private Baraja baraja8;
    private BakersGame x;
}
