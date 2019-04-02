package com.satou.webAvancee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.satou.webAvancee.model.Partie;

public class GameDaoImpl implements GameDao {

    private DAOFactory daoFactory;

    public GameDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    private static final String SQL_SELECT = "SELECT id, map, joueur, resultat, score, datejeu FROM Game ORDER BY score DESC";

    @Override
    public ArrayList<Partie> toutTrouver() throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Partie> parties = new ArrayList<Partie>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT, false );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données des éventuel ResulSet retourné */
            while ( resultSet.next() ) {
                parties.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return parties;
    }

    private static final String SQL_SELECT_PSEUDO = "SELECT id, map, joueur, resultat, score, datejeu FROM Game WHERE joueur = ? ORDER BY score DESC";

    @Override
    public ArrayList<Partie> trouver( String pseudo ) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Partie> parties = new ArrayList<Partie>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PSEUDO, false,
                    pseudo );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données des éventuel ResulSet retourné */
            while ( resultSet.next() ) {
                parties.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return parties;
    }

    private static final String SQL_SELECT_RECENT = "SELECT id, map, joueur, resultat, score, datejeu ORDER BY datejeu DESC";

    @Override
    public ArrayList<Partie> trouverRecent() throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Partie> parties = new ArrayList<Partie>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_RECENT, false );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données des éventuel ResulSet retourné */
            while ( resultSet.next() ) {
                parties.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return parties;
    }

    private static final String SQL_SELECT_WEEK = "SELECT id, map, joueur, resultat, score, datejeu FROM Game WHERE WEEK(DATE(datejeu))=WEEK(CURDATE()) ORDER BY score DESC";

    @Override
    public ArrayList<Partie> trouverCetteSemaine() throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Partie> parties = new ArrayList<Partie>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_WEEK, false );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données des éventuel ResulSet retourné */
            while ( resultSet.next() ) {
                parties.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return parties;
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des jeux (un ResultSet) et un
     * bean Partie.
     */
    private static Partie map( ResultSet resultSet ) throws SQLException {
        Partie partie = new Partie();

        partie.setDate( resultSet.getDate( "datejeu" ) );
        partie.setId( resultSet.getInt( "id" ) );
        partie.setJoueur( resultSet.getString( "joueur" ) );
        partie.setMap( resultSet.getString( "map" ) );
        partie.setResultat( resultSet.getString( "resultat" ) );
        partie.setScore( resultSet.getInt( "score" ) );
        return partie;
    }
}
