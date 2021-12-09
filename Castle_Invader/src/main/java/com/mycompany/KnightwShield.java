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
public class KnightwShield {

    private int lifePoints = 6;
    private int attackPoints;
    private int defensePoints = 4;

    public KnightwShield() {
        this.attackPoints = (int) (Math.random() * 4 + 2);
    }

    public int getlifePoints() {
        return lifePoints;
    }

    public void setlifePoints(int lifePoints) {
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

    public void setdefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

}
