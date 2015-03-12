package isamm.tn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOFactory extends AbstarctDAOFactory {

	protected static final SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public DAO getAdherentDAO() {
		return new AdherentDAO(sf);
	}

	@Override
	public DAO getDocumentDAO() {
		return new DocumentDAO(sf);
	}

	@Override
	public DAO getAdresseDAO() {
		return new AdresseDAO(sf);
	}

	@Override
	public DAO getAdministrateurDAO() {
		return new AdministrateurDAO(sf);
	}

	@Override
	public DAO getEmpruntDAO() {
		return new EmpruntDAO(sf);
	}

}