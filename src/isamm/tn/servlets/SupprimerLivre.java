package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupprimerLivre
 */
@WebServlet("/SupprimerLivre")
public class SupprimerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerLivre() {
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

		if (session.getAttribute("admin") != null) {

			String vue = "/views/accueil.jsp";

			String sup = request.getParameter("sup");
			DocumentServiceImpl impl = new DocumentServiceImpl();
			Document adr = new Document();
			int sup2;

			System.out.print("mod = " + sup);
			if (sup != null) {
				try {
					sup2 = Integer.parseInt(sup);
				} catch (Exception e) {
					sup2 = 0;
				}
				adr = impl.findDocument(sup2);

				if (impl.delete(adr)) {
					request.setAttribute("messageDoc",
							"Document supprimé avec succes ");
					this.getServletContext().getRequestDispatcher(vue)
							.forward(request, response);

				} else {
					request.setAttribute("messageDoc",
							"Document n/'est pas supprimé avec succes ");
					this.getServletContext().getRequestDispatcher(vue)
							.forward(request, response);

				}
			}

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
