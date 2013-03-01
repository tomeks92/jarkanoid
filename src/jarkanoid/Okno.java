/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomasz
 */
public class Okno extends javax.swing.JFrame {
    
    private Ekran ekran;
    private Plytka plytka;
    private ArrayList<Kulka> kulki;
    private ArrayList<Blok> bloki;
    /**
     * Creates new form Okno
     */  
    public Okno(Plytka plytka,ArrayList<Kulka> kulki, ArrayList<Blok> bloki) {
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameLayeredPane = new javax.swing.JLayeredPane();
        startButton = new javax.swing.JButton();
        imieField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        startButton.setBounds(290, 170, 224, 48);
        gameLayeredPane.add(startButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        imieField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imieFieldActionPerformed(evt);
            }
        });
        imieField.setBounds(360, 140, 125, 20);
        gameLayeredPane.add(imieField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Imię:");
        jLabel1.setBounds(330, 140, 24, 14);
        gameLayeredPane.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    private void imieFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imieFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imieFieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try {
            plytka = new Plytka();
            kulki = new ArrayList<>();
            kulki.add(new Kulka());
            bloki = new ArrayList<>();
            
            for (int i = 0; i < 15; i++) {
                
            
            bloki.add(new Blok(50, i*20+50, 0));
            bloki.add(new Blok(85, i*20+50, 0));
            bloki.add(new Blok(120, i*20+50, 0));
            bloki.add(new Blok(155, i*20+50, 0));
            bloki.add(new Blok(190, i*20+50, 0));
            bloki.add(new Blok(225, i*20+50, 0));
            bloki.add(new Blok(260, i*20+50, 0));
            bloki.add(new Blok(295, i*20+50, 0));
            bloki.add(new Blok(330, i*20+50, 0));
            bloki.add(new Blok(365, i*20+50, 0));
            bloki.add(new Blok(400, i*20+50, 0));
            bloki.add(new Blok(435, i*20+50, 0));
            bloki.add(new Blok(470, i*20+50, 0));
            bloki.add(new Blok(505, i*20+50, 0));
            bloki.add(new Blok(540, i*20+50, 0));
            bloki.add(new Blok(575, i*20+50, 0));
            bloki.add(new Blok(610, i*20+50, 0));
            bloki.add(new Blok(645, i*20+50, 0));
            bloki.add(new Blok(680, i*20+50, 0));
            bloki.add(new Blok(715, i*20+50, 0));
            }
            
            gameLayeredPane.setEnabled(false);
            gameLayeredPane.setVisible(false);
            ekran = new Ekran(plytka,kulki,bloki);
            new Thread(ekran).start();
            this.add(ekran);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane gameLayeredPane;
    private javax.swing.JTextField imieField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
