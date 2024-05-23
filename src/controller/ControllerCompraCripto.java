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
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.OutrasMoedas;
import view.ComprarCripto;

/**
 *
 * @author luana
 */
public class ControllerCompraCripto {
    private ComprarCripto view;
    private Investidor investidor;
    private ArrayList<String> carteiras = new ArrayList<>();
    private ArrayList<String> carteiras2 = new ArrayList<>();

    
    
    public ControllerCompraCripto(ComprarCripto view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
     public String arrayParaString(ArrayList<String> carteiras) {
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
    
    public void fazCarteira(){
        Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        OutrasMoedas m = null;
        String nomeMoeda = view.getTxtMoeda().getText();
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
    
    public void mostrarCotacao(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarTodaMoeda();
            String texto = "<html>";
            while (res.next()) {
                String id_moeda = res.getString("Nome"); 
                String valor = res.getString("Cotacao"); 
                if(id_moeda.equals("Real")){
                    
                }else{
                    texto = texto + id_moeda + ": R$" + valor + "<br>";
                }
                
            }
            view.getLblCotacao().setText(texto);
                
           }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
           }
      
    }
    
    public void compraMoeda(){
        Conexao conexao = new Conexao();
        String nomeMoeda = view.getTxtMoeda().getText();
        OutrasMoedas moeda = null;
        //Criando a moeda escolhida no gui com as informações do banco
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarMoedaExp(nomeMoeda);
            if(res.next()) {
                String nome = res.getString("Nome");
                String cotacao = res.getString("Cotacao");
                String tcompra = res.getString("Taxa_compra");
                String tvenda = res.getString("Taxa_venda");
                double doubleCotacao = Double.parseDouble(cotacao);
                float floatCompra = Float.parseFloat(tcompra);
                float floatVenda = Float.parseFloat(tvenda);
                moeda = new OutrasMoedas(nome,doubleCotacao,floatCompra,floatVenda);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(view,"Erro de conexao");
        }//Pegando a carteira do banco e a colocando em java
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarCarteira(investidor);
            while (res.next()) {
                String id_moeda = res.getString("NomeMoeda"); 
                String saldo = res.getString("Saldo");
                if(id_moeda.equals(moeda.getNome())){
                    double doubleSaldo = Double.parseDouble(saldo);
                    investidor.getCarteira().setMoedas(moeda);
                    investidor.getCarteira().setSaldo(doubleSaldo);
                    
                }
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(view,"Moeda não encontrada");
        }
        //pegando o saldo em reais
        double saldoReais = 0;
        try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                ResultSet res = dao.consultarReais(investidor);
                if(res.next()){
                    String Saldo = res.getString("Saldo");
                    saldoReais = Double.parseDouble(Saldo);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao ao pegar o "
                        + "saldo de reais da carteira");
            }
        //Realização da compra
        double quant = Double.parseDouble(view.getTxtQuantMoeda().getText());
        double taxaApli = moeda.getTaxaCompra()*moeda.getCotacao();
        double valorTotal = quant*(moeda.getCotacao() + taxaApli);
        double valorTotalCripto = investidor.getCarteira().getSaldo() + quant;
        if(valorTotal > saldoReais){
            JOptionPane.showMessageDialog(view,"Valor excede saldo atual!");    
        }else{
            double saldoFinal = saldoReais - valorTotal;
            try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                dao.AtualizarReaisCompra(investidor,saldoFinal);
                JOptionPane.showMessageDialog(view,moeda.getNome() 
                        + " comprada com sucesso!\n"
                        + "Valor atual de reais da conta: " 
                        + saldoFinal); 
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao ao "
                        + "atualizar Real");
        }
            try{
                Connection conn = conexao.getConnection();
                BancoDAO dao = new BancoDAO(conn);
                investidor.getCarteira().setSaldo(valorTotalCripto);
                dao.AtualizarMoedaCompra(investidor);
                extratoReal();
                extratoCripto();
                dao.InserirExtrato(investidor, "Real", "-", valorTotal, saldoFinal,arrayParaString(carteiras));
                dao.InserirExtrato(investidor, 
                       nomeMoeda,
                        "+", quant, valorTotalCripto,arrayParaString(carteiras2));//


            }catch(SQLException e){
                JOptionPane.showMessageDialog(view,"Erro de conexao ao "
                        + "atualizar a criptomoeda escolhida");
        }
            
        }
    }
    public void extratoReal(){
       Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        OutrasMoedas m = null;
        String nomeMoeda = view.getTxtMoeda().getText();
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
    }
    
    public void extratoCripto(){
       Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        OutrasMoedas m = null;
        String nomeMoeda = view.getTxtMoeda().getText();
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
                   if (!(moedasExistentes.get(i).equals(nomeMoeda))) {
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
                        carteiras2.add(c);

                    }
                    } 
                  }
            }

        conn.close();
        }catch(SQLException e){
             e.printStackTrace(); 
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        } 
    }


}
