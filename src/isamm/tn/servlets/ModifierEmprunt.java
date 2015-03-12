package isamm.tn.servlets;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.services.AdherentServiceImpl;
import isamm.tn.services.DocumentServiceImpl;
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
 * Servlet implementation class ModifierEmprunt
 */
@WebServlet("/ModifierEmprunt")
public class ModifierEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEmprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("message", ""); 

		if (session.getAttribute("admin") != null){
		String vue = "/views/ModifierEmprunt.jsp";
		
		DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl(); 
		 List<Document > d= documentServiceImpl.findAll();
		
		request.setAttribute("listeLivre", d);
	
		AdherentServiceImpl adherentServiceImpl = new AdherentServiceImpl();  
		 List<Adherent> a= adherentServiceImpl.findAll(); 
		
		request.setAttribute("listeAdherent", a);
	
	

		String mod = request.getParameter("mod"); 	 
		EmpruntServiceImpl impl = new EmpruntServiceImpl();  
		Emprunt emp = new Emprunt();  
		int mod2; 

		System.out.print("mod = "+mod); 
		if (mod != null){
		try {
			mod2= Integer.parseInt(mod);
		}catch (Exception e) {
			 mod2=0; 
		}
		emp = impl.findEmprunt(mod2);
		request.setAttribute("EmpruntMod", emp); 
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
		String vue = request.getContextPath()+"/GererEmprunt";
		String id = request.getParameter("id");
		String dateDebut = request.getParameter("dateDebut"); 
		String dateFin = request.getParameter("dateFin");
		String depasse = request.getParameter("depasse");
		String idAdr = request.getParameter("idAdr");
		String idDoc = request.getParameter("idDoc");
	
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date db,df; 
		try {
			db=  simpleDateFormat.parse(dateDebut);
			df=  simpleDateFormat.parse(dateFin);
			
		}catch (Exception e) {
			db = new Date(1,1,1);
			df = new Date(1,1,1);
		}
		Byte depasse1; 
		int idDoc1,idAdr1,id1; 
		try{
			id1 = Byte.parseByte(id); 
			depasse1 = Byte.parseByte(depasse); 
			idDoc1 = Integer.parseInt(idDoc); 
			idAdr1 = Integer.parseInt(idAdr); 
		}catch (Exception e) {
			depasse1 =1;  
			idDoc1 =1;  
			idAdr1 =1; 
			id1 =1; 
		}
		EmpruntServiceImpl empruntServiceImpl = new EmpruntServiceImpl(); 
		Emprunt emprunt = new Emprunt(); 
		emprunt = empruntServiceImpl.findEmprunt(id1);
		
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
		EmpruntServiceImpl  empruntServiceImpl2 = new EmpruntServiceImpl(); 
		HttpSession session = request.getSession(); 
		if (documentServiceImpl.numberExDoc(idDoc1)>=0){
		try {
			empruntServiceImpl2.update(emprunt);
			 
			session.setAttribute("messageModEmp", "Emprunt modifiée avec succes !"); 
			
			response.sendRedirect(vue);
			}catch (Exception e) {
				e.printStackTrace(); 
				session.setAttribute("messageModEmp", "Emprunt  n/'est pas modifiée avec succes !"); 
				response.sendRedirect(vue);
			}
		}else {
			session.setAttribute("messageModEmp", "nombre d'exemplaire insuffisant !"); 
			response.sendRedirect(vue);
		
		}
	
	}

}
