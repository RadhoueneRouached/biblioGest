package isamm.tn.services; 

import isamm.tn.beans.Document;
import isamm.tn.dao.DocumentDAO;

public interface DocumentService {


	

	public void createDocument(Document document);

	public Document findDocument(int id);

	void setDocumentDAO(DocumentDAO documentDAO);

}
