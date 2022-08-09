package visao;

import controlador.Atacar;
import controlador.Controle;
import controlador.MoverBaixo;
import controlador.MoverCima;
import controlador.MoverDireita;
import controlador.MoverEsquerda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ataque.AtaqueForte;
import ataque.AtaqueFraco;
import modelo.Andarilho;

public class VisualGame extends JPanel{
    private Controle controle;
    private Andarilho personagem;
    private Andarilho inimigo1;
    private Andarilho inimigo2;
    private Andarilho inimigo3;

    private int restantes;

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setFont(getFont().deriveFont(40f));
        g2d.drawString("Life: "+personagem.getEnergia(), 10, 600);
        g2d.drawString("Inimigos restantes: "+restantes, 10, 650);

        if (restantes == 0) {
            g2d.setFont(getFont().deriveFont(70f));
            g2d.setColor(Color.GREEN);
            g2d.drawString("VICTORY!", 180, 330);
        }

        g2d.setColor(Color.BLUE);
        g2d.fillOval(personagem.getX(), personagem.getY(), 20, 20);

        if (inimigo1.getEnergia() != 0) {g2d.setColor(Color.RED);}
        else {g2d.setColor(Color.BLACK);}
        g2d.fillOval(inimigo1.getX(), inimigo1.getY(), 20, 20);

        if (inimigo2.getEnergia() != 0) {g2d.setColor(Color.RED);}
        else {g2d.setColor(Color.BLACK);}
        g2d.fillOval(inimigo2.getX(), inimigo2.getY(), 20, 20);

        if (inimigo3.getEnergia() != 0) {g2d.setColor(Color.RED);}
        else {g2d.setColor(Color.BLACK);}
        g2d.fillOval(inimigo3.getX(), inimigo3.getY(), 20, 20);
    }

    public void jogar(VisualGame game) throws InterruptedException {
        JFrame frame = new JFrame("Adventure!");
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);

        personagem = new Andarilho(50, 50);
        inimigo1 = new Andarilho(100, 100);
        inimigo2 = new Andarilho(50, 100);
        inimigo3 = new Andarilho(0, 50);

        personagem.setAtaque(new AtaqueForte());
        inimigo1.setAtaque(new AtaqueFraco());
        inimigo2.setAtaque(new AtaqueFraco());
        inimigo3.setAtaque(new AtaqueFraco());

        personagem.observar(inimigo1);
        personagem.observar(inimigo2);
        personagem.observar(inimigo3);

        controle = new Controle();
        controle.addComando(new MoverEsquerda(personagem), 0);
        controle.addComando(new MoverDireita(personagem), 1);
        controle.addComando(new MoverCima(personagem), 2);
        controle.addComando(new MoverBaixo(personagem), 3);

        controle.addComando(new Atacar(personagem, inimigo1), 4);
        controle.addComando(new Atacar(personagem, inimigo2), 5);
        controle.addComando(new Atacar(personagem, inimigo3), 6);

        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;

        restantes = 3;

        while (personagem.getEnergia() > 0) {
            personagem.notificar();
            game.repaint();
            Thread.sleep(50);

            if (flag1 && inimigo1.getEnergia() <= 0) {
                personagem.deixarDeObservar(inimigo1);
                flag1 = false;
                restantes--;
            }

            if (flag2 && inimigo2.getEnergia() <= 0) {
                personagem.deixarDeObservar(inimigo2);
                flag2 = false;
                restantes--;
            }

            if (flag3 && inimigo3.getEnergia() <= 0) {
                personagem.deixarDeObservar(inimigo3);
                flag3 = false;
                restantes--;
            }
        }

        if (personagem.getEnergia() <= 0) {
            System.out.println("Morreu!!");
        }
    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT){                
                controle.pressionar(0);    
            }
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                controle.pressionar(1);    
               
            if (e.getKeyCode() == KeyEvent.VK_UP)
                controle.pressionar(2);    
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                controle.pressionar(3);    
               
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                controle.pressionar(4);
                controle.pressionar(5);
                controle.pressionar(6);
            }    
    
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
