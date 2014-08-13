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
//
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;



/**
 * 
 * 
 * Clase para crear el fondo del juego y agregar los componentes
 */
public class CustomPanel extends JPanel implements KeyListener{
    Thread hilos ;
    enemigo Ene;
    private int naveposx = 100;
    private int posx = 0;
    private int a = 110;
    private int b = 110;
    private int c = 1;
    private String nombre;// = "OVNI.png";
    
    private int cantEnem = 2;
    
    private URL url = getClass().getResource("/img/mario.jpg");
    Image image = new ImageIcon(url).getImage();
    
    nave naves = new nave();
    
    balas bull = new balas(naves.getPosx(),naves.getPosy());

    
    ArrayList <enemigo> enemigos = new ArrayList<enemigo> ();
    
    
    
   
    
       
    
    /**
     * metodo constructor agrega el keyListener, lo vuelve visible, y le agrega un tipo de layout
     */
    public CustomPanel(){
        //addMouseListener(this);
        
        
       
        addKeyListener(this);
        setFocusable(true);
        //prueba();
        LeerXml();
        setOpaque(false);
        setLayout(null);
        add(naves);
        
        
        
        
        
    }
    public void LeerXml(){
        try {
 
	File fXmlFile = new File("/home/fabricio/NetBeansProjects/Crazy2/ProyectoD/src/niveles/prueba.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
        NodeList nList = doc.getElementsByTagName("staff");
        NodeList mapa = doc.getElementsByTagName("mapa");
        //Para leer el mapa
        for (int temp = 0; temp < mapa.getLength(); temp++) {
 
		Node nNode = mapa.item(temp);
 
		
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        System.out.println(eElement.getElementsByTagName("jo").item(0).getTextContent());
                        this.url = getClass().getResource("/img/"+eElement.getElementsByTagName("jo").item(0).getTextContent());
                        Image image = new ImageIcon(url).getImage();
                        this.image = image;
                        
                                              
		}
	}
        
 
        //Para leer a los enemigos
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        this.a = Integer.parseInt(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        this.b = Integer.parseInt(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        this.c = Integer.parseInt(eElement.getElementsByTagName("nickname").item(0).getTextContent());
                        nombre = eElement.getElementsByTagName("salary").item(0).getTextContent();
                        enemigo Ene = new enemigo(this.a,this.b,this.c,this.nombre);
                        this.enemigos.add(Ene);
                        Ene.start();
                        this.add(Ene);
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
      
            
            
      

    }
      

    /**
     * metodo de pintar del JPanel
     */
    @Override
    public void paint(Graphics g){
        
        g.drawImage(image, posx, 0,image.getWidth(this), image.getHeight(this), this);
        
        super.paint(g);
        
    }
    
    /**
     * metodo para mover el fondo hacia atras
     */
    public void FondoAtras(){
        this.posx -= 2;
    
    }
    /**
    * metodo para mover el fondo hacia Adelante
    */
    public void FondoAdelante(){
        this.posx += 2;
    
    }
    
    
    
    /**
    * metodo para dar coordenadas a las balas por las que dirigirse
    */
    public void bal(){
        bull.setPosx(naves.getPosx());
        bull.setPosy(naves.getPosy());
        add(bull);
}
   
    
    /**
     * Metodos abstractos de la interface KeyListener
     */
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int c = e.getKeyCode();
      naves.getPosy();
      //bull.getPosy();
     
        //repaint();
        
//la variable "c" guarda el numero de tecla presionada y llama a los metodos que mueven la nave o la pantalla
        
        if (c == KeyEvent.VK_D){
            bal();
            bull.adelante();
                    
            bull.start();
        }
        
        if (c == KeyEvent.VK_A){
            bal();
            bull.atras();
                    
            bull.start();
        }
        
        if (c == KeyEvent.VK_W){
            bal();
            bull.arriba();
                    
            bull.start();
        }
        
        if (c == KeyEvent.VK_S){
            bal();
            bull.abajo();
                    
            bull.start();
        }
        
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
           FondoAtras();
           repaint();
                
         
        }
        if (c == KeyEvent.VK_LEFT) {
            Iterator<enemigo> ator = enemigos.iterator();
            while(ator.hasNext()){
            enemigo ene = ator.next();
            ene.adelante();
        }
           FondoAdelante();
           repaint();
           
        
                
    }
    }
    @Override
    public void keyReleased(KeyEvent e) {    
    }  
}
    


   
