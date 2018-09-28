package geneticalgorithms;


import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class Progress extends Thread
{
    JLabel  label;
    JLabel labelFit;
    ImageIcon image;
    JLabel labelGen;
    String fit;
    String gen;
    
    public Progress(ImageIcon img,JLabel _label,JLabel _labelFit,JLabel _labelGen,String _fit,String gen){
        this.labelFit=_labelFit;
        this.labelGen=_labelGen;
        this.image=img;
        this.label=_label;
        
        
    }
    
    @Override
    public void run(){
         this.label.setIcon(image);
         this.labelFit.setText(fit);
         this.labelGen.setText(gen);
        
    }
    
}
