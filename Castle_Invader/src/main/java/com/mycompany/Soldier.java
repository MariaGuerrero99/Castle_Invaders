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
public class Soldier {

    private int lifePoints;
    private int attackPoints;
    private int defensePoints;
    private String type;

    public Soldier() {
    }

    public Soldier(int lifePoints, int attackPoints, int defensePoints, String Tipo) {
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.type = type;
    }

    public String gettype() {
        return type;
    }

    public void setTipo(String type) {
        this.type = type;
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
