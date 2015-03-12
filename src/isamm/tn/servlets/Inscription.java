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
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
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

		String vue = "/inscription.jsp";
		this.getServletContext().getRequestDispatcher(vue)
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("Password");
		String dateNaissance = request.getParameter("DateNaissance");
		String cin = request.getParameter("cin");
		String nrue = request.getParameter("nrue");
		String rue = request.getParameter("rue");
		String cite = request.getParameter("cite");
		String ville = request.getParameter("ville");

		AdministrateurServiceImpl serviceImpl = new AdministrateurServiceImpl();
		Administrateur ad = serviceImpl.findAdministrateur(1);
		Adherent adherent = new Adherent();
		Adresse adresse = new Adresse();

		System.out.println(" " + cin + " " + nom + "" + rue + " " + ville);
		System.out.println("ad :" + ad.getLogin());

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
		adresse.setNumRue(n);
		adresse.setRue(rue);
		adresse.setCite(cite);
		adresse.setVille(ville);
		adherent.setAdministrateur(ad);
		adresse.setAdherent(adherent);
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		try {
			adresseServiceImpl.createAdresse(adresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		adherent.setAdresse(adresse);
		AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
		HttpSession session = request.getSession();
		String vue = request.getContextPath() + "/Login";
		try {
			adherentServiceImpl.createAdherent(adherent);

			session.setAttribute("message", "Adherent crée avec succes !");

			response.sendRedirect(vue);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message",
					"Adherent n/'est pas crée avec succes !");
			response.sendRedirect(vue);
		}

	}

}
