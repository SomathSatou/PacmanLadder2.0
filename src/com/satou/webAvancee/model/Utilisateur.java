package com.satou.webAvancee.model;

public class Utilisateur {
	private int id;
    private String pseudo;
    private String nom;
    private String prenom;
    private String mail;
    private String pwd;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
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
		if(nom != null)
			this.nom = nom;
		else
			this.nom = "";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		if(prenom != null)
			this.prenom = prenom;
		else
			this.nom = "";
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Utilisateur() {
        super();
    }

}