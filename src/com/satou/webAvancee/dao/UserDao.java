package com.satou.webAvancee.dao;

import com.satou.webAvancee.model.Utilisateur;

public interface UserDao {
	
    void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String Pseudo ) throws DAOException;
    
    boolean verifier (String pseudo, String mdp ) throws DAOException;

}