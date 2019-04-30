package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Messages")
public class Message {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    int idEmetteur;
    int idRecepteur;
    String contenu;

    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Message(int id, int idEmetteur, int idRecepteur, String contenu) {
        super();
        this.id = id;
        this.idEmetteur = idEmetteur;
        this.idRecepteur = idRecepteur;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmetteur() {
        return idEmetteur;
    }

    public void setIdEmetteur(int idEmetteur) {
        this.idEmetteur = idEmetteur;
    }

    public int getIdRecepteur() {
        return idRecepteur;
    }

    public void setIdRecepteur(int idRecepteur) {
        this.idRecepteur = idRecepteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    
    

}