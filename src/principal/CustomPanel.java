package principal;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CustomPanel extends JPanel implements KeyListener{
    Thread hilos ;
    enemigo Ene;
    private int naveposx = 100;
    private int posx = 0;
    private int a = 110;
    private int b = 110;
    private int c = 1;
    private int cantEnem = 2;
    
    private URL url = getClass().getResource("/img/mario.jpg");
    Image image = new ImageIcon(url).getImage();
    
    nave naves = new nave();
    
    ArrayList <enemigo> enemigos = new ArrayList<enemigo> ();
       
    
    // metodo constructor agrega el keyListener, lo vuelve visible, y le agrega un tipo de layout
    public CustomPanel(){
        //addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        prueba();
        setOpaque(false);
        setLayout(null);
        add(naves);
        
        
    }
    public void prueba(){
        for (int i = 1; i <= cantEnem; i++ ){
            if (i == 1){
            a += 20;
            b += 20;
            c = 1;
            }else if (i == 2){
            a += 100;
            b += 20;
            c = 2;
            }
            enemigo Ene = new enemigo(a,b,c);
            enemigos.add(Ene);
            Ene.start();
            this.add(Ene);        
        
        
        }
        
        
        
        
        
    }
    

    // metodo de pintar del JPanel
    @Override
    public void paint(Graphics g){
        
        g.drawImage(image, posx, 0,image.getWidth(this), image.getHeight(this), this);
        
        super.paint(g);
        
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
           Iterator<enemigo> ator = enemigos.iterator();
           while(ator.hasNext()){
           enemigo ene = ator.next();
           ene.atras();
        }
                
         
        }
        if (c == KeyEvent.VK_LEFT) {
            Iterator<enemigo> ator = enemigos.iterator();
            while(ator.hasNext()){
            enemigo ene = ator.next();
            ene.adelante();
        }
                
    }
    }
    @Override
    public void keyReleased(KeyEvent e) {    
    }
}
    


   
