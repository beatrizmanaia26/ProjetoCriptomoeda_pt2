/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Moedas;
import view.CadastrarCriptomoeda;

/**
 *
 * @author beatr
 */
public class ControllerCadastroCripto {
   
    private CadastrarCriptomoeda view;

    public ControllerCadastroCripto(CadastrarCriptomoeda view) {
        this.view = view;
    }
    
    public void salvarCripto(){
        String nome = view.getTxtNomeCripto().getText();
        double cotacao = Double.parseDouble(view.getTxtCotacaoCripto().getText());
        float taxaCompra = Float.parseFloat(view.getTxtTaxaCompra().getText());
        float taxaVenda = Float.parseFloat(view.getTxtTaxaVenda().getText());
        
        Moedas moeda = new Moedas(nome, cotacao, taxaCompra, taxaVenda);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            dao.inserirMoeda(moeda);
            JOptionPane.showMessageDialog(view,"Moeda cadastrado");
      
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Moeda nao cadastrado");
            }
        }
}