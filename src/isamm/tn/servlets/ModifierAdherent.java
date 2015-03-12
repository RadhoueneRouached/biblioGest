package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Adresse;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.AdministrateurServiceImpl;
import isamm.tn.services.AdresseServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifierAdherent
 */
@WebServlet("/ModifierAdherent")
public class ModifierAdherent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierAdherent() {
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
			String mod = request.getParameter("mod");
			AdherentServiceImpl impl = new AdherentServiceImpl();
			Adherent adr = new Adherent();
			int mod2;
			String vue = "/views/ModifierAdherent.jsp";
			System.out.print("mod = " + mod);
			if (mod != null) {
				try {
					mod2 = Integer.parseInt(mod);
				} catch (Exception e) {
					mod2 = 0;
				}
				adr = impl.findAdherent(mod2);
				request.setAttribute("adherentMod", adr);
				request.getSession().setAttribute("messageMod", "");

				this.getServletContext().getRequestDispatcher(vue)
						.forward(request, response);

			} else {
				this.getServletContext().getRequestDispatcher(vue)
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
		String idadr = request.getParameter("idAdherent");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("Password");
		String dateNaissance = request.getParameter("DateNaissance");
		String active = request.getParameter("active");
		String cin = request.getParameter("cin");
		String nrue = request.getParameter("nrue");
		String rue = request.getParameter("rue");
		String cite = request.getParameter("cite");
		String ville = request.getParameter("ville");

		AdministrateurServiceImpl serviceImpl = new AdministrateurServiceImpl();
		Administrateur ad = serviceImpl.findAdministrateur(1);
		Adherent adherent = new Adherent();
		AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
		int idadr2;
		try {
			idadr2 = Integer.parseInt(idadr);
		} catch (Exception e) {
			idadr2 = 0;
		}
		adherent = adherentServiceImpl.findAdherent(idadr2);
		System.out.println(" " + cin + " " + nom + "" + rue + " " + ville);
		System.out.println("ad :" + ad.getLogin());
		int nactive;
		try {
			nactive = Integer.parseInt(active);
		} catch (Exception e) {
			nactive = 0;
		}
		adherent.setActive(nactive);
		adherent.setNom(nom);
		adherent.setPrenom(prenom);
		adherent.setEmail(email);
		adherent.setPass(password);
		adherent.setDateNaissance(dateNaissance);
		int ncin;
		try {
			ncin = Integer.parseInt(cin);
		} catch (Exception e) {
			ncin = 0;
		}
		adherent.setCin(ncin);
		int n;
		try {
			n = Integer.parseInt(nrue);
		} catch (Exception e) {
			n = 0;
		}
		adherent.getAdresse().setNumRue(n);
		adherent.getAdresse().setRue(rue);
		adherent.getAdresse().setCite(cite);
		adherent.getAdresse().setVille(ville);
		adherent.setAdministrateur(ad);

		HttpSession session = request.getSession();
		String vue = request.getContextPath() + "/ModifierAdherent";
		if (adherentServiceImpl.update(adherent)) {
			session.setAttribute("messageMod", "Adherent modifié avec succes !");

			response.sendRedirect(vue);
		} else {

			session.setAttribute("messageMod",
					"Adherent n/'est pas modifié avec succes !");
			response.sendRedirect(vue);
		}

	}

}
