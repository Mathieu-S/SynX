package com.synx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="t_materiel")
public class Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idUser;
    private String type;

    public Materiel() {
    }

    public Materiel(int idUser, String type) {
        this.idUser = idUser;
        this.type = type;
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

    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", type='" + type + '\'' +
                '}';
    }
}
