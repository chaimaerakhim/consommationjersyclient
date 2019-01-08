package com.ebanking.consommationjersyclient.beans;


import java.io.Serializable;



public class Client implements Serializable {


    private String cin;

    private String nom;

    private String prenom;

    private int login;

    private String password;

    private String email;

    private String addresse;

    private int tel;

    private double solde;

    private int id_compte;


    public Client() {
    }

    public Client(String cin) {
        this.cin = cin;
    }

    public Client(String cin, String nom, String prenom, int login, String password, String email, String addresse, int tel, double solde,int id_compte) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.addresse = addresse;
        this.tel = tel;
        this.solde = solde;
        this.id_compte=id_compte;
    }

    public Client(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cin='" + cin + '\'' +
                '}';
    }
}
