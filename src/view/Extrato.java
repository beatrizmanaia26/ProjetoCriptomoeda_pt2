/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerExtrato;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.Investidor;

/**
 *
 * @author beatr
 */
public class Extrato extends javax.swing.JFrame {

    /**
     * Creates new form Extrato
     */
    public Extrato(Investidor investidor) {
        controller = new ControllerExtrato(this,investidor);
        initComponents();
        setLocationRelativeTo(null); //embaixo do ini pra fica no meio mesmo
        this.investidor = investidor;
        controller.verificaExistenciaExtrato();
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerExtrato getController() {
        return controller;
    }

    public void setController(ControllerExtrato controller) {
        this.controller = controller;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuBar getjMenuBar2() {
        return jMenuBar2;
    }

    public void setjMenuBar2(JMenuBar jMenuBar2) {
        this.jMenuBar2 = jMenuBar2;
    }

    public JMenuBar getjMenuBar3() {
        return jMenuBar3;
    }

    public void setjMenuBar3(JMenuBar jMenuBar3) {
        this.jMenuBar3 = jMenuBar3;
    }

    public JMenuBar getjMenuBar4() {
        return jMenuBar4;
    }

    public void setjMenuBar4(JMenuBar jMenuBar4) {
        this.jMenuBar4 = jMenuBar4;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public void setjMenuItem2(JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public void setjMenuItem3(JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
    }

    public JMenu getjMenuMenu() {
        return jMenuMenu;
    }

    public void setjMenuMenu(JMenu jMenuMenu) {
        this.jMenuMenu = jMenuMenu;
    }

    public JMenu getjMenuMenu1() {
        return jMenuMenu1;
    }

    public void setjMenuMenu1(JMenu jMenuMenu1) {
        this.jMenuMenu1 = jMenuMenu1;
    }

    public JMenu getjMenuMenu2() {
        return jMenuMenu2;
    }

    public void setjMenuMenu2(JMenu jMenuMenu2) {
        this.jMenuMenu2 = jMenuMenu2;
    }

    public JMenu getjMenuMenu3() {
        return jMenuMenu3;
    }

    public void setjMenuMenu3(JMenu jMenuMenu3) {
        this.jMenuMenu3 = jMenuMenu3;
    }

    public JLabel getLblCPFInvest() {
        return lblCPFInvest;
    }

    public void setLblCPFInvest(JLabel lblCPFInvest) {
        this.lblCPFInvest = lblCPFInvest;
    }

    public JLabel getLblCpf() {
        return lblCpf;
    }

    public void setLblCpf(JLabel lblCpf) {
        this.lblCpf = lblCpf;
    }

    public JLabel getLblExtratoInvest() {
        return lblExtratoInvest;
    }

    public void setLblExtratoInvest(JLabel lblExtratoInvest) {
        this.lblExtratoInvest = lblExtratoInvest;
    }

    public JLabel getLblExtratoInvest1() {
        return lblExtratoInvest1;
    }

    public void setLblExtratoInvest1(JLabel lblExtratoInvest1) {
        this.lblExtratoInvest1 = lblExtratoInvest1;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public void setLblNome(JLabel lblNome) {
        this.lblNome = lblNome;
    }

    public JLabel getLblNomeInvest() {
        return lblNomeInvest;
    }

    public void setLblNomeInvest(JLabel lblNomeInvest) {
        this.lblNomeInvest = lblNomeInvest;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExtratoInvest = new javax.swing.JLabel();
        lblCPFInvest = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblNomeInvest = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblExtratoInvest1 = new javax.swing.JLabel();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenuMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        lblExtratoInvest.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblExtratoInvest.setText("-");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCPFInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblCPFInvest.setText("CPF:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblNomeInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblNomeInvest.setText("Nome:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblExtratoInvest1.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblExtratoInvest1.setText("-");

        jMenuMenu3.setText("Menu");

        jMenuItem4.setText("menu");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuMenu3.add(jMenuItem4);

        jMenuBar4.add(jMenuMenu3);

        setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCPFInvest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNomeInvest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblExtratoInvest1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCPFInvest)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblExtratoInvest1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        BemVindoUsuario b = new BemVindoUsuario(investidor);
        b.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private Investidor investidor;
    private ControllerExtrato controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JMenu jMenuMenu1;
    private javax.swing.JMenu jMenuMenu2;
    private javax.swing.JMenu jMenuMenu3;
    private javax.swing.JLabel lblCPFInvest;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblExtratoInvest;
    private javax.swing.JLabel lblExtratoInvest1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeInvest;
    // End of variables declaration//GEN-END:variables
}
