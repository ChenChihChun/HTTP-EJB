package jcs.ejb.remote;

import javax.ejb.Remote;

import jcs.entities.Httpauthdata;

@Remote
public interface HttpauthdataRemote {
	
	public Httpauthdata query(String parameter);
}
