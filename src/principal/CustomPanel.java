package principal;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory; 
import org.w3c.dom.Document; 
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * 
 * 
 * Clase para crear el fondo del juego y agregar los componentes
 * @author tvlenin
 */
public class CustomPanel extends JPanel implements SerialPortEventListener, Runnable{
    Thread hilo ;
    enemigo Ene;
    public static boolean visible = true;
    private boolean estado = false; 
    private int naveposx = 100;
    private int posx = 0;
    public static int puntos = 0;
    private int a = 110;
    private int b = 110;
    private int c = 1;
    private int cantEne = 0;
    private String nombre;
    SerialPort serialPort;
        /** El puerto depende del sistema operativo. */
    private static final String PORT_NAMES[] = { 
                        "/dev/ttyACM0", //for Ubuntu
   "/dev/tty.usbserial-A9007UX1", // Mac OS X
   "/dev/ttyUSB0", // Linux
   "COM1", // Windows
    };
    
    //private int cantEnem = 2;
    
    public static String nivel;
    private URL url = getClass().getResource("/img/mario.jpg");
    Image image = new ImageIcon(url).getImage();
    
    
                    
    
    
    nave naves = new nave();
    
    balas bull = new balas(naves.getPosx(),naves.getPosy());

    
    ArrayList <enemigo> enemigos = new ArrayList<enemigo> ();
    
    
    
   
    
       
    
    /**
     * Metodo constructor agrega el keyListener, lo vuelve visible, y le agrega un tipo de layout
     * @author tvlenin
     */
    public CustomPanel(){
        //addMouseListener(this);
        
        
       
        //addKeyListener(this);
        setFocusable(true);
        
        LeerXml();
        setOpaque(false);
        setLayout(null);
        add(naves);
        
        
        this.start();
        initialize();
        
        
            
        
    }
    
    /**
     * 
     * A partir de aqui esta el codigo para arduino
     */
    private BufferedReader input;
    
    private OutputStream output;

    private static final int TIME_OUT = 2000;

    private static final int DATA_RATE = 9600;

    /**
     * Metodo para inicializar las operaciones con el Arduino
     * @author tvlenin
     */
    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
 
    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
            portId = currPortId;
            break;
            }
        }
    }
    if (portId == null) {
        System.out.println("Could not find COM port.");
        return;
    }
 
    try {
        // open serial port, and use class name for the appName.
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
        TIME_OUT);
 
        // set port parameters
        serialPort.setSerialPortParams(DATA_RATE,
        SerialPort.DATABITS_8,
        SerialPort.STOPBITS_1,
        SerialPort.PARITY_NONE);
 
        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();
 
        // add event listeners
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
    }catch (Exception e) {
        System.err.println(e.toString());
    }
 }
 
 /**
  * Metodo para evitar que los puertos se bloqueen cuando se deje de utilizar el puerto
  * @author tvlenin
  */
    public synchronized void close() {
        if (serialPort != null) {
           serialPort.removeEventListener();
           serialPort.close();
          }
 }
 
    /**
    * Metodo para analizar eventos en el puerto serial, lee datos y los muestra
    * @author tvlenin
    */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                
                if (inputLine.contains("1")){
                    
                    Iterator<enemigo> ator = enemigos.iterator();
                while(ator.hasNext()){
                    enemigo ene = ator.next();
                    ene.atras();
                }
            FondoAtras();
            repaint();  
    } if (inputLine.contains("2")){
        
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
    if (inputLine.contains("3")){
        if (posx >= 0){
            System.out.println("No");
        }else{
            Iterator<enemigo> ator = enemigos.iterator();
            while(ator.hasNext()){
            enemigo ene = ator.next();
            ene.adelante();
        }
           FondoAdelante();
        }
        repaint();
    }if (inputLine.contains("4")){
        
        
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
    }if (inputLine.contains("5")){
            estado = true;
            bal();
            bull.atras();
            this.start();        
            bull.start();
    }if (inputLine.contains("6")){
            estado = true;
            bal();
            bull.arriba();
            this.start();        
            bull.start();
    }if (inputLine.contains("7")){
            estado = true;
            bal();
            bull.adelante();
                    
            bull.start();
            this.start();
    }
    if (inputLine.contains("8")){
            bal();
            estado = true;
            bull.abajo();
            this.start();
            
            bull.start();
    }
    
            
   
   } catch (Exception e) {
    System.err.println(e.toString());
   }
  }

 }

    
    
    
    
    private void choques(){
        
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Metodo utilizado para la lectura de archivos XML
     * @author tvlenin
     */
    public void LeerXml(){
        try {
        
        File fXmlFile = new File("src/niveles/"+ nivel +".xml");
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
        NodeList nList = doc.getElementsByTagName("staff");
        NodeList mapa = doc.getElementsByTagName("mapa");
        
        NodeList ene = doc.getElementsByTagName("ene");
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
        // leer cantidad de enemigos
        for (int temp = 0; temp < ene.getLength(); temp++) {
 
		Node nNode = ene.item(temp);
 
		
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        System.out.println(eElement.getElementsByTagName("jo").item(0).getTextContent());
                        cantEne = Integer.parseInt(eElement.getElementsByTagName("jo").item(0).getTextContent());
                        
                                              
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
     * Metodo de pintar del JPanel
     * @param g El parametro g es utilizado para pintar
     * @author tvlenin
     */
    @Override
    public void paint(Graphics g){
        
        g.drawImage(image, posx, 0,image.getWidth(this), image.getHeight(this), this);
        
        super.paint(g);
        
    }
    
    /**
     * Metodo para mover el fondo hacia atras
     * @author tvlenin
     * 
     */
    public void FondoAtras(){
        this.posx -= 10;
    
    }
    /**
    * Metodo para mover el fondo hacia Adelante
    * @author tvlenin
    */
    public void FondoAdelante(){
        this.posx += 10;
    
    }
    
    
    
    /**
    * Metodo para dar coordenadas a las balas por las que dirigirse
    * @author fabricio
    */
    public void bal(){
        bull.setPosx(naves.getPosx());
        bull.setPosy(naves.getPosy());
        add(bull);
}
  
    

    /**
     * Metodos abstractos de la interface KeyListener
     * @author tvlenin
     */
    

    //@Override
    public void keyTyped(KeyEvent e) {
        
    }




    
    //@Override
    public void keyPressed(KeyEvent e) {

      int c = e.getKeyCode();
      naves.getPosy();
   
        
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
    //@Override
    public void keyReleased(KeyEvent e) {
    } 
    
    /**
     * Metodo para inicializar el hilo
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
     * Metodo para ejecutar el hilo y relizar los dibujos en la pantalla
     * @author tvlenin
     */
    @Override
    public void run() {
        while (true){
            
            try{
                // define el tiempo cada cuanto se baja una posicion 
                Thread.sleep(1);                         
            }catch (InterruptedException e) { }
        Iterator<enemigo> ator = enemigos.iterator();
            while(ator.hasNext()){
                puntaje puntajes = new puntaje();
                
                if (cantEne == 0 ){
                    this.add(puntajes);
                            this.setVisible(true);
                            this.remove(naves);
                            
                            
                                    
                            
                            
                            
                            repaint();
                }else{
                enemigo ene = ator.next();
                if (bull.getPosy() < ene.getposy() + 25 && bull.getPosy() > ene.getposy() - 25 ){
                    if( bull.getPosx() > ene.getposx() - 25 && bull.getPosx() < ene.getposx() + 25 ){
                        if (estado == true){
                        ene.puntos();
                        cantEne -= 1;
                        this.remove(ene);
                        ene.setPosx();
                        ene.setPosy();
                        ene = null;
                        bull.stop();
                        System.out.println(puntos);
                        this.remove(bull);
                        estado = false;
                        repaint();}
                       
                        
                        
                    }
                        
                        
                }else if(naves.getPosy() < ene.getposy() + 25 && naves.getPosy() > ene.getposy() - 25){
                     if(naves.getPosx() > ene.getposx() - 25 && naves.getPosx() < ene.getposx() + 25 ){
                         if (naves.getVidas() == 1){
                            ene.puntos();
                            cantEne -= 1;
                                    
                            puntaje.punt = puntos;
                            this.remove(ene);
                            this.remove(naves);
                            ene = null;
                            estado = false;
                            this.add(puntajes);
                            this.setVisible(true);
                          
                                    
                            
                            
                            
                            repaint();
                            
                            
                            
                            
                            
                            
                         }else{
                            ene.puntos();
                            cantEne -= 1;
                            System.out.println(puntos);
                            this.remove(ene);
                            ene.setPosx();
                            ene.setPosy();
                            naves.setVisible(false);
                            ene = null;
                            estado = false;
                            repaint();                    
                            naves.muerte();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) { }
                            naves.setVisible(true);
                         }
                     }
                }
}}
            
}
    }

   }

    


   
