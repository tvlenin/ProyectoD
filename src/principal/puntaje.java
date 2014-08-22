
package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La clase crea una interfaz en la que se muestra un mensaje de finalizacion y el puntaje del jugador
 * @author fabricio
 */
public class puntaje extends JPanel{
    
    
    private URL url = getClass().getResource("/img/mario.jpg");
    Image image = new ImageIcon(url).getImage();
    
    static int punt = 0;
    
    /**
     * Metodo constructor, crea los elementos a mostrar cuando se acaba el juego
     * @author fabricio
     */
    public puntaje(){
        this.setSize(800, 500);
        this.setBackground(Color.black);
        this.setLayout(null);
        
        JLabel go = new JLabel("Game Over");
        go.setVisible(true);
        go.setBounds(200, 10, 300, 100);
        go.setFont(new java.awt.Font("Tahoma", 0, 36));
        go.setForeground(Color.white);
        
        JLabel puntos = new JLabel("Puntaje: " + punt);
        puntos.setVisible(true);
        puntos.setBounds(10, 100, 300, 100);
        puntos.setFont(new java.awt.Font("Tahoma", 0, 36));
        puntos.setForeground(Color.white);
        
        
        this.add(puntos);
        this.add(go);
        this.setVisible(true);
    }
    
    /**
     * Metodo donde se encuentran las instrucciones para pintar en la pantalla
     * @author fabricio
     * @param g El parametro g es utilizado para pintar
     */
    @Override
    public void paint(Graphics g){
        
        g.drawImage(image, 0, 0,image.getWidth(this), image.getHeight(this), this);
        
        super.paint(g);        
    }
    
    
}
