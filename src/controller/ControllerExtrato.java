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
            } else { // se tiver coisa no extrato
                StringBuilder texto = new StringBuilder("<html>");
                do {
                    String tempo = res.getString("DataHora");
                    String tipoOperacao = res.getString("TipoOper");
                    String moeda = res.getString("ID_moeda");
                    String valorOper = res.getString("ValorOper");
                    String saldoAtual = res.getString("SaldoAtual");

                    // consultar a cotação da moeda especifica
                    String cotacao = "";
                    try {
                        ResultSet resCotacao = dao.consultarCotacao(moeda);
                        if (resCotacao.next()) {
                            cotacao = resCotacao.getString("Cotacao");
                        }
                        resCotacao.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Erro ao consultar cotação");
                    }

                    // consulta taxa de compra/venda da moeda especifica
                    String taxa = "";
                    try {
                        if (tipoOperacao.equals("+") && !"Real".equals(moeda)) {
                            ResultSet resTaxaCompra = dao.consultarTaxaCompra(moeda);
                            if (resTaxaCompra.next()) {
                                taxa = resTaxaCompra.getString("Taxa_compra");
                            }
                            resTaxaCompra.close();
                        } else if (tipoOperacao.equals("-") && !"Real".equals(moeda)) {
                            ResultSet resTaxaVenda = dao.consultarTaxaVenda(moeda);
                            if (resTaxaVenda.next()) {
                                taxa = resTaxaVenda.getString("Taxa_Venda");
                            }
                            resTaxaVenda.close();
                        } else {
                            taxa = "0.00";
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Erro ao consultar taxa");
                    }

                    // coloca informações no extrato
                    texto.append(tempo).append("   ").append(tipoOperacao).append("   ")
                            .append(valorOper).append("   ").append(moeda).append("   ").append("<b>")
                            .append("CT: ").append("</b>").append(cotacao).append("   ").append("<b>")
                            .append("TX: ").append("</b>").append(taxa).append(" ").append("Saldo: ")
                            .append(saldoAtual).append("<br>");
                    
                } while (res.next());
                texto.append("</html>");
                view.getLblExtratoInvest1().setText(texto.toString());
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro de conexão ao consultar extrato");
        }
    }
}
