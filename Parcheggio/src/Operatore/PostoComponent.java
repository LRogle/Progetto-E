/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operatore;

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
public class PostoComponent extends Component{
          
    private BufferedImage img;
    private boolean libero = true;
    private String fileverde = "./Immagini/verde.png";
    private String filerosso = "./Immagini/rosso.png";
    private int codice;
    
    
    public PostoComponent() {
        try {
            img = ImageIO.read(new File(fileverde));
        } catch (IOException e) {
        }
    }

    public void setLibero(boolean libero) {
        this.libero = libero;
    }

    public boolean isLibero() {
        return libero;
    }
    
//standard
    @Override
    public void paint(Graphics g) {
        if (this.libero==true) {
            try {
                img = ImageIO.read(new File(fileverde));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
        else {
            try {
                img = ImageIO.read(new File(filerosso));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
    }

    @Override
    public void repaint() {
        if (this.libero==true) {
            try {
                img = ImageIO.read(new File(fileverde));
            } catch (IOException e) {
                System.out.println("eccezione posto verde");
            }
            super.repaint(); //To change body of generated methods, choose Tools | Templates.
        }
        else {
            try {
                img = ImageIO.read(new File(filerosso));
            } catch (IOException e) {
                System.out.println("eccezione posto rosso");
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

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCodice() {
        return codice;
    }
    
    
}

