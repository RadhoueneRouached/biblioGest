package isamm.tn.dao;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Emprunt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class EmpruntDAO extends DAO<Emprunt> {

	// Session sf = HibernateUtil.getSessionFactory().openSession();

	public EmpruntDAO(SessionFactory session) {
		super(session);
	}

	public void create(Emprunt emprunt) {
		Session s = sessionfactory.openSession();

		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.save(emprunt);
			transaction.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			s.close();

		}

	}

	// public boolean delete(Adherent m);
	// public int convertir(String a);

	@Override
	public Emprunt find(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Emprunt epr = new Emprunt();
		try {

			transaction = s.beginTransaction();
			epr = (Emprunt) s.load(Emprunt.class, id);
			transaction.commit();
			return epr;
		} catch (Exception e) {
			System.out.print("emprunt  non trouvé ");
			return null;
		} finally {
			s.close();

		}

	}

	@Override
	public boolean delete(Emprunt obj) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.delete(obj);
			transaction.commit();
			return true;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			s.close();

		}

	}

	@Override
	public boolean update(Emprunt obj) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.update(obj);
			transaction.commit();
			return true;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			s.close();

		}
		return false;

	}

	@Override
	public List<Emprunt> findAll() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Emprunt.class);
			l = q.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return null;
	}

	public List<Emprunt> empruntDepasse() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Emprunt.class).add(
					Restrictions.isNull("depasse"));
			l = q.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return null;
	}

	public List<Emprunt> EmpruntParAdherent() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select e from Emprunt e,Adherent a  where e.adherent = a.id_adherent ");
			l = query.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return null;
	}

	public Long nombreEmpruntParMois(String dateDebMois, String dateFinMois) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Long l;
		try {

			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select count(id_emp) from Emprunt e  where (e.dateDeb >= '"
							+ dateDebMois
							+ "' and e.dateDeb <= '"
							+ dateFinMois
							+ "' ) AND  ( e.dateFin >= '"
							+ dateDebMois
							+ "' and e.dateFin <= '"
							+ dateFinMois + "' )");
			l = (Long) query.uniqueResult();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return (long) 0;
	}

	public Long EmpruntDouble(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;

		try {
			Long l = (long) 0;
			transaction = s.beginTransaction();
			
			String re = "SELECT count(e.adherent) FROM Emprunt e ,Adherent a  where ((e.adherent = '"
					+ id
					+ "') AND (e.adherent = a.id_adherent)  AND  e.dateDeb <= NOW() AND e.dateFin >= NOW() )  ";
			System.out.println(re);
			Query query = s.createQuery(re);
			l = (Long) query.uniqueResult();
			transaction.commit();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();

		}

		return (long) 0;
	}

	public Long nombreEmpruntTotal() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Long l;
		try {

			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select count(id_emp) from Emprunt e , Support s where e.document = s.id_support ");
			l = (Long) query.uniqueResult();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return (long) 0;
	}

	public List<Emprunt> empruntDepasseParMois(String dateFinMois) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select e from Emprunt e  where e.dateFin < '"
							+ dateFinMois + "' ");
			l = query.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return null;
	}

	public List<Emprunt> empruntNonConfirmer() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Emprunt.class).add(
					Restrictions.isNotNull("confirme"));
			l = q.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}
		return null;
	}

	public String miseAJourAdherentDepasse() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select a from Adherent a where (select count(id_emp) from Emprunt e,Adherent a  where e.adherent = a.id_adherent  and e.depasse <> 0) >= 3   ");
			l = query.list();
			transaction.commit();
			Iterator i1 = l.iterator();

			while (i1.hasNext()) {
				Adherent ad = (Adherent) i1.next();
				ad.setActive(1);
			}

			return "Mise a jour avec succes ";

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return " rien a mettre a jour ";
	}

	public int miseAJourAdherentDepasseAdherent(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		int l;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select a from Adherent a where (select count(id_emp) from Emprunt e,Adherent a  where e.adherent = a.id_adherent and (a.id_adherent="
							+ id + ")  and e.depasse <> 0) >= 3   ");
			l = (int) query.uniqueResult();
			transaction.commit();

			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return 0;
	}

	public List<Emprunt> EmpruntParDocument() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		List l;
		try {

			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select e from Emprunt e,Support a ,Adherent s  where e.document = a.id_support and e.adherent=s.id_adherent ");
			l = query.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les emprunts");
		} finally {
			s.close();

		}

		return null;
	}
}