
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author Ignacio
 */
public class GeneticAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        double notFitToMutate=0.3;
        int mutationRate=20;
        int populationN=68;
        
        //Cargar imagen meta
        TargetImage target=new TargetImage("C:\\Users\\Ignacio\\Desktop\\y.jpg");
        
       //Generar poblacion
        Population population=new Population(target.getWidth(),target.getHeight(),populationN);
        
        //Aplicar funcion de adaptabilidad a la poblacion inicial
        population=calculateFitness(population,target);
        population.sortPopulation();;
        
        // Ordenar por "fitness"
	   
	
        
        
        
        //La nueva   población de hijos y mutaciones que  se reemplaza por la vieja
        Matrix[]temporalPopulation=new Matrix[population.getLength()];
        
        FrameProgress fp=new FrameProgress();
        Random random = new Random();
        Matrix [] bestPopulation=new Matrix[10];
        int cont=0;
        while(true){
            ImageIcon icon=new ImageIcon(population.getPopulation()[0].getMatrix());
            fp.exc(icon,String.valueOf(population.getPopulation()[0].getFitness()),String.valueOf(cont));
            cont++;
            
 
            
            if(bestPopulation[0]==null){
                bestPopulation[0]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\o%.jpg");
                
            }
            if(population.getPopulation()[0].getFitness()>10 && bestPopulation[1]==null){
                bestPopulation[1]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+1+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
             if(population.getPopulation()[0].getFitness()>20 && bestPopulation[2]==null){
                 bestPopulation[2]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+2+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
              if(population.getPopulation()[0].getFitness()>30 && bestPopulation[3]==null){
                  bestPopulation[3]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+3+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
               if(population.getPopulation()[0].getFitness()>40 && bestPopulation[4]==null){
                   bestPopulation[4]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+4+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                if(population.getPopulation()[0].getFitness()>50 && bestPopulation[5]==null){
                    bestPopulation[5]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+5+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                 if(population.getPopulation()[0].getFitness()>60 && bestPopulation[6]==null){
                     bestPopulation[6]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+6+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                  if(population.getPopulation()[0].getFitness()>70 && bestPopulation[7]==null){
                      bestPopulation[7]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+7+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                   if(population.getPopulation()[0].getFitness()>80 && bestPopulation[8]==null){
                       bestPopulation[8]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+8+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                    if(population.getPopulation()[0].getFitness()>90 && bestPopulation[9]==null){
                        bestPopulation[9]= population.getPopulation()[0];
               population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+9+"0%.jpg");
               System.out.print("\n Iteraciones:" + cont+"n");
               
            }
                   
            
            
            //population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+q+".jpg");
            
           
            //population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+q+".jpg");
            //Generar el 'mating pool' dentro de la clase Population
            population.generateMatingPool((int) (population.getLength()-(population.getLength()*notFitToMutate)));
            int low = 0;
            int high = (int) (population.getLength()-(population.getLength()*notFitToMutate));
            Matrix[] fit=Arrays.copyOfRange(population.getPopulation(), 0, high);
            int f=fit.length;
            Matrix[] notFit=Arrays.copyOfRange(population.getPopulation(),high,population.getLength());
            int nf=notFit.length;
        for(int i=0;i<fit.length;i++){
           
           int a=random.nextInt((high-1)-low) + low;
           int b=random.nextInt((high-1)-low) + low;           
           Matrix parentA=(Matrix) population.getMatingPool().get(a);
           Matrix parentB=(Matrix) population.getMatingPool().get(b);
           Matrix child=parentA.CrossOver(parentA, parentB,target);
           temporalPopulation[i]=child;
           
           if(i==fit.length-1){
               for(int k=0;k<notFit.length;k++){
                   i++;
                   Matrix parent=notFit[k];
                   parent.generateMutation(target, mutationRate);
                   temporalPopulation[i]=parent;
                   
               }
           }
           
        }

        population.setPopulation(temporalPopulation);
        
        //Calcula el % de similitud con la nueva generación
        population=calculateFitness(population,target);
        population.sortPopulation();
       
        
        }
        System.out.print("\n Iteraciones:" + cont);
     population.setPopulation(bestPopulation);
    // population.savePopulationAsImages();
              
            
    }
    
    public static Population calculateFitness(Population population, TargetImage target){
        Fitness fit=new Fitness();
        for(int i=0;i<population.getLength();i++){
            population.getPopulation()[i]=fit.PixelIndividualComparison(
                    
                    population.getPopulation()[i], target);
        }
        return population;
    }
    

    

    
}
