/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.ExcluirCriptomoeda;
import DAO.BancoDAO;
import DAO.Conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.OutrasMoedas;

/**
 *
 * @author beatr
 */
public class ControllerExcluirCripto {
     private ExcluirCriptomoeda view;

    public ControllerExcluirCripto(ExcluirCriptomoeda view) {
        this.view = view;
    }
       public void removerCripto(){
        String nomeCripto = view.getTxtNomeCripto().getText();
        if(nomeCripto.equals("Real")){
            JOptionPane.showMessageDialog(view,"Não é possivel excluir real!");
            return;
        }
        OutrasMoedas moeda = new OutrasMoedas(nomeCripto,
        0,0,0); //cria investidor pra comparar se acha um cpf igual ao desse investidor para apagá-lo
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarCripto(moeda); //pega investidor com cpf desejado
            if(res.next()){
                String nome = res.getString("Nome"); //pega nome do investidor com cpf desejado
                double cotacao = res.getDouble("Cotacao");
                float taxaCompra = res.getFloat("Taxa_compra");
                float taxaVenda = res.getFloat("Taxa_venda");
                OutrasMoedas m = new OutrasMoedas(nome,cotacao,taxaCompra,taxaVenda);
                
                int option = JOptionPane.showConfirmDialog(view,"Deseja realmente excluir " + nome + "?");
                if(option != 1){
                    
                    try{
                        dao.excluirExtratoMoeda(m);
                        dao.excluirCarteiraMoeda(m);
                        dao.excluirCripto(m);
                        JOptionPane.showMessageDialog(view,"Moeda excluida");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(view,"Erro de conexao");
                   }
                }
                  
            }else{
                JOptionPane.showMessageDialog(view,"Moeda não encontrada");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
    }
}
