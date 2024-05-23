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
        this.lblNome.setText(investidor.getNome()); 
        this.lblCpf.setText(investidor.getCpf()); 
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

    public JMenuBar getjMenuBar4() {
        return jMenuBar4;
    }

    public void setjMenuBar4(JMenuBar jMenuBar4) {
        this.jMenuBar4 = jMenuBar4;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
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

        lblExtratoInvest1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCPFInvest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeInvest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(722, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExtratoInvest1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCPFInvest)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(lblExtratoInvest1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMenuMenu3;
    private javax.swing.JLabel lblCPFInvest;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblExtratoInvest;
    private javax.swing.JLabel lblExtratoInvest1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeInvest;
    // End of variables declaration//GEN-END:variables
}