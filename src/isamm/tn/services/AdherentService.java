package isamm.tn.services ;

import isamm.tn.beans.Adherent;
import isamm.tn.dao.AdherentDAO;

public interface AdherentService {


	public void setAdherentDAO(AdherentDAO adherentDAO);

	public void createAdherent(Adherent adherent);

	public Adherent findAdherent(int id);

}
