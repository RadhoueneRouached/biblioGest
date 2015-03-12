package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.services.AdherentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupprimerAdherent
 */
@WebServlet("/SupprimerAdherent")
public class SupprimerAdherent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerAdherent() {
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

			String vue = "/views/SupprimerAdherent.jsp";

			String sup = request.getParameter("sup");
			AdherentServiceImpl impl = new AdherentServiceImpl();
			Adherent adr = new Adherent();
			int sup2;

			System.out.print("mod = " + sup);
			if (sup != null) {
				try {
					sup2 = Integer.parseInt(sup);
				} catch (Exception e) {
					sup2 = 0;
				}
				adr = impl.findAdherent(sup2);

				if (impl.delete(adr)) {
					request.setAttribute("suppressionAdr",
							"Adherent supprimé avec succes ");
					this.getServletContext().getRequestDispatcher(vue)
							.forward(request, response);

				} else {

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
