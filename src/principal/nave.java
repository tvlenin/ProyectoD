

package principal;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *  
 * @author tvlenin
 * La clase implementa la interface Runnable para manejar hilos
 */

public class nave extends JLabel implements Runnable{
    Thread hilo;// crea e hilo
    public int mov = 0;
    
    
    private int posx = 100;//posicion inicial en x
    private int posy = 200;//posicion inicial en y
    //carga la imagen de la nave
    private URL url = getClass().getResource("/img/nave.jpg");
    ImageIcon icon = new ImageIcon(url);
    



/**
 * metodo constructor de la clase nave
 */
    public nave(){
        //setOpaque(false);
        setVisible(true);
        setIcon(icon);
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        setFocusable(true);
        }
    
    
    
    /**
     * metodo para obtener la posicion en x
     */
    public int getPosy(){
        return posy;
    }
    public int getPosx(){
        return posx;
    }
    
  
    
    /**
     * 
     * metodo para mover la nave hacia arriba
     */
    
    public void arriba(){
        posy -= 15;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        }
    /**
     *metodo para mover la nave hacia abajo 
     */
    
    public void abajo(){
        posy += 10;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
    }
    
    
    
    
    
    
    
    
    /**
     * Metodo para controlar los hilos, inicia el hilo
     */
    
    public void start(){
        if(hilo==null){
            hilo=new Thread(this);
            hilo.start();
        }
    }
    /**
    *metodo para detener el hilo
    */
    public void stop(){
        if(hilo!=null){
            hilo.stop();
            hilo=null;
        }
    }
   
    /**
     * 
     * metodo donde se encuentran las instrucciones para repetir en el hilo
     */
    @Override
    public void run() {
        
        try {
            // espera 300 milisegundos despues de subir la nave
            Thread.sleep(600);
                       
        } catch (InterruptedException ex) { }
            
        while (true) {
            try{
                // define el tiempo cada cuanto se baja una posicion 
                Thread.sleep(10);
                mov = 1;
            
            }catch (InterruptedException e) { }
                // baja la nave una posicion en y cada 30 milisegundos, definidos en el sleep de arriba
            if (posy <= 415){
                posy += 1;
                
                
                setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
            }
            if (posy == 415)
                mov = 0;   
        }   
    }
}
    
    
    
   

   
    
  
    
    
    

