package controller;

import model.Investidor;
import view.VendaCriptomoedas;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.OutrasMoedas;

public class ControllerVenderCripto {
    private VendaCriptomoedas view;
    private Investidor investidor;

    public ControllerVenderCripto(VendaCriptomoedas view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public void criarCarteira() {
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

    public void venderCripto() {
    String nomeMoeda = view.getTxtVender().getText();
    double quantidadeVender = Double.parseDouble(view.getTxtQtdMoeda().getText());
    Conexao conexao = new Conexao(); 
    try {
        Connection conn = conexao.getConnection();
        BancoDAO dao = new BancoDAO(conn);
        // Verificar se a moeda existe
        ResultSet res = dao.consultarMoedas();
        boolean moedaEncontrada = false;
        while (res.next()) {
            String id = res.getString("Nome"); 
            if (id.equals(nomeMoeda)) {
                moedaEncontrada = true;
                //verificar saldo da moeda
                double saldoMoeda = dao.consultarSaldoMoeda(investidor, nomeMoeda);
                if (saldoMoeda >= quantidadeVender) {
                    OutrasMoedas moeda = new OutrasMoedas();
                    moeda.setNome(nomeMoeda);
                    ResultSet resMoeda = dao.consultarCripto(moeda);
                    if (resMoeda.next()) {
                        //pega informações pra fazer calculo dos valores 
                        double cotacao = resMoeda.getDouble("Cotacao");
                        double taxaVenda = resMoeda.getDouble("Taxa_venda");
                        double valorReais = quantidadeVender * cotacao * (1 - taxaVenda);
                        double novoSaldoMoeda = saldoMoeda - quantidadeVender;
                        dao.atualizarSaldoCarteira(investidor, nomeMoeda, novoSaldoMoeda); 
                        ResultSet resReais = dao.consultarReais(investidor);
                        if (resReais.next()) {
                            double saldoReais = resReais.getDouble("Saldo");
                            double novoSaldoReais = saldoReais + valorReais;
                            investidor.getCarteira().setSaldo(novoSaldoReais);
                            dao.depositoReais(investidor);
                            JOptionPane.showMessageDialog(view, "Venda realizada com sucesso.\nSaldo atual: " 
                                                                + investidor.getCarteira().getSaldo()); 
                            //informações para extrato
                            dao.InserirExtrato(investidor, "Real", "+", valorReais, novoSaldoReais);
                            dao.InserirExtrato(investidor, nomeMoeda , "-", quantidadeVender , novoSaldoMoeda);
                        } else {
                            JOptionPane.showMessageDialog(view, "Saldo em reais não encontrado.");
                        }    
                    } else {
                        JOptionPane.showMessageDialog(view, "Dados da moeda não encontrados.");
                    } 
                } else {
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente de " + nomeMoeda + ".");
                } 
            }
        }
        res.close();
        if (!moedaEncontrada) {
            JOptionPane.showMessageDialog(view, "Moeda não encontrada.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(view, "Erro de conexão.");
    }     
}

    public void mostrarCotacoes(){
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
            
        }
    }
}


