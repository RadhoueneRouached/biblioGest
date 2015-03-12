package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Document;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.AdministrateurServiceImpl;
import isamm.tn.services.DocumentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifierLivre
 */
@WebServlet("/ModifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		if (session.getAttribute("admin") != null){
			
		String vue = "/views/ModifierLivre.jsp";

		String mod = request.getParameter("mod"); 	 
		DocumentServiceImpl impl = new DocumentServiceImpl(); 
		Document adr = new Document(); 
		int mod2; 

		System.out.print("mod = "+mod); 
		if (mod != null){
		try {
			mod2= Integer.parseInt(mod);
		}catch (Exception e) {
			 mod2=0; 
		}
		adr = impl.findDocument(mod2);
		request.setAttribute("DocumentMod", adr); 
		request.getSession().setAttribute("messageModDoc", ""); 
		
		this.getServletContext().getRequestDispatcher(vue)
		.forward(request, response);
	
		}else {
			this.getServletContext().getRequestDispatcher(vue)
			.forward(request, response);
		
		}

		}else{this.getServletContext().getRequestDispatcher("/login.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idLivre = request.getParameter("idLivre");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String auteur = request.getParameter("auteur");
		String DateSortie = request.getParameter("DateSortie");
		String numEdition = request.getParameter("numEdition");
		String exemplaire = request.getParameter("exemplaire");
		String type = request.getParameter("type");
		
		AdministrateurServiceImpl serviceImpl = new AdministrateurServiceImpl(); 
		Administrateur ad = serviceImpl.findAdministrateur(1); 
		Document document  = new Document();  
		DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl(); 
		 
		int exemplaire1, idSupport, numEdition1;  
		try {
			exemplaire1 = Integer.parseInt(exemplaire); 
			idSupport = Integer.parseInt(idLivre); 
			numEdition1= Integer.parseInt(numEdition); 
		}catch (Exception e) {
			exemplaire1 = 0; 
			idSupport = 0; 
			numEdition1= 0; 
		}
		document.setAdministrateur(ad); 
		document.setAuteur(auteur); 
		document.setDateSorie(DateSortie); 
		document.setDescription(description); 
		document.setExemplaire(exemplaire1); 
		document.setId_support(idSupport); 
		document.setNumEdition(numEdition1); 
		document.setTitre(titre); 
		document.setType(type); 
		
		HttpSession session = request.getSession(); 
		String vue = request.getContextPath()+"/Accueil";
		if (documentServiceImpl.update(document))  
		{
		session.setAttribute("messageDoc", "Document modifié avec succes !"); 
		response.sendRedirect(vue);
		}else{
			 
			session.setAttribute("messageDoc", "Document n/'est pas modifié avec succes !"); 
			response.sendRedirect(vue);
		}

		
	}

}
