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
class Game {

    private static Soldier soldier[] = new Soldier[6];
    private static Soldier enemy[] = new Soldier[4];
    private String winner;
    private String defeated;

    public Game() {
    }

    private void chooseSoldiers() {
        int soldiersAmount = 6;
        int selection = 1;
        int amountSelected;
        String text = "";
        int j = 0;
        try {
            do {

                selection = Integer.parseInt(JOptionPane.showInputDialog("Choose a Soldier: \n1. Archer \n2. Knight \n3. Knight with Shield"));
                switch (selection) {
                    case 1:
                        amountSelected = Integer.parseInt(JOptionPane.showInputDialog("Input the amount of Archers you want"));
                        if (amountSelected > soldiersAmount) {
                            JOptionPane.showMessageDialog(null, "You chosed more Archers than expected!");
                        } else {
                            soldiersAmount = soldiersAmount - amountSelected;
                            Archer archer[] = new Archer[amountSelected];
                            for (int i = 0; i < amountSelected; i++) {
                                archer[i] = new Archer();
                                if (j == 0) {
                                    j = i;

                                } else {
                                    j = j + 1;
                                }
                                soldier[j] = new Soldier();
                                soldier[j].setattackPoints(archer[i].getattackPoints());
                                soldier[j].setdefensePoints(archer[i].getdefensePoints());
                                soldier[j].setlifePoints(archer[i].getlifePoints());
                                soldier[j].setTipo("Archer");

                                text = text + j + "A" + archer[i].getattackPoints() + "," + archer[i].getdefensePoints() + "," + archer[i].getlifePoints() + "\n";
                            }
                        }
                        break;
                    case 2:
                        amountSelected = Integer.parseInt(JOptionPane.showInputDialog("Input the amount of Knights you want"));
                        if (amountSelected > soldiersAmount) {
                            JOptionPane.showMessageDialog(null, "You chosed more Knights than expected!");
                        } else {
                            soldiersAmount = soldiersAmount - amountSelected;
                            Knight knight[] = new Knight[amountSelected];
                            for (int i = 0; i < amountSelected; i++) {
                                knight[i] = new Knight();
                                if (j == 0) {
                                    j = i;

                                } else {
                                    j = j + 1;
                                }
                                soldier[j] = new Soldier();
                                soldier[j].setattackPoints(knight[i].getattackPoints());
                                soldier[j].setdefensePoints(knight[i].getdefensePoints());
                                soldier[j].setlifePoints(knight[i].getlifePoints());
                                soldier[j].setTipo("Knight");

                                text = text + "C" + knight[i].getattackPoints() + "," + knight[i].getdefensePoints() + "," + knight[i].getlifePoints() + "\n";
                            }
                        }
                        break;
                    case 3:
                        amountSelected = Integer.parseInt(JOptionPane.showInputDialog("Input the amount of Knights with Shield you want"));
                        if (amountSelected > soldiersAmount) {
                            JOptionPane.showMessageDialog(null, "You chosed more Knights with Shield than expected!");
                        } else {
                            soldiersAmount = soldiersAmount - amountSelected;
                            KnightwShield knightwShield[] = new KnightwShield[amountSelected];
                            for (int i = 0; i < amountSelected; i++) {
                                knightwShield[i] = new KnightwShield();
                                if (j == 0) {
                                    j = i;

                                } else {
                                    j = j + 1;
                                }
                                soldier[j] = new Soldier();
                                soldier[j].setattackPoints(knightwShield[i].getattackPoints());
                                soldier[j].setdefensePoints(knightwShield[i].getdefensePoints());
                                soldier[j].setlifePoints(knightwShield[i].getlifePoints());
                                soldier[j].setTipo("Knight with Shield");
                                text = text + j + "CE" + knightwShield[i].getattackPoints() + "," + knightwShield[i].getdefensePoints() + "," + knightwShield[i].getlifePoints() + "\n";
                            }
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "That is not a valid option!");

                }

            } while (soldiersAmount
                    > 0);
            System.out.println(
                    "" + text);
        } catch (Exception e) {
            // System.out.println(e);
            if (e.toString().contains("java.lang.NumberFormatException: null")) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Digit a valid option, the game will restart!");
                Game Game = new Game();
                Game.startGame();
            }
        }
    }

    public void startGame() {
        try {
            chooseSoldiers();
            int soldiersAmount = 6;
            Door door = new Door();
            Crossbow crossbow1 = new Crossbow();
            Crossbow crossbow2 = new Crossbow();
            Crossbow crossbow3 = new Crossbow();
            enemy[0] = new Soldier(10, 0, 2, "Door");
            enemy[1] = new Soldier(8, 2, 0, "Crossbow 1");
            enemy[2] = new Soldier(8, 2, 0, "Crossbow 2");
            enemy[3] = new Soldier(8, 2, 0, "Crossbow 3");
            int turno = 1;
            do {
                String header = "";
                String header2 = "";
                if (soldiersAmount <= 0) {
                    turno = 4;
                }

                for (int i = 0; i < 6; i++) {
                    System.out.println("" + soldier[i].getattackPoints());
                    if (soldier[i].getlifePoints() > 0) {
                        header = header + i + ") " + soldier[i].gettype() + " Life Points: " + soldier[i].getlifePoints() + " "
                                + "Attack Points: " + soldier[i].getattackPoints() + " Defense Points: " + soldier[i].getdefensePoints() + "\n";
                    } else {
                        soldiersAmount = soldiersAmount--;
                    }
                }
                if (door.getlifePoints() <= 0) {
                    turno = 4;
                } else {
                    header2 = "0) Door life Points: " + enemy[0].getlifePoints() + " Defense Points: " + enemy[0].getdefensePoints() + "\n";
                }
                if (crossbow1.getlifePoints() <= 0) {
                    JOptionPane.showMessageDialog(null, "Crossbow 1 is defeated");
                } else {
                    header2 = header2 + "1) Crossbow 1 life Points: " + enemy[1].getlifePoints() + " Defense Points: " + enemy[1].getattackPoints() + "\n";
                }
                if (crossbow2.getlifePoints() <= 0) {
                    JOptionPane.showMessageDialog(null, "Crossbow 2 is defeated");
                } else {
                    header2 = header2 + "2) Crossbow 2 life Points: " + enemy[2].getlifePoints() + " Attack Points: " + enemy[2].getattackPoints() + "\n";
                }
                if (crossbow3.getlifePoints() <= 0) {
                    JOptionPane.showMessageDialog(null, "Crossbow 3 is defeated");
                } else {
                    header2 = header2 + "3) Crossbow 3 life Points: " + enemy[3].getlifePoints() + " Attack Points: " + enemy[3].getattackPoints();
                }
                int selection;
                int randomSelection;
                switch (turno) {
                    case 1:
                        selection = Integer.parseInt(JOptionPane.showInputDialog(header + " Choose a soldier to attack"));
                        randomSelection = Integer.parseInt(JOptionPane.showInputDialog(header2 + "\n Choose the enmy you want to attack"));
                        if (soldier[selection].getattackPoints() > enemy[randomSelection].getdefensePoints()) {
                            enemy[randomSelection].setlifePoints(enemy[randomSelection].getlifePoints() - (-enemy[randomSelection].getdefensePoints() + soldier[selection].getattackPoints()));
                        }
                        turno = 2;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, header2);
                        if (enemy[1].getlifePoints() > 0) {
                            int enemyAttack = Integer.parseInt(header.charAt(0) + "");
                            if (enemy[1].getattackPoints() > soldier[enemyAttack].getdefensePoints()) {
                                soldier[enemyAttack].setlifePoints(soldier[enemyAttack].getlifePoints() - (-soldier[enemyAttack].getdefensePoints() + soldier[enemyAttack].getattackPoints()));
                            }
                        } else if (enemy[2].getlifePoints() > 0) {
                            int enemyAttack = header.charAt(0);
                            if (enemy[2].getattackPoints() > soldier[enemyAttack].getdefensePoints()) {
                                soldier[enemyAttack].setlifePoints(soldier[enemyAttack].getlifePoints() - (-soldier[enemyAttack].getdefensePoints() + soldier[enemyAttack].getattackPoints()));
                            }
                        } else if (enemy[3].getlifePoints() > 0) {
                            int enemyAttack = header.charAt(0);
                            if (soldier[3].getattackPoints() > soldier[enemyAttack].getdefensePoints()) {
                                soldier[enemyAttack].setlifePoints(soldier[enemyAttack].getlifePoints() - (-soldier[enemyAttack].getdefensePoints() + soldier[enemyAttack].getattackPoints()));
                            }
                        }
                        turno = 3;
                        break;
                    case 3:
                        if (enemy[0].getlifePoints() <= 0) {
                            winner = "Player 1 is the winner";
                            turno = 4;
                        } else if (soldier[0].getlifePoints() == 0
                                && soldier[1].getlifePoints() == 0
                                && soldier[2].getlifePoints() == 0
                                && soldier[3].getlifePoints() == 0
                                && soldier[4].getlifePoints() == 0
                                && soldier[5].getlifePoints() == 0) {
                            winner = "Player 2 is the winner";
                            turno = 4;
                        } else {
                            turno = 1;
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, winner);
                        turno = 5;
                        break;
                    case 5:
                        break;
                    default:
                }
            } while (turno != 5);
        } catch (Exception e) {

            if (e.toString().contains("java.lang.NumberFormatException: null")) {
                JOptionPane.showMessageDialog(null, "Thanks for Playing!");
                System.exit(0);
                //} else if (enemigo[1].getPuntosvida() >= 0) {
                //  derrota = "Enemigo1 ha sido derrotado";
                //} else if (enemigo[2].getPuntosvida() >= 0) {
                //  derrota = "Enemigo1 ha sido derrotado";
                //} else if (enemigo[3].getPuntosvida() >= 0) {
                //  derrota = "Enemigo1 ha sido derrotado";
            } else {
                JOptionPane.showMessageDialog(null, "Choose a valid option, the game will restart!" + e);
                Game game = new Game();
                game.startGame();
            }

        }
    }
}
