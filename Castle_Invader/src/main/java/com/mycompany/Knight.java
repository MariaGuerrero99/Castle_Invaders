/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_maria;

/**
 *
 *
 */
public class Knight {

    private int lifePoints = 6;
    private int attackPoints;
    private int defensePoints = 1;

    public Knight() {
        this.attackPoints = (int) (Math.random() * 5 + 3);
    }

    public int getlifePoints() {
        return lifePoints;
    }

    public void setPuntosvida(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getattackPoints() {
        return attackPoints;
    }

    public void setattackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getdefensePoints() {
        return defensePoints;
    }

    public void getdefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }
}
