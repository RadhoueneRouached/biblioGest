package isamm.tn.services;

import java.util.List;

import org.hibernate.SessionFactory;

import isamm.tn.beans.Administrateur;
import isamm.tn.dao.AbstarctDAOFactory;
import isamm.tn.dao.AdherentDAO;
import isamm.tn.dao.AdministrateurDAO;
import isamm.tn.dao.DAO;

public class AdministrateurServiceImpl implements AdministrateurService {
	AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

	DAO<Administrateur> adminDao = adf.getAdministrateurDAO();

	public void setAdministrateurDAO(AdministrateurDAO administrateurDAO) {
		this.adminDao = administrateurDAO;
	}

	public void createAdministrateur(Administrateur administrateur) {

		adminDao.create(administrateur);

	}

	public Administrateur findAdministrateur(int id) {
		return adminDao.find(id);
	}

	public Boolean delete(Administrateur administrateur) {

		try {
			adminDao.delete(administrateur);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Administrateur administrateur) {

		try {
			adminDao.update(administrateur);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Administrateur> findAll() {
		try {
			return adminDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Administrateur findByLogin(String login, String pwd) {
		try {
			return ((AdministrateurDAO) adminDao).findByLogin(login, pwd);
		} catch (Exception e) {
			return null;
		}
	}

}
