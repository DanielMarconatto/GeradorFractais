/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author danie
 */
public class SierpinskiCarpet extends JPanel {

    public SierpinskiCarpet(int iter) {
        //int i = 5;
        final int level = iter;

        JFrame frame = new JFrame("Sierpinsky Triangle - Java");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.BLACK);
                drawSierpinskyTriangle(level, 20, 20, 360, (Graphics2D) g);
            }
        };

        panel.setPreferredSize(new Dimension(400, 400));

        frame.add(panel);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void drawSierpinskyTriangle(int level, int x, int y, int size, Graphics2D g) {
        if (level <= 0) {
            return;
        }

        g.drawLine(x, y, x + size, y);
        g.drawLine(x, y, x, y + size);
        g.drawLine(x + size, y, x, y + size);

        drawSierpinskyTriangle(level - 1, x, y, size / 2, g);
        drawSierpinskyTriangle(level - 1, x + size / 2, y, size / 2, g);
        drawSierpinskyTriangle(level - 1, x, y + size / 2, size / 2, g);
    }
}
