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
    public void verificaExistenciaExtrato(){ //ve se extrato é nulo 
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarExtrato(investidores);
            ResultSet resSaldo = dao.consultarCarteira(investidores); //para pegar o saldo de todas as moedas
         //   ResultSet resMo = dao.consultarMoedaExp(moeda);
                if(res == null){
                       view.getLblExtratoInvest1().setText("Extrato inexistente");
                }
                else{
                    String texto = "<html>";
                    while (res.next()) {
                        String tempo = res.getString("DataHora"); 
                        String tipoOperacao = res.getString("TipoOper");
                        String moeda = res.getString("ID_moeda");
                        String valorOper = res.getString("ValorOper");
                        String saldoAtual = res.getString("SaldoAtual");
                      //  double cotacao = investidores.getCarteira().getMoedas().getCotacao();
                        //fazer if p ver se é taxacompra ou taxa venda (COLOCAR COLUNA EM EXTRATO PRA GUARDAR TAXA)
                        texto = texto + " " + tempo + " " + tipoOperacao + " " + valorOper + " "+ "CT: " +
                                " " + " " + " TX: " + "pendente"+ " " + moeda +": " + saldoAtual + "<br>" ;
                       // String taxa = 
                    }
                    view.getLblExtratoInvest1().setText(texto);
                }
            conn.close();
        }catch(SQLException e){
             e.printStackTrace(); 
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }       
    }
}
