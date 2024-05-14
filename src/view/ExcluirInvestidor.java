/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerExcluirInvestidor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author beatr
 */
public class ExcluirInvestidor extends javax.swing.JFrame {

    /**
     * Creates new form ExcluirInvestidor
     */
    public ExcluirInvestidor() {
        controller = new ControllerExcluirInvestidor(this);
        setLocationRelativeTo(null);
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

        lblExcluirInvest = new javax.swing.JLabel();
        txtCpfInvest = new javax.swing.JTextField();
        lblCpfInvest = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMenuItemMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblExcluirInvest.setFont(new java.awt.Font("Book Antiqua", 3, 36)); // NOI18N
        lblExcluirInvest.setText("Excluir investidor");

        txtCpfInvest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblCpfInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblCpfInvest.setText("CPF::");

        btExcluir.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jMenuMenu.setText("Menu");

        jMenuItemMenu.setText("menu");
        jMenuItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMenuActionPerformed(evt);
            }
        });
        jMenuMenu.add(jMenuItemMenu);

        jMenuBar1.add(jMenuMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblExcluirInvest, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblCpfInvest)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExcluirInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfInvest)
                    .addComponent(txtCpfInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemMenuActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        controller.remover();
    }//GEN-LAST:event_btExcluirActionPerformed

    public JButton getBtExcluir() {
        return btExcluir;
    }

    public void setBtExcluir(JButton btExcluir) {
        this.btExcluir = btExcluir;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuItem getjMenuItemMenu() {
        return jMenuItemMenu;
    }

    public void setjMenuItemMenu(JMenuItem jMenuItemMenu) {
        this.jMenuItemMenu = jMenuItemMenu;
    }

    public JMenu getjMenuMenu() {
        return jMenuMenu;
    }

    public void setjMenuMenu(JMenu jMenuMenu) {
        this.jMenuMenu = jMenuMenu;
    }

    public JLabel getLblCpfInvest() {
        return lblCpfInvest;
    }

    public void setLblCpfInvest(JLabel lblCpfInvest) {
        this.lblCpfInvest = lblCpfInvest;
    }

    public JLabel getLblExcluirInvest() {
        return lblExcluirInvest;
    }

    public void setLblExcluirInvest(JLabel lblExcluirInvest) {
        this.lblExcluirInvest = lblExcluirInvest;
    }

    public JTextField getTxtCpfInvest() {
        return txtCpfInvest;
    }

    public void setTxtCpfInvest(JTextField txtCpfInvest) {
        this.txtCpfInvest = txtCpfInvest;
    }

    /**
     * @param args the command line arguments
     */
  
    private ControllerExcluirInvestidor controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemMenu;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JLabel lblCpfInvest;
    private javax.swing.JLabel lblExcluirInvest;
    private javax.swing.JTextField txtCpfInvest;
    // End of variables declaration//GEN-END:variables
}
