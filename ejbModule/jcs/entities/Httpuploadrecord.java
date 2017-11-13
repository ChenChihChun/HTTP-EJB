package jcs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HTTPUPLOADRECORD database table.
 * 
 */
@Entity
@NamedQuery(name="Httpuploadrecord.findAll", query="SELECT h FROM Httpuploadrecord h")
public class Httpuploadrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String dataid;

	@Column(name="EXECUTE_RESULT")
	private String executeResult;

	@Temporal(TemporalType.DATE)
	@Column(name="EXECUTE_TIME")
	private Date executeTime;

	@Column(name="FROM_PATH")
	private String fromPath;

	@Column(name="TO_PATH")
	private String toPath;

	public Httpuploadrecord() {
	}

	public String getDataid() {
		return this.dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getExecuteResult() {
		return this.executeResult;
	}

	public void setExecuteResult(String executeResult) {
		this.executeResult = executeResult;
	}

	public Date getExecuteTime() {
		return this.executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public String getFromPath() {
		return this.fromPath;
	}

	public void setFromPath(String fromPath) {
		this.fromPath = fromPath;
	}

	public String getToPath() {
		return this.toPath;
	}

	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

}