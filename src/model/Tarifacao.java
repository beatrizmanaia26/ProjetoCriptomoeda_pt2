/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author beatr aplicamos o diagrama de classe pedido no projeto, nele, tarifacao é uma interface e todas as moedas a 
 * implementam
 */
public interface Tarifacao {
    public double TaxaCompra();
    public double TaxaVenda();
}
