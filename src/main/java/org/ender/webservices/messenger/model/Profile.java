package org.ender.webservices.messenger.model;

import java.util.Date;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Profile {
	
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date time;
	
	public Profile(){}
	
	public Profile(long id, String profileName, String firstName, String lastName)
	{
		this.id=id;
		this.firstName=firstName;
		this.profileName=profileName;
		this.lastName=lastName;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
