/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;
import java.io.File;
import java.awt.Color;
import javax.swing.JProgressBar;



/**
 *
 * @author Dulce
 */
public class HiloIntro  extends Thread{
    
    
   JProgressBar barrac;
   Intro intr;

        
    public HiloIntro(JProgressBar baca,Intro ino){
   barrac=baca;
   intr=ino;
    
}
    
    
    
public void run(){
   
  for(int i=0;i<=100;i++){
  
      barrac.setValue(i);
      if(i>0 && i<=30){
          barrac.setForeground(Color.RED);
      }else if (i>40){
          
           barrac.setForeground(Color.YELLOW);
      }
  try {
      Thread.sleep(100);
   }catch (InterruptedException ex){
        System.out.println("Error de hilo Intro");
   }
}
  
  barrac.setForeground(Color.GREEN);
  Inicio j = new Inicio();
  j.setBounds(30,30,700,480);
  j.setLocationRelativeTo(null);
  j.setVisible(true);
  intr.setVisible(false);
  
  
   /*Nivel2 n = new Nivel2 ();
 n.setBounds(30,30,700,710);
  n.setVisible(true);
  j.setVisible(false);*/
 
}

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}





