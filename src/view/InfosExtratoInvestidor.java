/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author beatr
 */
public class InfosExtratoInvestidor extends javax.swing.JFrame {

    /**
     * Creates new form InfosExtratoInvestidor
     */
    public InfosExtratoInvestidor() {
        initComponents();
        setLocationRelativeTo(null);
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

        lblNomeInvest = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPFInvest = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblExtratoInvest = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMenuItemMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNomeInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblNomeInvest.setText("Nome:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCPFInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblCPFInvest.setText("CPF:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblExtratoInvest.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblExtratoInvest.setText("-");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeInvest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCPFInvest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 451, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblExtratoInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeInvest, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCPFInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblExtratoInvest, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMenuActionPerformed
        BemVindoAdministrador adm = new BemVindoAdministrador();
        adm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemMenu;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JLabel lblCPFInvest;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblExtratoInvest;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeInvest;
    // End of variables declaration//GEN-END:variables
}
