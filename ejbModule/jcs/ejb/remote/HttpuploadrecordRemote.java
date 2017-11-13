package jcs.ejb.remote;

import javax.ejb.Remote;

import jcs.entities.Httpuploadrecord;

@Remote
public interface HttpuploadrecordRemote {

	public void insert(Httpuploadrecord record);
}
