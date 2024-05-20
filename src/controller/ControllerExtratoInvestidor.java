/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Investidor;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ExtratoInvestidor;


/**
 *
 * @author beatr
 */
public class ControllerExtratoInvestidor {
    private ExtratoInvestidor view;
    private Investidor investidor;

    public ControllerExtratoInvestidor(ExtratoInvestidor view) {
        this.view = view;
    }
    
    public void buscaUsuario(){
        String cpfD = view.getTxtCPF().getText();
        Investidor invest = new Investidor(null,cpfD,
        null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarInvestidor(invest);
            if(res.next()){
                String nome = res.getString("Nome");
                String cpf = res.getString("CPF");
                String senha = res.getString("Senha");
                investidor = new Investidor(nome,cpf,senha);              
            }else{
                JOptionPane.showMessageDialog(view,"Cpf não encontrado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
    }
}
