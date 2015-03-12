package isamm.tn.services ;

import isamm.tn.beans.Adresse;
import isamm.tn.dao.AdresseDAO;

public interface AdresseService {


	public void setAdresseDAO(AdresseDAO adresseDAO);

	public void createAdresse(Adresse adresse);

	public Adresse findAdresse(int id);

}
