package com.ebanking.consommationjersyclient.beans;


import java.util.Date;


public class Operation {

    private int id;

    private int source;

    private int destination;

    private double	montant;

    private Date date;

    public Operation(int id, int source, int destination, double montant, Date date) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.montant = montant;
        this.date = date;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", montant=" + montant +
                ", date=" + date +
                '}';
    }
}
