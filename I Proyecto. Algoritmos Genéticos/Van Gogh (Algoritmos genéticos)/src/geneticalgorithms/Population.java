/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 *
 * @author Ignacio
 * Clase con un arreglo donde se guarda la poblacion inicial de n individuos
 */
public class Population {
    private Matrix [] population;
    private int length;
    /*Aqui se van a guardar el 'ADN'
    de acuerdo al % de similitud con la imagen target, para aumentar
    la posibildad de cruce*/    
    private ArrayList<Matrix> matingPool=new ArrayList<Matrix>();
    
    public Population(int width,int hight,int n) throws IOException{
        population=new Matrix[n];
        this.length=n;
        generateRandomPopulation(width,hight,n);
    }

    private void generateRandomPopulation(int width,int height,int n) throws IOException{
        for(int i=0;i<n;i++){
            Matrix matrix=new Matrix(width,height);
            this.getPopulation()[i]=matrix;
        }
    }
    
    public void generateMatingPool( int end){
        this.matingPool.clear();
        for(int i=0;i<end;i++){
            int n=(int) getPopulation()[i].getFitness()/10;
            if(n==0){
                matingPool.add(getPopulation()[i]);
            }
            for(int k=0;k<n;k++){
                Matrix matrixAux=this.population[i];
                getMatingPool().add(getPopulation()[i]);
            }
        }
    }
    
    
    public void savePopulationAsImages() throws IOException{
        for(int i=0;i<this.population.length;i++){
            population[i].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+i+".jpg");
        }
    }
    
   public void sortPopulation(){

    int n = this.length;
    Matrix temp;

    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {

            if (this.population[j - 1].getFitness() > this.population[j].getFitness()) {
                temp = this.population[j - 1];
                this.population[j - 1] = this.population[j];
                this.population[j] = temp;
            }

        }
    }
    Collections.reverse(Arrays.asList(population));
    printArray();
}
   public void printArray(){
       for(int i=0;i<this.population.length;i++ ){
       System.out.print(this.population[i].getFitness()+"-");
       }
       System.out.print("\n");
   }
   
   public void invertPopulationArray(){
       
   }
   

    /**
     * @return the population
     */
    public Matrix[] getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(Matrix[] population) {
        this.population = population;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the matingPool
     */
    public ArrayList getMatingPool() {
        return matingPool;
    }

    /**
     * @param matingPool the matingPool to set
     */
    public void setMatingPool(ArrayList matingPool) {
        this.matingPool = matingPool;
    }
}
