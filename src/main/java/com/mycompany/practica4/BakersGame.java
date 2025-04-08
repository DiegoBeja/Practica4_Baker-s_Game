package com.mycompany.practica4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BakersGame extends JFrame {

    public BakersGame() {
        setTitle("Arrastra los JLabels");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos layout nulo para poder mover libremente los componentes

        // Crear y agregar varios JLabels de colores
        addColoredLabel("Rojo", Color.RED, 50, 50);
        addColoredLabel("Verde", Color.GREEN, 150, 100);
        addColoredLabel("Azul", Color.BLUE, 250, 150);
        addColoredLabel("Amarillo", Color.YELLOW, 350, 200);
    }

    private void addColoredLabel(String texto, Color color, int x, int y) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, 100, 40);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        makeDraggable(label);
        add(label);
    }

    private void makeDraggable(JLabel label) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BakersGame().setVisible(true);
        });
    }
}

