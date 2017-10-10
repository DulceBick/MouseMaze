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
public class HiloCambio3 extends Thread {
    JProgressBar barra3;
    CambioNivel3 niv3;
    
   public HiloCambio3(JProgressBar nivel3, CambioNivel3 cambio3){
       
       barra3= nivel3;
       niv3=cambio3;

   
   }
   public void run(){
  for(int i=0;i<=100;i++){
  
      barra3.setValue(i);
      if(i>0 && i<=50){
          barra3.setForeground(Color.RED);
      }else if (i>50){
          
           barra3.setForeground(Color.YELLOW);
      }
   
   try {
      Thread.sleep(55);
   }catch (InterruptedException ex){
        System.out.println("Error de hilo Intro");
   }
}

  barra3.setForeground(Color.GREEN);
  niv3.setVisible(false);
  Nivel3 n3 = new Nivel3();
  n3.setBounds(30,30,600,520);//setBounds(10, 10, 600,500);
  n3.setLocationRelativeTo(null);
  n3.setVisible(true);
  
  
 
}
    
}
