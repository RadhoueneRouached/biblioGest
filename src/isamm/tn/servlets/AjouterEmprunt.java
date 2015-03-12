package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;
import isamm.tn.services.EmpruntService;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjouterEmprunt
 */
@WebServlet("/AjouterEmprunt")
public class AjouterEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterEmprunt() {
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

			String vue = "/views/ajouterEmprunt.jsp";
			DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
			List<Document> d = documentServiceImpl.findAll();

			request.setAttribute("listeLivre", d);

			AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
			List<Adherent> a = adherentServiceImpl.findAll();

			request.setAttribute("listeAdherent", a);

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

		String vue = request.getContextPath() + "/AjouterEmprunt";
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		String depasse = request.getParameter("depasse");
		String idAdr = request.getParameter("idAdr");
		String idDoc = request.getParameter("idDoc");

		EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl();
		Emprunt emprunt = new Emprunt();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date db, df;
		try {
			db = simpleDateFormat.parse(dateDebut);
			df = simpleDateFormat.parse(dateFin);

		} catch (Exception e) {
			db = new Date(1, 1, 1);
			df = new Date(1, 1, 1);
		}
		Byte depasse1;
		int idDoc1, idAdr1;
		try {
			depasse1 = Byte.parseByte(depasse);
			idDoc1 = Integer.parseInt(idDoc);
			idAdr1 = Integer.parseInt(idAdr);
		} catch (Exception e) {
			depasse1 = 1;
			idDoc1 = 1;
			idAdr1 = 1;
		}
	
		DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
		Document document = new Document();
		document = documentServiceImpl.findDocument(idDoc1);

		AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
		Adherent adherent = new Adherent();
		adherent = adherentServiceImpl.findAdherent(idAdr1);
		emprunt.setDateDeb(db);
		emprunt.setDateFin(df);
		emprunt.setDepasse(depasse1);
		emprunt.setDocument(document);
		emprunt.setAdherent(adherent);
		EmpruntServiceImpl empruntServiceImpl2 = new EmpruntServiceImpl();
		HttpSession session = request.getSession();
		if (documentServiceImpl.numberExDoc(idDoc1) > 0) {
			try {
				empruntServiceImpl2.createEmprunt(emprunt);
				if (documentServiceImpl.minusDoc(idDoc1)) {
					session.setAttribute("message",
							"Emprunt crée avec succes !");

					response.sendRedirect(vue);
				}
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("message",
						"Emprunt  n/'est pas crée avec succes !");
				response.sendRedirect(vue);
			}
		} else {
			session.setAttribute("message", "nombre d'exemplaire insuffisant !");
			response.sendRedirect(vue);

		}
	}

}
