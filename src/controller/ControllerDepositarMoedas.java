/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Carteira;
import view.DepositoReais;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Investidor;
import model.Moedas;
import model.Real;

/**
 *
 * @author beatr
 */
public class ControllerDepositarMoedas {
    private DepositoReais view;
    private Investidor investidor;

    public ControllerDepositarMoedas(DepositoReais view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void buscaMoedas(){
        Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarMoedas();
            while (res.next()) {
                // Acesse os valores das colunas para a linha atual
                String id = res.getString("Nome"); // pego id da moeda para usar no resto
                // Faça o que for necessário com os valores, por exemplo, imprima-os
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

    public void consultarCarteira(){
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
            try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                ResultSet res = dao.consultarReais(investidor);
                if(res.next()){
                    String Saldo = res.getString("Saldo");
                    double doubleSaldo = Double.parseDouble(Saldo);
                    Real r = new Real();
                    investidor.getCarteira().setMoedas(r);
                    investidor.getCarteira().setSaldo(doubleSaldo);
                   

                }else{
                    JOptionPane.showMessageDialog(view,"Login não foi feito");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao");
            }
    }
    
    public void DepositarReais(){
        double deposito = Double.parseDouble(view.getTxtReaisDeposito().getText());
        double valorFinal = deposito + investidor.getCarteira().getSaldo();
        investidor.getCarteira().setSaldo(valorFinal);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            dao.depositoReais(investidor);
            JOptionPane.showMessageDialog(view,"Deposito feito com sucesso\n"
                    + "Saldo atual: "+ investidor.getCarteira().getSaldo());
            try{
                dao.InserirExtrato(investidor, "Real", "+", deposito, valorFinal);
            }catch(SQLException e){
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(view,"Erro de conexao");
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        
    }
}