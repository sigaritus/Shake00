package com.swu.shake.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
	private int iid;
	private String iname;
	private String idesc;
	private Integer iNumber;
	private Date onshelfdate;
	private String imagepath;
	private ItemType itemtype;

	@Id
	@GeneratedValue
	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	@ManyToOne
	public ItemType getItemtype() {
		return itemtype;
	}

	public void setItemtype(ItemType itemtype) {
		this.itemtype = itemtype;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getIdesc() {
		return idesc;
	}

	public void setIdesc(String idesc) {
		this.idesc = idesc;
	}

	public Date getOnshelfdate() {
		return onshelfdate;
	}

	public void setOnshelfdate(Date onshelfdate) {
		this.onshelfdate = onshelfdate;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public Integer getiNumber() {
		return iNumber;
	}

	public void setiNumber(Integer iNumber) {
		this.iNumber = iNumber;
	}

}
