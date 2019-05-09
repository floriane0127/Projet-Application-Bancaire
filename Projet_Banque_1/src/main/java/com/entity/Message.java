package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="msg")
public class Message {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_msg")
    private int id;
    private int idEmetteur;
    private int idRecepteur;
    private String date;
    private String contenu;
    
    @ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="MsgsUsers" , 
			joinColumns=@JoinColumn(name="id_msg" ,referencedColumnName="id_msg"),
		    inverseJoinColumns=@JoinColumn(name="id_ucpt" ,referencedColumnName="id_ucpt")
		
			)
	List<UtilisateursCompte> MsgsUsersss=new ArrayList<UtilisateursCompte>();


    public Message() {
        super();
    }
  
    
    public Message(int id, int idEmetteur, int idRecepteur, String date, String contenu, List<UtilisateursCompte> msgsUsersss) {
		super();
		this.id = id;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.date = date;
		this.contenu = contenu;
		MsgsUsersss = msgsUsersss;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public List<UtilisateursCompte> getMsgsUsersss() {
		return MsgsUsersss;
	}

	public void setMsgsUsersss(List<UtilisateursCompte> msgsUsersss) {
		MsgsUsersss = msgsUsersss;
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