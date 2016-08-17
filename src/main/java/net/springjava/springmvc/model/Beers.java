package net.springjava.springmvc.model;

import javax.persistence.Entity;

@Entity
public class Beers {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getPiwo() {
		return piwo;
	}
	public void setPiwo(String piwo) {
		this.piwo = piwo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getHalfprice() {
		return halfprice;
	}
	public void setHalfprice(int halfprice) {
		this.halfprice = halfprice;
	}
	public int getThreeprice() {
		return threeprice;
	}
	public void setThreeprice(int threeprice) {
		this.threeprice = threeprice;
	}
	private int id;
	private String pub;
	private String piwo;
	private String link;
	private int progress;
	private int halfprice;
	private int threeprice;
}
