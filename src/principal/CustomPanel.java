package principal;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CustomPanel extends JPanel implements KeyListener{
    Thread hilos ;
    private int naveposx = 100;
    private int posx = 0;
    private int a = 110;
    private int b = 110;
    private int disparar = 1;
    
    private URL url = getClass().getResource("/img/mario.jpg");
    Image image = new ImageIcon(url).getImage();
    
    nave naves = new nave();
    enemigo enemigo1 = new enemigo(700,40);
    
    // metodo constructor agrega el keyListener, lo vuelve visible, y le agrega un tipo de layout
    public CustomPanel(){
        //addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setOpaque(false);
        setLayout(null);
        add(naves);
        add(enemigo1);
        enemigo1.start();
    }
    

    // metodo de pintar del JPanel
    @Override
    public void paint(Graphics g){
        
        g.drawImage(image, posx, 0,image.getWidth(this), image.getHeight(this), this);
        
        g.drawRect(a, b, 10, 10);
        
        super.paint(g);
        
    }
    
    

    
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //metodo para mover la pantalla hacia la izquierda
    public void adelante(){
        this.posx -= 40;
        
        //repaint();
    }
    //metodo para mover la pantalla hacia la derecha
    public void atras(){
        this.posx += 40;
        //repaint();
    }
    
    //metodo para obtener la posicion x
   public int getFondox(){
       return posx;
   }
    
    // Metodos abstractos de la interface KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int c = e.getKeyCode();
      naves.getPosy();
     
        //repaint();
        
//la variable "c" guarda el numero de tecla presionada y llama a los metodos que mueven la nave o la pantalla
        if (c == KeyEvent.VK_UP) {
            if (naves.getPosy() < 30)
                System.out.println("Bum");
            if (naves.getPosy() > 20){
                if (naves.mov == 0){
                    naves.arriba();
                    
                    naves.start();
                }
                else if (naves.mov == 1){
                    naves.arriba();    
                    naves.stop();
                    naves.start();
                }
            }else
                System.out.println("Error en y");
            
        }
        if (c == KeyEvent.VK_DOWN) {
            if (naves.getPosy() < 415)
                naves.abajo();
            else
                System.out.println("Error en y");
        }
        if (c == KeyEvent.VK_RIGHT) {
            enemigo1.atras();
        }
        if (c == KeyEvent.VK_LEFT) {
            enemigo1.adelante();
        }
                
    }

    @Override
    public void keyReleased(KeyEvent e) {    
    }

    
}