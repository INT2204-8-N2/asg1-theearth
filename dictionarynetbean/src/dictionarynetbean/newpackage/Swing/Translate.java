/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarynetbean.newpackage.Swing;

import dictionarynetbean.newpackage.GoogleTranslate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VX15
 */
public class Translate extends javax.swing.JFrame {

    /**
     * Creates new form Translate
     */
    public Translate() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        AnhViet = new javax.swing.JRadioButton();
        VietAnh = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(AnhViet);
        AnhViet.setText("Anh - Việt");
        AnhViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnhVietActionPerformed(evt);
            }
        });

        buttonGroup1.add(VietAnh);
        VietAnh.setText("Việt - Anh");
        VietAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VietAnhActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setLineWrap(true);
        area.setRows(5);
        area.setWrapStyleWord(true);
        jScrollPane1.setViewportView(area);

        text.setColumns(20);
        text.setLineWrap(true);
        text.setRows(5);
        text.setWrapStyleWord(true);
        text.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        text.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textCaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(text);

        jLabel1.setText("Enter the text you want to translate:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionarynetbean/newpackage/Swing/google-translate-ho-tro-nhung-thiet-bi-nao-cai-nhu-the-nao.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(AnhViet)
                        .addGap(155, 155, 155)
                        .addComponent(VietAnh))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnhViet)
                    .addComponent(VietAnh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textCaretUpdate
        // TODO add your handling code here:
        String s = text.getText();
        if(AnhViet.isSelected()){
            try {
                area.setText(GoogleTranslate.translate("vi",s));
            } catch (IOException ex) {
                Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(VietAnh.isSelected()){
            try {
                area.setText(GoogleTranslate.translate("eng",s));
            } catch (IOException ex) {
                Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_textCaretUpdate

    private void AnhVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnhVietActionPerformed
        // TODO add your handling code here:
        String s = text.getText();
        try {
                area.setText(GoogleTranslate.translate("vi",s));
            } catch (IOException ex) {
                Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_AnhVietActionPerformed

    private void VietAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VietAnhActionPerformed
        // TODO add your handling code here:
        String s = text.getText();
        try {
                area.setText(GoogleTranslate.translate("eng",s));
            } catch (IOException ex) {
                Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_VietAnhActionPerformed

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
            java.util.logging.Logger.getLogger(Translate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Translate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Translate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Translate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Translate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AnhViet;
    private javax.swing.JRadioButton VietAnh;
    private javax.swing.JTextArea area;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
