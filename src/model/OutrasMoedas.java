/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class OutrasMoedas extends Moedas {
    private float TaxaCompra, TaxaVenda;

    public OutrasMoedas() {
    }

    public OutrasMoedas(String nome, double cotacao, float taxaCompra, float taxaVenda) {
        super(nome, cotacao, taxaCompra, taxaVenda);
        this.TaxaCompra = taxaCompra;
        this.TaxaVenda = taxaVenda;
    }

    public float getTaxaCompra() {
        return TaxaCompra;
    }

    public float getTaxaVenda() {
        return TaxaVenda;
    }

    public void setTaxaCompra(float TaxaCompra) {
        this.TaxaCompra = TaxaCompra;
    }

    public void setTaxaVenda(float TaxaVenda) {
        this.TaxaVenda = TaxaVenda;
    } 
}
