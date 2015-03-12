package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.net.www.content.text.plain;

/**
 * Servlet implementation class GererAdherent
 */
@WebServlet("/GererAdherent")
public class GererAdherent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GererAdherent() {
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

			AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
			List<Adherent> a = adherentServiceImpl.findAll();

			request.setAttribute("liste", a);
			String vue = "/views/GererAdherent.jsp";
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
		String vue ="/views/GererAdherent.jsp";
		//String db = request.getParameter("db");
		String df = request.getParameter("df");
		HttpSession session = request.getSession();
		if ( (!df.isEmpty())) {
			EmpruntServiceImpl impl = new EmpruntServiceImpl();
			List<Emprunt> l = new ArrayList<Emprunt>();

			String[] splitter = df.split("/");
			String m = splitter[0];
			String d = splitter[1];
			String y = splitter[2];
			String dd = y + "-" + m + "-" + d;
			l = impl.empruntDepasseParMois(dd);

			if (l != null) {
				Iterator i = l.iterator();
						System.out.print("Size :::: : "+l.size()); 
				while (i.hasNext()) {
					Emprunt emprunt = new Emprunt();
					emprunt = (Emprunt) i.next();
					System.out.print("Je suis ici !!"+emprunt.getId_emp());
					// System.out.println("Mise a JOUR EMPRUNT Active:  "+emprunt.getAdherent().getActive()+" Avert :"+emprunt.getAdherent().getAvertissement());
					System.out.print("Mise a JOUR EMPRUNT Depasse:  "
							+ emprunt.getDepasse());
					
					session.setAttribute("messageMAJ",
							"Mise a jour avec succes");
					 
				}
			} else {
				session.setAttribute("messageMAJ", "Rien a mettre a jour");
				}

		} else {
			 
			this.getServletContext().getRequestDispatcher(vue)
			.forward(request, response);

		}
		this.getServletContext().getRequestDispatcher(vue)
		.forward(request, response);
	
	}

}
