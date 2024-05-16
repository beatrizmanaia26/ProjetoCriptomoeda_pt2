/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Ethereum extends Moedas implements Tarifacao {

  

    public Ethereum(String nome, double cotacao, float taxaCompra, float taxaVenda) {
        super(nome, cotacao, taxaCompra, taxaVenda);
        
    }
    

    @Override
    public double TaxaCompra() {
        
        return 0.01;
        
    }

    @Override
    public double TaxaVenda() {
      
        return 0.02;    
    }
    
}
