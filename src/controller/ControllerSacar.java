/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import view.SacarReais;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Moedas;
import model.Real;
import view.ConsultarSaldo;

/**
 *
 * @author luana
 */
public class ControllerSacar {
    
    private SacarReais view;
    private Investidor investidor;

    public ControllerSacar(SacarReais view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void ConsultarCarteira(){
       
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarReais(investidor);
            if(res.next()){
                String Saldo = res.getString("Saldo");
                double doubleSaldo = Double.parseDouble(Saldo);
                Real r = new Real();
                investidor.getCarteira().setMoedas(r);
                investidor.getCarteira().setSaldo(doubleSaldo);
                System.out.println(investidor.getCarteira());
                
                
                
                
            }else{
                JOptionPane.showMessageDialog(view,"Login não foi feito");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
    }
    
    
    
    
}
