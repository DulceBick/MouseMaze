/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import javax.swing.JLabel;

/**
 *
 * @author Dulce
 */
public class HiloNivel4 extends Thread{
    JLabel mouse= new JLabel(); 
    JLabel pun = new JLabel();
    
     public HiloNivel4(JLabel mou,JLabel puntaje){
  
    mouse=mou;
    pun = puntaje;
  

    }
}
