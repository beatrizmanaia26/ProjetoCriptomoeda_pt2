/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Investidor extends Pessoa{
    Carteira carteira = new Carteira();
    

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        
        
    }

    

    @Override
    public String toString() {
       
        return "Investidor{" + "carteira=" + carteira + "Pessoa{" + "nome=" + 
                getNome() + ", cpf=" + getCpf() + ", senha=" + 
                getSenha() + "\nId: "  + '}';
    }
    
    
}
