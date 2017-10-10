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
public class HiloNivel3 extends Thread{
    
    
        
    JLabel mouse= new JLabel(); 
    JLabel vid1 = new JLabel();
    
     public HiloNivel3 (JLabel mou,JLabel vid){
  
    mouse=mou;
    vid1 = vid;
  

    }
    
}
