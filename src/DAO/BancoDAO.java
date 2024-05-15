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
import model.Moedas;
/**
 *
 * @author beatr
 */
public class BancoDAO {
    private Connection conn;

    public BancoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Investidor investidor) throws SQLException{//Funciona mais o id ta 
        String sql = "insert into investidores (\"Nome\", "
                + "\"Senha\", \"CPF\") values('" +
                investidor.getNome() + "', '" +
                investidor.getSenha() + "', '" +
                investidor.getCpf() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close(); 
    }
    public void inserirMoeda(Moedas moeda) throws SQLException{
        String sql = "insert into moedas ( \"Nome\", "
                + "\"Cotacao\", \"Taxa_compra\", \"Taxa_venda\") values('" +
                moeda.getNome() + "', '" +
                moeda.getCotacao() + "', '" +
                moeda.getTaxaCompra() + "', '" +
                moeda.getTaxaVenda() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close(); 
    }
    
      public ResultSet consultar(Investidor investidor) throws SQLException{ 
        String sql = "select * from investidores where \"CPF\" = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf());//1 pq  é primeira interrogação
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
      public void excluir(Investidor investidor) throws SQLException{
        String sql = "delete from investidores where \"CPF\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, investidor.getCpf());
        statement.execute();
        conn.close();
      }    
       public ResultSet consultarCripto(Moedas moeda) throws SQLException{ 
        String sql = "select * from moedas where \"Nome\" = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,moeda.getNome());//1 pq  é primeira interrogação
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
      public void excluirCripto(Moedas moeda) throws SQLException{
        String sql = "delete from moedas where \"Nome\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, moeda.getNome());
        statement.execute();
        conn.close();
      }
      
        public ResultSet consultarLogin(Investidor investidor) throws SQLException{
            String sql = "select * from aluno where \"CPF\" = ? and \"Senha\" = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, investidor.getCpf());
            statement.setString(2, investidor.getSenha());
            statement.execute();
            ResultSet resultado = statement.getResultSet();
            return resultado;
        
    }
}
