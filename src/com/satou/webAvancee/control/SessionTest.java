package com.satou.webAvancee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.satou.webAvancee.dao.DAOFactory;
import com.satou.webAvancee.model.SessionBean;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet( "/session" )
public class SessionTest extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String SESSION_JSP      = "/WEB-INF/Session.jsp";
    private static final String PSEUDO_BAND      = "pseudoh";
    private static final String PWD_BAND         = "pwdh";
    private static final String LOG_SESSION      = "session";
    private static final String REDIRECT         = "redirect";
    
    public static final String CONF_DAO_FACTORY = "daofactory";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( SESSION_JSP ).forward( request, response );
    }

    protected void doAuth( HttpServletRequest request, HttpServletResponse response, String red )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println( red );
        this.getServletContext().getRequestDispatcher( red ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pseudo = request.getParameter( PSEUDO_BAND );
        String password = request.getParameter( PWD_BAND );

        HttpSession session = request.getSession();
        SessionBean sessionBean = new SessionBean( pseudo, password, ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao() );
        session.setAttribute( LOG_SESSION, sessionBean );

        doGet( request, response );
    }

}