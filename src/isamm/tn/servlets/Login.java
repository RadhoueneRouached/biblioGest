package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.dao.AdministrateurDAO;
import isamm.tn.dao.EmpruntDAO;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.AdministrateurServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vue = "/login.jsp";
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
		HttpSession session = request.getSession();
		String admin = null;
		admin = request.getParameter("admin");
		System.out.print(admin);
		String login;
		login = request.getParameter("login");
		String pwd;
		pwd = request.getParameter("pwd");
		System.out.print("login : " + login + " pwd : " + pwd + " " + admin);
		if (admin != null) {

			AdministrateurServiceImpl administrateurServiceImpl = new AdministrateurServiceImpl();
			System.out.print("Administrateur : "
					+ administrateurServiceImpl.findByLogin(login, pwd));
			if (administrateurServiceImpl.findByLogin(login, pwd) != null) {
				Administrateur administrateur = administrateurServiceImpl
						.findByLogin(login, pwd);
				session.setAttribute("message", "");
				session.setAttribute("debut", 1);
				session.setAttribute("admin", administrateur.getId_admin());
				String vue = request.getContextPath() + "/Accueil";
				response.sendRedirect(vue);
			} else {
				String message = "invalide login ou mdp";
				session.setAttribute("message", message);
				String vue = request.getContextPath() + "/Login";
				response.sendRedirect(vue);
			}
		} else {

			AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
			System.out.print("Administrateur : "
					+ adherentServiceImpl.findByLogin(login, pwd));
			if (adherentServiceImpl.findByLogin(login, pwd) != null) {
				Adherent adherent = new Adherent();
				adherent = adherentServiceImpl.findByLogin(login, pwd);
				EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl();
				session.setAttribute("message", "");
				Date date = new Date();

				int passport = 0;
				if (empruntServiceImpl
						.miseAJourAdherentDepasseAdherent(adherent
								.getId_adherent())) {
					passport = 1;
					System.out.print("passport :: " + passport);
					if (adherent.getDateExp() == null) {
						passport += 1;
						System.out.print("passport :: " + passport);
					} else if (date.after(adherent.getDateExp())) {
						passport += 1;
						adherent.setActive(0);
						adherent.setAvertissement(0);
						adherentServiceImpl.update(adherent);

					} else {
						passport = 0;

						String message = "vous êtes banni";
						session.setAttribute("message", message);
						String vue = request.getContextPath() + "/Login";
						response.sendRedirect(vue);
					}
					System.out.print("passport :: " + passport);
					if (passport >= 2) {

						session.setAttribute("debut", 1);
						session.setAttribute("adherent",
								adherent.getId_adherent());
						String vue = request.getContextPath()
								+ "/ConsulterLivre";
						response.sendRedirect(vue);
					}
				} else {

					String message = "vous êtes banni";
					session.setAttribute("message", message);
					String vue = request.getContextPath() + "/Login";
					response.sendRedirect(vue);

				}
			} else {
				String message = "invalide login ou mdp";
				session.setAttribute("message", message);
				String vue = request.getContextPath() + "/Login";
				response.sendRedirect(vue);
			}
		}
	}

}
