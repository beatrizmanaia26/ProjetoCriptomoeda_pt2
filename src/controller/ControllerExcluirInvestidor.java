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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author beatr
 */

public class ControllerExcluirInvestidor {
    private ExcluirInvestidor view;
    

    public ControllerExcluirInvestidor(ExcluirInvestidor view) {
        this.view = view;
        
    }
    public void remover(){
        String cpfInvest = view.getTxtCpfInvest().getText();
        Investidor invest = new Investidor(null,cpfInvest,
        null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultar(invest);
            if(res.next()){
                String nome = res.getString("Nome");
                String cpf = res.getString("CPF");
                String senha = res.getString("Senha");
                Investidor i = new Investidor(nome,cpf,senha);
                
                int option = JOptionPane.showConfirmDialog(view,"Deseja realmente excluir " + nome + "?");
                if(option != 1){
                    
                    try{
                        dao.excluir(i);
                        JOptionPane.showMessageDialog(view,"Investidor excluido");



                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(view,"Erro de conexao");
                   }
                }
                  
            }else{
                JOptionPane.showMessageDialog(view,"Investidor não encontrado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
    }
  }
       


   
