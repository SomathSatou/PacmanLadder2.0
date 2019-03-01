package com.satou.webAvancee.dao;
import java.util.ArrayList;

import com.satou.webAvancee.model.Partie;

public interface GameDao {
	
	ArrayList<Partie> toutTrouver() throws DAOException;
	
	ArrayList<Partie> trouver(String pseudo) throws DAOException;

}
