package com.dell.booksearch;

import java.util.List;

public class Books {

	private List<String> booksList;
	private String myport;
	private String message;
	private String actualBookPrice;
	private String offerInPerc;
	private String offeredPrice;
	public List<String> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<String> booksList) {
		this.booksList = booksList;
	}
	public String getMyport() {
		return myport;
	}
	public void setMyport(String myport) {
		this.myport = myport;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getActualBookPrice() {
		return actualBookPrice;
	}
	public void setActualBookPrice(String actualBookPrice) {
		this.actualBookPrice = actualBookPrice;
	}
	public String getOfferInPerc() {
		return offerInPerc;
	}
	public void setOfferInPerc(String offerInPerc) {
		this.offerInPerc = offerInPerc;
	}
	public String getOfferedPrice() {
		return offeredPrice;
	}
	public void setOfferedPrice(String offeredPrice) {
		this.offeredPrice = offeredPrice;
	}
	
}
