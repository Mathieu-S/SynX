package com.synx.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_materiel")
public class Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idUser;
    private String type;
    private String nbSerie;

    public Materiel() {
    }

    public Materiel(String idUser, String type, String nbSerie) {
        this.idUser = Integer.parseInt(idUser);
        this.type = type;
        this.nbSerie = nbSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNbSerie() {
        return nbSerie;
    }

    public void setNbSerie(String nbSerie) {
        this.nbSerie = nbSerie;
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", type='" + type + '\'' +
                ", nbSerie='" + nbSerie + '\'' +
                '}';
    }
}
