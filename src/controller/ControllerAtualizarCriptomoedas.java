/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.BemVindoAdministrador;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.OutrasMoedas;
import java.sql.ResultSet;

/**
 *
 * @author beatr
 */
public class ControllerAtualizarCriptomoedas {
    private BemVindoAdministrador view;

    public ControllerAtualizarCriptomoedas(BemVindoAdministrador view) {
        this.view = view;
    }
    public void AtualizarCriptomoedas(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res= dao.ConsultarParaAtualizarCriptomoedas();
        }catch(Exception e){
           
        }
    }
   // public void SalvarBitcoin(){
   //     Conexao conexao = new Conexao();
    //    try {
     //       Connection conn = conexao.getConnection();
      //      BancoDAO dao = new BancoDAO(conn);
       //     ResultSet res= dao.ConsultarCotacaoBitcoin();
           // if (res.next()) { // Verifica se há pelo menos uma linha no ResultSet
          //      String cotacao = res.getString("Cotacao");
          //      try {
          //          double doubleCotacaoBitcoin = Double.parseDouble(cotacao);
          //          Bitcoin bit = new Bitcoin(doubleCotacaoBitcoin);
           //         bit.setCotacao(bit.atualizar());
           //         dao.AtualizarCotacaoBitcoin(bit);
          //      } catch (NumberFormatException e) {
                    // Tratar erro de conversão
          //          e.printStackTrace();
         //       }
        //    } else {
                // Tratar caso não haja resultados
        ///        System.out.println("Não há resultados na consulta.");
       //     }

      //      conn.close(); // Não esqueça de fechar a conexão
     ///   } catch (SQLException e) {
     //       JOptionPane.showMessageDialog(view,"Erro de conexao");
     //   }
   // }
}
