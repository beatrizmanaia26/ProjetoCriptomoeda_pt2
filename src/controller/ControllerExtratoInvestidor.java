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
import javax.swing.JOptionPane;
import model.Investidor;
import view.ExtratoInvestidor;
import view.InfosExtratoInvestidor;


/**
 *
 * @author beatr
 */
public class ControllerExtratoInvestidor {
    private ExtratoInvestidor view;
    private Investidor investidor;

    public ControllerExtratoInvestidor(ExtratoInvestidor view) {
        this.view = view;
    }
    
    public void buscaUsuario(){
        String cpfD = view.getTxtCPF().getText();
        Investidor invest = new Investidor(null,cpfD,
        null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarInvestidor(invest);
            if(res.next()){
                String nome = res.getString("Nome");
                String cpf = res.getString("CPF");
                String senha = res.getString("Senha");
                investidor = new Investidor(nome,cpf,senha);              
            }else{
                JOptionPane.showMessageDialog(view,"Cpf não encontrado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexao");
        }
    }
    
    public void verificaExistenciaExtrato() { 
        Conexao conexao = new Conexao();
        InfosExtratoInvestidor i = new InfosExtratoInvestidor();
        i.getLblCpf().setText(investidor.getCpf());
        i.getLblNome().setText(investidor.getNome());
        try {
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarExtrato(investidor);
            if (res == null) {
                i.getLblExtratoInvest().setText("Extrato inexistente");
            }else {
                String texto = "<html>";
                String tax = null;
                 do{
                    String id_moeda = res.getString("ID_moeda"); 
                    String hora = res.getString("DataHora"); 
                    String tipoOper = res.getString("TipoOper"); 
                    String valorOper = res.getString("ValorOper"); 
                    String saldo = res.getString("SaldoAtual");
                    String outrasMoedas = res.getString("SaldoOutrasMoedas");
                    String cot = res.getString("Cot_Atual");

                    try{
                        ResultSet resulM = dao.consultarTodaMoeda();
                        while (resulM.next()) {
                            String nomeMoeda = resulM.getString("Nome");
                            if(nomeMoeda.equals(id_moeda)){
                                if(tipoOper.equals("+")){
                                   tax = resulM.getString("Taxa_compra");
                                }else{
                                   tax = resulM.getString("Taxa_venda");
                                }
                            }
                        }
                        
                    }catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Erro de conexão extrato busca moeda");
                    }
                
                    texto = texto + hora + " " + tipoOper + " " + valorOper 
                            + " " + id_moeda + "<b> CT: </b>" + cot + "<b> TX: </b>" + tax 
                            + " <b>" + id_moeda + ":</b> " + saldo + ", " + outrasMoedas + "<br>";
            }while(res.next());
               i.getLblExtratoInvest().setText(texto);  
            }    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro de conexão ao consultar extrato");
        }
        i.setVisible(true);
        view.setVisible(false);
    }
    
}
