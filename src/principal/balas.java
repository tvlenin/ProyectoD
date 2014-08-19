

package principal;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *Clase para crear balas en la ventana
 * @author fabricio
 */
public class balas extends JLabel implements Runnable{
    
    Thread hilo;// crea e hilo
    public int mov = 0;
    private int posx;//posicion inicial en x
    private int posy;//posicion inicial en y
    //carga la imagen de la nave
    private URL url = getClass().getResource("/img/bala.jpg");
    ImageIcon icon = new ImageIcon(url);
    private int cont = 0;
    
    /**
     * Metodo constructor de la clase balas
     * @author fabricio
     * @param x La posicion en el eje "x" de la bala
     * @param y La posicion en el eje "y" de la bala
     */
    public balas(int x, int y){
        this.posx = x;
        this.posy = y;
        setVisible(true);
        setIcon(icon);
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());// indica las opciones del label como posicion en x, y el ancho y el largo
        setFocusable(true);
        }
    
    
    /**
     * Metodo que retorna un entero con la posicion del enemigo en el eje "y" de la bala
     * @author faricio
     * @return Retorna la posicion en el eje "y" de la bala
     */
    public int getPosy(){
        return this.posy;
    }
    
    /**
     * Metodo que retorna un entero con la posicion del enemigo en el eje "x"
     * @author faricio
     * @return Retorna la posicion en el eje "x" de la bala
     */
    public int getPosx(){
        return this.posx;
    }
    
    
    /**
     * Metodo para establecer la posicion en el eje "x" de la bala
     * @param y La posicion en el eje "y" de la bala
     * @author faricio
     */
    public void setPosy(int y){
        this.posy = y + 13;
    }
    
    /**
     * Metodo para establecer la posicion en el eje "x" de la bala
     * @param x La posicion en el eje "x" de la bala
     * @author faricio
     */
    public void setPosx(int x){
        this.posx = x + 22;
    }
    
    
    /**
     * Metodo para dirigir el movimiento de la bala hacia atras de la nave
     * @author faricio
     */
    public void atras(){
        this.posx -= 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 0;
        
    }
    
    /**
     * Metodo para dirigir el movimiento de la bala hacia adelante de la nave
     * @author faricio
     */
    public void adelante(){
        this.posx += 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 1;
    }
    
    /**
     * Metodo para dirigir el movimiento de la bala hacia arriba de la nave
     * @author faricio
     */
    public void arriba(){
        this.posy -= 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 2;
    }
    
    /**
     * Metodo para dirigir el movimiento de la bala hacia abajo de la nave
     * @author faricio
     */
    public void abajo(){
        this.posy += 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 3;
    }
    
    
    /**
     * Metodo para controlar los hilos, inicia el hilo
     * @author faricio
     */
    
    public void start(){
        if(hilo==null){
            hilo=new Thread(this);
            hilo.start();
        }
    }
    /**
    * Metodo para detener el hilo
    * @author faricio
    */
    public void stop(){
        if(hilo!=null){
            hilo.stop();
            hilo=null;
        }
    }
    
    
    /**
     * Metodo para ejecutar el hilo y realizar los movimientos delas balas
     * @author faricio
     */
    @Override
    public void run() {
        
            
        while (true) {
            try{
                // define el tiempo cada cuanto se baja una posicion 
                Thread.sleep(10);
                
            
            }catch (InterruptedException e) { }
                
            if(mov == 0){
                this.posx -= 4;
                
                setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
            }
            if(mov == 1){
                this.posx += 4;
                
                setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
            }
            if(mov == 2){
                this.posy -= 4;
                
                setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
            }
            if(mov == 3){
                this.posy += 4;
                
                setBounds(this.posx,this.posy , this.icon.getIconWidth(), this.icon.getIconHeight());
            }
        }   
    }
    
}
