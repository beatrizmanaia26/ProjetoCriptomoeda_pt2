/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author beatr aplicamos o diagrama de classe pedido no projeto, nele, todos os tipos de moeda herdam de Moedas
 */
public class Moedas {
    private String nome;
    private double cotacao;

    public Moedas(double cotacao) {
        this.cotacao = cotacao;
    }
    
    public Moedas() {
        
    }

    public Moedas(String nome, double cotacao, float taxaCompra, float taxaVenda) {
        this.nome = nome;
        this.cotacao = cotacao;
    }

    public Moedas(String nome, double cotacao) {
        this.nome = nome;
        this.cotacao = cotacao;
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

    public double atualizar(){
        Random random = new Random();
        double variacaoPercentual = (random.nextDouble() * 0.1) - 0.05; // -5% a +5%
        double novaCotacao = getCotacao() * (1 + variacaoPercentual);
        return novaCotacao;
    }

    @Override
    public String toString() {
        return "Moedas{" + "nome=" + nome + ", cotacao=" + cotacao + '}';
    }
    
    
}
