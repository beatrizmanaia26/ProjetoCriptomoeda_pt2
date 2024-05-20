/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.BemVindoAdministrador;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Moedas;
import view.BemVindoUsuario;

/**
 *
 * @author beatr
 */
public class ControllerAtualizarCriptomoedas {
    private BemVindoAdministrador view;
    private BemVindoUsuario viewUser;

    public ControllerAtualizarCriptomoedas(BemVindoUsuario viewUser) {
        this.viewUser = viewUser;
    }
    
    public ControllerAtualizarCriptomoedas(BemVindoAdministrador view) {
        this.view = view;
    }
    
    public void AtualizarCriptomoedas(){
        Conexao conexao = new Conexao();
        ArrayList<Moedas> moedas = new ArrayList<>();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res= dao.consultarParaAtualizarCriptomoedas();
            while (res.next()) {
                String nome = res.getString("Nome");
                String cotacao = res.getString("Cotacao");
                String tcompra = res.getString("Taxa_compra");
                String tvenda = res.getString("Taxa_venda");
                double doubleCotacao = Double.parseDouble(cotacao);
                float floatCompra = Float.parseFloat(tcompra);
                float floatVenda = Float.parseFloat(tvenda);
                Moedas mo = new Moedas(nome,doubleCotacao,floatCompra, floatVenda);
                moedas.add(mo);
                
            }
        } catch(Exception e){
           JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);  
            for (int i = 0; i < moedas.size(); i++){
                  // Moedas mo = new Moedas(doubleCotacaoMoeda);
                   moedas.get(i).setCotacao(moedas.get(i).atualizar());
                   dao.atualizarCriptomoedas(moedas.get(i));
               }
            JOptionPane.showMessageDialog(view,"Cotações atualizadas com sucesso");
            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,"Erro de conexao 2");
        }
    }
}
