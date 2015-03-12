package isamm.tn.servlets;

import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Document;
import isamm.tn.beans.Support;
import isamm.tn.services.AdministrateurServiceImpl;
import isamm.tn.services.DocumentServiceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AjouterLivre
 */
@WebServlet("/AjouterLivre")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterLivre() {
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

			String vue = "/views/ajouterLivre.jsp";
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

	/**
	 * handles file upload
	 */
	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vue = "/views/ajouterLivre.jsp";
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String auteur = request.getParameter("auteur");
		String DateSortie = request.getParameter("DateSortie");
		String numEdition = request.getParameter("numEdition");
		String exemplaire = request.getParameter("exemplaire");
		String type = request.getParameter("type");

		int exemplaire1, numEdition1;
		try {
			exemplaire1 = Integer.parseInt(exemplaire);
			numEdition1 = Integer.parseInt(numEdition);
		} catch (Exception e) {
			exemplaire1 = 0;
			numEdition1 = 0;
		}

		AdministrateurServiceImpl serviceImpl = new AdministrateurServiceImpl();
		Administrateur ad = serviceImpl.findAdministrateur(1);
		Document document = new Document();
		document.setAuteur(auteur);
		document.setDateSorie(DateSortie);
		document.setDescription(description);
		document.setExemplaire(exemplaire1);
		document.setNumEdition(numEdition1);
		document.setTitre(titre);
		document.setAdministrateur(ad);
		document.setType(type);
		DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();

		try {
			documentServiceImpl.createDocument(document);
			request.setAttribute("messageAjoutLivre",
					"Document ajouté avec succes ");

		} catch (Exception e) {
			request.setAttribute("messageAjoutLivre", "Document  NON ajouté  ");

		}
		this.getServletContext().getRequestDispatcher(vue)
				.forward(request, response);
	}

}
