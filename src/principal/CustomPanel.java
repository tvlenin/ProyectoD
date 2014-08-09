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
 
	File fXmlFile = new File("/home/tvlenin/NetBeansProjects/PruebaPanel/src/niveles/prueba.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
        /*System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        
        
        System.out.println("----------------------------");*/
        NodeList nList = doc.getElementsByTagName("staff");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			System.out.println("Staff id : " + eElement.getAttribute("id"));
			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
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
     * 
     * Metodo de prueba
     */
    public void prueba(){
        for (int i = 1; i <= cantEnem; i++ ){
            if (i == 1){
            this.a += 20;
            this.b += 20;
            this.c = 1;
            }else if (i == 2){
            this.a += 100;
            this.b += 20;
            this.c = 5;
            }
            //enemigo Ene = new enemigo(a,b,c);
            this.enemigos.add(Ene);
            Ene.start();
            this.add(Ene);        
        
        
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
     * Metodos abstractos de la interface KeyListener
     */
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
    


   
