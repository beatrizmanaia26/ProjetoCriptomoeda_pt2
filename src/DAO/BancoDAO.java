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
    
    public void inserir(Investidor investidor) throws SQLException{ 
        String sql = "insert into investidores (\"ID_Investidor\", \"Nome\", "
                + "\"Senha\", \"CPF\") values('" +
                investidor.getId() + "', '" + investidor.getNome() + "', '" +
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
}
