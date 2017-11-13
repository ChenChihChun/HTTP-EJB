package jcs.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HTTPAUTHDATA database table.
 * 
 */
@Entity
@Table(name="HTTPAUTHDATA",schema="GOD")
/*@NamedQuery(name="Httpauthdata.findAll", query="SELECT h FROM Httpauthdata h")*/
public class Httpauthdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HTTP_PARAMETER")
	private String httpParameter;

	@Column(name="HTTP_DESCRIPTION")
	private String httpDescription;

	@Column(name="HTTP_VALUE")
	private String httpValue;

	public Httpauthdata() {
	}

	public String getHttpParameter() {
		return this.httpParameter;
	}

	public void setHttpParameter(String httpParameter) {
		this.httpParameter = httpParameter;
	}

	public String getHttpDescription() {
		return this.httpDescription;
	}

	public void setHttpDescription(String httpDescription) {
		this.httpDescription = httpDescription;
	}

	public String getHttpValue() {
		return this.httpValue;
	}

	public void setHttpValue(String httpValue) {
		this.httpValue = httpValue;
	}

}