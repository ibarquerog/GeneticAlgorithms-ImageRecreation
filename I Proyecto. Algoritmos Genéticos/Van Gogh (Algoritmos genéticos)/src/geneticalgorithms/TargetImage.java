/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Paul Villafuerte Beita
 */
public class TargetImage{
    private int width;
    private int height;
    private BufferedImage matrix;
    
    public TargetImage(String path) throws IOException{
        BufferedImage img = ImageIO.read(new File(path));
        matrix = toGrayScale(img);
        this.width=matrix.getWidth();
        this.height=matrix.getHeight();
    }
    
private  BufferedImage toGrayScale(BufferedImage image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getRGB(i, j));
                int R = color.getRed();
                int G = color.getGreen();
                int B = color.getBlue();
                int A = color.getAlpha();
                
                int gr = (R + G + B)/3;
                //int gr = 0;
                //System.out.println(R);
                
                Color gColor = new Color(gr, gr, gr, A);
                image.setRGB(i, j, gColor.getRGB());
            }
        }
        return image;
    }
    
    
    
    
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the matrix
     */
    public BufferedImage getMatrix() {
        return matrix;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(BufferedImage matrix) {
        this.matrix = matrix;
    }
}
