package com.satou.webAvancee.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.satou.webAvancee.model.Utilisateur;
import com.satou.webAvancee.dao.DAOUtilitaire;;

public class UserDaoImpl implements UserDao {
	
	private DAOFactory daoFactory;
	
    UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    private static final String SQL_INSERT = "INSERT INTO User (pseudo, nom, prenom, mail, mot_de_passe) VALUES (?, ?, ?, ?, MD5(?))";
	@Override
	public void creer(Utilisateur utilisateur) throws DAOException {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getMail(), utilisateur.getPwd() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}

	private static final String SQL_SELECT_PAR_PSEUDO = "SELECT id, pseudo, nom, prenom, mail, mot_de_passe FROM User WHERE pseudo = ?";
	@Override
	public Utilisateur trouver(String pseudo) throws DAOException {
		
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Utilisateur utilisateur = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_PSEUDO, false, pseudo );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            utilisateur = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return utilisateur;
	}
	
	private static final String SQL_SELECT_PAR_MDP = "SELECT id, pseudo, nom, prenom, mail, mot_de_passe FROM User WHERE pseudo = ? AND mot_de_passe = ?";
	@Override
	public boolean verifier(String pseudo, String mdp) throws DAOException {
		
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_MDP, false, pseudo, mdp);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            return(true);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return (false);
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Utilisateur map( ResultSet resultSet ) throws SQLException {
	    Utilisateur utilisateur = new Utilisateur();
	    
	    utilisateur.setId( resultSet.getInt( "id" ) );
	    utilisateur.setMail( resultSet.getString( "mail" ) );
	    utilisateur.setPwd( resultSet.getString( "mot_de_passe" ) );
	    utilisateur.setNom( resultSet.getString( "nom" ) );
	    utilisateur.setPrenom( resultSet.getString( "prenom" ) );
	    utilisateur.setPseudo( resultSet.getString( "pseudo" ) );
	    return utilisateur;
	}

}
