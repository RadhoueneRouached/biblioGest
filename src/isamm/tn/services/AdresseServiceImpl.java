package isamm.tn.services;

import java.util.List;

import org.hibernate.SessionFactory;

import isamm.tn.beans.Adresse;
import isamm.tn.dao.AbstarctDAOFactory;
import isamm.tn.dao.AdresseDAO;
import isamm.tn.dao.DAO;

public class AdresseServiceImpl implements AdresseService {
	AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

	AdresseDAO adresseDao = (AdresseDAO) adf.getAdresseDAO();

	public void setAdresseDAO(AdresseDAO adresseDAO) {
		this.adresseDao = adresseDAO;
	}

	public void createAdresse(Adresse adresse) {

		adresseDao.create(adresse);

	}

	public Adresse findAdresse(int id) {
		return adresseDao.find(id);
	}

	public Boolean delete(Adresse adresse) {

		try {
			adresseDao.delete(adresse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Adresse adresse) {

		try {
			adresseDao.update(adresse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Adresse> findAll() {
		try {
			return adresseDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
