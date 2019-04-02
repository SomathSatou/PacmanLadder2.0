package com.satou.webAvancee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.satou.webAvancee.dao.DAOFactory;
import com.satou.webAvancee.dao.GameDao;

/**
 * Servlet implementation class Liste
 */
@WebServlet( "/Score" )
public class Liste extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String LISTE_JSP        = "/WEB-INF/scoreBoard.jsp";
    private static final String ARRAY_SCORE      = "scores";

    public static final String  CONF_DAO_FACTORY = "daofactory";
    private GameDao             gameDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {

        this.gameDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getGameDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();

        session.setAttribute( ARRAY_SCORE, this.gameDao.toutTrouver() );

        this.getServletContext().getRequestDispatcher( LISTE_JSP ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}