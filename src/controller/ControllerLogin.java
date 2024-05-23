/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import model.Administrador;
import model.Investidor;
import view.BemVindoAdministrador;
import view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import view.BemVindoUsuario;

/**
 *
 * @author beatr Verificamos se  cpf nao possuir . ou - e se o digitado (cpf e senha) é igual ao cpf e senha de algum
 * investidor cadastrado, se sim redirecionamos ele para o gui do investidor, ou se for igual ao cpf e senha do administrador
 * redirecionamos para o gui do administrador
 */
public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    
   public void ValidarUsuario(){
       Administrador a = new Administrador(); 
       String cpfLogin = view.getTxtCPF().getText();
       if (cpfLogin.contains(".") || cpfLogin.contains("-")) {
        JOptionPane.showMessageDialog(view, "CPF não pode conter . ou -");
        return;
        }
       String senhaLogin = view.getTxtSenha().getText();
       
       if(cpfLogin.equals(a.getCpf()) && senhaLogin.equals(a.getSenha())){
           BemVindoAdministrador adm = new BemVindoAdministrador();
           adm.setVisible(true);
           view.setVisible(false);
       }
       else{
        Investidor invest = new Investidor(null,cpfLogin,
        senhaLogin);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultar(invest);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login feito");
                String nome = res.getString("Nome");
                String cpf = res.getString("CPF");
                String senha = res.getString("Senha");
                
                BemVindoUsuario b = new BemVindoUsuario(new Investidor(nome, cpf, senha));
                b.setVisible(true);
                view.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(view,"Dados incorretos");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        
       }
    }    
}
