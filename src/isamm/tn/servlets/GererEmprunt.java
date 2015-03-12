package isamm.tn.servlets;

import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.DocumentServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GererEmprunt
 */
@WebServlet("/GererEmprunt")
public class GererEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GererEmprunt() {
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
		if (session.getAttribute("admin") != null) {

			String vue = "/views/GererEmprunt.jsp";
			session.setAttribute("messageSupEmp", "");
			session.setAttribute("messageModEmp", "");
			EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl();
			List<Emprunt> e = empruntServiceImpl.findAll();

			request.setAttribute("listeEmprunt", e);

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
