package isamm.tn.servlets;

import isamm.tn.beans.Document;
import isamm.tn.services.DocumentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechercherLivre
 */
@WebServlet("/RechercherLivre")
public class RechercherLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercherLivre() {
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
		if (session.getAttribute("adherent") != null) {

			String vue = "/views/RechercherLivre.jsp";

			String rechDoc = request.getParameter("rechDoc");

			DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
			Document document = new Document();
			document = documentServiceImpl.findByName(rechDoc);

			request.setAttribute("rechDoc", document);
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
	}

}
