package principal;

import javax.swing.JFrame;

/**
 *
 * @author fabricio
 */
public class inicio extends javax.swing.JFrame {

    /**
     * Metodo constructor de la clase inicio
     * @author fabricio
     */
    public inicio() {
        initComponents();
    }
    JFrame ventana = new JFrame();
   
    
    /**
     * Metodo desde el cual se colocan los elementos que se encuentran en la pantalla principal
     * @author fabricio
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ciudad.jpg"))); // NOI18N
        jLabel1.setText("hola");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(143, 1, 1));
        jLabel2.setText("Crazy Defenders");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("Jugar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 90, -1));

        textField1.setText("Digite el numero de nivel");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ciudad.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que invoca una nueva ventana donde se mostraran los elementos del juego
     * @author fabricio
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame ventana = new JFrame();
        CustomPanel.nivel = textField1.getText();
        CustomPanel panel = new CustomPanel();
        
        System.out.println(CustomPanel.nivel);
        
        
        ventana.setVisible(CustomPanel.visible);
      
      ventana.setSize(800, 500);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.getContentPane().add(panel);
      this.setVisible(false);
      
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Metodo para realizar tareas con el campo de texto
     * @author fabricio
     * @param evt 
     */
    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        
    }//GEN-LAST:event_textField1ActionPerformed

    /**
     * Metodo para inicializar los componentes de la pantalla
     * @author fabricio
     * @param args
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
