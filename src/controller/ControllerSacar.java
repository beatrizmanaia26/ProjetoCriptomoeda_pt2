/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import view.SacarReais;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Real;

/**
 *
 * @author luana
 */
public class ControllerSacar {
    
    private SacarReais view;
    private Investidor investidor;

    public ControllerSacar(SacarReais view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
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

                
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao");
            }
    }
    public void sacarReais(){
        double valorRetirado = Double.parseDouble(view.getTxtReaisSaque().getText());
        if(valorRetirado >= investidor.getCarteira().getSaldo()){
            JOptionPane.showMessageDialog(view,"Valor excede o saldo!");
        }else{
            double saldoFinal = investidor.getCarteira().getSaldo() - valorRetirado;
            investidor.getCarteira().setSaldo(saldoFinal);

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                dao.AtualizarReaisSaque(investidor);
                JOptionPane.showMessageDialog(view,"Saque feito com sucesso\n"
                        + "Valor atual de reais da conta: " 
                        + investidor.getCarteira().getSaldo());
                dao.InserirExtrato(investidor, "Real", "-", valorRetirado, saldoFinal);

            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
      }
    }
  }
