package org.ender.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ender.webservices.messenger.database.DatabaseClass;
import org.ender.webservices.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles= DatabaseClass.getProfiles();
	
	
	
	public ProfileService(){
		
		profiles.put("ender",new Profile(1L, "ey","enro", "luz"));
		
		
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;	//return Profile with Id added
	}
	
	public Profile updateProfile(Profile profile)
	{
		//System.out.println(profile.getId()+"xxx"+profile);
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(),profile);
		System.out.println(profiles);
		return profile; //return Profile itself
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);//return the removed Profile instanced
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	

}
