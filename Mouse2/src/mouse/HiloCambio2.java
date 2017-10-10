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
public class HiloCambio2 extends Thread {
    
    
    JProgressBar barra2;
    CambioNivel2 niv2;
    
   public HiloCambio2(JProgressBar nivel2, CambioNivel2 cambio2){
       
       barra2= nivel2;
       niv2=cambio2;

   
   }
   public void run(){
  for(int i=0;i<=100;i++){
  
      barra2.setValue(i);
      if(i>0 && i<=50){
          barra2.setForeground(Color.RED);
      }else if (i>50){
          
           barra2.setForeground(Color.YELLOW);
      }
   
   try {
      Thread.sleep(55);
   }catch (InterruptedException ex){
        System.out.println("Error de hilo Intro");
   }
}

  barra2.setForeground(Color.GREEN);
  niv2.setVisible(false);
  Nivel2 n2 = new Nivel2();
  n2.setBounds(30,30,600,520);//setBounds(10, 10, 600,500);
  n2.setLocationRelativeTo(null);
  n2.setVisible(true);
  
  
 
}
   
   
   
    
}

