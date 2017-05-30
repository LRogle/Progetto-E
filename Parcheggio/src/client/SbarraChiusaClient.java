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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraChiusaClient extends Component {
          
    private BufferedImage img;
    private String schiusa = "./nbproject/Immagini/Chiuso.png";
    
    
    public SbarraChiusaClient() {
           try {
           img = ImageIO.read(new File(schiusa));
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
        panel.add(new SbarraChiusaClient());
        panel.setVisible(true);
        return panel;
    }
    
    
}
 

