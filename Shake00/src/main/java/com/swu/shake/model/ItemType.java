package com.swu.shake.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "ItemTypes")
public class ItemType {
	
	private int tid;
	private String tname;
	private String tdescr;
	private Integer tlevel;
	private boolean isbranch;
	private Set<Item> set = new HashSet<Item>();
	
	@Id
	@GeneratedValue
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdescr() {
		return tdescr;
	}
	public void setTdescr(String tdescr) {
		this.tdescr = tdescr;
	}
	public Integer getTlevel() {
		return tlevel;
	}
	public void setTlevel(Integer tlevel) {
		this.tlevel = tlevel;
	}
	public boolean isIsbranch() {
		return isbranch;
	}
	public void setIsbranch(boolean isbranch) {
		this.isbranch = isbranch;
	}
	@OneToMany(mappedBy="itemtype")
	@Cascade(CascadeType.ALL)
	public Set<Item> getSet() {
		return set;
	}
	public void setSet(Set<Item> set) {
		this.set = set;
	}
	
	
}
