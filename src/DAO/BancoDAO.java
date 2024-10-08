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
import model.OutrasMoedas;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author beatr Nessa classe criamos metodos de consulta, insercao, remoção e tualização para acessar as tabelas 
 * do banco de dados e seus conteúdos para, com eles, realizarmos mas operações que desejamos no projeto 
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
      
    public double consultarSaldoMoeda(Investidor investidor, String tipoMoeda) throws SQLException {
    String sql = "SELECT \"Saldo\" FROM carteira WHERE \"CPF\" = ? AND \"NomeMoeda\" = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, investidor.getCpf());
    statement.setString(2, tipoMoeda);
    statement.execute();
    ResultSet resultado = statement.getResultSet();

    double saldo = 0.0; // Valor padrão se não houver resultados
        if (resultado.next()) {
            saldo = resultado.getDouble("Saldo");
        }

    return saldo;
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
    
        public ResultSet consultarParaAtualizarCriptomoedas() throws SQLException { 
        String sql = "select * from moedas"; 
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
        statement.execute();
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
 
    public void atualizarSaldoCarteira(Investidor investidor, String tipoMoeda, double novoSaldo) throws SQLException {
        String sql = "update carteira set \"Saldo\" = ? where \"CPF\" = ? and \"NomeMoeda\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, novoSaldo);
        statement.setString(2, investidor.getCpf());
        statement.setString(3, tipoMoeda);
        statement.execute();
        statement.close();
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
        
    public ResultSet consultarExtrato(Investidor investidor) throws SQLException{ 
        String sql = "select * from extrato where \"ID_Investidor\" = ?";//pega tudo do extrato do investidor que desejo
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getCpf()); //informa que investidor desejo
        statement.execute();
        ResultSet resultado = statement.getResultSet();//result null saldo 0
        if (resultado.next()) {                
            return resultado;
        } else {
            // Retorna null se não houver resultados;
            return null;
       }
    }
        
    public void InserirExtrato(Investidor investidor, String moeda, String tipoOper, double valor, double saldoAtual, String saldoMoedas, double cot) throws SQLException {
        String sql = "INSERT INTO extrato (\"ID_Investidor\", \"ID_moeda\", \"DataHora\", \"TipoOper\", \"ValorOper\",  \"SaldoAtual\",  \"SaldoOutrasMoedas\", \"Cot_Atual\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, investidor.getCpf());
            statement.setString(2, moeda);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String formattedTimestamp = timestamp.toString().split("\\.")[0]; // Remove a parte dos milissegundos
            statement.setString(3, formattedTimestamp); // define a data e hora atuais
            statement.setString(4, tipoOper);
            statement.setDouble(5, valor);
            statement.setDouble(6, saldoAtual);
            statement.setString(7, saldoMoedas);
            statement.setDouble(8, cot);

            statement.executeUpdate(); 
        }
    }
    
    public void excluirExtrato(Investidor investidor) throws SQLException{
        String sql = "delete from extrato where \"ID_Investidor\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, investidor.getCpf());
        statement.execute();
    }
    
    public void excluirExtratoMoeda(OutrasMoedas moeda) throws SQLException{
        String sql = "delete from extrato where \"ID_moeda\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql); //passa string para a conexao
        statement.setString(1, moeda.getNome());
        statement.execute();    
    }
      
}
