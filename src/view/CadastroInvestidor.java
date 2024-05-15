/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerCadastro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author luana
 */
public class CadastroInvestidor extends javax.swing.JFrame {

    /**
     * Creates new form CadastroInvestidor
     */
    public CadastroInvestidor() {
        initComponents();
        setLocationRelativeTo(null);
        control = new ControllerCadastro(this);
        
    }

    public JButton getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
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

    public JLabel getLblCadastroInvestidor() {
        return lblCadastroInvestidor;
    }

    public void setLblCadastroInvestidor(JLabel lblCadastroInvestidor) {
        this.lblCadastroInvestidor = lblCadastroInvestidor;
    }

    public JLabel getLblNomeInvest() {
        return lblNomeInvest;
    }

    public void setLblNomeInvest(JLabel lblNomeInvest) {
        this.lblNomeInvest = lblNomeInvest;
    }

    public JLabel getLblSenhaInvest() {
        return lblSenhaInvest;
    }

    public void setLblSenhaInvest(JLabel lblSenhaInvest) {
        this.lblSenhaInvest = lblSenhaInvest;
    }

    public JTextField getTxtCPFInvest() {
        return txtCPFInvest;
    }

    public void setTxtCPFInvest(JTextField txtCPFInvest) {
        this.txtCPFInvest = txtCPFInvest;
    }

    public JTextField getTxtNomeInvest() {
        return txtNomeInvest;
    }

    public void setTxtNomeInvest(JTextField txtNomeInvest) {
        this.txtNomeInvest = txtNomeInvest;
    }

    public JTextField getTxtSenhaInvest() {
        return txtSenhaInvest;
    }

    public void setTxtSenhaInvest(JTextField txtSenhaInvest) {
        this.txtSenhaInvest = txtSenhaInvest;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenhaInvest = new javax.swing.JLabel();
        lblCPFInvest = new javax.swing.JLabel();
        txtSenhaInvest = new javax.swing.JTextField();
        txtCPFInvest = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        lblCadastroInvestidor = new javax.swing.JLabel();
        lblNomeInvest = new javax.swing.JLabel();
        txtNomeInvest = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Investidor");

        lblSenhaInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblSenhaInvest.setText("Senha:");

        lblCPFInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblCPFInvest.setText("CPF:");

        txtSenhaInvest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        txtCPFInvest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btCadastrar.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lblCadastroInvestidor.setFont(new java.awt.Font("Book Antiqua", 3, 36)); // NOI18N
        lblCadastroInvestidor.setText("Cadastro Novo Investidor");

        lblNomeInvest.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblNomeInvest.setText("Nome:");

        txtNomeInvest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuMenu.setText("Menu");

        jMenuItem1.setText("menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuMenu.add(jMenuItem1);

        jMenuBar1.add(jMenuMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSenhaInvest)
                                    .addComponent(lblCPFInvest))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPFInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenhaInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNomeInvest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblCadastroInvestidor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastroInvestidor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeInvest)
                    .addComponent(txtNomeInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFInvest)
                    .addComponent(txtCPFInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaInvest)
                    .addComponent(txtSenhaInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        control.salvarInvestidor();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        BemVindoAdministrador adm = new BemVindoAdministrador();
        adm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

   
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CadastroInvestidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CadastroInvestidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CadastroInvestidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CadastroInvestidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CadastroInvestidor().setVisible(true);
//            }
//        });
//    }
    
    
    private ControllerCadastro control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JLabel lblCPFInvest;
    private javax.swing.JLabel lblCadastroInvestidor;
    private javax.swing.JLabel lblNomeInvest;
    private javax.swing.JLabel lblSenhaInvest;
    private javax.swing.JTextField txtCPFInvest;
    private javax.swing.JTextField txtNomeInvest;
    private javax.swing.JTextField txtSenhaInvest;
    // End of variables declaration//GEN-END:variables
}
