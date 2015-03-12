package isamm.tn.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.dao.AbstarctDAOFactory;
import isamm.tn.dao.AdherentDAO;
import isamm.tn.dao.E;
import isamm.tn.dao.EmpruntDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmpruntServiceImpl implements EmpruntService {

	AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

	EmpruntDAO empruntDAO = (EmpruntDAO) adf.getEmpruntDAO();

	public void setEmprunt(EmpruntDAO empruntDAO) {
		this.empruntDAO = empruntDAO;

	}
	public Long EmpruntDouble(int id) {
		try{
		return empruntDAO.EmpruntDouble(id); 
		}catch (Exception e) {
			e.printStackTrace() ; 
		}
		return (long) 0; 
		}
	public void createEmprunt(Emprunt emprunt) {
		try {
			empruntDAO.create(emprunt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Emprunt findEmprunt(int id) {
		return empruntDAO.find(id);
	}

	public Boolean delete(Emprunt emprunt) {

		try {
			empruntDAO.delete(emprunt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Emprunt emprunt) {

		try {
			empruntDAO.update(emprunt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Emprunt> findAll() {
		try {
			return empruntDAO.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Emprunt> empruntDepasse() {
		try {
			return empruntDAO.empruntDepasse();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Emprunt> EmpruntParAdherent() {
		try {
			return empruntDAO.EmpruntParAdherent();
		} catch (Exception e) {
			return null;
		}
	}

	public Long nombreEmpruntParMois(String dateDebMois, String dateFinMois) {
		try {
			return empruntDAO.nombreEmpruntParMois(dateDebMois, dateFinMois);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Emprunt> empruntDepasseParMois(
			String dateFinMois) {
		try {

			List l = new ArrayList<Emprunt>();
			l = empruntDAO.empruntDepasseParMois(dateFinMois);
			Iterator i = l.iterator();

			while (i.hasNext()) {
				
 
				Emprunt emp = (Emprunt) i.next();
				System.out.print("////////////////////////////////// ID ::::: "+emp.getId_emp()+" ::::::");
				emp.setDepasse((byte) 1);
				Adherent ad = new Adherent();
				ad = emp.getAdherent();
				int avert = ad.getAvertissement() + 1;
				ad.setAvertissement(avert);
				if (avert >= 3) {

					ad.setActive(1);

					Date dt = new Date();

					Calendar cal = Calendar.getInstance();
					cal.setTime(dt);
					cal.add(Calendar.DATE, 7);

					dt = cal.getTime();

					ad.setDateExp(dt);
					System.out.print("date setted " + dt);
				}
				AdherentDAO adherentDAO = (AdherentDAO) adf.getAdherentDAO();
				try {
					adherentDAO.update(ad);
					empruntDAO.update(emp);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Emprunt> empruntNonConfirmer() {
		try {
			return empruntDAO.empruntNonConfirmer();
		} catch (Exception e) {
			return null;
		}
	}

	public String miseAJourAdherentDepasse() {
		try {
			return empruntDAO.miseAJourAdherentDepasse();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Emprunt> EmpruntParDocument() {
		try {
			return empruntDAO.EmpruntParDocument();
		} catch (Exception e) {
			return null;
		}

	}

	public Long nombreEmpruntTotal() {
		try {
			return empruntDAO.nombreEmpruntTotal();
		} catch (Exception e) {
			return null;
		}

	}

	public boolean miseAJourAdherentDepasseAdherent(int id) {
		try {
			if (empruntDAO.miseAJourAdherentDepasseAdherent(id) >= 3) {
				AdherentDAO adherentDAO = (AdherentDAO) adf.getAdherentDAO();
				Adherent adherent = new Adherent();
				adherent = adherentDAO.find(id);
				adherent.setAvertissement(3);
				adherent.setActive(1);
				Date dt = new Date();

				Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				cal.add(Calendar.DATE, 7); 

				dt = cal.getTime();

				adherent.setDateExp(dt);
				adherentDAO.update(adherent);
				return true;

			}
			return true;
		} catch (Exception e) {

		}
		return false;

	}

}