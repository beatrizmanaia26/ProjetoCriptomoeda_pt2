/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Investidor;
/**
 *
 * @author beatr
 */
public class BancoDAO {
    private Connection conn;

    public BancoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Investidor investidor) throws SQLException{
        String sql = "insert into User (ID_user, Nome, Senha, CPF) values('" +
                1 + "', '" + investidor.getNome() + "', '" +
                investidor.getSenha() + "', '" +
                investidor.getCpf() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
      public ResultSet consultar(Investidor investidor) throws SQLException{ 
        String sql = "select * from User where CPF = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf());//1 pq  é primeira interrogação
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
      public void excluir(Investidor investidor) throws SQLException{
        String sql = "delete from User where CPF = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, investidor.getCpf());
        statement.execute();
        conn.close();
      }    
}
