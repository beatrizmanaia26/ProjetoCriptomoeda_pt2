package controller;

import view.Extrato;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;

/**
 *
 * @author beatr
 */
public class ControllerExtrato {
    public Extrato view;
    public Investidor investidores;

    public ControllerExtrato(Extrato view, Investidor investidores) {
        this.view = view;
        this.investidores = investidores;
    }

    public void buscaMoedas() { // cria carteira
        Conexao conexao = new Conexao();
        ArrayList<String> moedasExistentes = new ArrayList<>();
        try {
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
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }

        try {
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            for (String moeda : moedasExistentes) {
                try {
                    ResultSet res = dao.consultarSaldo(investidores, moeda);
                    if (res == null || !res.next()) {
                        try {
                            dao.inserirCarteira(investidores, 0, moeda);
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(view, "Erro de carteira");
                        }
                    }
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Erro ao consultar saldo");
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }
    }

    public void verificaExistenciaExtrato() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet res = dao.consultarExtrato(investidores);
            if (res == null || !res.next()) { // verifica se extrato é nulo
                view.getLblExtratoInvest1().setText("Extrato inexistente");

            }else {
                String texto = "<html>";
                String cot = null;
                String tax = null;
                 do{
                    String id_moeda = res.getString("ID_moeda"); 
                    String hora = res.getString("DataHora"); 
                    String tipoOper = res.getString("TipoOper"); 
                    String valorOper = res.getString("ValorOper"); 
                    String saldo = res.getString("SaldoAtual");

                    try{
                        ResultSet resulM = dao.consultarTodaMoeda();
                        while (resulM.next()) {
                            String nomeMoeda = resulM.getString("Nome");
                            if(nomeMoeda.equals(id_moeda)){
                                cot = resulM.getString("Cotacao");
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
                            + " <b>" + id_moeda + ":</b> " + saldo + "<br>";
            }while(res.next());
               view.getLblExtratoInvest1().setText(texto);  
            }    

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro de conexão ao consultar extrato");
        }
    }
}
