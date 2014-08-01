

package principal;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author tvlenin
 */
public class enemigo extends JLabel implements Runnable{
    private int posx = 0;
    private int posy = 0;
    private URL url = getClass().getResource("/img/OVNI.png");
    ImageIcon icon = new ImageIcon(url);
    Thread hilo;
    private int mov =0;
    
    public enemigo (int x,int y){
        this.posx = x;
        this.posy = y;
        setVisible(true);
        setIcon(icon);
        setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
        setFocusable(true);
}

    
    
public void mover(int o){
    switch (o){
        case 1 :
            if (posy >= 40  && mov == 0){
                posx += 10;
                posy -= 10;
                setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());

            }else if (posy < 440 ){
                mov = 1;
                posx -= 10;
                posy += 10;
                setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
                if (posy >= 440)
                    mov =0;
            }
            break;
         case 2 :
            if (posy >= 40  && mov == 0){
                posx += 1;
                posy -= 10;
                setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());

            }else if (posy < 440 ){
                mov = 1;
                posx -= 1;
                posy += 10;
                setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());
                if (posy >= 440)
                    mov =0;
            }
            break;
        default :
            System.out.println("");
    }
}  
//metodo para mover los objetos de la pantalla hacia la nave
public void atras(){
    posx -= 10;
    setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());

}
//metodo para alejarse de la nave
public void adelante(){
    posx += 10;
    setBounds(posx,posy , icon.getIconWidth(), icon.getIconHeight());

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  public void start(){
     if(hilo==null){
        hilo=new Thread(this);
        
        hilo.start();
     }
    }
    //metodo para detener el hilo
    public void stop(){
     if(hilo!=null){
        hilo.stop();
        hilo=null;
     }
  }
    // metodo donde se encuentran las instrucciones para repetir en el hilo
    @Override
    public void run() {
        
        while (true) {
            try{
                // define el tiempo cada cuanto se baja una posicion 
                Thread.sleep(100);
               
            
            }catch (InterruptedException e) { }
                // baja la nave una posicion en y cada 30 milisegundos, definidos en el sleep de arriba
                mover(2);
            }
             
        }   
    }
    

