/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientIngresso;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author luca
 */
public class SbarraClient extends Component {
          
    private BufferedImage img;
    private boolean aperta = false;
    private String sbarraAperta = "./Immagini/Aperto.png";
    private String sbarraChiusa = "./Immagini/Chiuso.png";
    
    
    public SbarraClient() {
        try {
            img = ImageIO.read(new File(sbarraChiusa));
        } catch (IOException e) {
        }
    }

    public void setAperta(boolean aperta) {
        this.aperta = aperta;
    }
    
//standard
    @Override
    public void paint(Graphics g) {
        if (this.aperta==true) {
        System.out.println("ridisegno");
            try {
                img = ImageIO.read(new File(sbarraAperta));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
        else {
            try {
                img = ImageIO.read(new File(sbarraChiusa));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
    }

    @Override
    public void repaint() {
        if (this.aperta==true) {
            try {
                img = ImageIO.read(new File(sbarraAperta));
            } catch (IOException e) {
            }
            super.repaint(); //To change body of generated methods, choose Tools | Templates.
        }
        else {
            try {
                img = ImageIO.read(new File(sbarraChiusa));
            } catch (IOException e) {
            }
            super.repaint();
        }
        
    }
    
//standard
    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
    
    
}