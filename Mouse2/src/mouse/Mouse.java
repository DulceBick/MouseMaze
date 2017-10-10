/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Dulce
 */
public class Mouse  extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      // CambioNivel4 a = new CambioNivel4();
     //Inicio a= new Inicio();
     
   //  GameOver a=new GameOver();
      //a.setBounds(30,30,340,250);
        Intro a = new Intro();   
       
       //Niveles a= new Niveles();
      //Nivel4 a= new Nivel4();
        //Ganaste a =new Ganaste ();
   //Nivel2 a= new Nivel2();
        //Nivel3 a= new Nivel3();
        // Nivel4 a= new Nivel4();
        //        a.setBounds(30,30,330,250); // GAME OVER
     //  a.setBounds(30,30,330,330);
       a.setBounds(30,30,600,520);//nive1,2,3,4
     //
     //a.setBounds(30,30,700,480);//Menu
        //a.setBounds(30,30,690,480);
        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
     
        
        
    }
    
}
