/*
 * TelaSplash.java
 *
 * Created on 16 de Abril de 2006, 01:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.leonardo.imc;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.IOException;

/**
 *
 * @author Leonardo
 */
public class TelaSplash extends Canvas implements Runnable {
    private byte telaAtual = 0;
    boolean mostrouSplash = false;
    
    /** Creates a new instance of TelaSplash */
    public TelaSplash() {
    }

    protected void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());        
        switch (telaAtual) {
            case 1:
                try {
                    Image imagem2 = Image.createImage("/imc.png");    
                    g.drawImage(imagem2, 
                        (this.getWidth()/2)-(imagem2.getWidth()/2) , 
                        (this.getHeight()/2)-(imagem2.getHeight()/2), 
                        Graphics.TOP | Graphics.LEFT);
                } catch (IOException e) {
                    g.drawString("Não encontrou a imagem2.", 0, 0, Graphics.TOP | Graphics.LEFT);
                }
                break;
            case 2:
                try {
                    Image imagem1 = Image.createImage("/leonardomelo.png");    
                    g.drawImage(imagem1, 
                        (this.getWidth()/2)-(imagem1.getWidth()/2) , 
                        (this.getHeight()/2)-(imagem1.getHeight()/2), 
                        Graphics.TOP | Graphics.LEFT);
                } catch (IOException e) {
                    g.drawString("Não encontrou a imagem1.", 0, 0, Graphics.TOP | Graphics.LEFT);
                }
                break;
            default:
                break;
        }
        
    }

    public void run() {
        try {
            this.telaAtual++;
            this.repaint();
            Thread.sleep(3000);

            /*this.telaAtual++;
            this.repaint();
            Thread.sleep(3000);*/

        } catch (InterruptedException e) {
            
        }
        this.mostrouSplash = true;
    }
    
    public void mostrarTela() {
        Thread t = new Thread(this);
        t.start();
    }
    
}
