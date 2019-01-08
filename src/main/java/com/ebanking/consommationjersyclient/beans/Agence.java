package com.ebanking.consommationjersyclient.beans;


public class Agence {


    private int id;

    private String nom;

    private String adresse;

    private int tel;

    private double solde_totale;

    public Agence(int id, String nom, String adresse, int tel, double solde_totale) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.solde_totale = solde_totale;
    }

    public Agence(int id) {
        this.id = id;
    }

    public Agence() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getSolde_totale() {
        return solde_totale;
    }

    public void setSolde_totale(double solde_totale) {
        this.solde_totale = solde_totale;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel=" + tel +
                ", solde_totale=" + solde_totale +
                '}';
    }
}
