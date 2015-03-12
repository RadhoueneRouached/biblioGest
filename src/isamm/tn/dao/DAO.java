package isamm.tn.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


 public abstract class DAO<T> {
	SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	
	public DAO(SessionFactory sessionfactory){
			this.sessionfactory = sessionfactory;
			}
	 
	public abstract void create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj );
	public abstract T find(int id);
	public abstract List findAll();
}
