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
    private static int id;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        id++;
        
    }

    public static int getId() {
        return id;
    }
    
}
