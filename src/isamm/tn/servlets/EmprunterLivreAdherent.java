package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;
import isamm.tn.services.EmpruntServiceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmprunterLivreAdherent
 */
@WebServlet("/EmprunterLivreAdherent")
public class EmprunterLivreAdherent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmprunterLivreAdherent() {
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

		String vue = "/views/ConsulterLivre.jsp";

		EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl();
		Emprunt emprunt = new Emprunt();
		String idDoc = request.getParameter("mod");
		if (idDoc != null) {
			int idDoc1;
			try {
				idDoc1 = Integer.parseInt(idDoc);

			} catch (Exception e) {
				idDoc1 = 1;
			}

			// emprunt = empruntServiceImpl.findEmprunt(idDoc1);

			DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
			Document document = new Document();
			document = documentServiceImpl.findDocument(idDoc1);

			HttpSession session = request.getSession();
			String idAdr = session.getAttribute("adherent").toString();
			int id;
			try {
				id = Integer.parseInt(idAdr);
			} catch (Exception e) {
				id = 0;
			}

			AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();
			Adherent adherent = new Adherent();
			adherent = adherentServiceImpl.findAdherent(id);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar db = Calendar.getInstance();
			Calendar df = Calendar.getInstance();
			df.add(Calendar.DAY_OF_MONTH, 3);
			System.out.print("date calendar :" + db.getTime());
			emprunt.setDateDeb(db.getTime());
			emprunt.setDateFin(df.getTime());
			Byte x = 0;
			emprunt.setDepasse(x);
			emprunt.setDocument(document);
			emprunt.setAdherent(adherent);
			EmpruntServiceImpl empruntServiceImpl2 = new EmpruntServiceImpl();
			if(empruntServiceImpl.EmpruntDouble(id)== 0) {
				System.out.println("************EMPRUNT DOUBLE *******************"+empruntServiceImpl.EmpruntDouble(id) +" ID "+id); 
				if (documentServiceImpl.numberExDoc(idDoc1) > 0) {
					try {
						empruntServiceImpl2.createEmprunt(emprunt);
						if (documentServiceImpl.minusDoc(idDoc1)) {

							session.setAttribute("messageEmp",
									"Emprunt crée avec succes !");
							response.sendRedirect("ConsulterLivre");
						}
					} catch (Exception e) {
						e.printStackTrace();
						session.setAttribute("messageEmp",
								"Emprunt  n/'est pas crée avec succes !");
						response.sendRedirect("ConsulterLivre");
					}

				} else {
					
					
					session.setAttribute("messageEmp",
							"nombre d'exemplaire insuffisant !");
					this.getServletContext().getRequestDispatcher(vue)
							.forward(request, response);

				}
			} else {
				//System.out.print("EMPRUNT "+empruntServiceImpl.EmpruntDouble(id).getId_emp()); 
				 
				try {
					System.out.println("///////////////////////////////////////////////////////////////"); 
					Long  emp =empruntServiceImpl.EmpruntDouble(id); 
					System.out.print("///////////////////////SIZE ////////////////////////////////////"+emp+"/ ::///"); 
					
				}catch (Exception e) {
						System.out.print("Pas de emprunt depasse pour ce mois "); 
					
					}
				session.setAttribute("messageEmp", "vous empruntez deja !");
				response.sendRedirect("ConsulterLivre"); 
			}
		} else {
			this.getServletContext().getRequestDispatcher(vue)
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
