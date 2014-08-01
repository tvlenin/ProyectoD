
package principal;

import javax.swing.JFrame;


public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      JFrame ventana = new JFrame();
      CustomPanel panel = new CustomPanel();
      
      ventana.setVisible(true);
      //panel.setOpaque(false);
      ventana.setSize(800, 500);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.getContentPane().add(panel);
      
      
      
      
      
      
      
      
      
    }
    
}
