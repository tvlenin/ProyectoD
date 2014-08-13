

package principal;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
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
     * metodo constructor de la clase nave
     */
    public balas(int x, int y){
        this.posx = x;
        this.posy = y;
        setVisible(true);
        setIcon(icon);
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());// indica las opciones del label como posicion en x, y el ancho y el largo
        setFocusable(true);
        }
    
    public int getPosy(){
        return this.posy;
    }
    public int getPosx(){
        return this.posx;
    }
    
    public void setPosy(int y){
        this.posy = y + 13;
    }
    public void setPosx(int x){
        this.posx = x + 22;
    }
    
    
    
    public void atras(){
        this.posx -= 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 0;
        
    }
    
    
    public void adelante(){
        this.posx += 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 1;
    }
    
    
    public void arriba(){
        this.posy -= 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 2;
    }
    
    public void abajo(){
        this.posy += 5;
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        this.mov = 3;
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
