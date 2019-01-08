package com.ebanking.consommationjersyclient.beans;


import java.io.Serializable;


public class Compte implements Serializable {

    private int id;

    private String type;

    private int solde;

    public Compte(int id, String type, int solde) {
        this.id = id;
        this.type = type;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", solde=" + solde +
                '}';
    }
}
