package com.kedut.directory.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.kedut.directory.model.Contact;
import com.kedut.directory.model.ProductCategory;
import com.kedut.directory.model.Subscription;


public interface BusinessDTO {
	

	public String getBusName();

	public void setBusName(String busName);

	public String getBusDesc();

	public void setBusDesc(String busDesc);

	public Date getDateModified();

	public void setDateModified(Date dateModified);

	public Date getDateUpdated();

	public void setDateUpdated(Date dateUpdated);

	public Subscription getSubscription();

	public void setSubscription(Subscription subscription);

	public Contact getContact();

	public void setContact(Contact contact);

}
