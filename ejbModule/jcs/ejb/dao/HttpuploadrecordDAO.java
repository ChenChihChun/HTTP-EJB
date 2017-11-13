package jcs.ejb.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jcs.ejb.remote.HttpuploadrecordRemote;
import jcs.entities.Httpuploadrecord;


@Stateless
@Remote(HttpuploadrecordRemote.class)
public class HttpuploadrecordDAO implements HttpuploadrecordRemote {

	@PersistenceContext(unitName="HTTPDS-entities")
	private EntityManager entityManager;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insert(Httpuploadrecord record) {
		// TODO Auto-generated method stub
		entityManager.merge(record);
	}

}
