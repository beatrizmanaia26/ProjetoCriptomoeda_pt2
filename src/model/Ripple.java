/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Ripple extends Moedas implements Tarifacao{

    @Override
    public double TaxaCompra() {
        return 0.01;
    }

    @Override
    public double TaxaVenda() {
        return 0.01;
    }
    
}
