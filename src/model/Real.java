/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Real extends Moedas implements Tarifacao {

    public Real() {
        setNome("Real");
        setCotacao(0);
    }

    @Override
    public double TaxaCompra() {
       
        return 0; 
    }

    @Override
    public double TaxaVenda() {
       
        return 0;
    }
    
}
