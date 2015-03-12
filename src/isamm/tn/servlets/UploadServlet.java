package isamm.tn.servlets;

import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Support;
import isamm.tn.services.AdministrateurServiceImpl;
import isamm.tn.services.DocumentServiceImpl;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("messageDoc", ""); 
		if (session.getAttribute("admin") != null) {

			String vue = "/views/ajouterLivrexml.jsp";
			this.getServletContext().getRequestDispatcher(vue)
					.forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static final String SAVE_DIR = "uploadFiles";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vue2 = "/views/accueil.jsp";
		String fileName = "";
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;
		String vue = "/views/ajouterLivre.jsp";
		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			part.write("G:/data/" + fileName);
		}

		try {

			File fXmlFile = new File("G:/data/" + fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Document");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					isamm.tn.beans.Document doc1 = new isamm.tn.beans.Document();
					AdministrateurServiceImpl serviceImpl = new AdministrateurServiceImpl();
					Administrateur ad = serviceImpl.findAdministrateur(1);
					int exemplaireN = 0;
					int numeEditionN = 0;
					try {
						exemplaireN = Integer.parseInt(eElement
								.getElementsByTagName("exemplaire").item(0)
								.getTextContent());
						numeEditionN = Integer.parseInt(eElement
								.getElementsByTagName("numEdition").item(0)
								.getTextContent());
					} catch (Exception e) {
						exemplaireN = 0;
						numeEditionN = 0;
					}
					doc1.setAuteur(eElement.getElementsByTagName("auteur")
							.item(0).getTextContent());
					doc1.setDateSorie(eElement
							.getElementsByTagName("dateSortie").item(0)
							.getTextContent());
					doc1.setDescription(eElement
							.getElementsByTagName("description").item(0)
							.getTextContent());
					doc1.setExemplaire(exemplaireN);
					doc1.setNumEdition(numeEditionN);
					doc1.setTitre(eElement.getElementsByTagName("titre")
							.item(0).getTextContent());
					doc1.setAdministrateur(ad);
					doc1.setType(eElement.getElementsByTagName("type").item(0)
							.getTextContent());
					DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();

					try {
						documentServiceImpl.createDocument(doc1);
						request.setAttribute("messageAjoutLivre",
								"Document ajouté avec succes ");

					} catch (Exception e) {
						request.setAttribute("messageAjoutLivre",
								"Document  NON ajouté  ");

						System.out.println("First Name : "
								+ eElement.getElementsByTagName("titre")
										.item(0).getTextContent());
						System.out.println("description : "
								+ eElement.getElementsByTagName("description")
										.item(0).getTextContent());
						System.out.println("auteur : "
								+ eElement.getElementsByTagName("auteur")
										.item(0).getTextContent());
						System.out.println("type : "
								+ eElement.getElementsByTagName("type").item(0)
										.getTextContent());
						System.out.println("dateSortie : "
								+ eElement.getElementsByTagName("dateSortie")
										.item(0).getTextContent());
						System.out.println("numEdition : "
								+ eElement.getElementsByTagName("numEdition")
										.item(0).getTextContent());
						System.out.println("exemplaire : "
								+ eElement.getElementsByTagName("exemplaire")
										.item(0).getTextContent());

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("message", "Upload has been done successfully!");
		getServletContext().getRequestDispatcher(vue2).forward(request,
				response);

	}

}
