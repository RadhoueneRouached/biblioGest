package isamm.tn.dao;

import isamm.tn.beans.Document;
import isamm.tn.beans.Support;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DocumentDAO extends DAO<Document> {

	// Session sf = HibernateUtil.getSessionFactory().openSession();

	public DocumentDAO(SessionFactory session) {
		super(session);

	}

	public void create(Document document) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.save(document);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			s.close();

		}

	}

	@Override
	public Document find(int id) {
		Session s = sessionfactory.openSession();
		Document d = new Document();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			d = (Document) s.get(Document.class, id);
			transaction.commit();
			return d;
		} catch (Exception e) {
			System.out.print("Document non trouvé ");
		} finally {
			s.close();

		}
		return null;
	}

	@Override
	public boolean delete(Document obj) {
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
	public boolean update(Document obj) {
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

	@Override
	public List<Document> findAll() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Document.class);
			List l = q.list();
			transaction.commit();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les documents");
		} finally {
			s.close();

		}

		return null;
	}

	public Long nombreLivre() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Long count = (long) 0;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select count(id_support) from Support ");
			count = (Long) query.uniqueResult();
			transaction.commit();
			return count;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return count;
		} finally {
			s.close();

		}
	}

	public Boolean minusDoc(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Long count = (long) 0;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("UPDATE Document SET exemplaire=exemplaire-1 Where id_support = '"
							+ id + "' ");

			query.executeUpdate();
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

	public Boolean plusDoc(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		Long count = (long) 0;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("UPDATE Document SET exemplaire=exemplaire+1 Where id_support = '"
							+ id + "' ");

			query.executeUpdate();
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

	public int numberExDoc(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		int count = (int) 0;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select exemplaire From Support Where id_support = "
							+ id + ") ");

			count = (int) query.uniqueResult();
			transaction.commit();
			return count;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return count;
		} finally {
			s.close();

		}
	}

	public Document findByName(String titre) {
		Session s = sessionfactory.openSession();
		Document d = new Document();
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			transaction = s.beginTransaction();
			criteria = s.createCriteria(Support.class).add(
					Restrictions.eq("titre", titre));

			transaction.commit();
			return (Document) criteria.list().get(0);
		} catch (Exception e) {
			System.out.print("Document non trouvé ");
		} finally {
			s.close();

		}
		return null;
	}

}
