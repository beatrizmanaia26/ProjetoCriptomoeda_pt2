/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarCripto;
import view.ConsultarSaldo;
import view.Extrato;
import view.VendaCriptomoedas;
import view.VerificacaoDeSenha;

/**
 *
 * @author luana Verifica se a senha digitada é igual a senha desse investidor e direcionamos a tela na qual a pessoa digitou
 * a senha para ser verificada ao respectivo gui 
 */
public class ControllerVerificaSenha {
    private VerificacaoDeSenha view;
    private Investidor investidor;

    public ControllerVerificaSenha(VerificacaoDeSenha view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void verificaSenha(int contador){
        String senha = view.getTxtSenha().getText();
        if(senha.equals(investidor.getSenha())){
            if(contador == 1){
                ConsultarSaldo c = new ConsultarSaldo(investidor);
                c.setVisible(true);
                view.setVisible(false);
            }else if(contador == 2){
                Extrato e = new Extrato(investidor);
                e.setVisible(true);
                view.setVisible(false);
            }else if(contador == 5){
                ComprarCripto c = new ComprarCripto(investidor);
                c.setVisible(true);
                view.setVisible(false);
            }else if(contador == 6){
                VendaCriptomoedas v = new VendaCriptomoedas(investidor);
                v.setVisible(true);
                view.setVisible(false);
            }
        }else{
            JOptionPane.showMessageDialog(view,"Senha incorreta!");
        }
    }
    
    
}
