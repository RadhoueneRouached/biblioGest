package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.dao.E;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class statistque
 */
@WebServlet("/statistque")
public class Statistque extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Statistque() {
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

			String vue = "/views/statistique.jsp";

			EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl();
			Long x = empruntServiceImpl.nombreEmpruntTotal();
			List<Emprunt> e = empruntServiceImpl.EmpruntParDocument();
			List<Emprunt> ad = empruntServiceImpl.EmpruntParAdherent();
			DocumentServiceImpl impl = new DocumentServiceImpl();
			Long l = impl.nombreLivre();
			AdherentServiceImpl impl2 = new AdherentServiceImpl();
			Long nta = impl2.nombreTotalAdherent();
			request.setAttribute("nta", nta);
			request.setAttribute("e", e);
			request.setAttribute("l", l);
			request.setAttribute("nbET", x);
			request.setAttribute("ad", ad);
			Iterator i = e.iterator();

			while (i.hasNext()) {
				Emprunt e2 = (Emprunt) i.next();
				System.out.println("count :" + e2.getDocument().getTitre()
						+ " titre :" + e2.getDocument().getExemplaire());
			}

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
