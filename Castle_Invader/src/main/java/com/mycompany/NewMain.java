/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_maria;

import javax.swing.JOptionPane;

/**
 *
 *
 */
public class NewMain {

    public static void main(String[] args) {
        // TODO code application logic here
        int seleccion;
        int a = 0;
        String mjsError;

        try {
            do {
                a = Integer.parseInt(JOptionPane.showInputDialog(null, "1.New Game\n 2.Exit"));
                if (a == 1) {
                    Game juego = new Game();
                    juego.startGame();
                }
            } while (a != 2);
        } catch (Exception e) {
            // System.out.println(e);
            if (e.toString().contains("java.lang.NumberFormatException: null")) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
            } else {
                Game juego = new Game();
                juego.startGame();
            }
        }
    }

}
