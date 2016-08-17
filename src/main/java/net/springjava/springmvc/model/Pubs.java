package net.springjava.springmvc.model;

import javax.persistence.Entity;

@Entity
public class Pubs {
	
	
	private int id;
	private String pub;
	private String link;
	
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
