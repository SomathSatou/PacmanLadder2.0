package com.satou.webAvancee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satou.webAvancee.dao.UserDao;
import com.satou.webAvancee.dao.DAOFactory;
import com.satou.webAvancee.model.InscriptionBean;
import com.satou.webAvancee.model.Utilisateur;

/**
 * Servlet implementation class TEST
 */
@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String TEST_JSP         = "/WEB-INF/inscription.jsp";
    public static final String  CHAMP_PSEUDO     = "pseudo";
    public static final String  CHAMP_EMAIL      = "email";
    public static final String  CHAMP_PASS       = "pwd";
    public static final String  CHAMP_CONF       = "pwd2";
    public static final String  CHAMP_PRENOM     = "prenom";
    public static final String  CHAMP_NOM        = "nom";
    public static final String  ATT_FORM         = "form";
    public InscriptionBean      form;

    public static final String CONF_DAO_FACTORY = "daofactory";
    private UserDao userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();

        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( TEST_JSP ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        /* Récupération des champs du formulaire. */
        String pseudo = request.getParameter( CHAMP_PSEUDO );

        String email = request.getParameter( CHAMP_EMAIL );

        String motDePasse = request.getParameter( CHAMP_PASS );

        String confirmation = request.getParameter( CHAMP_CONF );

        String nom = request.getParameter( CHAMP_NOM );

        String prenom = request.getParameter( CHAMP_PRENOM );

        form = new InscriptionBean( pseudo, email, motDePasse, confirmation, prenom, nom );

        request.setAttribute( ATT_FORM, form );
        if ( form.isResultats() ) {
            doLog( request, response );
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setMail(email);
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setPseudo(pseudo);
            utilisateur.setPwd(motDePasse);
            userDao.creer(utilisateur);
        } else {
            doGet( request, response );
        }

    }

    protected void doLog( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( "/"
                + "WEB-INF/SignIn.jsp" ).forward( request, response );
    }

}