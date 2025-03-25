package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.enums;


public enum Langue {
    fr("fr"),
    Anglais("Anglais"),
    Allemand("Allemand"),
    Espagnol("Espagnol"),
    Russe("Russe");

    int cpt = 0;
    private String nom;
    private int id;

    Langue(String nom) {
        this.nom = nom;
        this.id = cpt++;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}