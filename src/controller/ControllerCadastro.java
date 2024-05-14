/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.CadastroInvestidor;

/**
 *
 * @author luana
 */
public class ControllerCadastro {
    private CadastroInvestidor view;

    public ControllerCadastro(CadastroInvestidor view) {
        this.view = view;
    }
    
    public void salvarInvestidor(){
        String nome = view.getTxtNomeInvest().getText();
        String cpf = view.getTxtCPFInvest().getText();
        String senha = view.getTxtSenhaInvest().getText();
        
        Investidor invest = new Investidor(nome,cpf,senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            dao.inserir(invest);
            JOptionPane.showMessageDialog(view,"Investidor cadastrado");
      
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Investidor nao cadastrado");
        }
    }
}
