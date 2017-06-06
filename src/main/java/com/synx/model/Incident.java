package com.synx.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="t_incidents")
public class Incident implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idMateriel;
    private String titre;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    private String status;

    public Incident() {
    }

    public Incident(int idMateriel, String titre, String description, Date dateDebut, Date dateFin, String status) {
        this.idMateriel = idMateriel;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
    }

    public Incident(String idMateriel, String titre, String description, Date dateDebut, String status) {
        this.idMateriel = Integer.parseInt(idMateriel);
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", idMateriel=" + idMateriel +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", status='" + status + '\'' +
                '}';
    }
}
