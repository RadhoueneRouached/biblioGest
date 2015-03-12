package isamm.tn.services;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sun.org.apache.regexp.internal.recompile;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.dao.AbstarctDAOFactory;
import isamm.tn.dao.AdherentDAO;
import isamm.tn.dao.DocumentDAO;

public class DocumentServiceImpl implements DocumentService {

	AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

	DocumentDAO documentDAO = (DocumentDAO) adf.getDocumentDAO();

	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;

	}

	public void createDocument(Document document) {
		try {
			documentDAO.create(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Document findDocument(int id) {
		return documentDAO.find(id);
	}

	public Boolean delete(Document document) {

		try {
			documentDAO.delete(document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Document document) {

		try {
			documentDAO.update(document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Document> findAll() {
		try {
			return documentDAO.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Long nombreLivre() {
		return documentDAO.nombreLivre();
	}

	public Document findByName(String titre) {
		return documentDAO.findByName(titre);
	}

	public Boolean minusDoc(int id) {
		try {
			return documentDAO.minusDoc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean plusDoc(int id) {
		try {
			return documentDAO.plusDoc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	public int numberExDoc(int id) {
		return documentDAO.numberExDoc(id);
	}
}
