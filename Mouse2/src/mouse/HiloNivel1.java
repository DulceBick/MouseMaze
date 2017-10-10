/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dulce
 */
public class HiloNivel1 extends Thread {
    

    JLabel mouse= new JLabel(); 
    JLabel punt1 = new JLabel();
    JLabel vid1 = new JLabel();
    
    
       
    public HiloNivel1 (JLabel mou,JLabel pun, JLabel vid){
  
    mouse=mou;
    punt1 = pun;
    vid1 = vid;
  

    }


}
