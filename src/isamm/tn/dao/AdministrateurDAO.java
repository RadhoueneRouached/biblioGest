package isamm.tn.dao;

import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Document;
import isamm.tn.beans.Support;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class AdministrateurDAO extends DAO<Administrateur> {

	public AdministrateurDAO(SessionFactory sessionfactory) {
		super(sessionfactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Administrateur administrateur) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {

			transaction = s.beginTransaction();
			s.save(administrateur);
			transaction.commit();

		} catch (HibernateException he) {
			he.printStackTrace();

		} finally {
			s.close();

		}
	}

	@Override
	public Administrateur find(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Administrateur ad = new Administrateur();
		try {
			transaction = s.beginTransaction();
			ad = (Administrateur) s.get(Administrateur.class, id);
			transaction.commit();
			return ad;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			s.close();

		}

	}

	@Override
	public boolean delete(Administrateur obj) {
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
		}

		finally {
			s.close();

		}

	}

	@Override
	public boolean update(Administrateur obj) {
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
			return false;
		} finally {
			s.close();

		}
	}

	@SuppressWarnings("rawtypes")
	public List<Administrateur> findAll() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Administrateur.class);
			List l = q.list();
			return l;

		} catch (Exception e) {
			System.out
					.print(" on ne peut pas trouver tous les administrateurs");
		}

		finally {
			s.close();

		}
		return null;
	}

	public Administrateur findByLogin(String login, String pwd) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			transaction = s.beginTransaction();
			criteria = s.createCriteria(Administrateur.class);

			Criterion log = Restrictions.ilike("login", login);
			Criterion pwd1 = Restrictions.ilike("motDePass", pwd);
			LogicalExpression andExp = Restrictions.and(log, pwd1);
			criteria.add(andExp);

			transaction.commit();
			return (Administrateur) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Administrateur non trouvé ");
		} finally {
			s.close();

		}
		return null;
	}
}
