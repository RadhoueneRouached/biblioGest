package isamm.tn.services;

import java.util.List;

import org.hibernate.SessionFactory;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.dao.AbstarctDAOFactory;
import isamm.tn.dao.AdherentDAO;
import isamm.tn.dao.AdministrateurDAO;
import isamm.tn.dao.DAO;

public class AdherentServiceImpl implements AdherentService {
	AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

	AdherentDAO adherentDao = (AdherentDAO) adf.getAdherentDAO();

	public void setAdherentDAO(AdherentDAO adherentDAO) {
		this.adherentDao = adherentDAO;
	}

	public void createAdherent(Adherent adherent) {

		adherentDao.create(adherent);

	}

	public Adherent findAdherent(int id) {
		return adherentDao.find(id);
	}

	public Boolean delete(Adherent adherent) {

		try {
			adherentDao.delete(adherent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Adherent adherent) {

		try {
			adherentDao.update(adherent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Adherent> findAll() {
		try {
			return adherentDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Long nombreTotalAdherent() {
		try {
			return adherentDao.nombreTotalAdherent();
		} catch (Exception e) {
			return (long) 0;
		}
	}

	public Adherent findByLogin(String login, String pwd) {
		try {
			return ((AdherentDAO) adherentDao).findByLogin(login, pwd);
		} catch (Exception e) {
			return null;
		}
	}
}
