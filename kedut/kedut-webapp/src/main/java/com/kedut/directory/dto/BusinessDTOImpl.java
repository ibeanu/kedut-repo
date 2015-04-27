package com.kedut.directory.dto;

import java.util.Date;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.kedut.directory.model.Contact;
import com.kedut.directory.model.Subscription;
@ManagedResource
public class BusinessDTOImpl implements BusinessDTO {

	
	
	
	public BusinessDTOImpl() {
		
	}

	@Override
	public String getBusName() {
		// TODO Auto-generated method stub
		return null;
	}
	@ManagedAttribute
	@Override
	public void setBusName(String busName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getBusDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBusDesc(String busDesc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getDateModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDateModified(Date dateModified) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getDateUpdated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDateUpdated(Date dateUpdated) {
		// TODO Auto-generated method stub

	}

	@Override
	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSubscription(Subscription subscription) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact getContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContact(Contact contact) {
		// TODO Auto-generated method stub

	}

}
