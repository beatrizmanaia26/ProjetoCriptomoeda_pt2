/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Moedas {
    private String nome;
    private double cotacao;
    private float taxaCompra, taxaVenda;
    
    public Moedas() {
    }

    public Moedas(String nome, double cotacao, float taxaCompra, float taxaVenda) {
        this.nome = nome;
        this.cotacao = cotacao;
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public float getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(float taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public float getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(float taxaVenda) {
        this.taxaVenda = taxaVenda;
    }
}
