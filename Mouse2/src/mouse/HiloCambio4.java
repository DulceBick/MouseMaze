/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.awt.Color;
import javax.swing.JProgressBar;

/**
 *
 * @author Dulce
 */
public class HiloCambio4 extends Thread {
    JProgressBar barra4;
    CambioNivel4 niv4;
    
   public HiloCambio4(JProgressBar nivel4, CambioNivel4 cambio4){
       
       barra4= nivel4;
       niv4 = cambio4;

   
   }
   public void run(){
  for(int i=0;i<=100;i++){
  
      barra4.setValue(i);
      if(i>0 && i<=50){
          barra4.setForeground(Color.RED);
      }else if (i>50){
          
           barra4.setForeground(Color.YELLOW);
      }
   
   try {
      Thread.sleep(55);
   }catch (InterruptedException ex){
        System.out.println("Error de hilo Intro");
   }
}

  barra4.setForeground(Color.GREEN);
  niv4.setVisible(false);
  Nivel4 n4 = new Nivel4();
  n4.setBounds(30,30,600,520);//setBounds(10, 10, 600,500);
  n4.setLocationRelativeTo(null);
  n4.setVisible(true);
  
  
 
}
    
}
