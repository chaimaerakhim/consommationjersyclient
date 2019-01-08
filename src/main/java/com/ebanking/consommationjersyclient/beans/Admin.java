package com.ebanking.consommationjersyclient.beans;


public class Admin {


    private String cin;


    private String nom;

    private String prenom;

    private int login;

    private String password;

    private String email;

    private String addresse;

    private int tel;

    private int id_agence;


    public Admin(String cin, String nom, String prenom, int login, String password, String email, String addresse, int tel, int id_agence) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.addresse = addresse;
        this.tel = tel;
        this.id_agence = id_agence;
    }

    public Admin() {

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

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login=" + login +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", addresse='" + addresse + '\'' +
                ", tel=" + tel +
                ", id_agence=" + id_agence +
                '}';
    }
}
