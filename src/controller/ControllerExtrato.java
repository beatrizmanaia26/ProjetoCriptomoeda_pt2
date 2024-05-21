/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Extrato;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;

/**
 *
 * @author beatr
 */
public class ControllerExtrato {
    public Extrato view;
    public Investidor investidores;

    public ControllerExtrato(Extrato view, Investidor investidores) {
        this.view = view;
        this.investidores = investidores;
    }
    
    public void buscaMoedas(){ //cria carteira
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
                ResultSet res = dao.consultarSaldo(investidores,moedasExistentes.get(i));
                if(res == null){
                    try{
                        dao.inserirCarteira(investidores,0,moedasExistentes.get(i));
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
    
    public void verificaExistenciaExtrato() { 
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarExtrato(investidores);
            if (res == null) {
                view.getLblExtratoInvest1().setText("Extrato inexistente");
            } else {
                StringBuilder texto = new StringBuilder("<html>");
                while (res.next()) {
                    String tempo = res.getString("DataHora");
                    String tipoOperacao = res.getString("TipoOper");
                    String moeda = res.getString("ID_moeda");
                    String valorOper = res.getString("ValorOper");

                    // consultar a cotação da moeda especifica
                    ResultSet resCotacao = dao.consultarCotacao(moeda);
                    String cotacao = "";
                    if (resCotacao.next()) {
                        cotacao = resCotacao.getString("Cotacao");
                    }
                    resCotacao.close();
                    
                    //consulta taxa de compra da moeda especifica
                    ResultSet resTaxaCompra = dao.consultarTaxaCompra(moeda);
                    ResultSet resTaxaVenda = dao.consultarTaxaVenda(moeda);
                    String taxa = "";
                    if(resTaxaCompra.next()){
                        if (tipoOperacao.equals("+") && !"Real".equals(moeda)){
                            taxa = resTaxaCompra.getString("Taxa_compra");
                        }
                        if ((tipoOperacao.equals("+") && "Real".equals(moeda)) || 
                                (tipoOperacao.equals("-") && "Real".equals(moeda))){
                            taxa = "0.00";
                        }
                        if (tipoOperacao.equals("-") && !"Real".equals(moeda)){
                            taxa = resTaxaVenda.getString("Taxa_Venda");
                        }
                    }
                     // coloca informações no extrato
                    texto.append(tempo).append("   ").append(tipoOperacao).append("   ")
                         .append(valorOper).append("   ").append(moeda).append("   ")
                         .append("CT: ").append(cotacao).append("   ").append("TX: ").append(taxa).append(" ");
                    
                    //consulta a carteira pra pegar todas as moedas e seus saldos
                    ResultSet resCarteira = dao.consultarCarteira(investidores);
                    while (resCarteira.next()) {
                        String moedaCarteira = resCarteira.getString("NomeMoeda");
                        String saldo = resCarteira.getString("Saldo");
                        texto.append(moedaCarteira).append(":").append(" ").append(saldo).append(" ");
                    }

                texto.append("</html>");
                view.getLblExtratoInvest1().setText(texto.toString());
                    }    
                } 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro de conexão ao consultar extrato");
        }
    }
}
