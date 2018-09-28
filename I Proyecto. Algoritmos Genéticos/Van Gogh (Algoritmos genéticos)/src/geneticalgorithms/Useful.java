/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Ignacio
 */
public class Useful {
    public Useful(){};
    
 public Color averageColor(BufferedImage img){
        int QR = 0, QG = 0, QB = 0;
        for(int i = 0; i < img.getWidth(); i++){
            for(int j = 0; j < img.getHeight(); j++){
                Color color = new Color(img.getRGB(i, j));
                QR += color.getRed();
                QG += color.getGreen();
                QB += color.getBlue();
            }
        }
        int size = img.getWidth() * img.getHeight();
        Color avgColor = new Color(QR/size, QG/size, QB/size);
        return avgColor;
    }
 public double colorSimilitudePercentage(BufferedImage img, BufferedImage target){
        
        Color avgColorImg=averageColor(img);
        Color avgColorTarget=averageColor(target);
        int r1=avgColorImg.getRed();
        int r2=avgColorTarget.getRed();
        int g1=avgColorImg.getGreen();
        int g2=avgColorTarget.getGreen();
        int b1=avgColorTarget.getBlue();
        int b2=avgColorTarget.getBlue();
        int diffRed   = Math.abs(r1   - r2);
        int diffGreen = Math.abs(g1 - g2);
        int diffBlue  = Math.abs(b1  - b2);
        
        float pctDiffRed   = (float)diffRed   / 255;
        float pctDiffGreen = (float)diffGreen / 255;
        float pctDiffBlue   = (float)diffBlue  / 255;
        
        int DiferencePercentage=(int) ((pctDiffRed + pctDiffGreen + pctDiffBlue) / 3 * 100);
        return (100-DiferencePercentage);
        
        
    }
 public double colorSimilitudePercentage(Color color1,Color color2){
        int r1=color1.getRed();
        int r2=color2.getRed();
        int g1=color1.getGreen();
        int g2=color2.getGreen();
        int b1=color1.getBlue();
        int b2=color2.getBlue();
        int diffRed   = Math.abs(r1   - r2);
        int diffGreen = Math.abs(g1 - g2);
        int diffBlue  = Math.abs(b1  - b2);
        
        float pctDiffRed   = (float)diffRed   / 255;
        float pctDiffGreen = (float)diffGreen / 255;
        float pctDiffBlue   = (float)diffBlue  / 255;
        
        int DiferencePercentage=(int) ((pctDiffRed + pctDiffGreen + pctDiffBlue) / 3 * 100);
        return (100-DiferencePercentage);
 }
 
 public int randomPixel(){
        int a = (int)(Math.random()*255); //alpha
        int r = (int)(Math.random()*255); //red
        int g = (int)(Math.random()*255); //green
        int b = (int)(Math.random()*255); //blue                 
                
                int gr = (r + g + b)/3;
                //int gr = 0;
                //System.out.println(R);
                
                Color gColor = new Color(gr, gr, gr);
                return gColor.getRGB();
 }
    
}
