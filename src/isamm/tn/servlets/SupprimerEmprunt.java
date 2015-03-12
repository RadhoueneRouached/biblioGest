package isamm.tn.servlets;

import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.DocumentServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupprimerEmprunt
 */
@WebServlet("/SupprimerEmprunt")
public class SupprimerEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerEmprunt() {
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

			String sup = request.getParameter("sup");
			EmpruntServiceImpl impl = new EmpruntServiceImpl();
			DocumentServiceImpl impl2 = new DocumentServiceImpl(); 
			
			Emprunt adr = new Emprunt();
			int sup2;

			System.out.print("sup = " + sup);
			if (sup != null) {
				try {
					sup2 = Integer.parseInt(sup);
				} catch (Exception e) {
					sup2 = 0;
				}
				adr = impl.findEmprunt(sup2);
				
				if (impl.delete(adr)) {
					if(impl2.plusDoc(adr.getDocument().getId_support())){ 
					session.setAttribute("messageSupEmp",
							"Emprunt supprimé avec succes ");
					}
					response.sendRedirect("GererEmprunt");
					
				} else {
					session.setAttribute("messageSupEmp",
							"Emprunt n/'est pas supprimé avec succes ");
					response.sendRedirect("GererEmprunt");
				}
			} else {
				String vue1 = "/views/SupprimerEmprunt.jsp";
				this.getServletContext().getRequestDispatcher(vue1)
						.forward(request, response);
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
