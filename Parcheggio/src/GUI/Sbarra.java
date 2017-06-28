/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class Sbarra extends Component {
          
    private BufferedImage img;
    private boolean aperta = false;
    private String saperta = "./Immagini/Aperto.png";
    private String schiusa = "./Immagini/Chiuso.png";
    
    
    public Sbarra() {
        try {
            img = ImageIO.read(new File(schiusa));
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
                img = ImageIO.read(new File(saperta));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
        else {
            try {
                img = ImageIO.read(new File(schiusa));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
    }

    @Override
    public void repaint() {
        if (this.aperta==true) {
            try {
                img = ImageIO.read(new File(saperta));
            } catch (IOException e) {
            }
            super.repaint(); //To change body of generated methods, choose Tools | Templates.
        }
        else {
            try {
                img = ImageIO.read(new File(schiusa));
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