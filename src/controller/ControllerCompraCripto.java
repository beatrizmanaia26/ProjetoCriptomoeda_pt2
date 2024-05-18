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
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarCripto;

/**
 *
 * @author luana
 */
public class ControllerCompraCripto {
    private ComprarCripto view;
    private Investidor investidor;

    public ControllerCompraCripto(ComprarCripto view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void fazCarteira(){
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
}
