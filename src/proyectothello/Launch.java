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
public class Launch extends javax.swing.JFrame {

    /**
     * Creates new form Launch
     */
    public Launch() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        btnPlay1 = new javax.swing.JButton();
        btnPlay2 = new javax.swing.JButton();
        btnInstrucciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        lblimg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectothello/title logo.png"))); // NOI18N

        pnlMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPlay1.setText("VS Computadora");
        btnPlay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay1ActionPerformed(evt);
            }
        });

        btnPlay2.setText("Dos Jugadores");
        btnPlay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay2ActionPerformed(evt);
            }
        });

        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCreditos.setText("Créditos");
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPlay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreditos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnPlay1)
                .addGap(18, 18, 18)
                .addComponent(btnPlay2)
                .addGap(18, 18, 18)
                .addComponent(btnInstrucciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreditos)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(21, 21, 21))
        );

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectothello/main img.jpg"))); // NOI18N
        lblimg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblimg, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnPlay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay1ActionPerformed
        MiniGameForm launch = new MiniGameForm(false);
        launch.setLocationRelativeTo(null);
        launch.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPlay1ActionPerformed

    private void btnPlay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay2ActionPerformed
        MiniGameForm launch = new MiniGameForm(true);
        launch.setVisible(true);
        launch.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnPlay2ActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        Instrucciones pop = new Instrucciones();
        pop.setLocationRelativeTo(null);
        pop.setVisible(true);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        Credits pop = new Credits();
        pop.setLocationRelativeTo(null);
        pop.setVisible(true);
    }//GEN-LAST:event_btnCreditosActionPerformed

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
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnPlay1;
    private javax.swing.JButton btnPlay2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblimg;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
