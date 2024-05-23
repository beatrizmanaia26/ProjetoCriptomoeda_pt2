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
import model.OutrasMoedas;
import model.Real;

/**
 *
 * @author beatr
 */
public class ControllerDepositarMoedas {
    private DepositoReais view;
    private Investidor investidor;
    private ArrayList<String> carteiras = new ArrayList<>(); //cria pra adicionar no extrato os saldos das outras moedas que nao real
    
    public ControllerDepositarMoedas(DepositoReais view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public String arrayParaString() {
        StringBuilder sb = new StringBuilder();
    
        for (String carteira : carteiras) {
            sb.append(carteira); 
            sb.append(", ");
        }
        if (!carteiras.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Remove a última vírgula e o espaço
        }
        return sb.toString(); 
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
        OutrasMoedas m = null;
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
                }else{
                   if (!(moedasExistentes.get(i).equals("Real"))) {
                    ResultSet resMoeda = dao.consultarMoedaExp(moedasExistentes.get(i));
                    //pega td da moeda pra criar moeda (precisa de moeda pra criar carteira), precisa criar carteira pra
                    // ter nome da moeda e conseguir relacionar ao saldo na coluna de string do extrato 
                    if (resMoeda.next()) {//cria moeda
                        double cotacao = resMoeda.getDouble("Cotacao");
                        float taxaVenda = resMoeda.getFloat("Taxa_venda");
                        float taxaCompra = resMoeda.getFloat("Taxa_compra");

                        m = new OutrasMoedas(moedasExistentes.get(i), cotacao, taxaCompra, taxaVenda);

                        double saldo = res.getDouble("Saldo"); 
                        investidor.getCarteira().setMoedas(m);
                        investidor.getCarteira().setSaldo(saldo);  

                        String c = investidor.getCarteira().toString();
                        carteiras.add(c);

                    }
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
    
    public void DepositarReais(){ //faz outrasmoedas aqui pq aqui que tem saldo do real
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
            //transforma arraylist em string
            try{
                dao.InserirExtrato(investidor, "Real", "+", deposito, valorFinal,arrayParaString());
            }catch(SQLException e){
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(view,"Erro de conexao");
            }
            
        }catch(SQLException e){
             JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        
    }
}