/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2d;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class LoFeather extends JPanel {

    private Color color; // armazena cor utilizada para desenhar o fractal
    private int level; // armazena o nível atual do fractal

    private static final int WIDTH = 400; // define a largura do JPanel
    private static final int HEIGHT = 400; // define a altura do JPanel

    // configura o nível do fractal inicial com o valor especificado
    // e configura as especificações do JPanel
    public LoFeather(int currentLevel) {
        color = Color.BLACK; // inicializa a cor do desenho como azul
        level = currentLevel; // configura o nível do fractal inicial
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // desenha o padrão de fractal
                g.setColor(color);
                drawFractal(level, 100, 90, 290, 200, g);
            }
        };
        panel.setPreferredSize(new Dimension(400, 400));

        frame.add(panel);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
// desenha o fractal recursivamente 

    public void drawFractal(int level, int xA, int yA, int xB,
            int yB, Graphics g) {
        // caso básico: desenha uma linha conectando dois pontos dados 
        if (level == 0) {
            g.drawLine(xA, yA, xB, yB);
        } else // passo de recursão: determina novos pontos, desenha próximo nível
        {
            // calcula ponto intermediário entre (xA, yA) e (xB, yB) 
            int xC = (xA + xB) / 2;
            int yC = (yA + yB) / 2;

            // calcula o quarto ponto (xD, yD) que forma um 
            // triângulo isósceles entre (xA, yA) e (xC, yC) 
            // onde o ângulo direito está a (xD, yD)
            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

            // desenha recursivamente o Fractal
            drawFractal(level - 1, xD, yD, xA, yA, g);
            drawFractal(level - 1, xD, yD, xC, yC, g);
            drawFractal(level - 1, xD, yD, xB, yB, g);
        }
    }

    // começa a desenhar o fractal
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // desenha o padrão de fractal
        g.setColor(color);
        drawFractal(level, 100, 90, 290, 200, g);
    }

    // configura o novo nível de recursão
    public void setLevel(int currentLevel) {
        level = currentLevel;
    }

    // retorna o nível de recursão
    public int getLevel() {
        return level;
    }
}
