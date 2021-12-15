/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectothello;

/**
 *
 * @author jybra
 */
public class Instrucciones extends javax.swing.JFrame {

    /**
     * Creates new form Instrucciones
     */
    public Instrucciones() {
        initComponents();
        this.setTitle("Othello - ¿Cómo jugar?");
        String t = "<html><body>Othello es un juego de mesa por turnos en un tablero de 8x8, en el que cada turno un jugador coloca una pieza," + 
                            "<br>posteriormente, las piezas del jugador contrario que estén entre la pieza colocada y otras piezas propias" +
                            "<br>pasarán a ser del jugador de la pieza colocada. Como se puede ver en el ejemplo de abajo.</body></html>";
        lblIntroduccion.setText(t);
        
        t = "<html><body>Siendo el turno del jugador blanco, se puede ver que en la" + 
                    "<br>esquina inferior derecha es posible realizar un movimiento," +
                    "<br>este movimiento es marcado con un asterisco en la casilla." +
                    "<br><br>Al colocar una pieza en la casilla disponible, la pieza negra" + 
                    "<br>se da la vuelta y se transforma a blanca, porque está entre" +
                    "<br>en la linea que conecta las dos piezas blancas en diagonal.</body></html>";
        lblExampleexplanation.setText(t);
        
        t = "<html><body>En el ejemplo de la izquierda es una representación de que" + 
                    "<br>las piezas afectadas de cada movimiento no se limitan a una" +
                    "<br>sóla dirección, sino a todas las posibles." +
                    "<br><br>En esta situación el jugador blanco tiene dos posibles" + 
                    "<br>movimientos, la esquina inferior derecha, al igual que el" +
                    "<br>ejemplo anterior, pero si la pieza se coloca en la esquina" +
                    "<br>superior derecha, las direcciones izquierda y la diagonal" +
                    "<br>abajo-izquierda se ven afectadas, siendo mejor movimiento.</body></html>";
        lblExampleexplanation2.setText(t);
        
        t = "<html><body>Al empezar una partida el jugador de color negro empezará el primer movimiento, si un jugador no tiene algún" +
                    "<br>movimiento, este pasará su turno, ¡coloca tus piezas con sabiduría!" +
                    "<br><br>El juego se termina cuando los jugadores se queden sin turnos, es decir, ninguno tenga un movimiento" +
                    "<br>disponible, el tablero se llene, o un jugador se quede sin piezas. El ganador es el jugador con más piezas" + 
                    "al final.</body></html>";
        lblFinal.setText(t);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltitle = new javax.swing.JLabel();
        lblIntroduccion = new javax.swing.JLabel();
        lblexample = new javax.swing.JLabel();
        lblexample2 = new javax.swing.JLabel();
        lblExampleexplanation2 = new javax.swing.JLabel();
        lblExampleexplanation = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbltitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("¿Cómo se juega?");

        lblIntroduccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIntroduccion.setText("Othello es un juego de mesa por turnos en un tablero de 8x8, en el que cada turno un jugador coloca una pieza,");
        lblIntroduccion.setToolTipText("");
        lblIntroduccion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblexample.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectothello/example1.png"))); // NOI18N

        lblexample2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectothello/example2.png"))); // NOI18N

        lblExampleexplanation2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblExampleexplanation2.setText("Siendo el turno del jugador blanco, se puede ver que en la");
        lblExampleexplanation2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblExampleexplanation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblExampleexplanation.setText("Siendo el turno del jugador blanco, se puede ver que en la");
        lblExampleexplanation.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnSalir.setText("Cerrar instrucciones");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFinal.setText("Othello es un juego de mesa por turnos en un tablero de 8x8, en el que cada turno un jugador coloca una pieza,");
        lblFinal.setToolTipText("");
        lblFinal.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIntroduccion, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblexample, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExampleexplanation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblexample2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExampleexplanation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIntroduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExampleexplanation, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblexample))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblexample2)
                    .addComponent(lblExampleexplanation2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblExampleexplanation;
    private javax.swing.JLabel lblExampleexplanation2;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblIntroduccion;
    private javax.swing.JLabel lblexample;
    private javax.swing.JLabel lblexample2;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables
}