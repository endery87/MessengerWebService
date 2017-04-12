
package org.ender.webservices.messenger.database;

import java.util.*;
import org.ender.webservices.messenger.model.*;


public class DatabaseClass {
	
	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
