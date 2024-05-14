/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ExcluirInvestidor;
import java.sql.Connection;

/**
 *
 * @author beatr
 */

public class ControllerExcluirInvestidor {
    private ExcluirInvestidor view;
    private Investidor investidor;

    public ControllerExcluirInvestidor(ExcluirInvestidor view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    public void remover(){
        String invest = investidor.getCpf();
        int option = JOptionPane.showConfirmDialog(view,
                                  "deseja realmente excluir?" + invest + "?");
            if(option !=1){
                 Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                dao.excluir(investidor);
                JOptionPane.showMessageDialog(view, "excluido com sucesso");
                view.setVisible(false);       
            }catch(Exception e){
                JOptionPane.showMessageDialog(view, "falha de conexao");
            }
        }   
    }
}

   
