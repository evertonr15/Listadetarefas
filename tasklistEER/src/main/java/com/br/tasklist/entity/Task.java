package com.br.tasklist.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long idTask;
	private String nmTask;
	private String dsTask;
	private Integer fgStatus;
	private Date dtInsert;
	private Date dtDelete;
	private Date dtEnd;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTask == null) ? 0 : idTask.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (idTask == null) {
			if (other.idTask != null)
				return false;
		} else if (!idTask.equals(other.idTask))
			return false;
		return true;
	}
	
	public Long getIdTask() {
		return idTask;
	}
	
	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}
	public String getNmTask() {
		return nmTask;
	}
	public void setNmTask(String nmTask) {
		this.nmTask = nmTask;
	}
	public String getDsTask() {
		return dsTask;
	}
	public void setDsTask(String dsTask) {
		this.dsTask = dsTask;
	}
	public Integer getFgStatus() {
		return fgStatus;
	}
	public void setFgStatus(Integer fgStatus) {
		this.fgStatus = fgStatus;
	}
	public Date getDtInsert() {
		return dtInsert;
	}
	public void setDtInsert(Date dtInsert) {
		this.dtInsert = dtInsert;
	}
	public Date getDtDelete() {
		return dtDelete;
	}
	public void setDtDelete(Date dtDelete) {
		this.dtDelete = dtDelete;
	}
	public Date getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}
}
