package javaee.practice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Book implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bookname;
	String booknum;
	Vector<String> bookwriter;
	Date publishtime;
	float bookprice;
	int booktype;
	int booksubtype;
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooknum() {
		return booknum;
	}
	public void setBooknum(String booknum) {
		this.booknum = booknum;
	}
	public Vector<String> getBookwriter() {
		return bookwriter;
	}
	public void setBookwriter(Vector<String> bookwriter) {
		this.bookwriter = bookwriter;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}
	public int getBooktype() {
		return booktype;
	}
	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}
	public int getBooksubtype() {
		return booksubtype;
	}
	public void setBooksubtype(int booksubtype) {
		this.booksubtype = booksubtype;
	}
	
	
	
}
