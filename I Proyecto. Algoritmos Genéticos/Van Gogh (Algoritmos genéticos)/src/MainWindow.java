
import geneticalgorithms.Fitness;
import geneticalgorithms.FrameProgress;
import static geneticalgorithms.GeneticAlgorithms.calculateFitness;
import geneticalgorithms.Matrix;
import geneticalgorithms.Population;
import geneticalgorithms.TargetImage;
import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    
    public void main() throws IOException, InterruptedException{
           
        
        double notFitToMutate=Double.parseDouble(this.TextMenosAptos.getText())/100;
        int mutationRate=Integer.parseInt(this.TextMutacion.getText());
        int populationN= Integer.parseInt(this.TextPoblacion.getText());
        
        //Cargar imagen meta
        TargetImage target=new TargetImage(this.TextPathMeta.getText());
        
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
               
                
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\0%.jpg");
                 ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\0%.jpg");
                 this.LabelImg1.setIcon(img);
            }
            if(population.getPopulation()[0].getFitness()>10 && bestPopulation[1]==null){
                
                
                bestPopulation[1]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+1+"0%.jpg");
                 ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\10%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
                this.LabelImg2.setIcon(img);
            }
             if(population.getPopulation()[0].getFitness()>20 && bestPopulation[2]==null){

                 bestPopulation[2]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+2+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
                ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+2+"0%.jpg");
                this.LabelImg3.setIcon(img);
            }
              if(population.getPopulation()[0].getFitness()>30 && bestPopulation[3]==null){
                  bestPopulation[3]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+3+"0%.jpg");
                System.out.print("\n Iteraciones:" + cont+"\n");
                                  ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+3+"0%.jpg");
                this.LabelImg4.setIcon(img);
            }
               if(population.getPopulation()[0].getFitness()>40 && bestPopulation[4]==null){

                   bestPopulation[4]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+4+"0%.jpg");
                ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+4+"0%.jpg");
                this.LabelImg5.setIcon(img);
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                if(population.getPopulation()[0].getFitness()>50 && bestPopulation[5]==null){
                    bestPopulation[5]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+5+"0%.jpg");
                                    ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+5+"0%.jpg");
                this.LabelImg6.setIcon(img);
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                 if(population.getPopulation()[0].getFitness()>60 && bestPopulation[6]==null){

                     bestPopulation[6]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+6+"0%.jpg");
                                     ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+6+"0%.jpg");
                this.LabelImg7.setIcon(img);
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                  if(population.getPopulation()[0].getFitness()>70 && bestPopulation[7]==null){
                      bestPopulation[7]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+7+"0%.jpg");
                                      ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+7+"0%.jpg");
                this.LabelImg8.setIcon(img);
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                   if(population.getPopulation()[0].getFitness()>80 && bestPopulation[8]==null){
                       bestPopulation[8]= population.getPopulation()[0];
                population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+8+"0%.jpg");
                                       ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+8+"0%.jpg");
                this.LabelImg9.setIcon(img);
                System.out.print("\n Iteraciones:" + cont+"\n");
            }
                    if(population.getPopulation()[0].getFitness()>90 && bestPopulation[9]==null){
                      
                        bestPopulation[9]= population.getPopulation()[0];
               population.getPopulation()[0].saveMatrix("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+9+"0%.jpg");
                 ImageIcon img=new ImageIcon("C:\\Users\\Ignacio\\Desktop\\Resultados\\"+9+"0%.jpg");
                this.LabelImg10.setIcon(img);
               System.out.print("\n Iteraciones:" + cont+"n");
               break;
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
        if(this.jComboBox1.getSelectedItem().toString()=="Propia"){
            population=calculateFitness1(population,target);
        }
        else{
            population=calculateFitness2(population,target);
        }
        
        
        
        population.sortPopulation();
       
        
        }
        System.out.print("\n Iteraciones:" + cont);
     population.setPopulation(bestPopulation);
    // population.savePopulationAsImages();
              
            
    }        
    
    
    
     public static Population calculateFitness1(Population population, TargetImage target){
        Fitness fit=new Fitness();
        for(int i=0;i<population.getLength();i++){
            population.getPopulation()[i]=fit.PixelIndividualComparison(population.getPopulation()[i], target);
        }
        return population;
    }
     
          public static Population calculateFitness2(Population population, TargetImage target){
        Fitness fit=new Fitness();
        for(int i=0;i<population.getLength();i++){
            population.getPopulation()[i]=fit.myOwnFitnessFunction(population.getPopulation()[i], target);
        }
        return population;
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextPoblacion = new javax.swing.JTextField();
        TextMutacion = new javax.swing.JTextField();
        TextMenosAptos = new javax.swing.JTextField();
        TextPathMeta = new javax.swing.JTextField();
        LabelImg1 = new javax.swing.JLabel();
        ButtonAceptar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        LabelImg2 = new javax.swing.JLabel();
        LabelImg3 = new javax.swing.JLabel();
        LabelImg4 = new javax.swing.JLabel();
        LabelImg5 = new javax.swing.JLabel();
        LabelImg6 = new javax.swing.JLabel();
        LabelImg7 = new javax.swing.JLabel();
        LabelImg8 = new javax.swing.JLabel();
        LabelImg9 = new javax.swing.JLabel();
        LabelImg10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tamaño de la población");

        jLabel3.setText("% Genes a mutar");

        jLabel4.setText("% Individuos menos aptos a mutar");

        jLabel5.setText("Imagen meta");

        TextPoblacion.setName("TextPoblacion"); // NOI18N

        TextMutacion.setName("TextMutacion"); // NOI18N

        TextMenosAptos.setName("TextMenosAptos"); // NOI18N

        TextPathMeta.setName("TextMenosAptos"); // NOI18N

        LabelImg1.setBackground(new java.awt.Color(0, 255, 153));

        ButtonAceptar.setText("Aceptar");
        ButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAceptarMouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Encontrada", "Propia" }));

        jLabel6.setText("Función adaptabilidad");

        LabelImg2.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg3.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg4.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg5.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg6.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg7.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg8.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg9.setBackground(new java.awt.Color(0, 255, 153));

        LabelImg10.setBackground(new java.awt.Color(0, 255, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(201, 201, 201)
                                        .addComponent(jLabel5)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextPathMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextMenosAptos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonAceptar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelImg6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelImg7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelImg8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelImg9, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelImg10, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TextPathMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAceptar)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TextMenosAptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelImg4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelImg5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelImg6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelImg7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelImg8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelImg9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelImg10, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAceptarMouseClicked
        // TODO add your handling code here:
        
        
        try {
            main();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_ButtonAceptarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAceptar;
    private javax.swing.JLabel LabelImg1;
    private javax.swing.JLabel LabelImg10;
    private javax.swing.JLabel LabelImg2;
    private javax.swing.JLabel LabelImg3;
    private javax.swing.JLabel LabelImg4;
    private javax.swing.JLabel LabelImg5;
    private javax.swing.JLabel LabelImg6;
    private javax.swing.JLabel LabelImg7;
    private javax.swing.JLabel LabelImg8;
    private javax.swing.JLabel LabelImg9;
    private javax.swing.JTextField TextMenosAptos;
    private javax.swing.JTextField TextMutacion;
    private javax.swing.JTextField TextPathMeta;
    private javax.swing.JTextField TextPoblacion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}

