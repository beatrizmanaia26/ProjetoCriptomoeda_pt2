/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ConsultarSaldo;
import view.InfosSaldoInvestidor;
import view.SaldoInvestidor;

/**
 *
 * @author luana
 */
public class ControllerConsultarSaldoInvest {
    private SaldoInvestidor view;
    private Investidor investidor;

    public ControllerConsultarSaldoInvest(SaldoInvestidor view) {
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
            ResultSet res = dao.consultarInvestidor(invest);//////////
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
    
    public void buscaMoedas(){
        Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarMoedas();
            while (res.next()) {
                String id = res.getString("Nome"); 
                moedasExistentes.add(id);
                }
                res.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            for(int i = 0; i < moedasExistentes.size(); i++){
                ResultSet res = dao.consultarSaldo(investidor,moedasExistentes.get(i));
                if(res == null){
                    try{
                        dao.inserirCarteira(investidor,0,moedasExistentes.get(i));
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(view,"Erro de carteira");
                    }   
                }
                
            }
            conn.close();
        }catch(SQLException e){
             e.printStackTrace(); 
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }       
       }
    
    public void MostrarCarteira(){  
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarCarteira(investidor);
            String texto = "<html>";
            while (res.next()) {
                String id_moeda = res.getString("NomeMoeda"); 
                String saldo = res.getString("Saldo"); 
                texto = texto + id_moeda + ": " + saldo + "<br>";
                
            }
            InfosSaldoInvestidor i = new InfosSaldoInvestidor(investidor);
            i.getLblSaldoInvest().setText(texto);
            i.setVisible(true);
            view.setVisible(false);
                
           }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
           }
      }
}
