/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Bitcoin;
import model.Carteira;
import model.Investidor;
import model.Moedas;
import model.OutrasMoedas;
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
        String sql = "insert into investidores (\"Nome\", "
                + "\"Senha\", \"CPF\") values('" +
                investidor.getNome() + "', '" +
                investidor.getSenha() + "', '" +
                investidor.getCpf() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close(); 
    }
    
    public void inserirMoeda(OutrasMoedas moeda) throws SQLException{
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
        String sql = "select * from investidores where \"CPF\" = ? and \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf());//1 pq  é primeira interrogação
        statement.setString(2,investidor.getSenha());
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
      
      public ResultSet consultarInvestidor(Investidor investidor) throws SQLException{ 
        String sql = "select * from investidores where \"CPF\" = ?";
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
  
      public void excluirCarteiraInvest(Investidor investidor) throws SQLException{
        String sql = "delete from carteira where \"CPF\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, investidor.getCpf());
        statement.execute();   
      }
  
      public void excluirCarteiraMoeda(OutrasMoedas moeda) throws SQLException{
        String sql = "delete from carteira where \"NomeMoeda\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, moeda.getNome());
        statement.execute();    
      }
      
    public ResultSet consultarCripto(OutrasMoedas moeda) throws SQLException{ 
        String sql = "select * from moedas where \"Nome\" = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,moeda.getNome());//1 pq  é primeira interrogação
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void excluirCripto(OutrasMoedas moeda) throws SQLException{
        String sql = "delete from moedas where \"Nome\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, moeda.getNome());
        statement.execute();
        conn.close();
      }
      
    public ResultSet consultarLogin(Investidor investidor) throws SQLException{
        String sql = "select * from investidores where \"CPF\" = ? and \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha()); 
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    public ResultSet consultarParaAtualizarCriptomoedas() throws SQLException { 
        String sql = "select * from moedas"; 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
        
    public ResultSet consultarSaldo(Investidor investidor, String tipoMoeda) throws SQLException{ 
        String sql = "select \"Saldo\" from carteira where \"CPF\" = ? and \"NomeMoeda\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf());
        statement.setString(2,tipoMoeda);
        statement.execute();
        ResultSet resultado = statement.getResultSet();//result null saldo 0
        if (resultado.next()) {
       // Retorna o ResultSet se houver resultados
            return resultado;
        } else {
            // Retorna null se não houver resultados;
            return null;
        }
    }
        
    public ResultSet consultarMoedas() throws SQLException{ 
        String sql = "select \"Nome\" from moedas";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
         
    public ResultSet consultarTodaMoeda() throws SQLException{ //tem duas funções iguais
        String sql = "select * from moedas ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
  
        public void atualizarCriptomoedas(Moedas moeda) throws SQLException {
            String sql = "update moedas set \"Cotacao\" = ? where \"Nome\" = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(moeda.getCotacao()));
            statement.setString(2, moeda.getNome());
//            statement.setDouble());
            statement.execute();//pq n statement como no alunodao teo 10
            statement.close();
    }
        public void AtualizarReaisSaque(Investidor investidor) throws SQLException {
            String sql = "update carteira set \"Saldo\" = ? where "
                    + "\"CPF\" = ? and \"NomeMoeda\" = 'Real'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(investidor.getCarteira().getSaldo()));
            statement.setString(2, investidor.getCpf());
            statement.execute();
            statement.close();
    }
       
    public void inserirCarteira(Investidor investidor,double saldo, String tipoMoeda) throws SQLException{
        String sql = "insert into Carteira (\"CPF\", "
                + "\"NomeMoeda\", \"Saldo\") values('" +
                investidor.getCpf() + "', '" +
                tipoMoeda + "', '" +
                saldo + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();  
    }
        
    public ResultSet consultarCarteira(Investidor investidor) throws SQLException{ 
        String sql = "select * from \"carteira\" where \"CPF\" = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf());//1 pq  é primeira interrogação
        statement.execute();//excuta a query e gera reesultado do select(da consulta)
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void depositoReais(Investidor investidor) throws SQLException{
        String sql = "update carteira set \"Saldo\" = ? where \"NomeMoeda\" = 'Real' and \"CPF\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(investidor.getCarteira().getSaldo()));
        statement.setString(2, String.valueOf(investidor.getCpf())); //
        statement.execute();
        statement.close();
    }
  
        public ResultSet consultarReais(Investidor investidor) throws SQLException{ 
            String sql = "select \"Saldo\" from carteira where \"CPF\" = ? and \"NomeMoeda\" = 'Real'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,investidor.getCpf());
            statement.execute();
            ResultSet resultado = statement.getResultSet();
            return resultado;
    }
        
        public ResultSet consultarMoedaExp(String moeda) throws SQLException{ 
            String sql = "select * from moedas where \"Nome\" = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,moeda);
            statement.execute();
            ResultSet resultado = statement.getResultSet();
            return resultado;
    }
        public void AtualizarReaisCompra(Investidor investidor, double valor) throws SQLException {
            String sql = "update carteira set \"Saldo\" = ? where "
                    + "\"CPF\" = ? and \"NomeMoeda\" = 'Real'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(valor));
            statement.setString(2, investidor.getCpf());
            statement.execute();
            statement.close();
    }
        public void AtualizarMoedaCompra(Investidor investidor) throws SQLException {
            String sql = "update carteira set \"Saldo\" = ? where "
                    + "\"CPF\" = ? and \"NomeMoeda\" = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(investidor.getCarteira().getSaldo()));
            statement.setString(2, investidor.getCpf());
            statement.setString(3, investidor.getCarteira().getMoedas().getNome());
            statement.execute();
            statement.close();
    }
        
}
