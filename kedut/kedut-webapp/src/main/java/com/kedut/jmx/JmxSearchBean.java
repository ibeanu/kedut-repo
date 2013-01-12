package com.kedut.jmx;

import com.kedut.jmx.IJmxSearchBean;
import java.math.BigInteger;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description="My Managed Bean", log=true,
	    logFile="jmx.log", currencyTimeLimit=15, persistPolicy="OnUpdate", persistPeriod=200,
	    persistLocation="/data/logs/", persistName="bar")
public class JmxSearchBean implements IJmxSearchBean {

	private int counter;
	private String name;

	@Override
	@ManagedAttribute(description="The Name Attribute", currencyTimeLimit=15)
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	@ManagedAttribute(description="The Business name search hit counter Attribute", currencyTimeLimit=15)
	public int getCounter() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void setCounter(int counter) {
		this.counter = counter;

	}
	
	public void incrementCounter(){
		counter++;
		
	}

}
