package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("message", "");
		System.gc(); 
		
		if (session.getAttribute("admin") != null) {
			String vue = "/views/accueil.jsp";
			DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
			List<Document> a = documentServiceImpl.findAll();

			request.setAttribute("listeLivre", a);

			this.getServletContext().getRequestDispatcher(vue)
					.forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String vue = "/views/accueil.jsp";
		this.getServletContext().getRequestDispatcher(vue)
				.forward(request, response);

	}

}
