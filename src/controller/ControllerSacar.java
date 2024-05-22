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
import model.OutrasMoedas;
import model.Real;

/**
 *
 * @author luana
 */
public class ControllerSacar {
    private SacarReais view;
    private Investidor investidor;
    private ArrayList<String> carteiras = new ArrayList<>(); //cria pra adicionar no extrato os saldos das outras moedas que nao real

    public ControllerSacar(SacarReais view, Investidor investidor) {
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
                    } else {
                        String c = investidor.getCarteira().toString();
                        carteiras.add(c);
                    }
                  }
            }
            for (int i = 0; i < carteiras.size(); i++) { //adiciona 2 ripple na lista, esse código apaga a primeira ripple
                if (carteiras.get(i).startsWith("Ripple")) {
                    carteiras.remove(i);
                    break; // Para de percorrer a lista assim que encontrar a primeira ocorrência de Ripple
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
                dao.InserirExtrato(investidor, "Real", "-", valorRetirado, saldoFinal, arrayParaString());

            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
      }
    }
  }
