package com.satou.webAvancee.model;

import java.sql.Date;

public class Partie {
	private int id;
	private String map;
	private String joueur;
	private String resultat;
	private int score;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getJoueur() {
		return joueur;
	}
	public void setJoueur(String joueur) {
		this.joueur = joueur;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Partie() {
		super();
	}
}
