

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
     * Metodo constructor de la clase nave
     * @author tvlenin
     */
    public nave(){
        //setOpaque(false);
        setVisible(true);
        setIcon(icon);
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        setFocusable(true);
        }
    
    
    
    /**
     * Metodo para obtener la posicion en x
     * @author tvlenin
     */
    public int getPosy(){
        return this.posy;
    }
    public int getPosx(){
        return this.posx;
    }
    
  
    
    /**
     * 
     * Metodo para mover la nave hacia arriba
     * @author tvlenin
     */
    
    public void arriba(){
        this.posy -= 15;
        setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
        }
    /**
     * Metodo para mover la nave hacia abajo 
     * @author tvlenin
     */
    
    public void abajo(){
        this.posy += 10;
        setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    
    
    
    
    
    
    
    /**
     * Metodo para controlar los hilos, inicia el hilo
     * @author tvlenin
     */
    
    public void start(){
        if(hilo==null){
            hilo=new Thread(this);
            hilo.start();
        }
    }
    /**
    * Metodo para detener el hilo
    * @author tvlenin
    */
    public void stop(){
        if(hilo!=null){
            hilo.stop();
            hilo=null;
        }
    }
   
    /**
     * 
     * Metodo donde se encuentran las instrucciones para repetir en el hilo
     * @author tvlenin
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
                this.mov = 1;
            
            }catch (InterruptedException e) { }
                // baja la nave una posicion en y cada 30 milisegundos, definidos en el sleep de arriba
            if (this.posy <= 415){
                this.posy += 1;
                
                
                setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
            }
            if (this.posy == 415)
                this.mov = 0;   
        }   
    }
}
    
    
    
   

   
    
  
    
    
    

