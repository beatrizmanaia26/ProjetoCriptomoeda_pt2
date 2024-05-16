/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;
/**
 *
 * @author beatr
 */
public class Bitcoin extends Moedas implements Tarifacao {

    public Bitcoin(double cotacao) {
        super(cotacao);
    }

    @Override
    public double TaxaCompra() {
        return 0.02;
    }

    @Override
    public double TaxaVenda() {
        return 0.03;
    }
}
