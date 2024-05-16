/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.BemVindoAdministrador;
import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.OutrasMoedas;

/**
 *
 * @author beatr
 */
public class ControllerAtualizarCriptomoedas {
    private BemVindoAdministrador view;

    public ControllerAtualizarCriptomoedas(BemVindoAdministrador view) {
        this.view = view;
    }
}