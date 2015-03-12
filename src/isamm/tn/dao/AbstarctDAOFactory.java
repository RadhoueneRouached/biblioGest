package isamm.tn.dao;

public abstract class AbstarctDAOFactory {

	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAO getAdherentDAO();

	public abstract DAO getDocumentDAO();

	public abstract DAO getEmpruntDAO();

	public abstract DAO getAdresseDAO();

	public abstract DAO getAdministrateurDAO();

	public static AbstarctDAOFactory getFactory(int type) {
		switch (type) {
		case DAO_FACTORY:
			return new DAOFactory();
		case XML_DAO_FACTORY:
			return new XMLDAOFactory();
		default:
			return null;
		}
	}

}
