/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class FractalTree extends JFrame {

    private int numRecursoes;

    public void setNumRecursoes(int numRecursoes) {
        this.numRecursoes = numRecursoes;
    }

    public int getNumRecursoes() {
        return numRecursoes;
    }

    public FractalTree() {
        super("FractalTree");
        setBounds(500, 25, 1000, 1000);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void desenhaArvore(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) {
            return;
        }
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5.0);
        g.drawLine(x1, y1, x2, y2);
        desenhaArvore(g, x2, y2, angle - 20, depth - 1);
        desenhaArvore(g, x2, y2, angle + 20, depth - 1);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        int num = getNumRecursoes();
        desenhaArvore(g, 500, 800, -90, num);
    }

    public static void main(String[] args) {
    }

}
