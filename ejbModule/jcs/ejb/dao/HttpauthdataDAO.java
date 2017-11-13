package jcs.ejb.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jcs.ejb.remote.HttpauthdataRemote;
import jcs.entities.Httpauthdata;


@Stateless
@Remote(HttpauthdataRemote.class)
public class HttpauthdataDAO implements HttpauthdataRemote {
	
	@PersistenceContext(unitName="HTTPDS-entities")
	private EntityManager entityManager;
	
//	@EJB SYSS02Remote syss02Remote;
	

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Httpauthdata query(String parameter) {
		return entityManager.find(Httpauthdata.class, parameter);
//		System.out.println("select hp from Httpauthdata hp where hp.httpParameter= '"+parameter+"' ");
//		Query query = entityManager.createQuery("select hp from Httpauthdata hp where hp.httpParameter= '"+parameter+"' ");
//		query.getResultList();
//		//Query query = entityManager.createNativeQuery("select http_value from httpauthdata where http_parameter= ? ");
//		//query.setParameter(1, parameter);
//		
//		return (Httpauthdata) query.getResultList();
	}
}
