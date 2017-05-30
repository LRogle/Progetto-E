/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import GUI.*;
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
public class SbarraApertaClient extends Component {
          
    private BufferedImage img;
    private String saperta = "./nbproject/Immagini/Aperto.png";
    
    
    public SbarraApertaClient() {
           try {
           img = ImageIO.read(new File(saperta));
       } catch (IOException e) {
       }
    }
    
//standard
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
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
    
    
    public JPanel functionMain(){
        JPanel panel = new JPanel();
        panel.add(new SbarraApertaClient());
        
        panel.setVisible(true);
        return panel;
    }
    
    
}