package com.mycompany.practica4;

import java.awt.Color;
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
        setLayout(null);
        baraja = new Baraja();
        
        String[] palos = {"Trebol", "Diamante", "Corazon", "Picas"};
        for(int i=0; i<52; i++){
            ImageIcon imgOriginal = new ImageIcon("C:\\Users\\bombo\\Desktop\\Algoritmos\\Practica4\\src\\main\\java\\face\\" + (i+1) + ".png");
            
            Image img = imgOriginal.getImage();
            Image nuevaImg = img.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
            cartasImg[i] = new ImageIcon(nuevaImg);
            
            //Asignar las imagenes de las cartas a objetos tipo carta
            int aux = i+1;
            int auxPalo = i;
            int numeroCarta = (aux < 14) ? (numeroCarta = aux) : (aux = 2);
            int paloCarta = (auxPalo < 4) ? (paloCarta = auxPalo) : (auxPalo = 0);
            Carta carta = new Carta(numeroCarta, palos[paloCarta]);
            baraja.insertarInicio(carta);
        }
        
        int cont = 0;
        for(int i = 0; i < 8; i++){
            int columnas = (i < 4) ? 7 : 6;
            for(int j = columnas - 1; j >= 0; j--){
                if(cont < 52){
                    nuevoLabel("", cartasImg[cont], 25 + (i * 120), 300 + (j * 20));
                    cont++;
                }
            }
        }
        
        baraja.imprimirLista();
    }
    
    private void nuevoLabel(String texto, ImageIcon imagen, int x, int y) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, 60, 90);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        label.setIcon(imagen);
        arrastrar(label);
        add(label); 
    }

    private void arrastrar(JLabel label) {
        final Point[] offset = {new Point()};

        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                offset[0] = e.getPoint();
            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point current = e.getLocationOnScreen();
                SwingUtilities.convertPointFromScreen(current, label.getParent());
                label.setLocation(current.x - offset[0].x, current.y - offset[0].y);
            }
        });
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
}
