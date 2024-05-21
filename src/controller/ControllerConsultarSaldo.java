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
import view.ConsultarSaldo;

/**
 *
 * @author luana
 */
public class ControllerConsultarSaldo {
    
    private ConsultarSaldo view;
    private Investidor investidor;

    public ControllerConsultarSaldo(ConsultarSaldo view,Investidor invest) {
        this.view = view;
        investidor = invest; 
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
    
    public void MostrarCarteira(){  
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarCarteira(investidor);
            String texto = "<html>";
            while (res.next()) {
                String id_moeda = res.getString("NomeMoeda"); 
                String saldo = res.getString("Saldo");
                texto = texto + id_moeda + ": " + saldo + "<br>";
            }
            view.getLblSaldoInvest().setText(texto);
               
           }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
           }
      }

   }

