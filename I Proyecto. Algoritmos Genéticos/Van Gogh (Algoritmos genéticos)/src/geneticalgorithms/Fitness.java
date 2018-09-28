package geneticalgorithms;


import geneticalgorithms.Matrix;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class Fitness {
    
    public Fitness(){};
    
    public Matrix euclideanDistance(Matrix img,TargetImage target){
        double innerSum=0;
        //Sumatoria interna de la formula de distancia euclideana
        for(int i=0;i<img.getWidth();i++){
         for(int j=0;j<img.getHeight();j++){
             Color rgb1=new Color(img.getMatrix().getRGB(i, j));
             Color rgb2=new Color(target.getMatrix().getRGB(i, j));
             int diffR = rgb1.getRed() - rgb2.getRed();
             int diffG = rgb1.getGreen() - rgb2.getGreen();
             int diffB = rgb1.getBlue() - rgb2.getBlue();
             int resAux=diffR*diffR + diffG*diffG + diffB*diffB;
             innerSum+=resAux;
         }
                    
        }
        double result= Math.sqrt(innerSum);        
        img.setFitness((int)(result));
        return img;
    }
    
    public Matrix PixelIndividualComparison(Matrix img,TargetImage target){
        double score=0;
        for(int i=0;i<img.getHeight();i++){
            for(int j=0;j<img.getWidth();j++){
                if(img.getMatrix().getRGB(j, i)==target.getMatrix().getRGB(j, i)){
                    score++;
                }
            }
        }
        int totalPixels=img.getHeight()*img.getWidth();
        score=(score/totalPixels)*100;
        img.setFitness(score);
        return img;
    }
    
    public Matrix myOwnFitnessFunction(Matrix img,TargetImage target){
        Useful useful=new Useful();
        double score=0;
         for(int i=0;i<img.getWidth();i++){
            for(int j=0;j<img.getHeight();j++){                                
                    Color color1=new Color(img.getMatrix().getRGB(i, j));
                    Color color2=new Color(target.getMatrix().getRGB(i, j));
                    double similitudeParent1=useful.colorSimilitudePercentage(color1,color2);            
                    if(similitudeParent1>=80){ 
                        score++;                              
                }
                                                                     
           }
         }
         score=(score/(img.getHeight()*img.getWidth()))*100;
         img.setFitness(score);
        return img;
    }
    

}
