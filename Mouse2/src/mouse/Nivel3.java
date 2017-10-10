/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static mouse.Nivel1.puntos;
import static mouse.Nivel1.vidas;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Dulce
 */
public class Nivel3 extends javax.swing.JFrame implements KeyListener{
    HiloNivel3 h1;
    public static int vidas = 3;
    public static int puntos = 0;
    JLabel background;
    JLabel[][] lab = new JLabel[100][100];
    String[][] vc = new String[100][100];    
       int matriz[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                         {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                         {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                         {1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
                         {1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1},
                         {1,0,1,0,1,0,0,0,0,0,0,0,2,0,1,0,1,0,1},
                         {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1},
                         {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
                         {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                         {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                         {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    BasicPlayer sonido;
    String perder ="C:\\Mouse2\\lose.mp3";
    
    /**
     * Creates new form Nivel1
     */
    
    public Nivel3() {
        initComponents();
         setTitle("Nivel 3 -> Cuarto");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/7535422-Mouse-asustado-Looking-Up--Foto-de-archivo.jpg"));
        setIconImage(icon);
        llenado();
        encontrar();
    }
    
    public void llenado(){               
        for(int i=0;i<matriz.length;i++){
            for(int l=0;l<matriz[i].length;l++){                
                if(matriz[i][l]==1){
                    int x2=0+(l*30);
                    int y2=50+(i*30);
                    lab[i][l]=new JLabel();
                    lab[i][l].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/3.png")).getImage()));
                    lab[i][l].setBounds(x2, y2, 30,30);
                    lab[i][l].setVisible(true);
                    this.add(lab[i][l]);
                }
                else{
                    if(matriz[i][l]==2){
                    int x2=0+(l*30);
                    int y2=50+(i*30);
                    lab[i][l]=new JLabel();
                    lab[i][l].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/trampa.png")).getImage()));
                    lab[i][l].setBounds(x2, y2, 30,30);
                    lab[i][l].setVisible(true);
                    this.add(lab[i][l]);
                }else{
                    lab[i][l]=null;
                }
                }
                }    
            }
        background = new JLabel();
        background.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/NIÑO.jpg")).getImage()));
        background.setBounds(0, 0, 630, 520);
        this.add(background);
    }    
    public void encontrar(){        
        int x;
        int y;
        for(int i=0;i<matriz.length;i++){
            for(int l=0;l<matriz[i].length;l++){ 
                if(matriz[i][l]==1){
                    x = (int)lab[i][l].getLocation().getX();                                        
                    y = (int)lab[i][l].getLocation().getY();
                    vc[i][l] = Integer.toString(x)+" "+Integer.toString(y);                    
                }
                if(matriz[i][l]==2){
                    x = (int)lab[i][l].getLocation().getX();                                        
                    y = (int)lab[i][l].getLocation().getY();
                                      
                }
            }
        }
    }
    public void validar(Point coor, char le,int x,int y){    
        int x2 = (int)coor.getLocation().getX();
        int y2 = (int)coor.getLocation().getY();        
        String cc = x2+" "+y2;
        for(int i=0;i<matriz.length;i++){
            for(int l=0;l<matriz[i].length;l++){                
                if(cc == null ? vc[i][l] == null : cc.equals(vc[i][l])){
                    if(le=='s'){
                        etq_raton.setLocation(x, y-30);  
                    }
                    if(le=='w'){
                        etq_raton.setLocation(x, y+30);                        
                    }
                    if(le=='a'){
                        etq_raton.setLocation(x+30, y);                        
                    }
                    if(le=='d'){
                        etq_raton.setLocation(x-30, y);                        
                    }
                }           
            }
        }
    }
        public void iniciarSonidoPerder()
    {
        try
        {
            sonido = new BasicPlayer();
            sonido.open(new File(perder));
            sonido.play();
        }
        catch(BasicPlayerException ex)
        {
            System.out.println("Error iniciar sonido" + ex);
        }
    }
    public void ganar(Point coor){
        int x2 = (int)coor.getLocation().getX();
        int y2 = (int)coor.getLocation().getY();        
        String cc = x2+" "+y2;           
        if(cc.equals("390 200")){            
        JOptionPane.showMessageDialog(null, "Nivel4");
         this.dispose();   
         CambioNivel4 a= new CambioNivel4();
        a.setBounds(30,30,280,330);
          a.setResizable(false);
         a.setLocationRelativeTo(null);
         a.setVisible(true);
        

        }
    }
    public void pregunta(Point coor){
        int x2 = (int)coor.getLocation().getX();
        int y2 = (int)coor.getLocation().getY();        
        String cc = x2+" "+y2;
        int w;
        boolean exit=false;
        if(cc.equals("30 320")){            
         while(exit==false){
            int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            w = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuanto es 9*9?", "Huye de la trampa", JOptionPane.QUESTION_MESSAGE));
            if(w==81){
              exit=true;
              lab[6][1].setVisible(false);
            }else{
                vidas--;
              if(vidas==3){
                  etq_co.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX+30, actualY);
                  
              }
              if(vidas==2){
                  etq_co1.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX+30, actualY);
                  
              }
              if(vidas==1){
                  etq_co2.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX+30, actualY);
               
              }
              if (vidas==0) {
               GameOver a= new GameOver();
               this.dispose();
               a.setBounds(30,30,340,250);
               a.setVisible(true);
               exit=true;
               iniciarSonidoPerder();
               }
            }
         }
         
        }  
    
    }
      public void pregunta2(Point coor){
        int x2 = (int)coor.getLocation().getX();
        int y2 = (int)coor.getLocation().getY();        
        String cc = x2+" "+y2;
        int w;
        boolean exit=false;
        if(cc.equals("60 80")){            
         while(exit==false){
            int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            w = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuanto es 2*5", "Huye de la trampa", JOptionPane.QUESTION_MESSAGE));
            if(w==10){
              exit=true;
              lab[8][3].setVisible(false);
            }else{
                vidas--;
              if(vidas==3){
                  etq_co.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
                  
              }
              if(vidas==2){
                  etq_co1.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
                  
              }
              if(vidas==1){
                  etq_co2.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
               
              }
              if (vidas==0) {
               GameOver a= new GameOver();
               this.dispose();
               a.setBounds(30,30,340,250);
               a.setVisible(true);
               exit=true;
               iniciarSonidoPerder();
              }
            }
         }
         
        }  
    
    }
      
    public void pregunta3(Point coor){
        int x2 = (int)coor.getLocation().getX();
        int y2 = (int)coor.getLocation().getY();        
        String cc = x2+" "+y2;
        int w;
        boolean exit=false;
        if(cc.equals("360 200")){            
         while(exit==false){
            int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            w = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuanto es 200/4", "Huye de la trampa", JOptionPane.QUESTION_MESSAGE));
            if(w==50){
              exit=true;
              lab[12][5].setVisible(false);
            }else{
                vidas--;
              if(vidas==3){
                  etq_co.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
                  
              }
              if(vidas==2){
                  etq_co1.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
                  
              }
              if(vidas==1){
                  etq_co2.setVisible(false);
                  exit=true;
                  etq_raton.setLocation(actualX-30, actualY);
               
              }
              if (vidas==0) {
               GameOver a= new GameOver();
               this.dispose();
               a.setBounds(30,30,340,250);
               a.setVisible(true);
               exit=true;
               iniciarSonidoPerder();
              }
            }
         }
         
        }  
    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btn_iniciar = new javax.swing.JButton();
        etq_raton = new javax.swing.JLabel();
        btn_reiniciar = new javax.swing.JButton();
        btn_pausa = new javax.swing.JButton();
        etq_vidas = new javax.swing.JLabel();
        etq_co = new javax.swing.JLabel();
        etq_co1 = new javax.swing.JLabel();
        etq_co2 = new javax.swing.JLabel();
        btn_principal = new javax.swing.JButton();
        btn_niveles = new javax.swing.JButton();
        btn_instrucciones1 = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cafe.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btn_iniciar.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_iniciar.setText("Iniciar");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_iniciar);
        btn_iniciar.setBounds(30, 10, 90, 23);

        etq_raton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ratonAB.png"))); // NOI18N
        getContentPane().add(etq_raton);
        etq_raton.setBounds(30, 80, 40, 40);

        btn_reiniciar.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_reiniciar.setText("Continuar");
        btn_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reiniciar);
        btn_reiniciar.setBounds(230, 10, 100, 23);

        btn_pausa.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_pausa.setText("Pausar");
        btn_pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pausaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pausa);
        btn_pausa.setBounds(130, 10, 90, 23);

        etq_vidas.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        etq_vidas.setForeground(new java.awt.Color(0, 255, 0));
        etq_vidas.setText("Vidas:");
        etq_vidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(etq_vidas);
        etq_vidas.setBounds(350, 10, 40, 30);

        etq_co.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CO.png"))); // NOI18N
        getContentPane().add(etq_co);
        etq_co.setBounds(390, 20, 30, 14);

        etq_co1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CO.png"))); // NOI18N
        getContentPane().add(etq_co1);
        etq_co1.setBounds(410, 20, 30, 14);

        etq_co2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CO.png"))); // NOI18N
        getContentPane().add(etq_co2);
        etq_co2.setBounds(430, 20, 30, 14);

        btn_principal.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_principal.setText("Menú PRincipal");
        btn_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_principalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_principal);
        btn_principal.setBounds(70, 430, 150, 23);

        btn_niveles.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_niveles.setText("Menú nIVELES");
        btn_niveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nivelesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_niveles);
        btn_niveles.setBounds(240, 430, 150, 23);

        btn_instrucciones1.setFont(new java.awt.Font("dark forest", 0, 14)); // NOI18N
        btn_instrucciones1.setText("Instrucciones");
        btn_instrucciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_instrucciones1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_instrucciones1);
        btn_instrucciones1.setBounds(400, 430, 150, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
        iniciarTeclas();
        btn_iniciar.setEnabled(false);
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void btn_pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pausaActionPerformed
        btn_pausa.setEnabled(false);
        btn_reiniciar.setEnabled(true);
    }//GEN-LAST:event_btn_pausaActionPerformed

    private void btn_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reiniciarActionPerformed
        etq_raton.requestFocus();   
        btn_pausa.setEnabled(true);
        btn_reiniciar.setEnabled(false);
        

// TODO add your handling code here:
    }//GEN-LAST:event_btn_reiniciarActionPerformed

    private void btn_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_principalActionPerformed
        Inicio a= new Inicio();
        a.setBounds(30,30,700,480);//setBounds(10, 10, 600,500);
        //setBounds(10, 10, 600,500);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
        this.setVisible(false);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_principalActionPerformed

    private void btn_nivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nivelesActionPerformed
        Niveles a= new Niveles();
        a.setBounds(30,30,700,520);//setBounds(10, 10, 600,500);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
        this.setVisible(false);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nivelesActionPerformed

    private void btn_instrucciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_instrucciones1ActionPerformed

        JOptionPane.showMessageDialog(this, "INSTRUCCIONES \n"
            + "1.- El boton INICIAR permite comenzar el juego desde 0.\n"
            + "2.- Tu objetivo es salir del laberinto.\n"
            + "3.- Cada que salgas podrás cambiar de Nivel\n"
            + "4.- Igual puedes escoger los escenarios si te sientes un \n"
            + "un experto.\n"
            + "5.-Cada que topes con una trampa tendrás que \n"
            + " resolver un problema.\n"
            + "6.- La suma de 20 puntos suman una vida( depende de la imagen.)\n"
            + "8.- Si no puedes resolver la pregunta da Clic en Cancelar \n"
            + "y busca otra salida antes de que pierdas tus vidas\n"
            + "al contestar mal." );

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_instrucciones1ActionPerformed

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
            java.util.logging.Logger.getLogger(Nivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nivel3().setVisible(true);
                
               
            }
        });
        
      
    }
 
  public void iniciarTeclas(){
      etq_raton.requestFocus();
      etq_raton.addKeyListener(this);
        
     
    h1=new HiloNivel3(etq_raton,etq_vidas);
    h1.start();
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JButton btn_instrucciones1;
    private javax.swing.JButton btn_niveles;
    private javax.swing.JButton btn_pausa;
    private javax.swing.JButton btn_principal;
    private javax.swing.JButton btn_reiniciar;
    private javax.swing.JLabel etq_co;
    private javax.swing.JLabel etq_co1;
    private javax.swing.JLabel etq_co2;
    private javax.swing.JLabel etq_raton;
    private javax.swing.JLabel etq_vidas;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
        
           int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            actualX=actualX+30;     
            etq_raton.setLocation(actualX, actualY);
            validar(etq_raton.getLocation(),'d',actualX,actualY);
            pregunta(etq_raton.getLocation());
            pregunta2(etq_raton.getLocation());
            pregunta3(etq_raton.getLocation());
            ganar(etq_raton.getLocation());
            System.out.println("x:"+actualX+"\ny:"+actualY);
            etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonderecha.png")).getImage()));
           
          }
         if (e.getKeyCode() == KeyEvent.VK_LEFT){
            int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            actualX=actualX-30;     
            etq_raton.setLocation(actualX, actualY);
            validar(etq_raton.getLocation(),'a',actualX,actualY);
            pregunta(etq_raton.getLocation());
            pregunta2(etq_raton.getLocation());
            pregunta3(etq_raton.getLocation());
            ganar(etq_raton.getLocation());
            //System.out.println("x:"+actualX+"\ny:"+actualY);
            etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonizquierda.png")).getImage()));
          }
         if (e.getKeyCode() == KeyEvent.VK_DOWN){
          
            int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            actualY=actualY+30;     
            etq_raton.setLocation(actualX, actualY);
            validar(etq_raton.getLocation(),'s',actualX,actualY);
            pregunta(etq_raton.getLocation());
            pregunta2(etq_raton.getLocation());
            pregunta3(etq_raton.getLocation());
            ganar(etq_raton.getLocation());
            //System.out.println("x:"+actualX+"\ny:"+actualY);
            etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonabajo.png")).getImage()));
          }
          if (e.getKeyCode() == KeyEvent.VK_UP){
          
             int actualX=(int)etq_raton.getLocation().getX();
            int actualY=(int)etq_raton.getLocation().getY();
            actualY=actualY-30;
            etq_raton.setLocation(actualX, actualY);
            validar(etq_raton.getLocation(),'w',actualX,actualY);
            pregunta(etq_raton.getLocation());
            pregunta2(etq_raton.getLocation());
            pregunta3(etq_raton.getLocation());
            ganar(etq_raton.getLocation());
            //System.out.println("x:"+actualX+"\ny:"+actualY);
            etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonarriba.png")).getImage()));
          }
           if(e.getKeyChar()=='x' )
        {
            
            int salir = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(salir ==JOptionPane.YES_NO_OPTION )
            {
             
                h1 = null;
               
               System.exit(0); 
  
            }
           
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          if (e.getKeyCode() == KeyEvent.VK_UP){         

         etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonARR.png")).getImage()));
         
    }
          if (e.getKeyCode() == KeyEvent.VK_DOWN){         

         etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonAB.png")).getImage()));

    }
          if (e.getKeyCode() == KeyEvent.VK_RIGHT){         

         etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonD.png")).getImage()));

    }
          if (e.getKeyCode() == KeyEvent.VK_LEFT){         

         etq_raton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/ratonI.png")).getImage()));

    }
}
}