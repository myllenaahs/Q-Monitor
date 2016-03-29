package br.edu.ifpb.Monitoria.DAO;

import java.util.List;

import javax.mail.Session;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.edu.ifpb.Monitoria.entidade.Monitor;
import br.edu.ifpb.Monitoria.hibernate.HibernateUtil;

public class MonitorDAO extends GenericDao<Integer, Monitor> {

	static MonitorDAO instance;


	public static MonitorDAO getInstance() {

		instance = new MonitorDAO();
		return instance;
	}

	@Override
	public List<Monitor> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return getAll("Monitor.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Monitor.class;
	}

	@Override
	public Monitor find(Monitor entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Monitor getByKeyAuth(String keyAuth) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Monitor monitor = null;
		
		try {
			
			String hql = "from Monitor as m"
					+ " where m.keyAuth = :keyAuth";
			
			Query query = session.createQuery(hql);
			query.setParameter("keyAuth", keyAuth);			
			
			monitor = (Monitor) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return monitor;
	}
}
