/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Ignacio
 */
public class FrameProgress extends JFrame {
    JPanel panel;
    JLabel label;
    JLabel labelGen;
    JLabel labelFit;
    
    public FrameProgress(){
        setLayout(new GridLayout(0,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300,300);
        labelFit=new JLabel();
        labelGen=new JLabel();
        label=new JLabel();
        panel=new JPanel();
        panel.add(labelFit);
        panel.add(labelGen);
        panel.add(label);
        add(panel);


        setSize(500,500);
        setVisible(true);
        
    }
    public void exc(ImageIcon icon,String fit,String  gen){
        Progress prog=new Progress(icon,this.label,this.labelGen,this.labelFit,fit,gen);
        prog.start();
    }
    
    
}
