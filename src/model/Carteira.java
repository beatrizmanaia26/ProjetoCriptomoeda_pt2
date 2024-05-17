/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
public class Carteira {
    private Moedas moedas;//composicao
    private double saldo;

    public Carteira(Moedas moedas, double saldo) {
        this.moedas = moedas;
        this.saldo = saldo;
        this.moedas = new Moedas();
    }

    public Carteira() {
    }
    

    public Moedas getMoedas() {
        return moedas;
    }

    public void setMoedas(Moedas moedas) {
        this.moedas = moedas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + ", saldo=" + saldo + '}';
    }
    
    
    
}
