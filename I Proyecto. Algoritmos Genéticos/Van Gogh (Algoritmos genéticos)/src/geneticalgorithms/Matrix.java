package geneticalgorithms;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class Matrix {
    private int width;
    private int height;
    private BufferedImage matrix;
    private double fitness=0;
    private Useful usefu=new Useful();
    
    public  Matrix(int _Width, int _height) throws IOException{
        width=_Width;
        height=_height;
        matrix=randomMatrix();
       matrix=toGrayScale(matrix);
    }
    public Matrix(String path) throws IOException{
        BufferedImage img = ImageIO.read(new File(path));
        this.matrix=img;
        this.width=matrix.getWidth();
        this.height=matrix.getHeight();
        //matrix=toGrayScale(img);
        
        
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
    
    
    
    private BufferedImage randomMatrix() throws IOException{
        BufferedImage img=new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int y = 0; y < this.getHeight(); y++){
             for(int x = 0; x < this.getWidth(); x++){
                 Random rand = new Random(System.currentTimeMillis());
                 int a = (int)(Math.random()*256); //alpha
                 int r = (int)(Math.random()*256); //red
                 int g = (int)(Math.random()*256); //green
                 int b = (int)(Math.random()*256); //blue                 
                 int pixel = (a<<24) | (r<<16) | (g<<8) | b;
                 img.setRGB(x, y, pixel);
         }             
}
       return img;    
        
    }
    
    public Matrix CrossOver(Matrix parent1, Matrix parent2,TargetImage target){ 
        int cont=0;
        int valuej=0;
        for(int i=0;i<parent1.getWidth();i+=2){
            for(int j=valuej;j<parent1.getHeight();j+=2){     
                 if(i<parent1.getWidth()-1 && j<parent1.getHeight()-1){
                     cont++;
                     if(cont%2==0){
                         parent1.getMatrix().setRGB(i, j, parent2.getMatrix().getRGB(i, j));
                         parent1.getMatrix().setRGB(i+1, j, parent2.getMatrix().getRGB(i+1, j));
                         parent1.getMatrix().setRGB(i, j+1, parent2.getMatrix().getRGB(i, j+1));
                         parent1.getMatrix().setRGB(i+1, j+1, parent2.getMatrix().getRGB(i+1, j+1));
                     }
                     else{
                         parent1.getMatrix().setRGB(i, j, parent1.getMatrix().getRGB(i, j));
                         parent1.getMatrix().setRGB(i+1, j, parent1.getMatrix().getRGB(i+1, j));
                         parent1.getMatrix().setRGB(i, j+1, parent1.getMatrix().getRGB(i, j+1));
                         parent1.getMatrix().setRGB(i+1, j+1, parent1.getMatrix().getRGB(i+1, j+1));
                     }
                     if(Math.round( Math.random() ) ==0 )
                     {
                     valuej=0;
                     }
                     else{
                         valuej=2;
                     }
                     
            }
                 
            }          

        }
        return parent1;
        
    }
    
   
    
    public void saveMatrix(String path) throws IOException{
         File f = new File(path);
        ImageIO.write(this.matrix, "PNG", f);
        
    }
    
    public void generateMutation(TargetImage target, int porcentaje){
        Useful useful=new Useful();
        //Color colorPromedio = useful.averageColor(target.getMatrix());
        int colorAleatorio = useful.randomPixel();
        Double mutationPercentage = porcentaje * 0.01;
        Double cantidadMutables = target.getHeight() * target.getWidth() * mutationPercentage;
        
        int contador = 0, x, y;
        while(contador < cantidadMutables){
            x = (int)(Math.random()*this.width);
            y = (int)(Math.random()*this.height);
            Color color1=new Color(this.matrix.getRGB(x, y));
            Color color2=new Color(target.getMatrix().getRGB(x, y));
             double similitudeParent1=this.usefu.colorSimilitudePercentage(color1,color2);            
            if(this.getMatrix().getRGB(x, y) != target.getMatrix().getRGB(x, y)){
             //if(similitudeParent1<=80){
                int randomColor=useful.randomPixel();
                this.getMatrix().setRGB(x, y, colorAleatorio);
                contador+=1;
            }
        }
    }
    
   
    //Comparar, ordenar arrayList  por 'fitness'


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

    /**
     * @return the fitness
     */
    public double getFitness() {
        return fitness;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
    
    

    
}
