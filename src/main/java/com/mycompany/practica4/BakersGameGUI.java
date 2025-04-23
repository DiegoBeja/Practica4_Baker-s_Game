package com.mycompany.practica4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class BakersGameGUI extends javax.swing.JFrame {

    public BakersGameGUI() {
        //initComponents();
        setTitle("Baker's Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(953, 823);
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
        celda1 = new Baraja();
        celda2 = new Baraja();
        celda3 = new Baraja();
        celda4 = new Baraja();
        x = new BakersGame();
        labelsCartas = new ArrayList<>();
        pista = new JButton("Pista");
        
        //Genero las cartas junto con su imagen
        String[] palos = {"Trebol", "Diamante", "Corazon", "Picas"};
        for(int i=0; i<52; i++){
            ImageIcon imgOriginal = new ImageIcon("C:\\Users\\bombo\\Desktop\\Algoritmos\\Practica4\\src\\main\\java\\face\\" + (i+1) + ".png");
            
            //Creo el vector de imagenes
            Image img = imgOriginal.getImage();
            Image nuevaImg = img.getScaledInstance(80, 110, Image.SCALE_SMOOTH);
            cartasImg[i] = new ImageIcon(nuevaImg);
            
            //Genero las cartas
            int numeroCarta = (i % 13) + 1; 
            int paloIndex = i / 13;         
            String paloCarta = palos[paloIndex];
            Carta carta = new Carta(numeroCarta, paloCarta);
            baraja.insertarFin(carta);  //Agrego las cartas a una baraja principal
            labelsCartas.add(new ImgCarta(carta, cartasImg[i]));    //Creo un objeto que contiene la carta y su imagen y lo agrego a un ArrayList
            
        }
        
        Collections.shuffle(labelsCartas);
        
        //De la baraja principal(mezcladas) agrego las cartas a las barajas
        for(int i=0; i<52; i++){
            if (i < 28) { 
                if (i < 7) {
                    baraja1.insertarFin(labelsCartas.get(i).getCarta());
                } else if (i < 14) {
                    baraja2.insertarFin(labelsCartas.get(i).getCarta());
                } else if (i < 21) {
                    baraja3.insertarFin(labelsCartas.get(i).getCarta());
                } else {
                    baraja4.insertarFin(labelsCartas.get(i).getCarta());
                }
            } else{ 
                if (i < 34) {
                    baraja5.insertarFin(labelsCartas.get(i).getCarta());
                } else if (i < 40) {
                    baraja6.insertarFin(labelsCartas.get(i).getCarta());
                } else if (i < 46) {
                    baraja7.insertarFin(labelsCartas.get(i).getCarta());
                } else {
                    baraja8.insertarFin(labelsCartas.get(i).getCarta());
                }
            }
        }
        
        //Genero el label con la imagen y lo agrego al jframe principal
        int cont = 0;
        for(int i = 0; i < 8; i++){
            int columnas = (i < 4) ? 7 : 6;
            for(int j = columnas - 1; j >= 0; j--){
                if(cont < 52){
                    ImgCarta p = labelsCartas.get(cont);
                    switch(i){
                        case 0:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 1:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 2:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 3:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 4:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 5:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 6:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                        case 7:
                            nuevoLabel("", p.getIcon(), 25 + (i * 115), 300 + (j * 25), (Carta) p.getCarta());
                            break;
                    }
                    cont++;
                }
            }
        }
        
        //Genera los espacios de las celdas
        for(int i=0; i<4; i++){
            nuevoLabel("", null, 25+(i*110), 40, null).setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        }
        
        //Genera los espacios de las fundaciones
        for(int i=0; i<4; i++){
            nuevoLabel("", null, 500+(i*110), 40, null).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
        
        pista.setBounds(30, 740, 100, 30);
        pista.setVisible(true);
        add(pista);
        
        pista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Baraja[] barajas = {baraja1, baraja2, baraja3, baraja4, baraja5, baraja6, baraja7, baraja8};
                boolean sePintoAlMenosUna = false;

                for(int i=0; i<barajas.length; i++){
                    Carta cartaActual = (Carta) barajas[i].getPrimera();
                    if(cartaActual == null){
                        continue;
                    }

                    for(int j=0; j<barajas.length; j++){
                        if(i == j){
                            continue;
                        }

                        Carta cartaDestino = (Carta) barajas[j].getPrimera();
                        if(cartaDestino == null){
                            continue;
                        }

                        if(x.sePuedeMover(cartaActual, cartaDestino)){
                            JLabel labelCarta = obtenerLabelDeCarta(cartaActual);
                            if(labelCarta != null){
                                labelCarta.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                sePintoAlMenosUna = true;
                            }
                        }
                    }
                }

                Baraja[] celdas = {celda1, celda2, celda3, celda4};
                for(int i=0; i<celdas.length; i++){
                    Carta cartaCelda = (Carta) celdas[i].getPrimera();
                    if (cartaCelda == null){
                        continue;
                    }

                    for(int j=0; j<barajas.length; j++) {
                        Carta cartaDestino = (Carta) barajas[j].getPrimera();
                        if (cartaDestino == null){
                            continue;
                        }

                        if(x.sePuedeMover(cartaCelda, cartaDestino)){
                            JLabel labelCarta = obtenerLabelDeCarta(cartaCelda);
                            if(labelCarta != null){
                                labelCarta.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                sePintoAlMenosUna = true;
                            }
                        }
                    }
                }
            }
        });
    }
    
    //Genera el jlabel con las especificaciones necesarias para cada cosa
    private JLabel nuevoLabel(String texto, ImageIcon imagen, int x, int y, Carta carta) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(false);
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, 80, 110);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        label.setIcon(imagen);
        if(carta != null){
            label.putClientProperty("carta", carta);
        }
        mover(label);
        add(label); 
        return label;
    }

    //Logica para poder mover las cartas
    private void mover(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                label.setBorder(BorderFactory.createLineBorder(null));
                Carta carta = (Carta) label.getClientProperty("carta");     //Esta es la carta en la que el usuario ha hecho click
                if(!masMovimientos(carta)){
                    JOptionPane.showMessageDialog(null, "Ya no hay mas movimientos", "Fin", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }
                
                //Obtiene la primera carta de cada baraja
                Carta primeraCarta1 = (Carta) baraja1.getPrimera();
                Carta primeraCarta2 = (Carta) baraja2.getPrimera();
                Carta primeraCarta3 = (Carta) baraja3.getPrimera();
                Carta primeraCarta4 = (Carta) baraja4.getPrimera();
                Carta primeraCarta5 = (Carta) baraja5.getPrimera();
                Carta primeraCarta6 = (Carta) baraja6.getPrimera();
                Carta primeraCarta7 = (Carta) baraja7.getPrimera();
                Carta primeraCarta8 = (Carta) baraja8.getPrimera();
                
                if(carta.equals(primeraCarta1) || carta.equals(primeraCarta2) || carta.equals(primeraCarta3) || carta.equals(primeraCarta4) || carta.equals(primeraCarta5) || carta.equals(primeraCarta6) || carta.equals(primeraCarta7) || carta.equals(primeraCarta8)){
                    Baraja origen = null;
                    if(carta.equals(primeraCarta1)){
                        origen = baraja1;
                    } else if(carta.equals(primeraCarta2)){
                        origen = baraja2;
                    } else if(carta.equals(primeraCarta3)){
                        origen = baraja3;
                    } else if(carta.equals(primeraCarta4)){
                        origen = baraja4;
                    } else if(carta.equals(primeraCarta5)){
                        origen = baraja5;
                    } else if(carta.equals(primeraCarta6)){
                        origen = baraja6;
                    } else if(carta.equals(primeraCarta7)){
                        origen = baraja7;
                    } else if(carta.equals(primeraCarta8)){
                        origen = baraja8;
                    }
                    
                    System.out.println("Carta:" + carta.toString());
                    //Compara la carta seleccionada por el usuario con la primera carta de cada baraja
                    for(int i = 0; i < 8; i++){
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

                        if(x.sePuedeMover(carta, cartaTope)){
                            JLabel labelDestino = obtenerLabelDeCarta(cartaTope);
                            Carta cartaPaMover = (Carta) origen.eliminarInicio();
                            if(labelDestino != null){
                                //Mueve el jlabel a la carta correspondiente
                                Point p = labelDestino.getLocation();
                                label.setLocation(p.x, p.y + 25); 
                                Container parent = label.getParent();
                                parent.setComponentZOrder(label, 0); 
                                parent.repaint();
                                switch(i){
                                    case 0:
                                        baraja1.insertarInicio(cartaPaMover);
                                        break;
                                    case 1:
                                        baraja2.insertarInicio(cartaPaMover);
                                        break;
                                    case 2:
                                        baraja3.insertarInicio(cartaPaMover);
                                        break;
                                    case 3:
                                        baraja4.insertarInicio(cartaPaMover);
                                        break;
                                    case 4:
                                        baraja5.insertarInicio(cartaPaMover);
                                        break;
                                    case 5:
                                        baraja6.insertarInicio(cartaPaMover);
                                        break;
                                    case 6:
                                        baraja7.insertarInicio(cartaPaMover);
                                        break;
                                    case 7:
                                        baraja8.insertarInicio(cartaPaMover);
                                        break;
                                }
                                return;
                            }
                            break; 
                        }
                    } 
                    
                    int d = 0;
                    switch(carta.getPalo()){
                        case "Trebol":
                            d = 1;
                            break;
                        case "Diamante":
                            d = 2;
                            break;
                        case "Corazon":
                            d = 3;
                            break;
                        case "Picas":
                            d = 4;
                            break;
                    }
                    //Mueve las cartas a la fundacion correcta
                    if(x.sePuedeFundacion(carta, d)){
                        Carta cartaF = (Carta) origen.eliminarInicio();
                        x.agregarFundacion(cartaF, d);
                        switch(carta.getPalo()){
                            case "Trebol":
                                label.setLocation(500, 40);
                                Container parent = label.getParent();
                                parent.setComponentZOrder(label, 0); 
                                parent.repaint();
                                break;
                            case "Diamante":
                                label.setLocation(610, 40);
                                Container parent2 = label.getParent();
                                parent2.setComponentZOrder(label, 0); 
                                parent2.repaint();
                                break;
                            case "Corazon":
                                label.setLocation(720, 40);
                                Container parent3 = label.getParent();
                                parent3.setComponentZOrder(label, 0); 
                                parent3.repaint();
                                break;
                            case "Picas":
                                label.setLocation(830, 40);
                                Container parent4 = label.getParent();
                                parent4.setComponentZOrder(label, 0); 
                                parent4.repaint();
                                break;
                        }
                        return;
                    }
                    //Si la carta seleccionada no se puede mover a otra carta ni agregar a la fundacion se mueve a una celda, si hay cupo
                    if(!x.celdaLlena()){
                        x.agregarCelda(carta);
                        origen.eliminarInicio();
                        
                        if(celda1.size() == 0){
                            label.setLocation(25, 40);
                            celda1.insertarInicio(carta);
                        } else if(celda2.size() == 0){
                            label.setLocation(135, 40);
                            celda2.insertarInicio(carta);
                        } else if(celda3.size() == 0){
                            label.setLocation(245, 40);
                            celda3.insertarInicio(carta);
                        } else if(celda4.size() == 0){
                            label.setLocation(355, 40);
                            celda4.insertarInicio(carta);
                        }
                        return;
                    }
                }
                
                //Aqui mueve las cartas de las celdas a las demas cartas, si es que se puede
                if(x.getSizeCelda() > 0 && x.getSizeCelda() <= 4){
                    System.out.println("Carta Celda: " + carta.toString());
                    Baraja origenCelda = null;
                    //Obtengo la primera carta de las celdas que tengan cartas
                    for(int i=0; i<x.getSizeCelda(); i++){
                        switch(i){
                            case 0: if(carta.equals(celda1.getPrimera())){origenCelda = celda1;} break;
                            case 1: if(carta.equals(celda2.getPrimera())){origenCelda = celda2;} break;
                            case 2: if(carta.equals(celda3.getPrimera())){origenCelda = celda3;} break;
                            case 3: if(carta.equals(celda4.getPrimera())){origenCelda = celda4;} break;
                        }
                    }
                    if(origenCelda == null){
                        return;
                    }
                    for(int i = 0; i < 8; i++){
                        Carta cartaTopeC = null;
                        switch(i){
                            case 0: cartaTopeC = (Carta) baraja1.getPrimera(); break;
                            case 1: cartaTopeC = (Carta) baraja2.getPrimera(); break;
                            case 2: cartaTopeC = (Carta) baraja3.getPrimera(); break;
                            case 3: cartaTopeC = (Carta) baraja4.getPrimera(); break;
                            case 4: cartaTopeC = (Carta) baraja5.getPrimera(); break;
                            case 5: cartaTopeC = (Carta) baraja6.getPrimera(); break;
                            case 6: cartaTopeC = (Carta) baraja7.getPrimera(); break;
                            case 7: cartaTopeC = (Carta) baraja8.getPrimera(); break;
                        }
                        if(x.sePuedeMover(carta, cartaTopeC)){
                            JLabel labelDestino = obtenerLabelDeCarta(cartaTopeC);
                            Carta cartaPaMover = (Carta) origenCelda.eliminarInicio();
                            x.eliminarCelda(cartaPaMover);
                            if(labelDestino != null){
                                Point p = labelDestino.getLocation();
                                label.setLocation(p.x, p.y + 25); 
                                Container parent = label.getParent();
                                parent.setComponentZOrder(label, 0); 
                                parent.repaint();
                                switch(i){
                                    case 0:
                                        baraja1.insertarInicio(cartaPaMover);
                                        break;
                                    case 1:
                                        baraja2.insertarInicio(cartaPaMover);
                                        break;
                                    case 2:
                                        baraja3.insertarInicio(cartaPaMover);
                                        break;
                                    case 3:
                                        baraja4.insertarInicio(cartaPaMover);
                                        break;
                                    case 4:
                                        baraja5.insertarInicio(cartaPaMover);
                                        break;
                                    case 5:
                                        baraja6.insertarInicio(cartaPaMover);
                                        break;
                                    case 6:
                                        baraja7.insertarInicio(cartaPaMover);
                                        break;
                                    case 7:
                                        baraja8.insertarInicio(cartaPaMover);
                                        break;
                                }
                                return;
                            }
                            break; 
                        }
                    }
                }
            }
        });
    }
    
    public boolean masMovimientos(Carta carta){
        Baraja[] barajas = {baraja1, baraja2, baraja3, baraja4, baraja5, baraja6, baraja7, baraja8};
        for(int i=0; i<barajas.length; i++){
            Carta cartaActual = (Carta) barajas[i].getPrimera();
            if(cartaActual == null){
                continue;
            }
            
            for(int j=0; j<barajas.length; j++){
                if(i == j){
                    continue;
                }
                Carta cartaDestino = (Carta) barajas[j].getPrimera();
                if(cartaDestino == null){
                    continue;
                }
                if(x.sePuedeMover(cartaActual, cartaDestino)){
                    return true;
                }
                if(x.sePuedeFundacion(cartaActual, 1) || x.sePuedeFundacion(cartaActual, 2) || x.sePuedeFundacion(cartaActual, 3) || x.sePuedeFundacion(cartaActual, 4)){
                    return true;
                }
            }
        }
        
        if(x.getSizeCelda() < 4){
            return true;
        }
        
        if(x.getSizeCelda() == 4){
            Carta cartaActual = null;
            for(int i=0; i<x.getSizeCelda(); i++){
                switch(i){
                    case 0: cartaActual = (Carta) celda1.getPrimera(); break;
                    case 1: cartaActual = (Carta) celda2.getPrimera(); break;
                    case 2: cartaActual = (Carta) celda3.getPrimera(); break;
                    case 3: cartaActual = (Carta) celda4.getPrimera(); break;
                }
                
                for(int j=0; j<barajas.length; j++){
                    Carta cartaDestino = (Carta) barajas[j].getPrimera();
                    if(cartaDestino == null){
                        continue;
                    }
                    if(x.sePuedeMover(cartaActual, cartaDestino)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //Obtiene el label que le corresponde a una carta
    private JLabel obtenerLabelDeCarta(Carta cartaBuscada) {
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JLabel){
                JLabel lbl = (JLabel) comp;
                Carta carta = (Carta) lbl.getClientProperty("carta");
                if(carta != null && carta.equals(cartaBuscada)){
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
    private ArrayList<ImgCarta> labelsCartas;
    private Baraja baraja;
    private Baraja baraja1;
    private Baraja baraja2;
    private Baraja baraja3;
    private Baraja baraja4;
    private Baraja baraja5;
    private Baraja baraja6;
    private Baraja baraja7;
    private Baraja baraja8;
    private Baraja celda1;
    private Baraja celda2;
    private Baraja celda3;
    private Baraja celda4;
    private BakersGame x;
    private JButton pista;
}