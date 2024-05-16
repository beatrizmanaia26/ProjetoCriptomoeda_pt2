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
import view.BemVindoUsuario;
import view.ConsultarSaldo;

/**
 *
 * @author luana
 */
public class ControllerConsultarSaldo {
    
    private BemVindoUsuario view;
    private Investidor investidor;

    public ControllerConsultarSaldo(BemVindoUsuario view,Investidor invest) {
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
            String texto = "<html>";
            while (res.next()) {
                // Acesse os valores das colunas para a linha atual
                String id = res.getString("Nome"); // pego id da moeda para usar no resto
                // Faça o que for necessário com os valores, por exemplo, imprima-os
                texto = texto + id + "<br>";
                moedasExistentes.add(id);
                }
                res.close();
                ConsultarSaldo cs = new ConsultarSaldo(investidor);
                cs.getLblInformacoes().setText(texto);
                cs.setVisible(true);
                view.setVisible(false);
                
            
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
                        JOptionPane.showMessageDialog(view,"Erro de  carteira");
                    }
                    
                }else{
                    System.out.println("aa");
                }
                
            }
            conn.close();
        }catch(SQLException e){
             e.printStackTrace(); // Isso imprimirá a pilha de exceções para identificar a causa raiz do erro
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
        
    }
    
//    public void consulSaldo(){
//        
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            BancoDAO dao = new BancoDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res == null){
//                
//                
//            }else{
//                JOptionPane.showMessageDialog(view,"Login não foi feito");
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view,"Erro de conexao");
//        }
//        
//       }
    }

