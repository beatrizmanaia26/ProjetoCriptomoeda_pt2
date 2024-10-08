/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr aplicamos o diagrama de classe pedido no projeto, nele, carteira é composicao de investidor, por isso,
 * em todos os botoes referentes ao usuario setamos uma nova carteira para ele, carteira essa atualizada com todas as moedas
 * que existem. Além disso, todo investidor herda de Pessoa.
 */
public class Investidor extends Pessoa {
    
    private Carteira carteira; //composicao
    

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.carteira = new Carteira(); 
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    

    @Override
    public String toString() {
       
        return "Investidor{" + "carteira=" + carteira + "Pessoa{" + "nome=" + 
                getNome() + ", cpf=" + getCpf() + ", senha=" + 
                getSenha() + "\nId: "  + '}';
    }
    
    
}
