package isamm.tn.services; 

import isamm.tn.beans.Emprunt;
import isamm.tn.dao.EmpruntDAO;

public interface EmpruntService {


	public void setEmprunt (EmpruntDAO empruntDAO);

	public void createEmprunt(Emprunt emprunt);

	public Emprunt findEmprunt(int id);

}
